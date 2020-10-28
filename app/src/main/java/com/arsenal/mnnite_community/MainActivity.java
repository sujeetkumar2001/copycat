package com.arsenal.mnnite_community;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnSignUpMainActivityPage;
    private Button btnLogIn;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSignUpMainActivityPage=findViewById(R.id.btnSignUpMainActivityPage);
        btnLogIn=findViewById(R.id.btnLogIn);
        mAuth = FirebaseAuth.getInstance();
        // checking if someone is already logged in or not
        if(mAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),HomePage.class));
            finish();
        }




        btnSignUpMainActivityPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SignUp.class);
                startActivity(i);
            }
        });
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,LogIn.class);
                startActivity(i);
            }
        });
    }
}