package com.example.news_projectv10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class loginPage extends AppCompatActivity {

    EditText username,
             password;

    Button loginbtn , registerbtn;

    projectDatabase dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        username = findViewById(R.id.userName_loginPage_edt);
        password = findViewById(R.id.password_loginpage_edt);

        loginbtn = findViewById(R.id.loginpage_login_btn);
        registerbtn = findViewById(R.id.loginpage_register_btn);

        dp = new projectDatabase(this);

        ArrayList<userInfo> persons = dp.getAllUsers();

        if(!persons.isEmpty()) {
            username.setText(persons.get(0).getUsername());
            password.setText(persons.get(0).getPassword());
        }

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                user.trim();
                pass.trim();



                if(user.length()==0 || pass.length()==0) {
                    Toast.makeText(loginPage.this, "enter the empty fields", Toast.LENGTH_SHORT).show();
                } else if(user.length()>18 || pass.length()>18 ){
                    Toast.makeText(loginPage.this, "all filds can't be more than 18 char", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isAvalidUser = dp.checkIfAValidUser(new userInfo(user,pass));
                    if(isAvalidUser) {
                        Toast.makeText(loginPage.this, "login successfully", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(loginPage.this, "username or password wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),registerPage.class);
                startActivity(intent);
            }
        });

    }

}