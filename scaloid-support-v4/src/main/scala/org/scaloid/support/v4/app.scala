/*
 *
 *
 *
 *
 * Scaloid: Simpler Android
 *
 * http://scaloid.org
 *
 *
 *
 *
 *
 *
 * Copyright 2013 Sung-Ho Lee and Scaloid contributors
 *
 * Sung-Ho Lee and Scaloid contributors licenses this file to you under the Apache License,
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
import android.content._
import scala.reflect._

/**
 * Automatically generated enriching class of `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html android.support.v4.app.Fragment]]`.
 */
class RichFragment[This <: android.support.v4.app.Fragment](val basis: This) extends TraitFragment[This]

/**
 * Automatically generated helper trait of `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html android.support.v4.app.Fragment]]`. This contains several property accessors.
 */
trait TraitFragment[This <: android.support.v4.app.Fragment] {

  def basis: This

  /**
   * Implicit context for other Scaloid components.
   *
   * [__Caution__] Unlike an activity which is a context by itself,
   * a fragment needs to get attached to underlying activity in order to access the context. When the fragment is not
   * yet attached or was detached during the end of its lifecycle, it will be `null`.
   *
   * For detail, refer to [[http://developer.android.com/guide/components/fragments.html#Lifecycle]].
   */
  implicit def ctx = basis.getActivity

  def inTransaction(f: FragmentTransaction => Unit) = {
    val txn = basis.getFragmentManager.beginTransaction()
    f(txn)
    txn.commit()
  }

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#getActivity() getActivity()]]`
   */
  @inline def activity = basis.getActivity

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#getArguments() getArguments()]]`
   */
  @inline def arguments = basis.getArguments

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#setArguments(android.os.Bundle) setArguments(android.os.Bundle)]]`
   */
  @inline def arguments(p: android.os.Bundle) = arguments_=(p)

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#setArguments(android.os.Bundle) setArguments(android.os.Bundle)]]`
   */
  @inline def arguments_=(p: android.os.Bundle) = { basis.setArguments(p); basis }

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#getFragmentManager() getFragmentManager()]]`
   */
  @inline def fragmentManager = basis.getFragmentManager

