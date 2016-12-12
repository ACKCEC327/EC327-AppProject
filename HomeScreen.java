package com.ec327.android.tuneplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class HomeScreen extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

    }

    public static int level = 1; // Initializes global level variable, used in PlayScreen.java to change levels

    // This method is called when the directions button is pushed
    public void viewDirections(View view) {
        // Goes to DirectionScreen to show user how to play
        Intent goToDir = new Intent(this, DirectionsScreen.class);
        startActivity(goToDir);
    }

    public void practice(View view){
        // Goes to PracticeScreen to practice playing the instruments
        Intent goToPrac = new Intent(this, PracticeScreen.class);
        startActivity(goToPrac);
    }

    public void playGame(View view) {
        // Goes to PlayScreen to start playing game
        Intent goToPlay = new Intent(this, PlayScreen.class);
        startActivity(goToPlay);
    }
}
