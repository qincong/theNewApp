package com.example.thenewapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by 秦聪 on 2017/8/6.
 */

public class VideoPlay extends AppCompatActivity {
    private VideoView mVideoView;
    private MediaController mMediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        mVideoView=(VideoView)findViewById(R.id.video_view);
        mVideoView.setVideoPath(Uri.parse("http://119.29.173.76/video/airuxinghuo.3gp").toString());
        mMediaController = new MediaController(this);
        mVideoView.setMediaController(mMediaController);
        mVideoView.start();
        mVideoView.requestFocus();
    }
}
