$license()$

package org.scaloid.common

import android.app._
import android.content._
import android.graphics.drawable.{Drawable, StateListDrawable}
import android.os._
import android.view._
import android.view.WindowManager.LayoutParams._
import org.scaloid.common.{AppHelpers, Creatable, Registerable, SContext}

import scala.collection.immutable.Vector
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.deprecated


trait TraitActivity[+This <: Activity] {

  @inline def contentView_=(p: View): Activity = {
    basis.setContentView(p)
    basis
  }

  @inline def contentView(p: View): Activity = contentView_=(p)

  @inline def contentView(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'contentView'")

  def intent = Some[Intent](basis.getIntent)

  def basis: Activity

  def find[V <: View](id: Int): V = basis.findViewById(id).asInstanceOf[V]

  def runOnUiThread (f: => Unit): Unit = {
    if(uiThread == Thread.currentThread) {
      f
    } else {
      handler.post(new Runnable() {
        def run(): Unit = {
          f
        }
      })
    }
  }
}

/**
 * Enriched trait for the class android.app.Activity.
 * To enable Scaloid, inherit this trait instead of the class Activity.
 *
 * SActivity has shortcut methods for each lifecycle stages. These methods shorten the method overriding, which is
 * very frequent for activity classes.
 *
 * For example, instead of this:
 *
 * {{{
 *   override def onCreate(b: Bundle) {
 *     super.onCreate(b)
 *     // do something for onCreate
 *   }
 * }}}
 *
 * The equivalent is:
 *
 * {{{
 *   onCreate {
 *     // do something for onCreate
 *   }
 * }}}
 * or
 * {{{
 *   onCreate(doSomething())
 * }}}
 *
 * If the `Bundle` is needed in the `onCreate` call to restore saved state, a function can be supplied which accepts
 * `Option[Bundle]`:
 *
 * {{{
 *   onCreate { ob: Option[Bundle] =>
 *     // do something for onCreate
 *     ob.foreach { b =>
 *       // do things if bundle was defined at onCreate time
 *     }
 *   }
 * }}}
 *
 * In contrast of method overriding, this shortcut can be called multiple times from different places of your code.
 *
 */
trait SActivity extends Activity with SContext with TraitActivity[SActivity] with Destroyable with Creatable with Registerable {

  override def basis = this
  override implicit val ctx: SActivity = this

  def onRegister(body: => Any): () => Any = onResume(body)
  def onUnregister(body: => Any): () => Any = onPause(body)

  val onStartStop = new Registerable {
    def onRegister(body: => Any): () => Any = onStart(body)
    def onUnregister(body: => Any): () => Any = onStop(body)
  }

  val onCreateDestroy = new Registerable {
    def onRegister(body: => Any): () => Any = onCreate(body)
    def onUnregister(body: => Any): () => Any = onDestroy(body)
  }

  protected override def onCreate(b: Bundle): Unit = {
    super.onCreate(b)
    AppHelpers.createBundle.withValue(Option(b)) {
      onCreateBodies.foreach(_ ())
    }
  }

  def onCreate(body: Option[Bundle] => Any) = {
    val el = { () =>
      body(AppHelpers.createBundle.value)
    }
    onCreateBodies :+= el
    el
  }

  override def onStart(): Unit = {
    super.onStart()
    onStartBodies.foreach(_ ())
  }

  protected var onStartBodies = Vector[() => Any]()

  def onStart(body: => Any) = {
    val el = () => body
    onStartBodies :+= el
    el
  }

  override def onResume(): Unit = {
    super.onResume()
    onResumeBodies.foreach(_ ())
  }

  protected var onResumeBodies = Vector[() => Any]()

  def onResume(body: => Any) = {
    val el = () => body
    onResumeBodies :+= el
    el
  }

  override def onPause(): Unit = {
    onPauseBodies.foreach(_ ())
    super.onPause()
  }

  protected var onPauseBodies = Vector[() => Any]()

  def onPause(body: => Any) = {
    val el = () => body
    onPauseBodies :+= el
    el
  }

  override def onStop(): Unit = {
    onStopBodies.foreach(_ ())
    super.onStop()
  }

  protected var onStopBodies = Vector[() => Any]()

  def onStop(body: => Any) = {
    val el = () => body
    onStopBodies :+= el
    el
  }

  override def onDestroy(): Unit = {
    onDestroyBodies.foreach(_ ())
    super.onDestroy()
  }
}


/**
 * Enriched trait of the class android.app.Service. To enable Scaloid support for subclasses of android.app.Service, extend this trait.
 */
trait SService extends Service with SContext with Destroyable with Creatable with Registerable {
  override def basis = this
  override implicit val ctx: SService = this

  def onRegister(body: => Any): () => Any = onCreate(body)
  def onUnregister(body: => Any): () => Any = onDestroy(body)

