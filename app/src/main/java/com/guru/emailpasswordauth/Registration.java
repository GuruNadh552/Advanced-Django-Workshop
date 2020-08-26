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

public class Registration extends AppCompatActivity {
    EditText etRegemail,etRegPass;

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etRegemail = findViewById(R.id.registerEmailId);
        etRegPass = findViewById(R.id.registerpassword);
        auth = FirebaseAuth.getInstance();
    }

    public void register(View view) {
        String email_reg,pass_reg;
        email_reg = etRegemail.getText().toString();
        pass_reg = etRegPass.getText().toString();
        auth.createUserWithEmailAndPassword(email_reg,pass_reg).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                   Toast.makeText(Registration.this,"Registration Done ",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(Registration.this,"Registration Failed ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void openLoginActivity(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
