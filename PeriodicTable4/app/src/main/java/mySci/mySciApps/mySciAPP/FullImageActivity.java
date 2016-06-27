package mySci.mySciApps.mySciAPP;

/*This is where i declared the elements and then put them in the arrayList.
 * I had to make the objects implement Parcelable since I created the objects here
 * but need to access them in another class so when I created the intent I send
 * that arrayList to the next class. */

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidhive.R;

public class FullImageActivity extends Activity {


   private ArrayList <Element> myList;
    Element [] pTable;
    private final String TAG = "** subActivity **";
Button button;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.full_image);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


		// get intent data
		Intent i = getIntent();

        myList = getIntent().getParcelableArrayListExtra ("mylist");
        pTable= new Element[118];
        for (int m = 0; m < myList.size (); m++)
        {
            Element a = myList.get (m);
            pTable[m]=a;
            //Log.d (TAG, "state:" + a.getName ());
        }


		int position = i.getExtras().getInt("id");
		ImageAdapter imageAdapter = new ImageAdapter(this);
		TextView textview = (TextView) findViewById (R.id.text_id);
		textview.setTextSize(24);
        TextView textMass = (TextView) findViewById (R.id.mass);
        textMass.setTextSize(24);
        TextView textConfig = (TextView) findViewById (R.id.text_config);
        textConfig.setTextSize(24);
        TextView textOxidation = (TextView) findViewById (R.id.text_oxidation);
        textOxidation.setTextSize(24);
        TextView textElectro = (TextView) findViewById (R.id.text_electronegativity);
        textElectro.setTextSize(24);


		for(int s=0;s<pTable.length;s++){
			if(position==pTable[s].getID()){
                textview.setText("Element: "+pTable[s].getName());
                if(pTable[s].getMass()>=0){
                    textMass.setText("Molar: "+pTable[s].getMass());}
                else{
                    textMass.setText("Molar: Unknown ");
                }
                textConfig.setText("Electron Configuration: "+pTable[s].getConfig());
                textOxidation.setText("Oxidation: "+pTable[s].getOxidation());
                if(pTable[s].getElectro()>=0){
                    textElectro.setText("Electronegativity: "+pTable[s].getElectro());}
                else{
                    textElectro.setText("Electronegativity: Not applicable ");
                }

				}
		}
	
	}

}
