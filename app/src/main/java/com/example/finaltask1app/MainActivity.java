package com.example.finaltask1app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.resources.MaterialAttributes;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button strtbtn = findViewById(R.id.startbtn);
        strtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent strtapp = new Intent(getApplicationContext(),mainscreen.class);
                startActivity(strtapp);
                //MainActivity.this.finish();
                //System.exit(0);
            }
        });

    }


}