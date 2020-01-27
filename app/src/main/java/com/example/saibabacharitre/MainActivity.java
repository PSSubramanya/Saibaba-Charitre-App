package com.example.saibabacharitre;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    TextView saibabatext;
    CircleImageView saibabaicon;

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        saibabaicon = (CircleImageView)findViewById(R.id.saibabaicon);
        saibabatext = (TextView)findViewById(R.id.saibabatext);


        Animation animation = AnimationUtils.loadAnimation(this,R.anim.slidedown);

        saibabaicon.startAnimation(animation);
        saibabatext.startAnimation(animation);


        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,OptionPage.class);
                startActivity(intent);
                finish();
            }
        },2500);

    }
}
