package com.example.saibabacharitre;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;

public class Chapter1audio extends AppCompatActivity {

    private SeekBar seekbar1;
    private Button btnplay,fastfrwrdplay, fastrewindplay;
    private TextView saibabachapter1textname, starttime, stoptime, endtime, getlyrics;
    private MediaPlayer mediaPlayer;
    private Runnable runnable;
    private Handler handler;
    private ProgressDialog progressDialog;
    private ProgressBar progressBar;
    private boolean playpause;
    private boolean initialstage = true;

    Dialog dialog;
    Dialog dialog1;
    Dialog dialog2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1audio);


//        dialog2 = new Dialog(getApplicationContext());
//        dialog2.setContentView(R.layout.activity_dialog_lyrics);
//        dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        dialog = new Dialog(getApplicationContext());
        dialog.setContentView(R.layout.download_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog.show();


        seekbar1 = (SeekBar)findViewById(R.id.seekbar1);
        btnplay = (Button)findViewById(R.id.btnplay);
        fastfrwrdplay = (Button)findViewById(R.id.fastfrwrdplay);
        fastrewindplay = (Button)findViewById(R.id.fastrewindplay);
//        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        saibabachapter1textname = (TextView) findViewById(R.id.saibabachapter1textname);
        starttime = (TextView) findViewById(R.id.starttime);
        endtime = (TextView)findViewById(R.id.endtime);
        getlyrics = (TextView)findViewById(R.id.getlyrics);
//        stoptime = (TextView) findViewById(R.id.stoptime);

        handler = new Handler();
        seekbar1 = findViewById(R.id.seekbar1);




        //Firebase audio streaming video from ds virdi
        mediaPlayer =  new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        progressDialog = new ProgressDialog(this);

//        progressBar.setVisibility(View.VISIBLE);





        final String getItem = getIntent().getStringExtra("audioFileName");


//        if (getItem.equals("0"))
//        {
////            mediaPlayer = MediaPlayer.create(this,R.raw.sri_sai_charitre_chapter_one);
//            saibabachapter1textname.setText("Sai Charitre - Chapter 1");
////            MediaPlayer mediaPlayer = new MediaPlayer();
//
////MItchcoding segmenet
////            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
////            progressDialog = new ProgressDialog(this);
////
////
////            new MediaPlayer().execute("https://www.ssaurel.com/tmp/mymusic.mp3");
////            mediaPlayer.start();
////MItchcoding segmenet end
//
//
//
//
////            //simplifiedCodingtutorial
////            MediaPlayer mediaPlayer = new MediaPlayer();
////            try {
////                mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_one.mp3?alt=media&token=48e38f0d-3b1c-4bf4-bd9c-320e950520ed");
////                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
////                    @Override
////                    public void onPrepared(MediaPlayer mp) {
////                        mp.start();
////                    }
//////                    public void onPrepared(MediaPlayer mediaPlayer) {
//////                        mediaPlayer.start();
//////                    }
////                });
////
////                mediaPlayer.prepare();
////
////            }
////            catch (IOException e)
////            {
////                e.printStackTrace();
////            }
////            //simplifiedCodingtutorial
//
//
//
//
//
////            dialog = new Dialog(Chapter1audio.this);
////            dialog.setContentView(R.layout.download_dialog);
////            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
////            dialog.show();
//        }
//
//        if (getItem.equals("1"))
//        {
////            pdfchapter1.fromAsset("sai_chapter 2.pdf").load();
//            mediaPlayer = MediaPlayer.create(this,R.raw.sri_sai_charitre_chapter_two);
//            saibabachapter1textname.setText("Sai Charitre - Chapter 2");
//        }
//
//
//        if (getItem.equals("2"))
//        {
////            pdfchapter1.fromAsset("sai_chapter 2.pdf").load();
//            mediaPlayer = MediaPlayer.create(this,R.raw.sri_sai_charitre_chapter_three);
//            saibabachapter1textname.setText("Sai Charitre - Chapter 3");
//        }





//        mediaPlayer = MediaPlayer.create(this,R.raw.sri_sai_charitre_chapter_one);

//        starttime.setText(mediaPlayer.getCurrentPosition());
//        stoptime.setText(mediaPlayer.getDuration());


//        int currentPosition = mediaPlayer.getCurrentPosition();





//string for setting stop time
        String total = createTimeLabel(mediaPlayer.getDuration());
//        stoptime.setText(total);
//string for setting stop time






//
//
//        starttime.setText(currentPosition);
//        stoptime.setText(total);


        getlyrics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog2 = new Dialog(Chapter1audio.this);
                dialog2.setContentView(R.layout.aarati_lyrics_dialog);
                dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog2.show();
            }
        });


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
                //working code
