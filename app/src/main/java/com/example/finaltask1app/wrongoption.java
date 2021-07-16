package com.example.finaltask1app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class wrongoption extends AppCompatActivity {
    TextView txtvw;
    Button rstrtbtn,extapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrongoption);
        txtvw = findViewById(R.id.txtscre);
        rstrtbtn = findViewById(R.id.restrtbtn);
        extapp = findViewById(R.id.extapp);
        int score = getIntent().getIntExtra("mycount", 0);
        txtvw.setText(score+"");

        rstrtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rstrt = new Intent(wrongoption.this,MainActivity.class);
                startActivity(rstrt);
            }
        });

        extapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                //wrongoption.this.finish();
                //System.exit(0);

            }
        });



    }
}