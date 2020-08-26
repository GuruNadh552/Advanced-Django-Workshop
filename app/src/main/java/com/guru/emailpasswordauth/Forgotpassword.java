package com.guru.emailpasswordauth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Forgotpassword extends AppCompatActivity {
    EditText etforemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        etforemail = findViewById(R.id.ForgotemailID);
    }

    public void forgotpassword(View view) {
    }
}
