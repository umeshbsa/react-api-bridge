package com.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;

import com.facebook.react.ReactActivity;

/**
 * Activity to start from React Native JavaScript, triggered via
 */
public final class PostActivity extends ReactActivity {

    @Override
    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();

        if (bundle != null) {
            String data = bundle.getString("DATA");
            TextView tvData = (TextView) findViewById(R.id.tvData);
            tvData.setText("DATA " + data);
        }

        findViewById(R.id.go_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }
}
