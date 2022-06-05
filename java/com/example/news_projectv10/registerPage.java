package com.example.news_projectv10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registerPage extends AppCompatActivity {

    EditText username,
             password,
             repassword;

    Button registerbtn;

    projectDatabase dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);


        dp = new projectDatabase(this);


        username = findViewById(R.id.userName_register_edt);
        password = findViewById(R.id.password_register_edt);
        repassword = findViewById(R.id.repetepassword_register_edt);

        registerbtn = findViewById(R.id.registerpage_register_btn);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                user.trim();
                pass.trim();
                repass.trim();

                if(user.length()==0 || pass.length()==0 || repass.length()==0) {
                    Toast.makeText(registerPage.this, "enter the empty fields", Toast.LENGTH_SHORT).show();
                } else if(user.length()>18 || pass.length()>18 || repass.length()>18){
                    Toast.makeText(registerPage.this, "all filds can't be more than 18 char", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(pass.equals(repass)){
                        boolean isuserexist = dp.isUserExist(user);

                        if(isuserexist) {
                            Toast.makeText(registerPage.this, "this user is already exist", Toast.LENGTH_SHORT).show();
                        } else {
                            boolean insertdata = dp.insertNewUser(new userInfo(user , pass));
                            if(insertdata){
                                Toast.makeText(registerPage.this, "register successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(registerPage.this, "error occur", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        Toast.makeText(registerPage.this, "passwords are not the same", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}