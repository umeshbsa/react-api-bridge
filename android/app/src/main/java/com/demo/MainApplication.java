package com.demo;


import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;

import android.app.Application;
import android.content.Context;
import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.soloader.SoLoader;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import com.facebook.react.shell.MainReactPackage;

public class MainApplication extends Application implements ReactApplication {

  private static final String JS_BUNDLE_NAME = "index.bundle";
  private static final String JS_MAIN_MODULE_NAME = "index";

  private final ReactNativeHost mReactNativeHost =
      new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
           return BuildConfig.DEBUG;
        }


         /**
         * Returns the name of the main module. Determines the URL used to fetch the JS bundle
         * from the packager server. It is only used when dev support is enabled.
         */
        @NonNull
        @Override
        protected String getJSMainModuleName() {
            return JS_MAIN_MODULE_NAME;
        }

        /**
         * Returns the name of the bundle in assets.
         */
        @NonNull
        @Override
        protected String getBundleAssetName() {
            return JS_BUNDLE_NAME;
        }

        /**
         * <p>
         *     Returns a list of {@link ReactPackage}s used by the app.
         * </p>
         * <p>
         *     This method is called by the React Native framework.
         *     It is not normally called by the application itself.
         * </p>
         */
        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.asList(
                    new ActivityStarterReactPackage(),
                    new MainReactPackage()
            );
        }

      };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
    initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
  }

  /**
   * Loads Flipper in React Native templates. Call this in the onCreate method with something like
   * initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
   *
   * @param context
   * @param reactInstanceManager
   */
  private static void initializeFlipper(
      Context context, ReactInstanceManager reactInstanceManager) {
    if (BuildConfig.DEBUG) {
      try {
        /*
         We use reflection here to pick up the class that initializes Flipper,
        since Flipper library is not available in release mode
        */
        Class<?> aClass = Class.forName("com.demo.ReactNativeFlipper");
        aClass
            .getMethod("initializeFlipper", Context.class, ReactInstanceManager.class)
            .invoke(null, context, reactInstanceManager);
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      } catch (NoSuchMethodException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      }
    }
  }
}