  override def onCreate(): Unit = {
    super.onCreate()
    onCreateBodies.foreach(_ ())
  }

  override def onDestroy(): Unit = {
    onDestroyBodies.foreach(_ ())
    super.onDestroy()
  }
}

/**
 * An in-process service that can be bound with [[LocalServiceConnection]]. This yields far more concise code than that uses plain-old Android API.
 *
 * Please refer to the URL below for more details.
 *
 * [[http://blog.scaloid.org/2013/03/introducing-localservice.html]]
 */
trait LocalService extends SService {
  private val binder = new ScaloidServiceBinder

  def onBind(intent: Intent): IBinder = binder

  class ScaloidServiceBinder extends Binder {
    def service: LocalService = LocalService.this
  }

}

/**
 * A Scala-style builder for AlertDialog.
 * {{{
 *  new AlertDialogBuilder("Exit the app", "Do you really want to exit?") {
 *    positiveButton("Exit", finishTheApplication())
 *    negativeButton("Cancel")
 *  }.show()
 * }}}
 * This displays an alert dialog with given string resources.
 *
 * Although this builder displays some UI element, this builder can be called from any thread, because the method `show()` handles threading internally.
 *
 * Please refer to the URL below for more details.
 *
 * [[https://github.com/pocorall/scaloid/wiki/Basics#class-alertdialogbuilder]]
 *
 * See also: `alert()`
 */
class AlertDialogBuilder(_title: CharSequence = null, _message: CharSequence = null)(implicit context: Context) extends AlertDialog.Builder(context) {
  if (_title != null) setTitle(_title)
  if (_message != null) setMessage(_message)


  @inline def positiveButton(name: CharSequence = android.R.string.yes, onClick: => Unit = {}): AlertDialogBuilder =
    positiveButton(name, (_, _) => {
      onClick
    })

  @inline def positiveButton(name: CharSequence, onClick: (DialogInterface, Int) => Unit): AlertDialogBuilder = {
    setPositiveButton(name, func2DialogOnClickListener(onClick))
    this
  }

  @inline def neutralButton(name: CharSequence = android.R.string.ok, onClick: => Unit = {}): AlertDialogBuilder =
    neutralButton(name, (_, _) => {
      onClick
    })

  @inline def neutralButton(name: CharSequence, onClick: (DialogInterface, Int) => Unit): AlertDialogBuilder = {
    setNeutralButton(name, func2DialogOnClickListener(onClick))
    this
  }

  @inline def negativeButton(name: CharSequence, onClick: => Unit): AlertDialogBuilder =
    negativeButton(name, (_, _) => {
      onClick
    })

  @inline def negativeButton(name: CharSequence = android.R.string.no, onClick: (DialogInterface, Int) => Unit = (d, _) => {
    d.cancel()
  }): AlertDialogBuilder = {
    setNegativeButton(name, func2DialogOnClickListener(onClick))
    this
  }

  var tit: CharSequence = _

  @inline def title_=(str: CharSequence) = {
    tit = str
    setTitle(str)
  }

  @inline def title = tit

  var msg: CharSequence = _

  @inline def message_=(str: CharSequence) = {
    msg = str
    setMessage(str)
  }

  @inline def message = msg

  /**
   * Shows the dialog that is currently building.
   * Because this method runs runOnUiThread internally, you can call this method from any thread.
   * This method blocks until the dialog has been built in the UI thread.
   */
  override def show(): AlertDialog = Await.result(evalOnUiThread(super.show()), Duration.Inf)
}

/**
 * Scaloid wrapper of android.graphics.drawable.StateListDrawable.
 * You can write StateListDrawable simply, for example:
 * {{{
 * new SStateListDrawable {
 *   +=(R.drawable.pressed, PRESSED)
 *   +=(R.drawable.normal)
 * }
 * }}}
 */
class SStateListDrawable extends StateListDrawable {
  val ABOVE_ANCHOR = android.R.attr.state_above_anchor
  val ACTIVE = android.R.attr.state_active
  val CHECKABLE = android.R.attr.state_checkable
  val CHECKED = android.R.attr.state_checked
  val EMPTY = android.R.attr.state_empty
  val ENABLED = android.R.attr.state_enabled
  val EXPANDED = android.R.attr.state_expanded
  val FIRST = android.R.attr.state_first
  val FOCUSED = android.R.attr.state_focused
  val LAST = android.R.attr.state_last
  val LONG_PRESSABLE = android.R.attr.state_long_pressable
  val MIDDLE = android.R.attr.state_middle
  val PRESSED = android.R.attr.state_pressed
  val SELECTED = android.R.attr.state_selected
  val SINGLE = android.R.attr.state_single
  val WINDOW_FOCUSED = android.R.attr.state_window_focused

  def +=(drawable: Drawable, states: Int*): SStateListDrawable = {
    addState(states.toArray, drawable)
    this
  }
}
