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
 * Copyright 2013 Sung-Ho Lee
 *
 * Sung-Ho Lee licenses this file to you under the Apache License,
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
 * This file is automatically generated. Any changes on this file will be overwritten!
 */

package org.scaloid.common

import android.app._
import admin.DevicePolicyManager
import android.view._
import android.net._
import android.os._
import android.media._

import android.view.accessibility._
import android.accounts._
import android.view.inputmethod._
import android.location._
import android.hardware._
import android.telephony._
import android.net.wifi._
import android.content._
import java.lang.CharSequence

import language.implicitConversions

trait SystemService {
  @inline def accessibilityManager(implicit context: Context) =
    context.getSystemService(Context.ACCESSIBILITY_SERVICE).asInstanceOf[android.view.accessibility.AccessibilityManager]

  @inline def accountManager(implicit context: Context) =
    context.getSystemService(Context.ACCOUNT_SERVICE).asInstanceOf[android.accounts.AccountManager]

  @inline def activityManager(implicit context: Context) =
    context.getSystemService(Context.ACTIVITY_SERVICE).asInstanceOf[android.app.ActivityManager]

  @inline def alarmManager(implicit context: Context) =
    context.getSystemService(Context.ALARM_SERVICE).asInstanceOf[android.app.AlarmManager]

  @inline def audioManager(implicit context: Context) =
    context.getSystemService(Context.AUDIO_SERVICE).asInstanceOf[android.media.AudioManager]

  @inline def clipboardManager(implicit context: Context) =
    context.getSystemService(Context.CLIPBOARD_SERVICE).asInstanceOf[android.text.ClipboardManager]


  class RichClipboardManager(cm: android.text.ClipboardManager) {
    def text_=(txt: CharSequence) = cm.setText(txt)
    def text = cm.getText
  }

  @inline implicit def richClipboardManager(cm: android.text.ClipboardManager): RichClipboardManager = new RichClipboardManager(cm)

  @inline def connectivityManager(implicit context: Context) =
    context.getSystemService(Context.CONNECTIVITY_SERVICE).asInstanceOf[android.net.ConnectivityManager]

  @inline def devicePolicyManager(implicit context: Context) =
    context.getSystemService(Context.DEVICE_POLICY_SERVICE).asInstanceOf[android.app.admin.DevicePolicyManager]

  @inline def dropBoxManager(implicit context: Context) =
    context.getSystemService(Context.DROPBOX_SERVICE).asInstanceOf[android.os.DropBoxManager]

  @inline def inputMethodManager(implicit context: Context) =
    context.getSystemService(Context.INPUT_METHOD_SERVICE).asInstanceOf[android.view.inputmethod.InputMethodManager]

  @inline def keyguardManager(implicit context: Context) =
    context.getSystemService(Context.KEYGUARD_SERVICE).asInstanceOf[android.app.KeyguardManager]

  @inline def layoutInflater(implicit context: Context) =
    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE).asInstanceOf[android.view.LayoutInflater]

  @inline def locationManager(implicit context: Context) =
    context.getSystemService(Context.LOCATION_SERVICE).asInstanceOf[android.location.LocationManager]

  @inline def notificationManager(implicit context: Context) =
    context.getSystemService(Context.NOTIFICATION_SERVICE).asInstanceOf[android.app.NotificationManager]

  @inline def powerManager(implicit context: Context) =
    context.getSystemService(Context.POWER_SERVICE).asInstanceOf[android.os.PowerManager]

  @inline def searchManager(implicit context: Context) =
    context.getSystemService(Context.SEARCH_SERVICE).asInstanceOf[android.app.SearchManager]

  @inline def sensorManager(implicit context: Context) =
    context.getSystemService(Context.SENSOR_SERVICE).asInstanceOf[android.hardware.SensorManager]

  @inline def telephonyManager(implicit context: Context) =
    context.getSystemService(Context.TELEPHONY_SERVICE).asInstanceOf[android.telephony.TelephonyManager]


  def onCallForwardingIndicatorChanged(fun: Boolean => Any)(implicit ctx: Context, reg: Registerable) {
    val callStateListener = new PhoneStateListener() {
      override def onCallForwardingIndicatorChanged(cfi: Boolean) {
        fun(cfi)
      }
    }
    reg.onRegister {
      telephonyManager.listen(callStateListener, PhoneStateListener.LISTEN_CALL_FORWARDING_INDICATOR)
    }
    reg.onUnregister {
      telephonyManager.listen(callStateListener, PhoneStateListener.LISTEN_NONE)
    }
  }

  def onCallStateChanged(fun: (Int, String) => Any)(implicit ctx: Context, reg: Registerable) {
    val callStateListener = new PhoneStateListener() {
      override def onCallStateChanged(state: Int, incomingNumber: String) {
        fun(state, incomingNumber)
      }
    }
    reg.onRegister {
      telephonyManager.listen(callStateListener, PhoneStateListener.LISTEN_CALL_STATE)
    }
    reg.onUnregister {
      telephonyManager.listen(callStateListener, PhoneStateListener.LISTEN_NONE)
    }
  }

  def onCellLocationChanged(fun: CellLocation => Any)(implicit ctx: Context, reg: Registerable) {
    val callStateListener = new PhoneStateListener() {
      override def onCellLocationChanged(cellLocation: CellLocation) {
        fun(cellLocation)
      }
    }
    reg.onRegister {
      telephonyManager.listen(callStateListener, PhoneStateListener.LISTEN_CELL_LOCATION)
    }
    reg.onUnregister {
      telephonyManager.listen(callStateListener, PhoneStateListener.LISTEN_NONE)
    }
  }

  @inline def uiModeManager(implicit context: Context) =
    context.getSystemService(Context.UI_MODE_SERVICE).asInstanceOf[android.app.UiModeManager]

  @inline def vibrator(implicit context: Context) =
    context.getSystemService(Context.VIBRATOR_SERVICE).asInstanceOf[android.os.Vibrator]

  @inline def wallpaperManager(implicit context: Context) =
    context.getSystemService(Context.WALLPAPER_SERVICE).asInstanceOf[android.app.WallpaperManager]

  @inline def wifiManager(implicit context: Context) =
    context.getSystemService(Context.WIFI_SERVICE).asInstanceOf[android.net.wifi.WifiManager]

  @inline def windowManager(implicit context: Context) =
    context.getSystemService(Context.WINDOW_SERVICE).asInstanceOf[android.view.WindowManager]

}