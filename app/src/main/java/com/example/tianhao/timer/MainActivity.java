package com.example.tianhao.timer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
        MediaPlayer mediaPlayer;
        TextView timer;
        SeekBar bar;
        int value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.laser);
        bar = (SeekBar)findViewById(R.id.seekBar);
        timer = (TextView)findViewById(R.id.textView);

        bar.setMax(600);

        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int minutes = progress /60;
                int seconds = progress- (minutes* 60);
                timer.setText(String.valueOf(minutes) + ":" + Integer.toString(seconds));
                value = progress;

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    private void timer(int maxTime){
        new CountDownTimer(maxTime*1000, 1000){
            public void onTick(long millisecondsUntilDone){
                long y = millisecondsUntilDone/1000;
                Log.i("Second Left!",String.valueOf(millisecondsUntilDone/1000 ));
                //timer.setText(String.valueOf(millisecondsUntilDone/1000 ));

                bar.setProgress((int)y);
            }
            public void onFinish(){
                Log.i("We are done!", "No more countdown");
                //mediaPlayer.start();
            }
        }.start();
    }
    public void onStart(View view){
        timer(value);
    }
}



