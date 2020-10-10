package com.example.foodsafetyappl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {

    private FirebaseAuth firebaseauth;
Button btn_login;
EditText txtemail,txtpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        firebaseauth = FirebaseAuth.getInstance();
         txtemail = findViewById(R.id.editText6);
         txtpassword = findViewById(R.id.editText7);
        Button btn_login = findViewById(R.id.button5);

        btn_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String email = txtemail.getText().toString().trim();
                String password = txtpassword.getText().toString().trim();





                    firebaseauth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(loginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        startActivity(new Intent(getApplicationContext(),modules_activity.class));

                                    } else {
                                        Toast.makeText(loginActivity.this,"Login failed or User not Available",Toast.LENGTH_SHORT).show();

                                    }


                                }
                            });

            }
        });
    }
}