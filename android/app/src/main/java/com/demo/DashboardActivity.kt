package com.demo

import android.os.Bundle
import android.util.Log
import android.view.View
import com.facebook.react.ReactActivity
import android.widget.TextView
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter
import androidx.annotation.CallSuper
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