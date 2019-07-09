package com.example.dhanraj.myvideoapk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaController mediaController;

        VideoView videoView = (VideoView) findViewById(R.id.videoview);

        videoView.setVideoPath("android.resource://" + getPackageName()+ "/" + R.raw.clip);

        mediaController = new MediaController(this);

        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);

        videoView.start();
    }
}
