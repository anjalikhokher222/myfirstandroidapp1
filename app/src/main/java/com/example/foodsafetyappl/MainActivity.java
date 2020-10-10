package com.example.foodsafetyappl;

import android.support.v4.app.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodsafetyappl.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
Button login;
Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS

        );


getSupportActionBar().hide();



        login=findViewById(R.id.button);
        signup=findViewById(R.id.button2);

login.setOnClickListener(new View.OnClickListener() {
    @Override

    public void onClick(View v) {
       Intent intent=new Intent(MainActivity.this , loginActivity.class);
               startActivity(intent);







    }
});
        signup.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Signup_Activity.class);
                startActivity(intent);


            }

});


    }
}
