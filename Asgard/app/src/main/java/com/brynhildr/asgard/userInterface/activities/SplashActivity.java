package com.brynhildr.asgard.userInterface.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.brynhildr.asgard.R;
import com.brynhildr.asgard.connection.GetEventsFromRemote;
import com.brynhildr.asgard.connection.GetRelationsFromRemote;

public class SplashActivity extends Activity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new GetEventsFromRemote().execute();
        new GetRelationsFromRemote().execute();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
