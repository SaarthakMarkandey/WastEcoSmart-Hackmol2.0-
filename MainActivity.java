package com.example.hackmol;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    Animation topAnim,bottomAnim;
    TextView logo;
    ImageView image;
    GifImageView gif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        image=findViewById(R.id.imageView);
        logo=findViewById(R.id.textView);

        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);


        gif=findViewById(R.id.gif);
        gif.setAlpha(0f);
        gif.animate().setDuration(5000).alpha(1f).withEndAction(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this, LogInScreen.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();

            }
        });





    }
}