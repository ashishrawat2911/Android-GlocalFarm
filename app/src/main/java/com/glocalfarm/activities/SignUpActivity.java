package com.glocalfarm.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.glocalfarm.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void alreadyAccount(View view) {
        goIntent(LoginActivity.class);

    }

    private void goIntent(Class<?> cls) {
        startActivity(new Intent(SignUpActivity.this, cls));
        finish();
    }

    public void SignU(View view) {
        goIntent(MainActivity.class);
    }
}
