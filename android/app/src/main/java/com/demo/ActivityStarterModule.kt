package com.demo

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import com.demo.DashboardActivity
import com.demo.AppUtils
import com.facebook.react.ReactPackage
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
import com.demo.MainActivity
import com.facebook.react.ReactApplication
import com.demo.ActivityStarterReactPackage
import com.facebook.react.bridge.*
import com.facebook.react.shell.MainReactPackage
import com.facebook.soloader.SoLoader

/**
 * Expose Java to JavaScript. Methods annotated with [ReactMethod] are exposed.
 */
internal class ActivityStarterModule(reactContext: ReactApplicationContext?) :
    ReactContextBaseJavaModule(reactContext) {
    /**
     * @return the name of this module. This will be the name used to `require()` this module
     * from JavaScript.
     */
    override fun getName(): String {
        return "ActivityStarter"
    }

    @ReactMethod
    fun navigateToExample(data: String?) {
        val activity = currentActivity
        if (activity != null) {
            val b = Bundle()
            b.putString("DATA", data)
            val intent = Intent(activity, DashboardActivity::class.java)
            intent.putExtras(b)
            activity.startActivity(intent)
        }
    }

    @ReactMethod
    fun getName(callback: Callback) {
        val activity = currentActivity
        if (activity != null) {
            callback.invoke("Speed : " + AppUtils.getSpeed())
        }
    }
}