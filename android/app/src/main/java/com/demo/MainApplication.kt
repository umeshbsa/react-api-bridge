package com.demo

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import android.app.Activity
import android.app.Application
import android.content.Context
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
import com.demo.MainActivity
import com.facebook.react.ReactApplication
import com.demo.ActivityStarterReactPackage
import com.facebook.react.shell.MainReactPackage
import com.facebook.soloader.SoLoader
import java.lang.reflect.InvocationTargetException
import java.util.*

class MainApplication : Application(), ReactApplication {
    private val mReactNativeHost: ReactNativeHost = object : ReactNativeHost(this) {
        override fun getUseDeveloperSupport(): Boolean {
            return BuildConfig.DEBUG
        }

        /**
         * Returns the name of the main module. Determines the URL used to fetch the JS bundle
         * from the packager server. It is only used when dev support is enabled.
         */
        override fun getJSMainModuleName(): String {
            return JS_MAIN_MODULE_NAME
        }

        /**
         * Returns the name of the bundle in assets.
         */
        override fun getBundleAssetName(): String {
            return JS_BUNDLE_NAME
        }

        /**
         *
         *
         * Returns a list of [ReactPackage]s used by the app.
         *
         *
         *
         * This method is called by the React Native framework.
         * It is not normally called by the application itself.
         *
         */
        override fun getPackages(): List<ReactPackage> {
            return Arrays.asList(
                ActivityStarterReactPackage(),
                MainReactPackage()
            )
        }
    }

    override fun getReactNativeHost(): ReactNativeHost {
        return mReactNativeHost
    }

    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this,  /* native exopackage */false)
        initializeFlipper(this, reactNativeHost.reactInstanceManager)
    }

    companion object {
        private const val JS_BUNDLE_NAME = "index.bundle"
        private const val JS_MAIN_MODULE_NAME = "index"

        /**
         * Loads Flipper in React Native templates. Call this in the onCreate method with something like
         * initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
         *
         * @param context
         * @param reactInstanceManager
         */
        private fun initializeFlipper(
            context: Context, reactInstanceManager: ReactInstanceManager
        ) {
            if (BuildConfig.DEBUG) {
                try {
                    /*
         We use reflection here to pick up the class that initializes Flipper,
        since Flipper library is not available in release mode
        */
                    val aClass = Class.forName("com.demo.ReactNativeFlipper")
                    aClass
                        .getMethod(
                            "initializeFlipper",
                            Context::class.java,
                            ReactInstanceManager::class.java
                        )
                        .invoke(null, context, reactInstanceManager)
                } catch (e: ClassNotFoundException) {
                    e.printStackTrace()
                } catch (e: NoSuchMethodException) {
                    e.printStackTrace()
                } catch (e: IllegalAccessException) {
                    e.printStackTrace()
                } catch (e: InvocationTargetException) {
                    e.printStackTrace()
                }
            }
        }
    }
}