package com.example.classassets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class Login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        EditText email = findViewById(R.id.emailLog);
        EditText password = findViewById(R.id.passwordLog);
        Button loginbtn = findViewById(R.id.loginButton);
        TextView signUpPage = findViewById(R.id.signUpPage);
        SpannableString content = new SpannableString("If don't have an account");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        signUpPage.setText(content);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database db = new Database(getApplicationContext());
                String em = email.getText().toString();
                String pass = password.getText().toString();
                String id = db.loginCheck(em,pass);
                if(id != null){

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        i.putExtra("id",id);
                    SharedPreferences.Editor editor = getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE).edit();
                    editor.putString("id", id);
                    editor.putBoolean("isLogged", true);
                    editor.commit();
                        startActivity(i);

                }else{
                    Toast.makeText(getApplicationContext(),"User Not Match!",Toast.LENGTH_SHORT).show();
                }


            }
        });

        TextView logInBtn = findViewById(R.id.signUpPage);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignUp.class);
                startActivity(i);
            }
        });

        Button redirectButton = (Button) findViewById(R.id.redirectToMain);
        redirectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}