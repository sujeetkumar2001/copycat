package com.arsenal.mnnite_community;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity {
    private FloatingActionButton create;
    private Button btnLogOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        create=findViewById(R.id.create );
        btnLogOut=findViewById(R.id.btnLogOut);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePage.this, "post karo na yaar", Toast.LENGTH_SHORT).show();
            }
        });
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             FirebaseAuth.getInstance().signOut();
             startActivity(new Intent(HomePage.this,MainActivity.class));
             finish();
            }
        });
    }


}