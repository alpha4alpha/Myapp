package com.example.fyp2.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fyp2.R;
import com.example.fyp2.Acitivities.drawer;


public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button LoginButton = findViewById(R.id.LoginButton);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(LoginActivity.this, drawer.class);
                startActivity(i);

            }
        });

    }

        /*
            public void browser1(View view)
            {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://carb.extensasol.com/signUp.html"));
                startActivity(browserIntent);

            }*/

}
