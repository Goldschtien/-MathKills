package inphamouswin.mathkills;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    private Switch bgmSwitch;
  //  MediaPlayer bgm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Referenced widgets on "settings" screen
        bgmSwitch = (Switch) findViewById(R.id.bgmSwitch);

        // Sets switch to ON at the start of launch
        bgmSwitch.setChecked(true);
        // Attaches listener to check for changes in switch's state
        bgmSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // If switch is ON, then Toast will say BGM is on
                    Toast.makeText(getApplicationContext(), "BGM is on.", Toast.LENGTH_SHORT).show();
                } else {
                    // If switch is OFF, then Toast will say BGM is off
                    Toast.makeText(getApplicationContext(), "BGM is off.", Toast.LENGTH_SHORT).show();

                }


            }
        });
    }

    // Navigates to the "main menu" activity when "Back" button is clicked
    public void backToMenu(View view) {
        //Intent i = new Intent(this, MainMenu.class);
        //startActivity(i);
        finish();
    }

  /*  @Override
    protected void onPause(){
        super.onPause();
        bgm.release();
        finish();
}*/

}


