/* 
 *
 * 
 *
 *
 * Less painful Android development with Scala
 *
 * http://scaloid.org
 *
 *
 *
 *
 *
 *
 * Copyright 2013 Sung-Ho Lee and Scaloid team
 *
 * Sung-Ho Lee and Scaloid team licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

/*
 * This file is automatically generated. Any changes on this file will be OVERWRITTEN!
 * To learn how to contribute, please refer to:
 * https://github.com/pocorall/scaloid/wiki/Inside-Scaloid
 */

package org.scaloid.support.v4

import org.scaloid.common._
import android.support.v4.app._
import reflect._
import android.content._


/**
 * Automatically generated enriching class of `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html android.support.v4.app.Fragment]]`.
 */
class RichFragment[V <: android.support.v4.app.Fragment](val basis: V) extends TraitFragment[V]

/**
 * Automatically generated helper trait of `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html android.support.v4.app.Fragment]]`. This contains several property accessors.
 */
trait TraitFragment[V <: android.support.v4.app.Fragment] {

  def basis: V



  @inline def activity = basis.getActivity

  @inline def arguments = basis.getArguments
  @inline def arguments  (p: android.os.Bundle) =            arguments_=  (p)
  @inline def arguments_=(p: android.os.Bundle) = { basis.setArguments    (p); basis }

  @inline def fragmentManager = basis.getFragmentManager

