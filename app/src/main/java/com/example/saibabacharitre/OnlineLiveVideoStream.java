package com.example.saibabacharitre;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class OnlineLiveVideoStream extends AppCompatActivity {

    ProgressDialog pDialog;
//    VideoView videoview;
    VideoView streamVideoView;
    String vid_url ="https://www.youtube.com/watch?v=QnOcXQL2wDA&t=18s";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_live_video_stream);



        Intent intent = getIntent();
        // String vid_url = intent.getStringExtra("video_url");
        streamVideoView = (VideoView) findViewById(R.id.streamVideoView);
        pDialog = new ProgressDialog(this);
        pDialog.setTitle("Video Stream");
        pDialog.setMessage("Buffering...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
        try {
//            MediaController mediacontroller = new MediaController(this);
//            mediacontroller.setAnchorView(streamVideoView);
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(streamVideoView);

            Uri video = Uri.parse(vid_url);
            streamVideoView.setMediaController(mediaController);
            streamVideoView.setVideoURI(video);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        streamVideoView.requestFocus();
        streamVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mp) {
                OnlineLiveVideoStream.this.pDialog.dismiss();
                OnlineLiveVideoStream.this.streamVideoView.start();
            }
        });
        streamVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                finish();
            }
        });
    }
}
