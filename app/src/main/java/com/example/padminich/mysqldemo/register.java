package com.example.padminich.mysqldemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class register extends AppCompatActivity{
    EditText name,email,pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=(EditText)findViewById(R.id.etname);
        email=(EditText)findViewById(R.id.etemail);
        pwd=(EditText)findViewById(R.id.etpassword);

            }

        public void OnReg(View view ){
            String str_name =name.getText().toString();
            String str_email =email.getText().toString();
            String str_pwd =pwd.getText().toString();
            String type="register";
            BackgroundWorker backgroundWorker=new BackgroundWorker(this);
            backgroundWorker.execute(type,str_name,str_email,str_pwd);

        }

    }


