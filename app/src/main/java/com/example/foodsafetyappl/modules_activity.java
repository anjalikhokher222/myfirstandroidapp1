package com.example.foodsafetyappl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.foodsafetyappl.ui.login.LoginActivity;

public class modules_activity extends AppCompatActivity {
    Button adulterants;
Button uploadfoodarticles;
Button consumer;
Button foodalertnews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules_activity);

        foodalertnews=findViewById(R.id.button9);
        adulterants = findViewById(R.id.button3);
        uploadfoodarticles = findViewById(R.id.button4);
consumer=findViewById(R.id.button6);
        adulterants.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                startActivity(new Intent(getApplicationContext(),recyclerview.class));



            }
        });
        uploadfoodarticles.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                startActivity(new Intent(getApplicationContext(),uploadpdf_activity.class));



            }
        });

        consumer.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                startActivity(new Intent(getApplicationContext(),Consumer_activity.class));


            }
        });
        foodalertnews.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                startActivity(new Intent(getApplicationContext(),foodalertrecyclerview_activity.class));


            }
        });





    }
}

