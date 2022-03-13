package com.demo

import android.app.Application
import android.content.Context
import com.facebook.react.ReactPackage
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactApplication
import com.facebook.react.shell.MainReactPackage
import com.facebook.soloader.SoLoader
import java.lang.reflect.InvocationTargetException
import java.util.*

class App : Application(), ReactApplication {
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

        INSTANCE = this@App

        SoLoader.init(this,  /* native exopackage */false)
        initializeFlipper(this, reactNativeHost.reactInstanceManager)
    }

    companion object {

        var INSTANCE: App = App()

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