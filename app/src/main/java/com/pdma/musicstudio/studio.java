package com.pdma.musicstudio;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class studio extends Activity implements View.OnClickListener {

    TextView songName, timer;

    ImageView cymbalsimageView10, drumimageView10, drumBassimageView10,
            maracasimageView10,
            guitarimageView10,
            BguitarimageView10,
            castanetsimageView10,triangleimageView10;
    Dialog dialog;
    Button Recordbutton,
            LowDobutton2,
            Rebutton2,
            Mibutton2,
            Fabutton2,
            Solbutton2,
            Labutton2,
            Tibutton2,
            HighDobutton2;
    String music_type = "";
    CountDownTimer countDownTimer;
    MediaPlayer mediaPlayerMain = null;


    public  void customDialog(View.OnClickListener clickListener, Context dialogContext, String message){
        dialog = new Dialog(dialogContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        // dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.dailog_conditions);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        ((Button) dialog.findViewById(R.id.btnDialogOk)).setOnClickListener(clickListener);
        ((TextView) dialog.findViewById(R.id.txtDialogMessage)).setText(message);

        dialog.show();
    }



    public void dismissDailog(){
        dialog.dismiss();
    }


    MediaPlayer mediaPlayer = null,mediaPlayer1 = null,mediaPlayer2 = null,mediaPlayer3 = null;
    int resID = 0,resID1 = 0,resID2 = 0,resID3 = 0;

    MediaPlayer mediaPlayer4 = null,mediaPlayer5 = null,mediaPlayer6 = null,mediaPlayer7 = null;
    int resID4 = 0,resID5 = 0,resID6 = 0,resID7 = 0;

    MediaPlayer mediaPlayer8 = null,mediaPlayer9 = null,mediaPlayer10 = null,mediaPlayer11 = null;
    int resID8 = 0,resID9 = 0,resID10 = 0,resID11 = 0;

    MediaPlayer mediaPlayer12 = null,mediaPlayer13 = null,mediaPlayer14 = null,mediaPlayer15 = null;
    int resID12 = 0,resID13 = 0,resID14 = 0,resID15 = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studio);
        music_type =  getIntent().getExtras().getString("music_type");
        init();
        initRes();

        songName.setText(music_type);





    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayerMain != null){
            if(mediaPlayerMain.isPlaying()) {
                mediaPlayerMain.stop();
            }
        }
        stopAll();
        if(countDownTimer != null) {
            countDownTimer.cancel();
        }

    }

    public void stopAll(){
        if(mediaPlayer != null){mediaPlayer.stop();}
        if(mediaPlayer1 != null){mediaPlayer1.stop();}
        if(mediaPlayer2 != null){mediaPlayer2.stop();}
        if(mediaPlayer3 != null){mediaPlayer3.stop();}
        if(mediaPlayer4 != null){mediaPlayer4.stop();}
        if(mediaPlayer5 != null){mediaPlayer5.stop();}
        if(mediaPlayer6 != null){mediaPlayer6.stop();}
        if(mediaPlayer7 != null){mediaPlayer7.stop();}
        if(mediaPlayer8 != null){mediaPlayer8.stop();}
        if(mediaPlayer9 != null){mediaPlayer9.stop();}
        if(mediaPlayer10 != null){mediaPlayer10.stop();}
        if(mediaPlayer11 != null){mediaPlayer11.stop();}
        if(mediaPlayer12 != null){mediaPlayer12.stop();}
        if(mediaPlayer13 != null){mediaPlayer13.stop();}
        if(mediaPlayer14 != null){mediaPlayer14.stop();}
        if(mediaPlayer15 != null){mediaPlayer15.stop();}


    }

    public void init() {
        Recordbutton = (Button) findViewById(R.id.Recordbutton);
        songName = (TextView) findViewById(R.id.songName);
        timer = (TextView) findViewById(R.id.timer);

        cymbalsimageView10 = (ImageView) findViewById(R.id.cymbalsimageView10);
        drumimageView10 = (ImageView) findViewById(R.id.drumimageView10);
        drumBassimageView10 = (ImageView) findViewById(R.id.drumBassimageView10);
        maracasimageView10 = (ImageView) findViewById(R.id.maracasimageView10);
        guitarimageView10 = (ImageView) findViewById(R.id.guitarimageView10);
        BguitarimageView10 = (ImageView) findViewById(R.id.BguitarimageView10);
        castanetsimageView10 = (ImageView) findViewById(R.id.castanetsimageView10);
        triangleimageView10 = (ImageView) findViewById(R.id.triangleimageView10);

        LowDobutton2 = (Button) findViewById(R.id.LowDobutton2);
        Rebutton2 = (Button) findViewById(R.id.Rebutton2);
        Mibutton2 = (Button) findViewById(R.id.Mibutton2);
        Fabutton2 = (Button) findViewById(R.id.Fabutton2);
        Solbutton2 = (Button) findViewById(R.id.Solbutton2);
        Labutton2 = (Button) findViewById(R.id.Labutton2);
        Tibutton2 = (Button) findViewById(R.id.Tibutton2);
        HighDobutton2 = (Button) findViewById(R.id.HighDobutton2);

        cymbalsimageView10.setOnClickListener(this);
        Recordbutton.setOnClickListener(this);
        drumimageView10.setOnClickListener(this);
        drumBassimageView10.setOnClickListener(this);
        maracasimageView10.setOnClickListener(this);
        guitarimageView10.setOnClickListener(this);
        BguitarimageView10.setOnClickListener(this);
        castanetsimageView10.setOnClickListener(this);
        triangleimageView10.setOnClickListener(this);
        LowDobutton2.setOnClickListener(this);
        Rebutton2.setOnClickListener(this);
        Mibutton2.setOnClickListener(this);
        Fabutton2.setOnClickListener(this);
        Solbutton2.setOnClickListener(this);
        Labutton2.setOnClickListener(this);
        Tibutton2.setOnClickListener(this);
        HighDobutton2.setOnClickListener(this);

    }

    public void initRes() {


        resID = getResources().getIdentifier("cymbals", "raw", getPackageName());
        mediaPlayer = MediaPlayer.create(this, resID);

        resID1 = getResources().getIdentifier("drumroll", "raw", getPackageName());
        mediaPlayer1 = MediaPlayer.create(this, resID1);

        resID2 = getResources().getIdentifier("bassdrum", "raw", getPackageName());
        mediaPlayer2 = MediaPlayer.create(this, resID2);

        resID3 = getResources().getIdentifier("maracas", "raw", getPackageName());
        mediaPlayer3 = MediaPlayer.create(this, resID3);

        resID4 = getResources().getIdentifier("guitarstrum", "raw", getPackageName());
        mediaPlayer4 = MediaPlayer.create(this, resID4);

        resID5 = getResources().getIdentifier("electricguitar", "raw", getPackageName());
        mediaPlayer5 = MediaPlayer.create(this, resID5);

        resID6 = getResources().getIdentifier("castanet", "raw", getPackageName());
        mediaPlayer6 = MediaPlayer.create(this, resID6);

        resID7 = getResources().getIdentifier("triangle", "raw", getPackageName());
        mediaPlayer7 = MediaPlayer.create(this, resID7);

        resID8 = getResources().getIdentifier("lowdo", "raw", getPackageName());
        mediaPlayer8 = MediaPlayer.create(this, resID8);

        resID9 = getResources().getIdentifier("re", "raw", getPackageName());
        mediaPlayer9 = MediaPlayer.create(this, resID9);

        resID10 = getResources().getIdentifier("mi", "raw", getPackageName());
        mediaPlayer10 = MediaPlayer.create(this, resID10);

        resID11 = getResources().getIdentifier("fa", "raw", getPackageName());
        mediaPlayer11 = MediaPlayer.create(this, resID11);

        resID12 = getResources().getIdentifier("sol", "raw", getPackageName());
        mediaPlayer12 = MediaPlayer.create(this, resID12);

        resID13 = getResources().getIdentifier("la", "raw", getPackageName());
        mediaPlayer13 = MediaPlayer.create(this, resID13);

        resID14 = getResources().getIdentifier("ti", "raw", getPackageName());
        mediaPlayer14 = MediaPlayer.create(this, resID14);

        resID15 = getResources().getIdentifier("highdo", "raw", getPackageName());
        mediaPlayer15 = MediaPlayer.create(this, resID15);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cymbalsimageView10:
                mediaPlayer.start();
                break;
            case R.id.drumimageView10:
                mediaPlayer1.start();
                break;

            case R.id.drumBassimageView10:
                mediaPlayer2.start();
                break;

            case R.id.maracasimageView10:
                mediaPlayer3.start();
                break;

            case R.id.guitarimageView10:
                mediaPlayer4.start();
                break;

            case R.id.BguitarimageView10:
                mediaPlayer5.start();

                break;

            case R.id.castanetsimageView10:
                mediaPlayer6.start();

                break;
            case R.id.triangleimageView10:
                mediaPlayer7.start();
                break;

            case R.id.Recordbutton:

                if (music_type.isEmpty()) {

                } else{
                    resID = getResources().getIdentifier(music_type, "raw", getPackageName());
                    mediaPlayerMain = MediaPlayer.create(this, resID);
                    mediaPlayerMain.start();
                    mediaPlayerMain.setLooping(true);
                }

                countDownTimer =  new CountDownTimer(20000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        timer.setText(""+String.format("%d : %d ",
                                TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished),
                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                    }

                    public void onFinish() {
                        timer.setText("0:0");
                        customDialog(studio.this,studio.this,"You sound great!");
                        if(mediaPlayerMain != null){
                            if(mediaPlayerMain.isPlaying()) {
                                mediaPlayerMain.stop();
                            }
                        }
                        stopAll();
                    }

                };
                countDownTimer.start();


                break;
            case R.id.btnDialogOk:

              dismissDailog();
                finish();
                Intent intent = new Intent(studio.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                break;

            case R.id.LowDobutton2:


                mediaPlayer8.start();

                break;

            case R.id.Rebutton2:

                mediaPlayer9.start();

                break;

            case R.id.Mibutton2:



                mediaPlayer10.start();

                break;

            case R.id.Fabutton2:



                mediaPlayer11.start();

                break;

            case R.id.Solbutton2:


                mediaPlayer12.start();

                break;

            case R.id.Labutton2:


                mediaPlayer13.start();

                break;

            case R.id.Tibutton2:


                mediaPlayer14.start();

                break;


            case R.id.HighDobutton2:


                mediaPlayer15.start();

                break;

        }
    }
}
