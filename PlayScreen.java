package com.ec327.android.tuneplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.io.IOException;
import java.util.Random;
import android.media.MediaPlayer;

public class PlayScreen extends AppCompatActivity {

    //Initialize array that song will be played from
    int[] songArray;
    //Initialize dynamic size of songArray
    int Size;
    //Initialize Count variable used to check user's input to value in songArray
    int Count = 0;
    //Initializes boolean variable to prevent checking user's input against 
    //songArray during original sample playing of tune
    boolean donePlaying = false;


    //Initialize MediaPlayer instrument sounds
    private static MediaPlayer p1;
    private static MediaPlayer p2;
    private static MediaPlayer p3;
    private static MediaPlayer g1;
    private static MediaPlayer g2;
    private static MediaPlayer d1;
    private static MediaPlayer d2;


    // get level number with dot operator: HomeScreen.level
    // level is initialized to 1 when Home Screen is created

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);

        //Initialize Song Arrays
        int[] Song1 = new int[0];
        int[] Song2 = new int[0];
        int[] Song3 = new int[0];

        // assign song array values according to level
        switch(HomeScreen.level) {
            case 1:
                //declare MediaPlayer instrument sounds at Level 1
                p1 = MediaPlayer.create(getApplicationContext(), R.raw.piano_g3);
                p2 = MediaPlayer.create(getApplicationContext(), R.raw.piano_a3);
                p3 = MediaPlayer.create(getApplicationContext(), R.raw.piano_b3);
                g1 = MediaPlayer.create(getApplicationContext(), R.raw.guitar_c);
                g2 = MediaPlayer.create(getApplicationContext(), R.raw.guitar_d);
                d1 = MediaPlayer.create(getApplicationContext(), R.raw.snare);
                d2 = MediaPlayer.create(getApplicationContext(), R.raw.bass);

                //Creates arrays representing the songs for level 1
                Song1 = new int[]{1, 2, 3};
                Song2 = new int[]{4, 5, 6};
                Song3 = new int[]{5, 1, 5};
                Size = 3;
                break;
            case 2:
                //Creates arrays representing the songs for level 2
                Song1 = new int[]{3, 2, 1};
                Song2 = new int[]{5, 5, 6};
                Song3 = new int[]{4, 5, 4};
                Size = 3;
                break;
            case 3:
                //Creates arrays representing the songs for level 3
                Song1 = new int[]{1, 2, 3, 2, 1};
                Song2 = new int[]{1, 3, 4, 5, 6}; //"Oh when the saints"
                Song3 = new int[]{1, 5, 4, 1, 2};
                Size = 5;
                break;
            case 4:
                //Creates arrays representing the songs for level 4
                Song1 = new int[]{7, 1, 3, 2, 5}; //"Hunger Games"
                Song2 = new int[]{4, 4, 5, 6, 6};
                Song3 = new int[]{1, 5, 4, 1, 2};
                Size = 5;
                break;
            case 5:
                //Creates arrays representing the songs for level 5
                Song1 = new int[]{6, 6, 6, 1, 2, 3};
                Song2 = new int[]{3, 2, 1, 4, 4, 5};
                Song3 = new int[]{7, 6, 5, 4, 6, 7};
                Size = 6;
                break;
            case 6:
                //Creates arrays representing the songs for level 6
                Song1 = new int[]{1, 1, 2, 1, 4, 3}; //"Happy Birthday!"
                Song2 = new int[]{7, 1, 2, 6, 7, 6};
                Song3 = new int[]{1, 5, 4, 3, 2, 1};
                Size = 6;
                break;
            case 7:
                //Creates arrays representing the songs for level 7
                Song1 = new int[]{4, 4, 4, 1, 2, 2, 1}; //"Old McDonald had a Farm"
                Song2 = new int[]{5, 5, 1, 2, 3, 4, 5}; //Exerpt from "National Anthem"
                Song3 = new int[]{1, 2, 6, 3, 2, 6, 4};
                Size = 7;
                break;
            case 8:
                //Creates arrays representing the songs for level 8
                Song1 = new int[]{4, 4, 1, 1, 2, 2, 1}; //"Twinkle, Twinkle"
                Song2 = new int[]{6, 5, 2, 4, 5, 4, 6};
                Song3 = new int[]{3, 2, 1, 2, 3, 3, 3}; //"Mary Had a Little Lamb"
                Size = 7;
                break;
            case 9:
                //Creates arrays representing the songs for level 9
                Song1 = new int[]{3, 3, 4, 5, 5, 4, 3, 2}; //"Ode to Joy"
                Song2 = new int[]{3, 2, 1, 4, 4, 5, 6, 6};
                Song3 = new int[]{5, 1, 1, 1, 2, 3, 3, 3}; //"Oh Christmas Tree"
                Size = 8;
                break;
            case 10:
                //Creates arrays representing the songs for level 10
                Song1 = new int[]{1, 4, 4, 4, 1, 5, 3, 4}; //"Here comes the Bride!"
                Song2 = new int[]{1, 4, 4, 5, 4, 3, 2, 2}; //"We wish you a Merry Christmas" :)
                Song3 = new int[]{1, 3, 4, 5, 3, 1, 3, 2}; //"Oh when the saints go marching in"
                Size = 8;
                break;
        }

        //Randomly plays one of the songs
        Random randGen = new Random();
        int randInt = randGen.nextInt(3); // chose value from 0-2
        if(randInt == 0){
            songArray = Song1; // will play song1
        }
        else if(randInt == 1){
            songArray = Song2; // will play song2
        }
        else if(randInt == 2) {
            songArray = Song3; // will play song3
        }
    }

    //play method for first piano key (far left)
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

        // If it is user's turn to play the song, check method will check if this instrument
        // was the correct choice
        if(donePlaying) {
            check(1);
        }
    }

    // play method for second piano key (middle)
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
        if(donePlaying) {
            check(2);
        }
    }

    // play method for third piano key (far right)
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
        if(donePlaying) {
            check(3);
        }
    }

    // play method for first guitar string (top)
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
        if(donePlaying) {
            check(4);
        }
    }

    // play method for second guitar string (bottom)
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
        if(donePlaying) {
            check(5);
        }
    }

    // play method for first drum (left)
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
        if(donePlaying) {
            check(6);
        }
    }

    // play method for second drum (right)
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
        if(donePlaying) {
            check(7);
        }
    }

    // This method reads the song array and plays instruments according to their assigned array values
    public void playSongFunc(int[] CurrentSong, int Size) throws IOException {
        for(int i = 0; i<Size; i=i+1){
            switch(CurrentSong[i]) {
                case 1:
                    // If the array value is 1, the first piano key will play
                    playP1(findViewById(R.id.pianoOne));
                    break;
                case 2:
                    // second piano key will play
                    playP2(findViewById(R.id.pianoTwo));
                    break;
                case 3:
                    // third piano key will play
                    playP3(findViewById(R.id.pianoThree));
                    break;
                case 4:
                    // first guitar string will play
                    playG1(findViewById(R.id.guitarOne));
                    break;
                case 5:
                    // second guitar string will play
                    playG2(findViewById(R.id.guitarTwo));
                    break;
                case 6:
                    // first drum will play
                    playD1(findViewById(R.id.drumOne));
                    break;
                case 7:
                    // second drum will play
                    playD2(findViewById(R.id.drumTwo));
                    break;
            }

        }
        donePlaying = true; // indicates program is done playing tune for user
    }

    // this method references the onClick XML attribute for the "Play Tune" button
    public void showMe(View view) throws IOException {
        // code to show user the tune
        playSongFunc(songArray, Size); // play the tune for the user
        view.setVisibility(View.GONE); // make button disappear so user can't listen to song again
    }

    // this method checks if the user input (instrument choice) is correct
    void check(int butpress){
        // checks user input against array
        if(butpress == songArray[Count]){
            Count = Count+1;
            if(Count == Size){
                HomeScreen.level = HomeScreen.level + 1;
                if(HomeScreen.level == 11){
                    //After the last level, go to Won Game screen
                    HomeScreen.level = 1; // reset level to 1 if you win the game
                    Intent goToWonGame = new Intent(this, WonGameScreen.class);
                    startActivity(goToWonGame);
                }
                else {
                    //Go to Next level screen
                    Intent goToNextLevel = new Intent(this, nextLevelScreen.class);
                    startActivity(goToNextLevel);
                }
            }
        }
        else {
            //Go to Game Over
            HomeScreen.level = 1; // reset level to 1 if you lose the game
            Intent goToGameOver = new Intent(this, gameOverScreen.class);
            startActivity(goToGameOver);
        }
    }
}

