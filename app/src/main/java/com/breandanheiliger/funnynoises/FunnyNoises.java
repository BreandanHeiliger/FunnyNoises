package com.breandanheiliger.funnynoises;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;

public class FunnyNoises extends Activity implements View.OnClickListener{

    //Sounds
    private SoundPool soundPool;
    int sound1 = -1, sound2 = -1, sound3 = -1, sound4 = -1, sound5 = -1, sound6 = -1;

    //Animations
    Animation anim1, anim2, anim3, anim4, anim5, anim6;

    //Buttons
    ImageButton button1, button2, button3, button4, button5, button6;

    //For Toast
    Toast toast;
    Context context;
    CharSequence text;
    int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funny_noises);

        //Start the Splash screen.
        //setContentView(R.layout.activity_splash);

        //Set animations.
        anim1 = AnimationUtils.loadAnimation(this, R.anim.laugh);
        anim2 = AnimationUtils.loadAnimation(this, R.anim.chipmunk);
        anim3 = AnimationUtils.loadAnimation(this, R.anim.cough);
        anim4 = AnimationUtils.loadAnimation(this, R.anim.drums);
        anim5 = AnimationUtils.loadAnimation(this, R.anim.golf);
        anim6 = AnimationUtils.loadAnimation(this, R.anim.villain);

        //Set buttons
        button1 = (ImageButton) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (ImageButton) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = (ImageButton) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = (ImageButton) findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = (ImageButton) findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button6 = (ImageButton) findViewById(R.id.button6);
        button6.setOnClickListener(this);


        //Sounds
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        try {
            AssetManager assetsManager = getAssets();
            AssetFileDescriptor descriptor;

            //Golf ball bounce.
            descriptor = assetsManager.openFd("laugh.wav");
            sound1 = soundPool.load(descriptor, 0);

            //Chipmunks
            descriptor = assetsManager.openFd("chipmunks.wav");
            sound2 = soundPool.load(descriptor, 0);

            //Dry sound3.
            descriptor = assetsManager.openFd("cough.wav");
            sound3 = soundPool.load(descriptor, 0);

            //Joke sound4.
            descriptor = assetsManager.openFd("drums.wav");
            sound4 = soundPool.load(descriptor, 0);

            //Short sound5.
            descriptor = assetsManager.openFd("golf.wav");
            sound5 = soundPool.load(descriptor, 0);

            //Villain sound5.
            descriptor = assetsManager.openFd("villain.wav");
            sound6 = soundPool.load(descriptor, 0);

        } catch (IOException e) {

            context = getApplicationContext();
            text = "File not found!";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }


    }//End onCreate.

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button1:  //when the first button is pressed
                //Do animation and play sound.
                button1.startAnimation(anim1);
                soundPool.play(sound1, 1, 1, 0, 0, 1);
                break;
            case R.id.button2:
                //Do animation and play sound.
                button2.startAnimation(anim2);
                soundPool.play(sound2, 1, 1, 0, 0, 1);
                break;
            case R.id.button3:
                //Do animation and play sound.
                button3.startAnimation(anim3);
                soundPool.play(sound3, 1, 1, 0, 0, 1);
                break;

            case R.id.button4:
                //Do animation and play sound.
                button4.startAnimation(anim4);
                soundPool.play(sound4, 1, 1, 0, 0, 1);
                break;

            case R.id.button5:
                //Do animation and play sound.
                button5.startAnimation(anim5);
                soundPool.play(sound5, 1, 1, 0, 0, 1);
                break;
            case R.id.button6:
                //Do animation and play sound.
                button6.startAnimation(anim6);
                soundPool.play(sound6, 1, 1, 0, 0, 1);
                break;
        }

    }//End onClick override.

}//End class.
