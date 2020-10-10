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

import com.example.foodsafetyappl.data.customer;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup_Activity extends AppCompatActivity {
    EditText txtEmail, txtPassword, txtphone, txtAddress, txtusername, txtconfirmpass;
    Button btn_register;
    private FirebaseAuth firebaseauth;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_);
        getSupportActionBar().setTitle("Signup_Activity");

        txtEmail = (EditText) findViewById(R.id.editText3);

        txtPassword = (EditText) findViewById(R.id.password);
        txtphone = (EditText) findViewById(R.id.editText2);
        txtAddress = (EditText) findViewById(R.id.editText4);
        txtusername = (EditText) findViewById(R.id.usern);
        txtconfirmpass = (EditText) findViewById(R.id.passwordc);
        firebaseauth = FirebaseAuth.getInstance();
        databaseReference=FirebaseDatabase.getInstance().getReference("customer");

        btn_register=findViewById(R.id.buttonsignup);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
               final String phone = txtphone.getText().toString().trim();
                final String address = txtAddress.getText().toString().trim();
                final String username = txtAddress.getText().toString().trim();
                String confirmpassword = txtconfirmpass.getText().toString().trim();

                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(Signup_Activity.this, "Please enter your  UserName", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Signup_Activity.this, "Please enter your  email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Signup_Activity.this, "Please enter your  password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(Signup_Activity.this, "Please enter your  phoneno", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(address)) {
                    Toast.makeText(Signup_Activity.this, "Please enter your  address", Toast.LENGTH_SHORT).show();
                    return;

                }

                if (TextUtils.isEmpty(confirmpassword)) {
                            Toast.makeText(Signup_Activity.this,"Please enter your  confirm password" ,Toast.LENGTH_SHORT).show();
                    return;}

                    if (password.equals(confirmpassword)) {
                        firebaseauth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Signup_Activity.this, new OnCompleteListener<AuthResult>(){
                                @Override

                                public void onComplete(@NonNull Task<AuthResult> task) {


                                    if (task.isSuccessful()) {
                                        customer information=new customer(username,phone,email,address);
                                        final Task<Void> voidTask = FirebaseDatabase.getInstance().getReference("customer")
                                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        Toast.makeText(Signup_Activity.this, "REGISTRATION COMPLETED", Toast.LENGTH_SHORT).show();

                                                        startActivity(new Intent(getApplicationContext(),loginActivity.class));

                                                    }
                                                });


                                    } else {
                                        Toast.makeText(Signup_Activity.this, "AUTHENTICATION FAILED", Toast.LENGTH_SHORT).show();

                                    }


                                }

                            });
                }

            }
        });
    }
}
