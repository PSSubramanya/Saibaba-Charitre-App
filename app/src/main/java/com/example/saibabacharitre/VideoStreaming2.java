package com.example.saibabacharitre;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoStreaming2 extends AppCompatActivity {

    ProgressDialog pDialog;
    VideoView videoview;
    String vid_url ="https://www.youtube.com/watch?v=QnOcXQL2wDA&t=18s";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_streaming2);

        Intent intent = getIntent();
        // String vid_url = intent.getStringExtra("video_url");
        videoview = (VideoView) findViewById(R.id.videoView);
        pDialog = new ProgressDialog(this);
        pDialog.setTitle("Video Stream");
        pDialog.setMessage("Buffering...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        Toast.makeText(VideoStreaming2.this, "Loading......", Toast.LENGTH_LONG).show();
//        pDialog.show();
        try {
//            MediaController mediacontroller = new MediaController(this);
            MediaController mediacontroller = new MediaController(this);
            mediacontroller.setAnchorView(videoview);
            Uri video = Uri.parse(vid_url);
            videoview.setMediaController(mediacontroller);
            videoview.setVideoURI(video);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        videoview.requestFocus();
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mp) {
//                VideoPlayer.this.pDialog.dismiss();
//                VideoPlayer.this.videoview.start();
//                pDialog.dismiss();
                videoview.start();

            }
        });
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                finish();
            }
        });


    }
//    }
}
