package inphamouswin.mathkills;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.media.MediaPlayer;

public class MainMenu extends AppCompatActivity {


    MediaPlayer bgm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // Referenced all widgets on "main menu" screen
        Button startGameButton = (Button) findViewById(R.id.startGameButton);
        Button settingsButton = (Button) findViewById(R.id.settingsButton);
        Button creditsButton = (Button) findViewById(R.id.creditsButton);
        TextView highScoreText = (TextView) findViewById(R.id.highScoreText);
        //creates music on MainMenu
        bgm = MediaPlayer.create(MainMenu.this, R.raw.faded_alan_walker);
        while(!bgm.isPlaying())
        {
            bgm.setLooping(true);
            bgm.start();
        }





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

   /* @Override
    protected void onPause() {
        super.onPause();
        bgm.release();
        finish();

    }*/
}

