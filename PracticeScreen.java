package com.example.kristof.tuneplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.media.MediaPlayer;



public class PracticeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);
    }

    public void playP1(View view){
        // code to produce sound when left piano key is clicked
        MediaPlayer p1 = MediaPlayer.create(getApplicationContext(), R.raw.piano_g3);
        p1.start();
    }

    public void playP2(View view){
        // code to produce sound when middle piano key is clicked
        MediaPlayer p2 = MediaPlayer.create(getApplicationContext(), R.raw.piano_a3);
        p2.start();
    }

    public void playP3(View view){
        // code to produce sound when right piano key is clicked
        MediaPlayer p3 = MediaPlayer.create(getApplicationContext(), R.raw.piano_b3);
        p3.start();
    }

    public void playG1(View view){
        // code to produce sound when top guitar string is clicked
        MediaPlayer g1 = MediaPlayer.create(getApplicationContext(), R.raw.guitar_c);
        g1.start();
    }

    public void playG2(View view){
        // code to produce sound when bottom guitar string is clicked
        MediaPlayer g2 = MediaPlayer.create(getApplicationContext(), R.raw.guitar_d);
        g2.start();
    }

    public void playD1(View view){
        // code to produce sound when left drum is clicked
        MediaPlayer d1 = MediaPlayer.create(getApplicationContext(), R.raw.snare);
        d1.start();
    }

    public void playD2(View view){
        // code to produce sound when right drum is clicked
        MediaPlayer d2 = MediaPlayer.create(getApplicationContext(), R.raw.cymbal);
        d2.start();
    }

    public void playGame(View view) {
        // response to clicking "How to Play" button
        Intent goToPlay = new Intent(this, PlayScreen.class);
        startActivity(goToPlay);
    }
}
