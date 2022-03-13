package com.demo

import android.os.Bundle
import com.facebook.react.ReactActivity
import com.facebook.react.ReactActivityDelegate
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationManagerCompat

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
        val application = application as App
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