package com.demo

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.view.View
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
import com.demo.MainActivity
import com.facebook.react.ReactApplication
import com.demo.ActivityStarterReactPackage
import com.facebook.react.shell.MainReactPackage
import com.facebook.soloader.SoLoader
import java.lang.Exception

/**
 * Activity to start from React Native JavaScript, triggered via
 */
class DashboardActivity : ReactActivity() {
    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val i = intent
        val bundle = i.extras
        if (bundle != null) {
            val data = bundle.getString("DATA")
            val tvData = findViewById<View>(R.id.tvData) as TextView
            tvData.text = "DATA $data"
        }
        findViewById<View>(R.id.go_back_button1).setOnClickListener { onBackPressed() }
        findViewById<View>(R.id.go_back_button2).setOnClickListener {
            try {
                reactInstanceManager.currentReactContext
                    ?.getJSModule(RCTDeviceEventEmitter::class.java)
                    ?.emit("DASHBOARD1", "eij eij ej ")
            } catch (e: Exception) {
                Log.e("ReactNative", "Caught Exception: " + e.message)
            }
            onBackPressed()
        }
    }

}