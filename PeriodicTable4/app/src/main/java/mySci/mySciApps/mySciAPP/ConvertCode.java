package mySci.mySciApps.mySciAPP;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.androidhive.R;

import java.text.NumberFormat;


public class ConvertCode extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner1;
    private Button btnSubmit;
    private Button clear;
    TextView unitOne;
    TextView unitTwo;
    String unit1;
    String unit2;
    String text;
    int location;
    EditText enterOne;
    EditText enterTwo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convert_screen);

        addListenerOnButton();

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(this);
        unitOne = (TextView) findViewById(R.id.unitOne);
        unitTwo = (TextView) findViewById(R.id.unitTwo);
        enterOne=(EditText)findViewById(R.id.convertOne);
        enterTwo=(EditText)findViewById(R.id.convertTwo);
    }


    public String roundValue(double number){
        NumberFormat fmt = NumberFormat.getNumberInstance( );
        fmt.setMaximumFractionDigits(3);
        fmt.setMinimumFractionDigits(3);
        String answer = fmt.format(number);
        return answer;
    }


    public double conversionFactor (String textOption){
        double a=1;
        if(textOption.equals("in to cm")){
            a=2.54;
        }
        else if(textOption.equals("ft to m")){
            a=0.3048;
        }
        else if(textOption.equals("yd to m")){
            a=0.9144;
        }
        else if(textOption.equals("mile to km")){
            a=1.60934;
        }
        else if(textOption.equals("mile to m")){
            a=1609.34;
        }
        else if(textOption.equals("acre to m²")){
            a=4046.86;
        }
        else if(textOption.equals("gal(US) to L")){
            a=3.78541;
        }
        else if(textOption.equals("gal(UK) to L")){
            a=4.54609;
        }

        else if(textOption.equals("km/h to m/s")){
            a=1.0/(3.6);
        }
        else if(textOption.equals("oz to g")){
            a=28.3495;
        }
        else if(textOption.equals("lb to kg")){
            a=0.453592;
        }
        else if(textOption.equals("atm to kPa")){
            a=101.325;
        }
        else if(textOption.equals("mmHg to kPa")){
            a=0.133322368;
        }
        else if(textOption.equals("hp to kW")){
            a=0.745699872;
        }
        else if(textOption.equals("kgf/cm² to kPa")){
            a=98.068059;
        }
        else if(textOption.equals("J to cal")){
            a=0.2390057;
        }
        return a;
    }

    //get the selected dropdown list value
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        clear = (Button) findViewById(R.id.btnClear);

        clear.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                enterOne.setText("");
                enterTwo.setText("");
            }
        });

        btnSubmit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                   //what you want to do when you click submit
                    String text = spinner1.getSelectedItem().toString().trim();
                     String firstVal = (enterOne.getText().toString().trim());
                     String secondVal = (enterTwo.getText().toString().trim());
                    double conversion = conversionFactor(text);

                       if(firstVal.equals(".")||secondVal.equals(".")){
                           if (firstVal.equals(".")){
                               enterOne.setText("");
                               firstVal="";
                           }
                           if (secondVal.equals(".")){
                               enterTwo.setText("");
                               secondVal="";
                           }
                       }

                       if(firstVal.equals("")&&!secondVal.equals("")){
                               double secondValue = Double.parseDouble(enterTwo.getText().toString());
                               double temp = secondValue/conversion;
                           if(text.equals("°F to °C")){
                               temp= (temp*1.8)+32;
                           }
                           else if(text.equals("K to °C"))
                           {
                               temp= temp+273;
                           }
                               String answer= roundValue(temp);
                               enterOne.setText(String.valueOf(answer));


                           //cel to fare
                       }
                       else if(!firstVal.equals("")&&secondVal.equals("")||!firstVal.equals("")&&!secondVal.equals("")){
                               double secondValue = Double.parseDouble(enterOne.getText().toString());
                               double temp = secondValue*conversion;
                           if(text.equals("°F to °C")){
                               temp= (temp-32)/1.8;
                           }
                           else if(text.equals("K to °C"))
                           {
                               temp= temp-273;
                           }
                               String answer= roundValue(temp);
                               enterTwo.setText(String.valueOf(answer));
                           //far to cel
                       }
                   }
        }


        );
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        text = spinner1.getSelectedItem().toString();
        location = text.indexOf("to", 0);
        unit1 = text.substring(0, location - 1);
        unitOne.setText(unit1);
        location = text.indexOf("to", 0);
        unit2 = text.substring(location + 2, text.length());
        unitTwo.setText(unit2);
        enterOne.setText("");
        enterTwo.setText("");
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}