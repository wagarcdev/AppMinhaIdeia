package com.arcieri.wagner.appminhaideia.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.arcieri.wagner.appminhaideia.R;
import com.arcieri.wagner.appminhaideia.api.AppUtil;
import com.arcieri.wagner.appminhaideia.model.Client;

public class SplashActivityNew extends AppCompatActivity {


    int timeDelay = 1000 * 3 ;

    Client objectClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_new);

        int timeDelay = 1000 * 3 ;


        changeScreen();


    }

    private void changeScreen() {

        Log.d(AppUtil.TAG, "changeScreen: CHANGING SCREEN");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                objectClient = new Client(
                        "Wagner",
                        "wagner@email.com",
                        "48 9 9191 9191",
                        30,
                        true
                );


                Log.d(AppUtil.TAG, "run: DELAYING SOME TIME....");

                Intent changeOfScreen = new Intent(SplashActivityNew.this, MainActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("name", objectClient.getName());
                bundle.putString("email", objectClient.getEmail());
                bundle.putString("telephone", objectClient.getTelephone());
                bundle.putInt("age", objectClient.getAge());
                bundle.putBoolean("gender", objectClient.isGender());

                changeOfScreen.putExtras(bundle);

                startActivity(changeOfScreen);
                finish();

            }
        }, timeDelay);

    }

}