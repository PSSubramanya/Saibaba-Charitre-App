package com.example.saibabacharitre;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AboutAppPage extends AppCompatActivity {

    TextView abouttheappinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app_page);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        abouttheappinfo = (TextView)findViewById(R.id.abouttheappinfo);

        abouttheappinfo.setText("\nOM SAIRAM\nThis app is built to provide an easy access to people who intend to read Saibaba Charitre. We are providing the app with both PDFs and Audio clips for each of the 50 chapters of the charitre.\nBow to Shri Sai - Peace be to all.");
    }
}
