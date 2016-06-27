package mySci.mySciApps.mySciAPP;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidhive.R;

/**
 * Created by Twins on 2015-06-25.
 */
public class ChemistryOptionsScreen extends Activity {

    Button button; //go to periodic table
    Button button1; //go to gas lawas
    Button button2; //go to molar mass calculate
    //Element[] pTable;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.chemistry_options_screen);
        click1();
        click();
        click2();

    }

    public void click() { //go to molar mass calc
        //Select a specific button to bundle it with the action you want
        button = (Button) findViewById(R.id.molarMass);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cal = new Intent(getApplicationContext(), MolarMass.class);
                // passing array index
                startActivity(cal);
            }
        });
    }
    public void click1() { //go to gas laws
        //Select a specific button to bundle it with the action you want
        button1 = (Button) findViewById(R.id.gasLaws);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cal = new Intent(getApplicationContext(), GasLawCode.class);
                // passing array index
                startActivity(cal);
            }
        });
    }
    public void click2() { // go to periodic table
        //Select a specific button to bundle it with the action you want
        button2 = (Button) findViewById(R.id.pTable);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cal = new Intent(getApplicationContext(), AndroidGridLayoutActivity.class);
                // passing array index
                startActivity(cal);
            }
        });
    }




}
