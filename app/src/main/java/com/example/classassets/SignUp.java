package com.example.classassets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EditText name = findViewById(R.id.name);
        EditText email = findViewById(R.id.email);
        EditText phone = findViewById(R.id.phone);
        EditText password = findViewById(R.id.password);

    Button btnsign = findViewById(R.id.signUpButton);
    btnsign.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Database db = new Database(getApplicationContext());
            db.insertUser(name.getText().toString(), email.getText().toString(), phone.getText().toString(), password.getText().toString());
            Toast.makeText(getApplicationContext(),"Data Saved",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(), Login_Activity.class);
            startActivity(i);
        }
    });

    TextView logInBtn = findViewById(R.id.loginPage);
        SpannableString content = new SpannableString("If Already have an account");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        logInBtn.setText(content);
    logInBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), Login_Activity.class);
            startActivity(i);
        }
    });
    }
}