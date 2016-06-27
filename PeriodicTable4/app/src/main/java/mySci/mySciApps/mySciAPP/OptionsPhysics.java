package mySci.mySciApps.mySciAPP;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidhive.R;

/**
 * Created by Twins on 07/04/2015.
 */
public class OptionsPhysics extends Activity{

    Button buttonKinematics;
    Button buttonFBD;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.physics_options);
        clickKinematics();
        clickFBD();
    }

    public void clickKinematics() {
        //Select a specific button to bundle it with the action you want
        buttonKinematics = (Button) findViewById(R.id.kinematicsButton);
        buttonKinematics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cal = new Intent(getApplicationContext(), Kinematics.class);
                // passing array index
                startActivity(cal);
            }
        });
    }
    public void clickFBD() {
        //Select a specific button to bundle it with the action you want
        buttonKinematics = (Button) findViewById(R.id.fbdButton);
        buttonKinematics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cal = new Intent(getApplicationContext(), FBD_Screen.class);
                // passing array index
                startActivity(cal);
            }
        });
    }
}
