package com.example.saibabacharitre;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;

public class Chapter1audio extends AppCompatActivity {

    private SeekBar seekbar1;
    private Button btnplay,fastfrwrdplay, fastrewindplay;
    private TextView saibabachapter1textname, starttime, stoptime;
    private MediaPlayer mediaPlayer;
    private Runnable runnable;
    private Handler handler;

    Dialog dialog;
    Dialog dialog1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1audio);


        dialog = new Dialog(getApplicationContext());
        dialog.setContentView(R.layout.download_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog.show();


        seekbar1 = (SeekBar)findViewById(R.id.seekbar1);
        btnplay = (Button)findViewById(R.id.btnplay);
        fastfrwrdplay = (Button)findViewById(R.id.fastfrwrdplay);
        fastrewindplay = (Button)findViewById(R.id.fastrewindplay);

        saibabachapter1textname = (TextView) findViewById(R.id.saibabachapter1textname);
        starttime = (TextView) findViewById(R.id.starttime);
        stoptime = (TextView) findViewById(R.id.stoptime);

        handler = new Handler();
        seekbar1 = findViewById(R.id.seekbar1);


        String getItem = getIntent().getStringExtra("audioFileName");


        if (getItem.equals("0"))
        {
            mediaPlayer = MediaPlayer.create(this,R.raw.sri_sai_charitre_chapter_one);
            saibabachapter1textname.setText("Sai Charitre - Chapter 1");

//            dialog = new Dialog(Chapter1audio.this);
//            dialog.setContentView(R.layout.download_dialog);
//            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            dialog.show();
        }

        if (getItem.equals("1"))
        {
//            pdfchapter1.fromAsset("sai_chapter 2.pdf").load();
            mediaPlayer = MediaPlayer.create(this,R.raw.sri_sai_charitre_chapter_two);
            saibabachapter1textname.setText("Sai Charitre - Chapter 2");
        }


        if (getItem.equals("2"))
        {
//            pdfchapter1.fromAsset("sai_chapter 2.pdf").load();
            mediaPlayer = MediaPlayer.create(this,R.raw.sri_sai_charitre_chapter_three);
            saibabachapter1textname.setText("Sai Charitre - Chapter 3");
        }
//        mediaPlayer = MediaPlayer.create(this,R.raw.sri_sai_charitre_chapter_one);

//        starttime.setText(mediaPlayer.getCurrentPosition());
//        stoptime.setText(mediaPlayer.getDuration());


        int currentPosition = mediaPlayer.getCurrentPosition();
        String total = createTimeLabel(mediaPlayer.getDuration());
        stoptime.setText(total);
//
//
//        starttime.setText(currentPosition);
//        stoptime.setText(total);


        fastfrwrdplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()+10000);
            }
        });


        fastrewindplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()-10000);
            }
        });


        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying())
                {
                    mediaPlayer.pause();
                    btnplay.setBackgroundResource(R.drawable.audioplay);
                }
                else
                {
                    mediaPlayer.start();
                    btnplay.setBackgroundResource(R.drawable.audiopause);
                    changeSeekbar();
                }
            }
        });



        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekbar1.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekbar();
            }
        });

        seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    mediaPlayer.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @SuppressLint("HandlerLeak")
    private Handler handler1 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//            Log.i("handler ", "handler called");
            int current_position = msg.what;
            seekbar1.setProgress(current_position);
            String cTime = createTimeLabel(current_position);
            starttime.setText(cTime);
        }
    };


    public String createTimeLabel(int duration) {
        String timeLabel = "";
        int min = duration / 1000 / 60;
        int sec = duration / 1000 % 60;

        timeLabel += min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;


    }

//    new Thread(new Runnable() {
//        @Override
//        public void run() {
//            while (mMediaPlayer != null) {
//                try {
////                        Log.i("Thread ", "Thread Called");
//                    // create new message to send to handler
//                    if (mMediaPlayer.isPlaying()) {
//                        Message msg = new Message();
//                        msg.what = mMediaPlayer.getCurrentPosition();
//                        handler.sendMessage(msg);
//                        Thread.sleep(1000);
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }).start();

    private void changeSeekbar()
    {
        seekbar1.setProgress(mediaPlayer.getCurrentPosition());

        if (mediaPlayer.isPlaying())
        {
            runnable = new Runnable() {
                @Override
                public void run() {


                    Message msg = new Message();
                    msg.what = mediaPlayer.getCurrentPosition();
                    handler1.sendMessage(msg);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }


                    changeSeekbar();
                }
            };

            handler.postDelayed(runnable,1000);
        }
    }
}
