package com.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Expose Java to JavaScript. Methods annotated with {@link ReactMethod} are exposed.
 */
final class ActivityStarterModule extends ReactContextBaseJavaModule {

    ActivityStarterModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * @return the name of this module. This will be the name used to {@code require()} this module
     * from JavaScript.
     */
    @Override
    public String getName() {
        return "ActivityStarter";
    }

    @ReactMethod
    void navigateToExample(String data) {
        Activity activity = getCurrentActivity();
        if (activity != null) {
            Bundle b = new Bundle();
            b.putString("DATA", data);
            Intent intent = new Intent(activity, DashboardActivity.class);
            intent.putExtras(b);
            activity.startActivity(intent);
        }
    }

    @ReactMethod
    void getName(@NonNull Callback callback) {
        Activity activity = getCurrentActivity();
        if (activity != null) {
            callback.invoke("Speed : " + AppUtils.getSpeed());
        }
    }
}
