package com.ec327.android.tuneplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    // This method is called when the directions button is pushed
    public void viewDirections(View view) {
        // code to take app to direction screen
        Intent goToDir = new Intent(this, directionsScreen.class);
        startActivity(goToDir);
    }

    public void playGame(View view) {
        // response to clicking "How to Play" button
        Intent goToPlay = new Intent(this, PlayScreen.class);
        startActivity(goToPlay);
    }
}
