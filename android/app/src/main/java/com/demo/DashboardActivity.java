package com.demo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

/**
 * Activity to start from React Native JavaScript, triggered via
 */
public final class DashboardActivity extends ReactActivity {

    @Override
    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();

        if (bundle != null) {
            String data = bundle.getString("DATA");
            TextView tvData = (TextView) findViewById(R.id.tvData);
            tvData.setText("DATA " + data);
        }

        findViewById(R.id.go_back_button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        findViewById(R.id.go_back_button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                try {
                    getReactInstanceManager().getCurrentReactContext()
                            .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                            .emit("DASHBOARD1", "eij eij ej ");

                } catch (Exception e) {
                    Log.e("ReactNative", "Caught Exception: " + e.getMessage());
                }

                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        EditText etData = (EditText) findViewById(R.id.etSetData);

        try {
            getReactInstanceManager().getCurrentReactContext()
                    .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                    .emit("DASHBOARD", etData.getText().toString());

        } catch (Exception e) {
            Log.e("ReactNative", "Caught Exception: " + e.getMessage());
        }
        super.onBackPressed();
    }
}