  @inline def hasOptionsMenu(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'hasOptionsMenu'")

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#setHasOptionsMenu(boolean) setHasOptionsMenu(boolean)]]`
   */
  @inline def hasOptionsMenu(p: Boolean) = hasOptionsMenu_=(p)

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#setHasOptionsMenu(boolean) setHasOptionsMenu(boolean)]]`
   */
  @inline def hasOptionsMenu_=(p: Boolean) = { basis.setHasOptionsMenu(p); basis }

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#getId() getId()]]`
   */
  @inline def id = basis.getId

  @inline def initialSavedState(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'initialSavedState'")

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#setInitialSavedState(android.support.v4.app.Fragment.SavedState) setInitialSavedState(android.support.v4.app.Fragment.SavedState)]]`
   */
  @inline def initialSavedState(p: android.support.v4.app.Fragment.SavedState) = initialSavedState_=(p)

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#setInitialSavedState(android.support.v4.app.Fragment.SavedState) setInitialSavedState(android.support.v4.app.Fragment.SavedState)]]`
   */
  @inline def initialSavedState_=(p: android.support.v4.app.Fragment.SavedState) = { basis.setInitialSavedState(p); basis }

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#getLoaderManager() getLoaderManager()]]`
   */
  @inline def loaderManager = basis.getLoaderManager

  @inline def menuVisibility(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'menuVisibility'")

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#setMenuVisibility(boolean) setMenuVisibility(boolean)]]`
   */
  @inline def menuVisibility(p: Boolean) = menuVisibility_=(p)

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#setMenuVisibility(boolean) setMenuVisibility(boolean)]]`
   */
  @inline def menuVisibility_=(p: Boolean) = { basis.setMenuVisibility(p); basis }

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#getResources() getResources()]]`
   */
  @inline def resources = basis.getResources

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#getRetainInstance() getRetainInstance()]]`
   */
  @inline def retainInstance = basis.getRetainInstance

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#setRetainInstance(boolean) setRetainInstance(boolean)]]`
   */
  @inline def retainInstance(p: Boolean) = retainInstance_=(p)

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#setRetainInstance(boolean) setRetainInstance(boolean)]]`
   */
  @inline def retainInstance_=(p: Boolean) = { basis.setRetainInstance(p); basis }

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#getTag() getTag()]]`
   */
  @inline def tag = basis.getTag

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#getTargetFragment() getTargetFragment()]]`
   */
  @inline def targetFragment = basis.getTargetFragment

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#getTargetRequestCode() getTargetRequestCode()]]`
   */
  @inline def targetRequestCode = basis.getTargetRequestCode

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#getUserVisibleHint() getUserVisibleHint()]]`
   */
  @inline def userVisibleHint = basis.getUserVisibleHint

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#setUserVisibleHint(boolean) setUserVisibleHint(boolean)]]`
   */
  @inline def userVisibleHint(p: Boolean) = userVisibleHint_=(p)

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#setUserVisibleHint(boolean) setUserVisibleHint(boolean)]]`
   */
  @inline def userVisibleHint_=(p: Boolean) = { basis.setUserVisibleHint(p); basis }

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/Fragment.html#getView() getView()]]`
   */
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
class RichFragmentActivity[This <: android.support.v4.app.FragmentActivity](val basis: This) extends TraitFragmentActivity[This]

/**
 * Automatically generated helper trait of `[[https://developer.android.com/reference/android/support/v4/app/FragmentActivity.html android.support.v4.app.FragmentActivity]]`. This contains several property accessors.
 */
trait TraitFragmentActivity[This <: android.support.v4.app.FragmentActivity] extends TraitActivity[This] {

  override def basis: This

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/FragmentActivity.html#getLastCustomNonConfigurationInstance() getLastCustomNonConfigurationInstance()]]`
   */
  @inline def lastCustomNonConfigurationInstance = basis.getLastCustomNonConfigurationInstance

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/FragmentActivity.html#getSupportFragmentManager() getSupportFragmentManager()]]`
   */
  @inline def supportFragmentManager = basis.getSupportFragmentManager

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/FragmentActivity.html#getSupportLoaderManager() getSupportLoaderManager()]]`
   */
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
 * Automatically generated enriching class of `[[https://developer.android.com/reference/android/support/v4/app/FragmentManager.html android.support.v4.app.FragmentManager]]`.
 */
class RichFragmentManager[This <: android.support.v4.app.FragmentManager](val basis: This) extends TraitFragmentManager[This]

/**
 * Automatically generated helper trait of `[[https://developer.android.com/reference/android/support/v4/app/FragmentManager.html android.support.v4.app.FragmentManager]]`. This contains several property accessors.
 */
trait TraitFragmentManager[This <: android.support.v4.app.FragmentManager] {

  def basis: This

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/FragmentManager.html#getBackStackEntryCount() getBackStackEntryCount()]]`
   */
  @inline def backStackEntryCount = basis.getBackStackEntryCount

  @inline def onBackStackChanged[U](f: => U): This = {
    basis.addOnBackStackChangedListener(new android.support.v4.app.FragmentManager.OnBackStackChangedListener {
      def onBackStackChanged(): Unit = { f }
    })
    basis
  }

}

/**
 * Automatically generated enriching class of `[[https://developer.android.com/reference/android/support/v4/app/FragmentTransaction.html android.support.v4.app.FragmentTransaction]]`.
 */
class RichFragmentTransaction[This <: android.support.v4.app.FragmentTransaction](val basis: This) extends TraitFragmentTransaction[This]

/**
 * Automatically generated helper trait of `[[https://developer.android.com/reference/android/support/v4/app/FragmentTransaction.html android.support.v4.app.FragmentTransaction]]`. This contains several property accessors.
 */
trait TraitFragmentTransaction[This <: android.support.v4.app.FragmentTransaction] {

  def basis: This

  @inline def breadCrumbShortTitle(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'breadCrumbShortTitle'")

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/FragmentTransaction.html#setBreadCrumbShortTitle(int) setBreadCrumbShortTitle(int)]]`
   */
  @inline def breadCrumbShortTitle(p: Int) = breadCrumbShortTitle_=(p)

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/FragmentTransaction.html#setBreadCrumbShortTitle(int) setBreadCrumbShortTitle(int)]]`
   */
  @inline def breadCrumbShortTitle_=(p: Int) = { basis.setBreadCrumbShortTitle(p); basis }

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/FragmentTransaction.html#setBreadCrumbShortTitle(java.lang.CharSequence) setBreadCrumbShortTitle(java.lang.CharSequence)]]`
   */
  @inline def breadCrumbShortTitle(p: java.lang.CharSequence) = breadCrumbShortTitle_=(p)

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/FragmentTransaction.html#setBreadCrumbShortTitle(java.lang.CharSequence) setBreadCrumbShortTitle(java.lang.CharSequence)]]`
   */
  @inline def breadCrumbShortTitle_=(p: java.lang.CharSequence) = { basis.setBreadCrumbShortTitle(p); basis }

  @inline def breadCrumbTitle(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'breadCrumbTitle'")

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/FragmentTransaction.html#setBreadCrumbTitle(int) setBreadCrumbTitle(int)]]`
   */
  @inline def breadCrumbTitle(p: Int) = breadCrumbTitle_=(p)

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/FragmentTransaction.html#setBreadCrumbTitle(int) setBreadCrumbTitle(int)]]`
   */
  @inline def breadCrumbTitle_=(p: Int) = { basis.setBreadCrumbTitle(p); basis }

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/FragmentTransaction.html#setBreadCrumbTitle(java.lang.CharSequence) setBreadCrumbTitle(java.lang.CharSequence)]]`
   */
  @inline def breadCrumbTitle(p: java.lang.CharSequence) = breadCrumbTitle_=(p)

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/FragmentTransaction.html#setBreadCrumbTitle(java.lang.CharSequence) setBreadCrumbTitle(java.lang.CharSequence)]]`
   */
  @inline def breadCrumbTitle_=(p: java.lang.CharSequence) = { basis.setBreadCrumbTitle(p); basis }

  @inline def transition(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'transition'")

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/FragmentTransaction.html#setTransition(int) setTransition(int)]]`
   */
  @inline def transition(p: Int) = transition_=(p)

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/FragmentTransaction.html#setTransition(int) setTransition(int)]]`
   */
  @inline def transition_=(p: Int) = { basis.setTransition(p); basis }

  @inline def transitionStyle(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'transitionStyle'")

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/FragmentTransaction.html#setTransitionStyle(int) setTransitionStyle(int)]]`
   */
  @inline def transitionStyle(p: Int) = transitionStyle_=(p)

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/FragmentTransaction.html#setTransitionStyle(int) setTransitionStyle(int)]]`
   */
  @inline def transitionStyle_=(p: Int) = { basis.setTransitionStyle(p); basis }

}

/**
 * Automatically generated enriching class of `[[https://developer.android.com/reference/android/support/v4/app/ListFragment.html android.support.v4.app.ListFragment]]`.
 */
class RichListFragment[This <: android.support.v4.app.ListFragment](val basis: This) extends TraitListFragment[This]

/**
 * Automatically generated helper trait of `[[https://developer.android.com/reference/android/support/v4/app/ListFragment.html android.support.v4.app.ListFragment]]`. This contains several property accessors.
 */
trait TraitListFragment[This <: android.support.v4.app.ListFragment] extends TraitFragment[This] {

  @inline def emptyText(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'emptyText'")

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/ListFragment.html#setEmptyText(java.lang.CharSequence) setEmptyText(java.lang.CharSequence)]]`
   */
  @inline def emptyText(p: java.lang.CharSequence) = emptyText_=(p)

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/ListFragment.html#setEmptyText(java.lang.CharSequence) setEmptyText(java.lang.CharSequence)]]`
   */
  @inline def emptyText_=(p: java.lang.CharSequence) = { basis.setEmptyText(p); basis }

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/ListFragment.html#getListAdapter() getListAdapter()]]`
   */
  @inline def listAdapter = basis.getListAdapter

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/ListFragment.html#setListAdapter(android.widget.ListAdapter) setListAdapter(android.widget.ListAdapter)]]`
   */
  @inline def listAdapter(p: android.widget.ListAdapter) = listAdapter_=(p)

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/ListFragment.html#setListAdapter(android.widget.ListAdapter) setListAdapter(android.widget.ListAdapter)]]`
   */
  @inline def listAdapter_=(p: android.widget.ListAdapter) = { basis.setListAdapter(p); basis }

  @inline def listShown(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'listShown'")

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/ListFragment.html#setListShown(boolean) setListShown(boolean)]]`
   */
  @inline def listShown(p: Boolean) = listShown_=(p)

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/ListFragment.html#setListShown(boolean) setListShown(boolean)]]`
   */
  @inline def listShown_=(p: Boolean) = { basis.setListShown(p); basis }

  @inline def listShownNoAnimation(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'listShownNoAnimation'")

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/ListFragment.html#setListShownNoAnimation(boolean) setListShownNoAnimation(boolean)]]`
   */
  @inline def listShownNoAnimation(p: Boolean) = listShownNoAnimation_=(p)

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/ListFragment.html#setListShownNoAnimation(boolean) setListShownNoAnimation(boolean)]]`
   */
  @inline def listShownNoAnimation_=(p: Boolean) = { basis.setListShownNoAnimation(p); basis }

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/ListFragment.html#getListView() getListView()]]`
   */
  @inline def listView = basis.getListView

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/ListFragment.html#getSelectedItemId() getSelectedItemId()]]`
   */
  @inline def selectedItemId = basis.getSelectedItemId

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/ListFragment.html#getSelectedItemPosition() getSelectedItemPosition()]]`
   */
  @inline def selectedItemPosition = basis.getSelectedItemPosition

  @inline def selection(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'selection'")

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/ListFragment.html#setSelection(int) setSelection(int)]]`
   */
  @inline def selection(p: Int) = selection_=(p)

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/ListFragment.html#setSelection(int) setSelection(int)]]`
   */
  @inline def selection_=(p: Int) = { basis.setSelection(p); basis }

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
class RichDialogFragment[This <: android.support.v4.app.DialogFragment](val basis: This) extends TraitDialogFragment[This]

/**
 * Automatically generated helper trait of `[[https://developer.android.com/reference/android/support/v4/app/DialogFragment.html android.support.v4.app.DialogFragment]]`. This contains several property accessors.
 */
trait TraitDialogFragment[This <: android.support.v4.app.DialogFragment] extends TraitFragment[This] {

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/DialogFragment.html#isCancelable() isCancelable()]]`
   */
  @inline def cancelable = basis.isCancelable

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/DialogFragment.html#setCancelable(boolean) setCancelable(boolean)]]`
   */
  @inline def cancelable(p: Boolean) = cancelable_=(p)

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/DialogFragment.html#setCancelable(boolean) setCancelable(boolean)]]`
   */
  @inline def cancelable_=(p: Boolean) = { basis.setCancelable(p); basis }

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/DialogFragment.html#getDialog() getDialog()]]`
   */
  @inline def dialog = basis.getDialog

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/DialogFragment.html#getShowsDialog() getShowsDialog()]]`
   */
  @inline def showsDialog = basis.getShowsDialog

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/DialogFragment.html#setShowsDialog(boolean) setShowsDialog(boolean)]]`
   */
  @inline def showsDialog(p: Boolean) = showsDialog_=(p)

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/DialogFragment.html#setShowsDialog(boolean) setShowsDialog(boolean)]]`
   */
  @inline def showsDialog_=(p: Boolean) = { basis.setShowsDialog(p); basis }

  /**
   * Shortcut for `[[https://developer.android.com/reference/android/support/v4/app/DialogFragment.html#getTheme() getTheme()]]`
   */
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

