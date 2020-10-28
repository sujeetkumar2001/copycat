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
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {
    private EditText EdtTxtName;
    private EditText EdtTxtUserName;
    private EditText EdtTxtEmail;
    private EditText EdtTxtPassword;
    private EditText EdtTxtRegNo;
    private EditText EdtTxtYear;
    private Button   btnSignUp;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EdtTxtName=findViewById(R.id.EdtTxtName);
        EdtTxtUserName=findViewById(R.id.EdtTxtUsername);
        EdtTxtEmail=findViewById(R.id.EdtTxtEmail);
        EdtTxtPassword=findViewById(R.id.EdtTxtPassword);
        EdtTxtRegNo=findViewById(R.id.EdtTxtRegNo);
        EdtTxtYear=findViewById(R.id.EdtTxtYear);
        btnSignUp=findViewById(R.id.btnSignUp);
        mAuth = FirebaseAuth.getInstance();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validating the data
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
                // registering the user in firebase
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignUp.this, "Signed up successfully", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(SignUp.this,HomePage.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SignUp.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });


    }
}