package com.demo

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import android.app.Activity
import android.os.Bundle
import android.content.Intent
import com.demo.DashboardActivity
import com.demo.AppUtils
import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.demo.ActivityStarterModule
import com.facebook.react.ReactActivity
import com.demo.R
import android.widget.TextView
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter
import android.widget.EditText
import com.facebook.react.ReactActivityDelegate
import com.demo.MainApplication
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactInstanceManager
import com.facebook.react.devsupport.interfaces.DevSupportManager
import com.facebook.react.devsupport.interfaces.DevOptionHandler
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationManagerCompat
import com.demo.MainActivity
import com.facebook.react.ReactApplication
import com.demo.ActivityStarterReactPackage
import com.facebook.react.shell.MainReactPackage
import com.facebook.soloader.SoLoader

class MainActivity : ReactActivity() {
    /**
     * Returns the name of the main component registered from JavaScript. This is used to schedule
     * rendering of the component.
     */
    override fun getMainComponentName(): String? {
        return "demo"
    }

    /**
     * We override to provide launch options that we can read in JavaScript (see buildType).
     */
    override fun createReactActivityDelegate(): ReactActivityDelegate {
        return object : ReactActivityDelegate(this, mainComponentName) {
            override fun getLaunchOptions(): Bundle? {
                val launchOptions = Bundle()
                launchOptions.putString("buildType", BuildConfig.BUILD_TYPE)
                return launchOptions
            }
        }
    }

    /**
     * Demonstrates how to add a custom option to the dev menu.
     * https://stackoverflow.com/a/44882371/3968276
     * This only works from the debug build with dev options enabled.
     */
    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val application = application as MainApplication
        val reactNativeHost = application.reactNativeHost
        val reactInstanceManager = reactNativeHost!!.reactInstanceManager
        val devSupportManager = reactInstanceManager.devSupportManager
        devSupportManager.addCustomDevOption("Custom dev option") {
            if (NotificationManagerCompat.from(this@MainActivity).areNotificationsEnabled()) {
                Toast.makeText(this@MainActivity, CUSTOM_DEV_OPTION_MESSAGE, Toast.LENGTH_LONG)
                    .show()
            } else {
                val dialog = AlertDialog.Builder(this@MainActivity).create()
                dialog.setTitle("Dev option")
                dialog.setMessage(CUSTOM_DEV_OPTION_MESSAGE)
                dialog.show()
            }
        }
    }

    companion object {
        private const val CUSTOM_DEV_OPTION_MESSAGE = "Hello from custom dev option!"
    }
}