package com.example.m;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton;
    private EditText  loginphoneImput,loginPasswordImput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button) findViewById(R.id.login_btn);
        loginphoneImput = (EditText) findViewById(R.id.login_phone_input);
        loginPasswordImput =(EditText) findViewById((R.id.login_password_input));

    }
}
