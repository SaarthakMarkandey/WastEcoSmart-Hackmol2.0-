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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInScreen extends AppCompatActivity {
    private TextInputEditText email;
    private TextInputEditText password;
    private Button signin,signup;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);
        TextView textView=(TextView)findViewById(R.id.website);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        signin=findViewById(R.id.loginbtn);
        auth=FirebaseAuth.getInstance();
        signup=findViewById(R.id.Signbtn);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email=email.getText().toString();
                String txt_password=password.getText().toString();


                if(TextUtils.isEmpty(txt_email)||TextUtils.isEmpty(txt_password)){
                    Toast.makeText(LogInScreen.this,"Empty Credentials",Toast.LENGTH_SHORT).show();
                }
                else{
                    loginUser(txt_email,txt_password);
                }

            }

            private void loginUser(String email, String password) {
                auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(LogInScreen.this,"Sign In Successfull",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LogInScreen.this,Activity2.class));
                        finish();
                    }
                });
                auth.signInWithEmailAndPassword(email, password).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LogInScreen.this,"Email or Password Incorrect",Toast.LENGTH_SHORT).show();

                    }
                });

            }


        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LogInScreen.this,SigInScreen.class);
                startActivity(intent);
                finish();
            }
        });
    }


}