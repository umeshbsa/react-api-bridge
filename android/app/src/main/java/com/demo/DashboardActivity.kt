package com.demo

import android.os.Bundle
import android.util.Log
import android.view.View
import com.facebook.react.ReactActivity
import android.widget.TextView
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter
import androidx.annotation.CallSuper
import androidx.viewbinding.ViewBinding
import com.demo.databinding.ActivityDashboardBinding
import com.demo.databinding.ActivitySigninBinding
import java.lang.Exception

/**
 * Activity to start from React Native JavaScript, triggered via
 */
class DashboardActivity : BaseActivity() {

    private lateinit var ui: ActivityDashboardBinding

    override fun layoutRes(): ViewBinding {
        return ActivityDashboardBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = binding as ActivityDashboardBinding

        val i = intent
        val bundle = i.extras
        if (bundle != null) {
            val data = bundle.getString("DATA")

            ui.tvData.text = "DATA $data"
        }

        ui.goBackButton1.setOnClickListener {
            launchActivity(SignInActivity::class.java)
        }


        ui.goBackButton2.setOnClickListener {
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