package inphamouswin.mathkills;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }

    //Navigates back to Main Menu
    public void backToMenu(View view){
        Intent i = new Intent(this, MainMenu.class);
        startActivity(i);
    }
}