  @inline def hasOptionsMenu(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'hasOptionsMenu'")
  @inline def hasOptionsMenu  (p: Boolean) =            hasOptionsMenu_=  (p)
  @inline def hasOptionsMenu_=(p: Boolean) = { basis.setHasOptionsMenu    (p); basis }

  @inline def id = basis.getId

  @inline def initialSavedState(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'initialSavedState'")
  @inline def initialSavedState  (p: android.support.v4.app.Fragment.SavedState) =            initialSavedState_=  (p)
  @inline def initialSavedState_=(p: android.support.v4.app.Fragment.SavedState) = { basis.setInitialSavedState    (p); basis }

  @inline def loaderManager = basis.getLoaderManager

  @inline def menuVisibility(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'menuVisibility'")
  @inline def menuVisibility  (p: Boolean) =            menuVisibility_=  (p)
  @inline def menuVisibility_=(p: Boolean) = { basis.setMenuVisibility    (p); basis }

  @inline def resources = basis.getResources

  @inline def retainInstance = basis.getRetainInstance
  @inline def retainInstance  (p: Boolean) =            retainInstance_=  (p)
  @inline def retainInstance_=(p: Boolean) = { basis.setRetainInstance    (p); basis }

  @inline def tag = basis.getTag

  @inline def targetFragment = basis.getTargetFragment

  @inline def targetRequestCode = basis.getTargetRequestCode

  @inline def userVisibleHint = basis.getUserVisibleHint
  @inline def userVisibleHint  (p: Boolean) =            userVisibleHint_=  (p)
  @inline def userVisibleHint_=(p: Boolean) = { basis.setUserVisibleHint    (p); basis }

  @inline def view = basis.getView


  @inline def startActivity[T: ClassTag](implicit context: Context): Unit = basis.startActivity(SIntent[T])

  @inline def startActivityForResult[T: ClassTag](p: Int)(implicit context: Context): Unit = basis.startActivityForResult(SIntent[T], p)
}

/**
 * Automatically generated concrete helper class of `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html android.support.v4.app.Fragment]]`.
 */
class SFragment()
    extends android.support.v4.app.Fragment() with TraitFragment[SFragment] {

  def basis = this

}

object SFragment {
  def apply(): SFragment = {
    val v = new SFragment
    v
  }

}


/**
 * Automatically generated enriching class of `[[https://developer.android.com/reference/android/support/v4/app/FragmentActivity.html android.support.v4.app.FragmentActivity]]`.
 */
class RichFragmentActivity[V <: android.support.v4.app.FragmentActivity](val basis: V) extends TraitFragmentActivity[V]

/**
 * Automatically generated helper trait of `[[https://developer.android.com/reference/android/support/v4/app/FragmentActivity.html android.support.v4.app.FragmentActivity]]`. This contains several property accessors.
 */
trait TraitFragmentActivity[V <: android.support.v4.app.FragmentActivity] extends TraitActivity[V] {


  override def basis: V

  @inline def lastCustomNonConfigurationInstance = basis.getLastCustomNonConfigurationInstance

  @inline def supportFragmentManager = basis.getSupportFragmentManager

  @inline def supportLoaderManager = basis.getSupportLoaderManager


}

/**
 * Automatically generated concrete helper class of `[[https://developer.android.com/reference/android/support/v4/app/FragmentActivity.html android.support.v4.app.FragmentActivity]]`.
 */
class SFragmentActivity()
    extends android.support.v4.app.FragmentActivity() with TraitFragmentActivity[SFragmentActivity] {

  def basis = this

}

object SFragmentActivity {
  def apply(): SFragmentActivity = {
    val v = new SFragmentActivity
    v
  }

}


/**
 * Automatically generated enriching class of `[[https://developer.android.com/reference/android/support/v4/app/ListFragment.html android.support.v4.app.ListFragment]]`.
 */
class RichListFragment[V <: android.support.v4.app.ListFragment](val basis: V) extends TraitListFragment[V]

/**
 * Automatically generated helper trait of `[[https://developer.android.com/reference/android/support/v4/app/ListFragment.html android.support.v4.app.ListFragment]]`. This contains several property accessors.
 */
trait TraitListFragment[V <: android.support.v4.app.ListFragment] extends TraitFragment[V] {




  @inline def emptyText(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'emptyText'")
  @inline def emptyText  (p: java.lang.CharSequence) =            emptyText_=  (p)
  @inline def emptyText_=(p: java.lang.CharSequence) = { basis.setEmptyText    (p); basis }

  @inline def listAdapter = basis.getListAdapter
  @inline def listAdapter  (p: android.widget.ListAdapter) =            listAdapter_=  (p)
  @inline def listAdapter_=(p: android.widget.ListAdapter) = { basis.setListAdapter    (p); basis }

  @inline def listShown(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'listShown'")
  @inline def listShown  (p: Boolean) =            listShown_=  (p)
  @inline def listShown_=(p: Boolean) = { basis.setListShown    (p); basis }

  @inline def listShownNoAnimation(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'listShownNoAnimation'")
  @inline def listShownNoAnimation  (p: Boolean) =            listShownNoAnimation_=  (p)
  @inline def listShownNoAnimation_=(p: Boolean) = { basis.setListShownNoAnimation    (p); basis }

  @inline def listView = basis.getListView

  @inline def selectedItemId = basis.getSelectedItemId

  @inline def selectedItemPosition = basis.getSelectedItemPosition

  @inline def selection(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'selection'")
  @inline def selection  (p: Int) =            selection_=  (p)
  @inline def selection_=(p: Int) = { basis.setSelection    (p); basis }

}

/**
 * Automatically generated concrete helper class of `[[https://developer.android.com/reference/android/support/v4/app/ListFragment.html android.support.v4.app.ListFragment]]`.
 */
class SListFragment()
    extends android.support.v4.app.ListFragment() with TraitListFragment[SListFragment] {

  def basis = this

}

object SListFragment {
  def apply(): SListFragment = {
    val v = new SListFragment
    v
  }

}


/**
 * Automatically generated enriching class of `[[https://developer.android.com/reference/android/support/v4/app/DialogFragment.html android.support.v4.app.DialogFragment]]`.
 */
class RichDialogFragment[V <: android.support.v4.app.DialogFragment](val basis: V) extends TraitDialogFragment[V]

/**
 * Automatically generated helper trait of `[[https://developer.android.com/reference/android/support/v4/app/DialogFragment.html android.support.v4.app.DialogFragment]]`. This contains several property accessors.
 */
trait TraitDialogFragment[V <: android.support.v4.app.DialogFragment] extends TraitFragment[V] {




  @inline def cancelable = basis.isCancelable
  @inline def cancelable  (p: Boolean) =            cancelable_=  (p)
  @inline def cancelable_=(p: Boolean) = { basis.setCancelable    (p); basis }

  @inline def dialog = basis.getDialog

  @inline def showsDialog = basis.getShowsDialog
  @inline def showsDialog  (p: Boolean) =            showsDialog_=  (p)
  @inline def showsDialog_=(p: Boolean) = { basis.setShowsDialog    (p); basis }

  @inline def theme = basis.getTheme


}

/**
 * Automatically generated concrete helper class of `[[https://developer.android.com/reference/android/support/v4/app/DialogFragment.html android.support.v4.app.DialogFragment]]`.
 */
class SDialogFragment()
    extends android.support.v4.app.DialogFragment() with TraitDialogFragment[SDialogFragment] {

  def basis = this

}

object SDialogFragment {
  def apply(): SDialogFragment = {
    val v = new SDialogFragment
    v
  }

}



