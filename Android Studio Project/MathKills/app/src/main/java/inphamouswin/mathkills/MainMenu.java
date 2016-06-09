package inphamouswin.mathkills;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // Starts the Background Music Service
        Intent BGM = new Intent();
        BGM.setClass(this, BackgroundMusicService.class);
        startService(BGM);

        // Referenced all widgets on "main menu" screen
        Button startGameButton = (Button) findViewById(R.id.startGameButton);
        Button settingsButton = (Button) findViewById(R.id.settingsButton);
        Button creditsButton = (Button) findViewById(R.id.creditsButton);
        TextView highScoreText = (TextView) findViewById(R.id.highScoreText);
    }

    // Starts the game when "Start Game" button is clicked
    public void startGame(View view){

    }

    // Navigates to the "settings" activity when "Settings" button is clicked
    public void settings(View view){
        Intent i = new Intent(this, Settings.class);
        startActivity(i);
    }

    // Navigates to the "credits" activity when "Credits" button is clicked
    public void credits(View view){
        Intent i = new Intent(this, Credits.class);
        startActivity(i);
    }
}
