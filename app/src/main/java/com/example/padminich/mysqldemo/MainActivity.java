package com.example.padminich.mysqldemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {
EditText emailEt,passwordEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailEt=(EditText)findViewById(R.id.etEmail);
        passwordEt=(EditText)findViewById(R.id.etpassword);
    }
    public void OnLogin(View view)
    {
        String username =emailEt.getText().toString();
        String password =passwordEt.getText().toString();
        String type="login";
        BackgroundWorker backgroundWorker=new BackgroundWorker(this);
        backgroundWorker.execute(type,username,password);

    } public void OpenReg(View view){

        startActivity(new Intent(this,register.class));
    }

    public void OpenSub(View view){
        startActivity(new Intent(this,details.class));
    }

      public void OnExit(View view) {
          String type="logout";
          BackgroundWorker backgroundWorker=new BackgroundWorker(this);
          backgroundWorker.execute(type);
    }
}
