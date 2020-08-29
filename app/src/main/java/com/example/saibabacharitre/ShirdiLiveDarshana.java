package com.example.saibabacharitre;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class ShirdiLiveDarshana extends AppCompatActivity {

    private String videoUrl = "https://www.tv9marathi.com/live-tv";

    ProgressDialog progressDialog;

    VideoView videoViewLive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shirdi_live_darshana);

        videoViewLive = (VideoView)findViewById(R.id.videoViewLive);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Bufferring...");
        progressDialog.setCancelable(true);
        playVideo();
    }

    private void playVideo()
    {
        try {
            getWindow().setFormat(PixelFormat.TRANSLUCENT);
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoViewLive);

            videoViewLive.setMediaController(mediaController);

            Uri videoUri = Uri.parse(videoUrl);
            videoViewLive.setVideoURI(videoUri);
            videoViewLive.requestFocus();
            videoViewLive.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    progressDialog.dismiss();
                    videoViewLive.start();
                }
            });
        }
        catch (Exception e)
        {
            progressDialog.dismiss();
            Toast.makeText(ShirdiLiveDarshana.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
