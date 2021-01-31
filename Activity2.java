package com.example.hackmol;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Activity2 extends AppCompatActivity {
private  Button signout;
private LinearLayout L1,L2,L3,L4,L5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        signout=findViewById(R.id.signout);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Activity2.this,"Successfully Signed Out",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Activity2.this,LogInScreen.class));
                finish();
            }
        });
        L1=findViewById(R.id.linear_view);
        L2=findViewById(R.id.linear_view2);
        L3=findViewById(R.id.linear_view3);
        L4=findViewById(R.id.linear_view4);
        L5=findViewById(R.id.linear_view5);

        L1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity2.this,SellingPage.class);
                startActivity(intent);
            }
        });
        L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity2.this,FurnitureSellingPage.class);
                startActivity(intent);
            }
        });
        L3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity2.this,PlasticSellingPage.class);
                startActivity(intent);
            }
        });
        L4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity2.this,ClothesSellingPage.class);
                startActivity(intent);
            }
        });
        L5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity2.this,BrokCrocSellingPage.class);
                startActivity(intent);
            }
        });

    }
}