//                if (mediaPlayer.isPlaying())
//                {
//                    mediaPlayer.pause();
//                    btnplay.setBackgroundResource(R.drawable.audioplay);
//                }
//                else
//                {
//                    mediaPlayer.start();
//                    btnplay.setBackgroundResource(R.drawable.audiopause);
//                    changeSeekbar();
//
//
////                    new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_one.mp3?alt=media&token=48e38f0d-3b1c-4bf4-bd9c-320e950520ed");
////                    btnplay.setBackgroundResource(R.drawable.audiopause);
////                    changeSeekbar();
//                }
                //working code



//                String total = createTimeLabel(mediaPlayer.getDuration());
//                stoptime.setText(total);

                if (!playpause)
                {
                    btnplay.setBackgroundResource(R.drawable.audiopause);
                    if (initialstage)
                    {


                        if (getItem.equals("0"))
                        {
//                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/aarati_saibaba_song.mp3?alt=media&token=0189cbb3-c176-48a8-839f-adc19fc0ae25");
                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/aarati_saibaba_song.mp3?alt=media&token=0ba95ca5-0d18-4ca8-80f3-c032222dfded");
                            saibabachapter1textname.setText("Saibaba Aarati Song");
                            getlyrics.setVisibility(View.VISIBLE);
                            endtime.setText("4:02");
//                            String total = createTimeLabel(mediaPlayer.getDuration());
//                            stoptime.setText(total);
                        }

                        if (getItem.equals("1"))
                        {
//                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_one.mp3?alt=media&token=48e38f0d-3b1c-4bf4-bd9c-320e950520ed");
                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_one.mp3?alt=media&token=bf7de0ff-4088-46e6-a62a-54fff46fd84f");
                            saibabachapter1textname.setText("Sai Charitre - Chapter 1");
                            String total = createTimeLabel(mediaPlayer.getDuration());
                            endtime.setText("8:45");

//                            getlyrics.setVisibility(View.VISIBLE);
//                            stoptime.setText(total);


//                            int length = mediaPlayer.getDuration(); // duration in time in millis
////                            String durationText = DateUtils.formatElapsedTime(length / 1000);
//
//
//                            String timeLabel = "";
//                            int min = length / 1000 / 60;
//                            int sec = length / 1000 % 60;
//
//                            timeLabel += min + ":";
//                            if (sec < 10) timeLabel += "0";
//                            timeLabel += sec;
//
////                            return timeLabel;
//                            stoptime.setText(timeLabel);
                        }

                        if (getItem.equals("2"))
                        {
//                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_two.mp3?alt=media&token=0da9fc93-69ca-48c7-b141-79b673ab972e");
                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_two.mp3?alt=media&token=f52b2204-433e-4113-83aa-847505428e93");
                            saibabachapter1textname.setText("Sai Charitre - Chapter 2");
                            endtime.setText("16:51");
//                            String total = createTimeLabel(mediaPlayer.getDuration());
//                            stoptime.setText(total);
                        }

                        if (getItem.equals("3"))
                        {
//                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_three.mp3?alt=media&token=73d07986-ff5d-4ad1-b19b-f7f07a6c16b1");
                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_three.mp3?alt=media&token=9076dd99-6a39-4bf3-83e0-812e900fd045");
                            saibabachapter1textname.setText("Sai Charitre - Chapter 3");
                            endtime.setText("15:40");
//                            String total = createTimeLabel(mediaPlayer.getDuration());
//                            stoptime.setText(total);
                        }

                        if (getItem.equals("4"))
                        {
//                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_four.mp3.mp3?alt=media&token=895335d1-0983-438d-a73a-0cf3bf986575");
                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_four.mp3.mp3?alt=media&token=267a4206-3a9d-41f7-a22b-462f4f56e745");
                            saibabachapter1textname.setText("Sai Charitre - Chapter 4");
                            endtime.setText("23:52");
//                            String total = createTimeLabel(mediaPlayer.getDuration());
//                            stoptime.setText(total);
                        }

                        if (getItem.equals("5"))
                        {
//                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_five.mp3.mp3?alt=media&token=d1a155c6-8463-4127-981e-d98bc2e11368");
                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_five.mp3.mp3?alt=media&token=c30b4a48-d98a-47b2-9b5c-6c4c3556dd68");
                            saibabachapter1textname.setText("Sai Charitre - Chapter 5");
                            endtime.setText("48:40");
//                            String total = createTimeLabel(mediaPlayer.getDuration());
//                            stoptime.setText(total);
                        }

                        if (getItem.equals("6"))
                        {
//                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_six.mp3.mp3?alt=media&token=cc2d0be4-9418-470f-a229-9112f04c7379");
                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_six.mp3.mp3?alt=media&token=48d74d7c-5cf2-40e1-8157-fa4c66d74943");
                            saibabachapter1textname.setText("Sai Charitre - Chapter 6");
                            endtime.setText("21:49");
//                            String total = createTimeLabel(mediaPlayer.getDuration());
//                            stoptime.setText(total);
                        }

                        if (getItem.equals("7"))
                        {
//                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_seven.mp3.mp3?alt=media&token=22dca863-c0f3-4392-8f57-d82051dab6bf");
                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_seven.mp3.mp3?alt=media&token=3f8f592b-ce91-46b4-96d7-65e68bc03984");
                            saibabachapter1textname.setText("Sai Charitre - Chapter 7");
                            endtime.setText("18:56");
//                            String total = createTimeLabel(mediaPlayer.getDuration());
//                            stoptime.setText(total);
                        }

                        if (getItem.equals("8"))
                        {
//                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_eight.mp3.mp3?alt=media&token=61c764ff-0467-43db-b953-5925cd8ef727");
                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_eight.mp3.mp3?alt=media&token=e5e29c7e-a217-471a-831d-225a2e378228");
                            saibabachapter1textname.setText("Sai Charitre - Chapter 8");
                            endtime.setText("13.:55");
//                            String total = createTimeLabel(mediaPlayer.getDuration());
//                            stoptime.setText(total);
                        }

                        if (getItem.equals("9"))
                        {
//                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_nine.mp3?alt=media&token=feae26fc-9738-458a-adb6-17ae0c761d03");
                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_nine.mp3?alt=media&token=bdb8d8b5-6a55-4cb7-a4e4-24338c7b8844");
                            saibabachapter1textname.setText("Sai Charitre - Chapter 9");
                            endtime.setText("16.40");
//                            String total = createTimeLabel(mediaPlayer.getDuration());
//                            stoptime.setText(total);
                        }

                        if (getItem.equals("10"))
                        {
//                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_ten.mp3?alt=media&token=5a925527-e396-4741-9ebc-fa5004bd5f9b");
                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_ten.mp3?alt=media&token=618d74e2-3be8-4f1c-8459-5b8ec5d605ed");
                            saibabachapter1textname.setText("Sai Charitre - Chapter 10");
                            endtime.setText("16.28");
//                            String total = createTimeLabel(mediaPlayer.getDuration());
//                            stoptime.setText(total);
                        }

                        if (getItem.equals("11"))
                        {
//                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_eleven.mp3?alt=media&token=022e8b3a-1dba-4b59-a151-3c0481337369");
                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_eleven.mp3?alt=media&token=b1bc690d-1e9d-4826-a307-a18f070b3df8");
                            saibabachapter1textname.setText("Sai Charitre - Chapter 11");
                            endtime.setText("12.:53");
//                            String total = createTimeLabel(mediaPlayer.getDuration());
//                            stoptime.setText(total);
                        }

                        if (getItem.equals("12"))
                        {
//                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_twelve.mp3?alt=media&token=2f826b65-bbea-4f12-bbb9-056f6340303a");
                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_twelve.mp3?alt=media&token=d04ea8dd-47bc-4026-9119-888e99a22af2");
                            saibabachapter1textname.setText("Sai Charitre - Chapter 12");
                            endtime.setText("12:00");
//                            String total = createTimeLabel(mediaPlayer.getDuration());
//                            stoptime.setText(total);
                        }

                        if (getItem.equals("13"))
                        {
//                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_thirteen.mp3?alt=media&token=14e225b5-c43d-4710-bcab-76feac3a0dc0");
                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_thirteen.mp3?alt=media&token=d374fd83-9844-47c8-bf17-bc559f65c883");
                            saibabachapter1textname.setText("Sai Charitre - Chapter 13");
                            endtime.setText("13.:18");
//                            String total = createTimeLabel(mediaPlayer.getDuration());
//                            stoptime.setText(total);
                        }

                        if (getItem.equals("14"))
                        {
//                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_fourteen.mp3?alt=media&token=5a988ca9-4372-4292-8604-e8d26a383332");
                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_fourteen.mp3?alt=media&token=560f1208-398a-492a-a95b-373528b2fb07");
                            saibabachapter1textname.setText("Sai Charitre - Chapter 14");
                            endtime.setText("17.:11");
//                            String total = createTimeLabel(mediaPlayer.getDuration());
//                            stoptime.setText(total);
                        }

                        if (getItem.equals("15"))
                        {
//                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_fifteen.mp3?alt=media&token=acd65f2e-0690-4a30-8b09-36d544bd5087");
                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_fifteen.mp3?alt=media&token=ba1a770d-0fca-447a-aad0-0d2eecec57a3");
                            saibabachapter1textname.setText("Sai Charitre - Chapter 15");
                            endtime.setText("8:33");
//                            String total = createTimeLabel(mediaPlayer.getDuration());
//                            stoptime.setText(total);
                        }

                        if (getItem.equals("16"))
                        {
//                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_sixteen_and_seventeen.mp3?alt=media&token=adb1b522-cf05-4ef2-ad5f-e3eb367b7cc9");
                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_sixteen_and_seventeen.mp3?alt=media&token=099ffa45-8ec8-4961-8524-8b177f3cea93");
                            saibabachapter1textname.setText("Sai Charitre - Chapter 16 and 17");
                            endtime.setText("15.:37");
//                            String total = createTimeLabel(mediaPlayer.getDuration());
//                            stoptime.setText(total);
                        }

                        if (getItem.equals("17"))
                        {
//                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_eighteen_and_ninteen.mp3?alt=media&token=37723840-5aa9-42a7-a454-f8062bfa0781");
                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_eighteen_and_ninteen.mp3?alt=media&token=9e7c8f02-17ce-471c-aefc-4012fa730a3c");
                            saibabachapter1textname.setText("Sai Charitre - Chapter 18 and 19");
                            endtime.setText("32.:43");
//                            String total = createTimeLabel(mediaPlayer.getDuration());
//                            stoptime.setText(total);
                        }

                        if (getItem.equals("18"))
                        {
//                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_twenty.mp3?alt=media&token=b0cc114d-2957-4924-a94f-4922b1a72d4b");
                            new Player().execute("https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_twenty.mp3?alt=media&token=5df91437-63bb-4d05-b880-0a0a670af611");
                            saibabachapter1textname.setText("Sai Charitre - Chapter 20");
                            endtime.setText("13.:02");
//                            String total = createTimeLabel(mediaPlayer.getDuration());
//                            stoptime.setText(total);
                        }




//                        new Player().execute("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_one.mp3?alt=media&token=48e38f0d-3b1c-4bf4-bd9c-320e950520ed");
                    }
                    else
                    {
                        if (!mediaPlayer.isPlaying())
                        {
//                            mediaPlayer.pause();
//                            btnplay.setBackgroundResource(R.drawable.audioplay);
                            mediaPlayer.start();
                            btnplay.setBackgroundResource(R.drawable.audiopause);
                            changeSeekbar();
                        }

                    }
                    playpause = true;
                }
                else
                {
                    if (mediaPlayer.isPlaying())
                    {
                        mediaPlayer.pause();
                        btnplay.setBackgroundResource(R.drawable.audioplay);
                    }
                    playpause = false;
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


    @Override
    protected void onPause() {
        super.onPause();

        if (mediaPlayer != null) {
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


    class Player extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... strings) {
            Boolean prepared = false;

            try {
                mediaPlayer.setDataSource(strings[0]);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        initialstage = true;
                        playpause = false;
//                        btnplay.setText("Launch Streaming");
                        mediaPlayer.stop();
//                        mediaPlayer.reset();
                    }
                });

                mediaPlayer.prepare();
                prepared = true;

            } catch (Exception e) {
                Log.e("MyAudioStreamingApp", e.getMessage());
                prepared = false;
            }

            return prepared;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            if (progressDialog.isShowing()) {
                progressDialog.cancel();
            }

            mediaPlayer.start();
            initialstage = false;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

//            progressDialog.setMessage("Buffering...");
            progressDialog.show();
            progressDialog.setContentView(R.layout.progress_dialogbox);
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        }
    }


}
