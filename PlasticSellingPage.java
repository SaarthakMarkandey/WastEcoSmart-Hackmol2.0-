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
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

public class PlasticSellingPage extends AppCompatActivity {
    Button button;
    String address,uid;
    String points;
    String wastetype="";
    FirebaseUser user;
    private Spinner spinner;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling_page);
        user= FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();
        spinner=findViewById(R.id.spinner);
        List<String> type=new ArrayList<>();
        type.add("Choose Waste Type");
        type.add("Plastic");

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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(PlasticSellingPage.this,FinalPage3.class);
                startActivity(intent);
            }
        });
    }
}