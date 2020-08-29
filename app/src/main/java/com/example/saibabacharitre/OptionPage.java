package com.example.saibabacharitre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Path;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class OptionPage extends AppCompatActivity {

    ImageView charitrebook, charitreicon;
    TextView saicharitretextview1, saicharitretextview2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_page);

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();



        charitrebook = (ImageView)findViewById(R.id.charitrebook);
        saicharitretextview1 = (TextView)findViewById(R.id.saicharitretextview1);
        charitreicon = (ImageView)findViewById(R.id.charitreicon);
        saicharitretextview2 = (TextView)findViewById(R.id.saicharitretextview2);


        Animation animation = AnimationUtils.loadAnimation(this,R.anim.slideup);
        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.slidein);
        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.reverse_slidein);

        charitrebook.startAnimation(animation1);
        saicharitretextview1.startAnimation(animation1);
        charitreicon.startAnimation(animation2);
        saicharitretextview2.startAnimation(animation2);


        charitrebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OptionPage.this,BookCharitre.class);
                startActivity(intent);
            }
        });

        charitreicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(OptionPage.this,Chapter1audio.class);
//                startActivity(intent);

                Intent intent = new Intent(OptionPage.this,AudioCharitre.class);
                startActivity(intent);
            }
        });
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //return super.onCreateOptionsMenu(menu);
//        getMenuInflater().inflate(R.menu.optionpage_toolbar,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        int id = item.getItemId();
//
//        if (id == R.id.appinfoid);
//        {
////            Toast.makeText(ChoicePage.this, "Click on the icon to choose!", Toast.LENGTH_LONG).show();
//            Intent intent = new Intent(OptionPage.this,AboutAppPage.class);
//            startActivity(intent);
//        }
//
//        if (id == R.id.aaratiid);
//        {
////            Toast.makeText(ChoicePage.this, "Click on the icon to choose!", Toast.LENGTH_LONG).show();
//            Intent intent = new Intent(OptionPage.this,AaratiPage.class);
//            startActivity(intent);
//        }
//
//        if (id == R.id.liverelayid);
//        {
//            Toast.makeText(OptionPage.this, "You will get live Saibaba darshana from Shiradi!", Toast.LENGTH_LONG).show();
////            Intent intent = new Intent(OptionPage.this,AaratiPage.class);
////            startActivity(intent);
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.optionpage_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

//        if (id == R.id.helpbutton)
//        {
//            Toast.makeText(ChoicePage.this, "Click on the icons to choose!", Toast.LENGTH_LONG).show();
//        }

        if (id == R.id.appinfoid)
        {
//            Toast.makeText(ChoicePage.this, "Click on the icon to choose!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(OptionPage.this,AboutAppPage.class);
            startActivity(intent);
        }


//        if (id == R.id.aaratiid)
//        {
////            Toast.makeText(ChoicePage.this, "Click on the icon to choose!", Toast.LENGTH_LONG).show();
//            Intent intent = new Intent(OptionPage.this,AaratiPage.class);
//            startActivity(intent);
//        }


        if (id == R.id.liverelayid)
        {
            Toast.makeText(OptionPage.this, "Live Relay from Shiradi", Toast.LENGTH_LONG).show();
//            Intent intent = new Intent(OptionPage.this,SaiDarshanaPage.class);
            Intent intent = new Intent(OptionPage.this,TestVideoStreamPage.class);
//            Intent intent = new Intent(OptionPage.this,ShirdiLiveDarshana.class);
            startActivity(intent);

//            Uri uri = Uri.parse("https://www.sai.org.in/en/sai-video-popup"); // missing 'http://' will cause crashed
//            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
