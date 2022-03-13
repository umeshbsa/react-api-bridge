package com.demo

import android.os.Bundle
import android.content.Intent
import com.facebook.react.bridge.*

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
            callback.invoke("Speed : ")
        }
    }
}