package com.arsenal.mnnite_community;

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

public class LogIn extends AppCompatActivity {
    private EditText EdtTxtEmail;
    private EditText EdtTxtPassword;
     private  Button btnLogIn;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        btnLogIn=findViewById(R.id.btnLogIn);
        EdtTxtEmail=findViewById(R.id.EdtTxtEmail);
        EdtTxtPassword=findViewById(R.id.EdtTxtPassword);
        mAuth = FirebaseAuth.getInstance();
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=EdtTxtEmail.getText().toString();
                String password=EdtTxtPassword.getText().toString();

                if(TextUtils.isEmpty(email)){
                    EdtTxtEmail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    EdtTxtPassword.setError("Password is required");
                    return;
                }
                if (password.length()<5){
                    EdtTxtPassword.setError("length should be >5");
                    return;
                }
                //authenticate the user
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LogIn.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(LogIn.this,HomePage.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(LogIn.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}