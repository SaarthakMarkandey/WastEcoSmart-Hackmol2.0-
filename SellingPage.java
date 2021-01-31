package com.example.hackmol;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class SellingPage extends AppCompatActivity {
    Button button;
    String address,uid;
    String points;
    String email,name;
    String wastetype="";
    FirebaseUser user;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling_page);
        user= FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();
        spinner=findViewById(R.id.spinner);
        List<String> type=new ArrayList<>();
        type.add("Choose Waste Type");
        type.add("Laptop/pc");
        type.add("Mobile");
        type.add("Speaker");
        type.add("Other");
        ArrayAdapter<String> typeAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,type);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(typeAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String type=spinner.getSelectedItem().toString();
                if (!type.equals("Choose Waste Type")){
                    wastetype=type;
                }
                else {
                    wastetype="";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        button=findViewById(R.id.sellbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(SellingPage.this,FinalPage.class);
                startActivity(intent);
            }
        });




    }
}