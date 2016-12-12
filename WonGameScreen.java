package com.example.kristof.tuneplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WonGameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won_game_screen);
    }

    public void practice(View view){
        // Go to PracticeScreen to practice playing the instruments
        Intent goBackToHome = new Intent(this, HomeScreen.class);
        startActivity(goBackToHome);
    }
}
