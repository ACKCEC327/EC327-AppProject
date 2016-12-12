package com.ec327.android.tuneplay;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class PracticeScreen extends AppCompatActivity {

    //Initialize MediaPlayer instrument sounds
    private static MediaPlayer p1;
    private static MediaPlayer p2;
    private static MediaPlayer p3;
    private static MediaPlayer g1;
    private static MediaPlayer g2;
    private static MediaPlayer d1;
    private static MediaPlayer d2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_screen);

        p1 = MediaPlayer.create(getApplicationContext(), R.raw.piano_g3);
        p2 = MediaPlayer.create(getApplicationContext(), R.raw.piano_a3);
        p3 = MediaPlayer.create(getApplicationContext(), R.raw.piano_b3);
        g1 = MediaPlayer.create(getApplicationContext(), R.raw.guitar_c);
        g2 = MediaPlayer.create(getApplicationContext(), R.raw.guitar_d);
        d1 = MediaPlayer.create(getApplicationContext(), R.raw.snare);
        d2 = MediaPlayer.create(getApplicationContext(), R.raw.bass);
    }

    public void backHome(View view){
        // takes user back to Home Screen
        Intent goHome = new Intent(this, HomeScreen.class);
        startActivity(goHome);
    }

    public void playGame(View view){
        // Starts game
        Intent gamePlay = new Intent(this, PlayScreen.class);
        startActivity(gamePlay);
    }

    public void playP1(View view) throws IOException {
        // code to produce sound when left piano key is clicked
        p1.start(); // play sound

        // delay for .5 seconds
        try {
            Thread.sleep(500);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        p1.stop(); // stop sound
        p1.prepare(); // prepare sound to start again upon next method call

    }

    public void playP2(View view) throws IOException {
        // code to produce sound when middle piano key is clicked
        p2.start();
        try {
            Thread.sleep(500);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        p2.stop();
        p2.prepare();
    }

    public void playP3(View view) throws IOException {
        // code to produce sound when right piano key is clicked
        p3.start();
        try {
            Thread.sleep(500);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        p3.stop();
        p3.prepare();
    }

    public void playG1(View view) throws IOException {
        // code to produce sound when top guitar string is clicked
        g1.start();
        try {
            Thread.sleep(500);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        g1.stop();
        g1.prepare();
    }

    public void playG2(View view) throws IOException {
        // code to produce sound when bottom guitar string is clicked
        g2.start();
        try {
            Thread.sleep(500);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        g2.stop();
        g2.prepare();
    }

    public void playD1(View view) throws IOException {
        // code to produce sound when left drum is clicked
        d1.start();
        try {
            Thread.sleep(500);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        d1.stop();
        d1.prepare();
    }

    public void playD2(View view) throws IOException {
        // code to produce sound when right drum is clicked
        d2.start();
        try {
            Thread.sleep(500);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        d2.stop();
        d2.prepare();
    }
}
