public class gameOverScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over_screen);
    }

    // This method is called when the Play Again button is pushed
    public void playAgain(View view) {
        // code to take app to beginning of game
        Intent goToGame = new Intent(this, PlayScreen.class);
        startActivity(goToGame);
    }

    // This method is called when the Back Home button is pushed
    public void backHome(View view) {
        // code to take app to next level
        Intent goToHome = new Intent(this, HomeScreen.class);
        startActivity(goToHome);
    }
}
