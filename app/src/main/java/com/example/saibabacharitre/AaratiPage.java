package com.example.saibabacharitre;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class AaratiPage extends AppCompatActivity {

    private SeekBar aaratiseekbar1;
    private Button aaratibtnplay,aaratifastfrwrdplay, aaratifastrewindplay;
    private TextView aaratisaibabachapter1textname, aaratistarttime, aaratistoptime;
    private MediaPlayer mediaPlayer1;
    private Runnable runnable1;
    private Handler handler1;
    private ProgressDialog progressDialog1;
    private ProgressBar progressBar1;
    private boolean aaratiplaypause;
    private boolean initialstage1 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aarati_page);


    }
}
