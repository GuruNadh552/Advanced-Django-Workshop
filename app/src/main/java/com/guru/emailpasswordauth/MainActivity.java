package com.guru.emailpasswordauth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText etloginemail,etloginpassword;
    FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mauth = FirebaseAuth.getInstance();
        etloginemail = findViewById(R.id.loginEmailId);
        etloginpassword = findViewById(R.id.loginpassword);
    }

    public void login(View view) {

        String email,password;
        email = etloginemail.getText().toString();
        password = etloginpassword.getText().toString();
        mauth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this,"Login Success",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void openforgotActivity(View view) {
        Intent i = new Intent(this,Forgotpassword.class);
        startActivity(i);
    }

    public void openRegistrationActivity(View view) {
        Intent i = new Intent(this,Registration.class);
        startActivity(i);
    }
}
