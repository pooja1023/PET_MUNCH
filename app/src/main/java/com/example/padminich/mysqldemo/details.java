package com.example.padminich.mysqldemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class details extends AppCompatActivity {
    EditText ageEt,wtEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ageEt=(EditText)findViewById(R.id.etage);
        wtEt=(EditText)findViewById(R.id.etwt);
    }
    public void OnSub(View view)
    {
        String age =ageEt.getText().toString();
        String weight=wtEt.getText().toString();
        String type="sub";
        BackgroundWorker backgroundWorker=new BackgroundWorker(this);
        backgroundWorker.execute(type,age,weight);

    }



    }


