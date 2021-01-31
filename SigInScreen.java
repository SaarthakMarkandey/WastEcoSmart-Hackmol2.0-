package com.example.hackmol;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SigInScreen extends AppCompatActivity {
    private TextInputEditText email;
    String point="0";
    private TextInputEditText password,name;
    private Button CreateAccount;
    private FirebaseAuth auth;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sig_in_screen);
        TextView textView=(TextView)findViewById(R.id.website);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        email=findViewById(R.id.email);
        name=findViewById(R.id.name);
        password=findViewById(R.id.password);
        CreateAccount=findViewById(R.id.newaccbtn);
        auth=FirebaseAuth.getInstance();
        databaseReference=FirebaseDatabase.getInstance().getReference("UserInfo");
        CreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email=email.getText().toString();
                String txt_name=name.getText().toString();
                String txt_password=password.getText().toString();
                if(TextUtils.isEmpty(txt_email)||TextUtils.isEmpty(txt_password)){
                    Toast.makeText(SigInScreen.this,"Empty Credentials",Toast.LENGTH_SHORT).show();
                }
                else {
                    registerUser(txt_email,txt_password,txt_name);
                }
            }

            private void registerUser(String email, String password,String name) {
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SigInScreen.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User information=new User(name,email,point);
                            FirebaseDatabase.getInstance().getReference("UserInfo")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(information)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(SigInScreen.this,"Sign In Successfull",Toast.LENGTH_SHORT).show();
                                            Intent intent=new Intent(SigInScreen.this,Activity2.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    });

                        }
                        else {
                            Toast.makeText(SigInScreen.this,"Sign In F0000ailed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}