package mySci.mySciApps.mySciAPP;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidhive.R;


public class GasLawCode extends Activity {

    Button buttonCalculate;
    Button buttonClear;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.gas_laws);
       //  click();
    }

    public void click() {
        //Select a specific button to bundle it with the action you want
       // setContentView(R.layout.gas_laws);
        buttonCalculate = (Button) findViewById(R.id.CalculateButton);
        //decalre everything
        //when this button is clicked
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                      }
                                  }
        );





        buttonClear.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {

                                       }
                                   }
        );
    }


}
