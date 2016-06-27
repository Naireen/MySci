package mySci.mySciApps.mySciAPP;
import com.example.androidhive.R;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


/*This is the main screen with the two buttons, You can change the text in the XML file
 * and when you click each button, it creates a new Intent which opens up the class and 
 * loads the appropriate layout based on the XML file. If you want to create a new intent,
 * it needs to be listed in the Android Manifest.*/
public class MainScreen extends Activity {
	Button button;
	Button button2;
    Button button3;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.main_screen);
		click2();
		click();
        click3();

		
	}
	public void click() {
		//Select a specific button to bundle it with the action you want
		button = (Button) findViewById(R.id.chem);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent cal = new Intent(getApplicationContext(), ChemistryOptionsScreen.class);
				// passing array index  	
				startActivity(cal);
			}
		});
	}
	public void click2() {
		//Select a specific button to bundle it with the action you want
		button2 = (Button) findViewById(R.id.physics);
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent cal = new Intent(getApplicationContext(), Kinematics.class);
				// passing array index  	
				startActivity(cal);
			}
		});
	}
    public void click3() {
        //Select a specific button to bundle it with the action you want
        button3 = (Button) findViewById(R.id.generalMath);
        button3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cal = new Intent(getApplicationContext(), MathOptionScreen.class);
                // passing array index
                startActivity(cal);
            }
        });
    }


}
