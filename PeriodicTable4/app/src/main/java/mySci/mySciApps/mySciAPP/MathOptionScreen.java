package mySci.mySciApps.mySciAPP;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidhive.R;

/**
 * Created by Twins on 2015-04-11.
 */
public class MathOptionScreen extends Activity {

    Button button;
    Button button1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.math_option_screen);
        click1();
        click();

    }

    public void click() {
        //Select a specific button to bundle it with the action you want
        button = (Button) findViewById(R.id.Quadratic);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cal = new Intent(getApplicationContext(), mathCode.class);
                // passing array index
                startActivity(cal);
            }
        });
    }
    public void click1() {
        //Select a specific button to bundle it with the action you want
        button = (Button) findViewById(R.id.Convert);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cal = new Intent(getApplicationContext(), ConvertCode.class);
                // passing array index
                startActivity(cal);
            }
        });
    }
}
