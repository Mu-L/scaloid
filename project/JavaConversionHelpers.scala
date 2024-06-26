import java.beans.PropertyDescriptor
import java.lang.reflect.{Array => JavaArray, _}
import org.reflections.ReflectionUtils._
import scala.collection.JavaConverters._


trait JavaConversionHelpers {

  def getSuperclass(cls: Class[_]): Option[Class[_]] =
    cls.getSuperclass match {
      case c: Class[_] => Some(c)
      case _ => cls.getInterfaces.headOption
    }

  def isPublic(m: Member): Boolean = Modifier.isPublic(m.getModifiers)
  def isPublic(c: Class[_]): Boolean = Modifier.isPublic(c.getModifiers)
  def isAbstract(m: Member): Boolean = Modifier.isAbstract(m.getModifiers)
  def isAbstract(c: Class[_]): Boolean = Modifier.isAbstract(c.getModifiers)
  def isFinal(m: Member): Boolean = Modifier.isFinal(m.getModifiers)
  def isFinal(c: Class[_]): Boolean = Modifier.isFinal(c.getModifiers)
  def isInterface(c: Class[_]): Boolean = Modifier.isInterface(c.getModifiers)
  def isStatic(c: Class[_]): Boolean = Modifier.isStatic(c.getModifiers)
  def isConcrete(c: Class[_]): Boolean = ! (isInterface(c) || isStatic(c))
  def isOverride(m: Method): Boolean =
    getSuperclass(m.getDeclaringClass) match {
      case Some(c) =>
        getAllMethods(c,
          withName(m.getName),
          withParameters(m.getParameterTypes: _*)
        ).asScala.nonEmpty
      case None => false
    }
  def isDeprecated(e: AnnotatedElement) = e.isAnnotationPresent(classOf[java.lang.Deprecated])

  def methodSignature(m: Method): String = List(
    m.getName,
    m.getReturnType.getName,
    "["+m.getParameterTypes.map(_.getName).toList.mkString(",")+"]"
  ).mkString(":")

  def propDescSignature(pdesc: PropertyDescriptor): String = List(
    pdesc.getName,
    pdesc.getPropertyType
  ).mkString(":")

  def simpleClassName(s: String): String = s.split(Array('.', '#')).last
  def simpleClassName(c: Class[_]): String = simpleClassName(c.getName)

  private def innerClassDelim(c: Class[_]) = if (isConcrete(c)) "#" else "."

  def toScalaType(_tpe: Type): ScalaType = {
    def step(tpe: Type, level: Int): ScalaType = {
      val nextLevel = level + 1

      if (level > 5)
        ScalaType("_")
      else
        tpe match {
          case null => throw new Error("Property cannot be null")
          case ga: GenericArrayType =>
            ScalaType("Array", List(step(ga.getGenericComponentType, nextLevel)))
          case p: ParameterizedType =>
            ScalaType(
              step(p.getRawType, nextLevel).name,
              p.getActualTypeArguments.map(step(_, nextLevel)).toList
            )
          case t: TypeVariable[_] =>
            ScalaType(t.getName, Nil, bounds = t.getBounds.map(step(_, nextLevel)).toList, isVar = true)
          case w: WildcardType =>
            val bs = w.getUpperBounds.map(step(_, nextLevel)).toList.filter(_.name != "Any")
            ScalaType("_", Nil, bounds = bs)
          case c: Class[_] => {
            if (c.isArray) {
              ScalaType("Array", List(step(c.getComponentType, nextLevel)))
            } else if (c.isPrimitive) {
              ScalaType(c.getName match {
                case "void" => "Unit"
                case n => n.capitalize
              })
            } else if (c == classOf[java.lang.Object]) {
              ScalaType("Any")
            } else {
              ScalaType(
                name = c.getName.replace("$", innerClassDelim(c)),
                params = c.getTypeParameters.map(step(_, nextLevel)).toList
              )
            }
          }
          case _ =>
            throw new Error("Cannot find type of " + tpe.getClass + " ::" + tpe.toString)
        }
    }

    def javaTypeName(t: Type) =
      t.toString.replaceFirst("^[^ ]+ ", "").replace("$", ".")

    val javaName =
      _tpe match {
        case c: Class[_] =>
          if (c.isArray) javaTypeName(c.getComponentType) + "[]"
          else if (c.isPrimitive) _tpe.toString
          else c.getCanonicalName

        case _ => // TODO match generic types
          javaTypeName(_tpe)
      }

    step(_tpe, 0).copy(javaName = javaName)
  }

  def toTypeStr(_tpe: Type, isVarArgs: Boolean, isLast: Boolean): String = {
    def step(tpe: Type): String = {
      val arrayNotation = if (isLast && isVarArgs) "..." else "[]"

      tpe match {
        case ga: GenericArrayType =>
          step(ga.getGenericComponentType) + arrayNotation
        case p: ParameterizedType =>
          p.toString.replace("$", ".")
        case _: WildcardType => "?"
        case c: Class[_] =>
          if (c.isArray) {
            step(c.getComponentType) + arrayNotation
          } else {
            c.getName.replace("$", innerClassDelim(c))
          }
        case _ =>
          tpe.toString
      }
    }
    step(_tpe)
  }

}
