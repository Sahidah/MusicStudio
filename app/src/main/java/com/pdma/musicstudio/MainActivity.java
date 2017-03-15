package com.pdma.musicstudio;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pdma.musicstudio.utility.OnSwipeTouchListener;

public class MainActivity extends AppCompatActivity {

    public String music_type= "";
    private Thread mThread;
    private boolean isFinish = false;
     TextView preparing;
    Button StartButton;
    ImageView MagicHatimageView;
    GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonShare = (Button) findViewById(R.id.buttonShare);
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                share.putExtra(Intent.EXTRA_TEXT, "This is my Music Studio app");
                startActivity(Intent.createChooser(share, "Share"));
            }
        });

        StartButton = (Button)findViewById(R.id.StartButton);
        RelativeLayout parentReltv = (RelativeLayout)findViewById(R.id.parentReltv);
        preparing = (TextView) findViewById(R.id.preparing);
        gifImageView = (GifImageView) findViewById(R.id.GifImageView);
       final LinearLayout musicType = (LinearLayout) findViewById(R.id.musicType);
        Button       jazz = (Button) findViewById(R.id.jazz);
        Button pop = (Button) findViewById(R.id.pop);
        Button none = (Button) findViewById(R.id.none);
        final TextView songchoice = (TextView) findViewById(R.id.songchoice);
        MagicHatimageView = (ImageView) findViewById(R.id.MagicHatimageView);

        jazz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                music_type  ="jazzbackground";
                musicType.setVisibility(View.INVISIBLE);
                preparing.setVisibility(View.VISIBLE);
                songchoice.setVisibility(View.INVISIBLE);
                buttonShare.setVisibility(View.GONE);

                gifImageView.setVisibility(View.VISIBLE);
                gifImageView.setGifImageResource(R.drawable.giphy);
                mThread = new Thread(mRunnable);
                mThread.start();

            }
        });
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                music_type  ="popbackground";
                musicType.setVisibility(View.GONE);
                preparing.setVisibility(View.VISIBLE);
                songchoice.setVisibility(View.GONE);

                gifImageView.setVisibility(View.VISIBLE);
                gifImageView.setGifImageResource(R.drawable.giphy);

                mThread = new Thread(mRunnable);
                mThread.start();
            }
        });
        none.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                music_type  ="";
                musicType.setVisibility(View.GONE);
                preparing.setVisibility(View.VISIBLE);
                songchoice.setVisibility(View.GONE);

                gifImageView.setVisibility(View.VISIBLE);
                gifImageView.setGifImageResource(R.drawable.giphy);
                mThread = new Thread(mRunnable);
                mThread.start();
            }
        });

        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, studio.class);
                intent.putExtra("music_type",music_type);
                startActivity(intent);
            }
        });

        parentReltv.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            public void onSwipeTop() {
                //Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                //Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeLeft() {
                Intent intent = new Intent(MainActivity.this, studio.class);
                intent.putExtra("music_type",music_type);
                startActivity(intent);
            }
            public void onSwipeBottom() {
                //Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });

    }


    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            SystemClock.sleep(2500);
            mHandler.sendEmptyMessage(0);
        }
    };

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0 && (!isFinish)) {
                stop();
            }
            super.handleMessage(msg);
        }

    };



    @Override
    protected void onDestroy() {
        try {
            mThread.interrupt();
            mThread = null;
        } catch (Exception e) {
        }
        super.onDestroy();
    }

    @SuppressLint("SimpleDateFormat")
    private void stop() {
        isFinish = true;

        preparing.setVisibility(View.GONE);
        gifImageView.setVisibility(View.GONE);
        StartButton.setVisibility(View.VISIBLE);


    }
	


}
