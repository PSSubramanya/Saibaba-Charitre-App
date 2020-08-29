package com.example.saibabacharitre;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;

public class SaiDarshanaPage extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "";
    ProgressDialog mDialog;
    //    VideoView videoView;
    ImageButton btnplaypause;


    MediaPlayer mPlayer;

    String videoUrl = "https://www.youtube.com/watch?v=gp1Q-tCB5-c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sai_darshana_page);

//        videoView = (VideoView)findViewById(R.id.videoView);
        btnplaypause = (ImageButton) findViewById(R.id.btnplaypause);
        btnplaypause.setOnClickListener(this);


//        MediaController mediaController = new MediaController(this);
//        mediaController.setAnchorView(videoView);
//        Uri uri = Uri.parse("https://www.sai.org.in/en/sai-video-popup");
//        if (!videoView.isPlaying())
//        {
//            Uri uri = Uri.parse("https://www.youtube.com/watch?v=gp1Q-tCB5-c");
//
//            videoView.setMediaController(mediaController);
//            videoView.setVideoURI(uri);
//        }
//        Uri uri = Uri.parse("https://www.youtube.com/watch?v=gp1Q-tCB5-c");
//
//        videoView.setMediaController(mediaController);
//        videoView.setVideoURI(uri);
//
//
//        videoView.requestFocus();
////        videoView.start();
//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
////                mediaPlayer.setLooping(true);
//                videoView.start();
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        mDialog = new ProgressDialog(SaiDarshanaPage.this);
        mDialog.setMessage("Preparing live relay...");
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();


//        try {
//            if (!videoView.isPlaying())
//            {
//                Uri uri = Uri.parse(videoUrl);
//                videoView.setVideoURI(uri);
//                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                    @Override
//                    public void onCompletion(MediaPlayer mediaPlayer) {
//                        btnplaypause.setImageResource(R.drawable.ic_pause_black_24dp);
//                    }
//                });
//            }
//            else
//            {
//                videoView.pause();
//                btnplaypause.setImageResource(R.drawable.ic_play_arrow_black_24dp);
//            }
//        }
//        catch (Exception ex)
//        {
//
//        }
//        videoView.requestFocus();
//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                mDialog.dismiss();
//                mediaPlayer.setLooping(true);
//
//                btnplaypause.setImageResource(R.drawable.ic_pause_black_24dp);
//                videoView.start();
//            }
//        });


        /**/

        final VideoView videoview = (VideoView) findViewById(R.id.videoView);
//        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videoanimae);
        try {
            if (!videoview.isPlaying()) {
                Uri uri = Uri.parse(videoUrl);
                videoview.setVideoURI(uri);
//                videoview.setZOrderOnTop(true);

                MediaController mediaController = new MediaController(SaiDarshanaPage.this);
                videoview.setMediaController(mediaController);
                mediaController.setAnchorView(videoview);

                btnplaypause.setImageResource(R.drawable.ic_pause_black_24dp);
                videoview.start();
            } else {
                videoview.pause();
                btnplaypause.setImageResource(R.drawable.ic_play_arrow_black_24dp);
            }
        } catch (Exception ex) {
            Log.d(TAG, "onClick: I am here");
        }

        videoview.requestFocus();
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mDialog.dismiss();
//                mediaPlayer.setLooping(true);

                btnplaypause.setImageResource(R.drawable.ic_pause_black_24dp);
                videoview.start();
            }
        });

        /**/
//        final VideoView videoview = (VideoView)findViewById(R.id.videoView);
////        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videoanimae);
//        if (mPlayer == null)
//            mPlayer = new MediaPlayer();
//        try {
//            if (!videoview.isPlaying())
//            {
////                mPlayer.setDataSource(videoUrl);
//                videoview.set
////                mPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
////
////                    @Override
////                    public boolean onError(MediaPlayer mp, int what, int extra) {
////                        if (extra == MediaPlayer.MEDIA_ERROR_SERVER_DIED
////                                || extra == MediaPlayer.MEDIA_ERROR_MALFORMED) {
//////                        sendPlayerStatus("erroronplaying");
////                            Toast.makeText(SaiDarshanaPage.this, "Error on Playing", Toast.LENGTH_LONG).show();
////                        } else if (extra == MediaPlayer.MEDIA_ERROR_IO) {
//////                        sendPlayerStatus("erroronplaying");
////                            Toast.makeText(SaiDarshanaPage.this, "Error on Playing", Toast.LENGTH_LONG).show();
////                            return false;
////                        }
////                        return false;
////                    }
////                });
////                mPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
////
////                    public void onBufferingUpdate(MediaPlayer mp, int percent) {
////                        Log.e("onBufferingUpdate", "" + percent);
////
////                    }
////                });
////                mPlayer.prepareAsync();
////                mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
////
////                    public void onPrepared(MediaPlayer mp) {
////                        mPlayer.start();
//////                    sendPlayerStatus("playing");
////                        Toast.makeText(SaiDarshanaPage.this, "Playing", Toast.LENGTH_LONG).show();
////                    }
////                });
////                mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
////
////                    @Override
////                    public void onCompletion(MediaPlayer mp) {
////                        Log.e("onCompletion", "Yes");
//////                    sendPlayerStatus("completed");
////                        Toast.makeText(SaiDarshanaPage.this, "Completed", Toast.LENGTH_LONG).show();
////                    }
////                });
////                mPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
////                    @Override
////                    public boolean onInfo(MediaPlayer mp, int what, int extra) {
////                        return false;
////                    }
////                });
//            }
//            else
//            {
//                videoview.
//            }
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////        catch (IOException e) {
////            e.printStackTrace();
////        }
//
////        videoview.requestFocus();
////        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
////            @Override
////            public void onPrepared(MediaPlayer mediaPlayer) {
////                mDialog.dismiss();
//////                mediaPlayer.setLooping(true);
////
////                btnplaypause.setImageResource(R.drawable.ic_pause_black_24dp);
////                videoview.start();
////            }
////        });
//    }
//
////    private void sendPlayerStatus(String status) {
////        Intent intent = new Intent();
////        intent.setAction(SERVICE_TO_ACTIVITY);
////        intent.putExtra(PLAYER_STATUS_KEY, status);
////        sendBroadcast(intent);
////    }
    }
}
