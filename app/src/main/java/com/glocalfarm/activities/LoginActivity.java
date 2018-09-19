package com.glocalfarm.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.glocalfarm.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        goIntent(MainActivity.class);
    }

    public void loginSignUp(View view) {
        goIntent(SignUpActivity.class);
    }

    private void goIntent(Class<?> cls) {
        startActivity(new Intent(LoginActivity.this, cls));
    }
}
