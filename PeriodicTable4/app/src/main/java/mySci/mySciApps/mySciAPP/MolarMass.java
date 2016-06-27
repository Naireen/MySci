package mySci.mySciApps.mySciAPP;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.androidhive.R;

/*Whenever you click an element, it displays the name, molar mass and a button
 * to go to the next screen to calculate stuff. We're working on the last part :D*/
public class MolarMass extends Activity {

	Button button;
	EditText editText;
	EditText editTextQuant;
	TextView textView;
	private ArrayList <Element> myList;
	Element [] pTable;
	private final String TAG = "** subActivity **";
	boolean mass=true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent cal = getIntent();
		setContentView(R.layout.main);
		editText = (EditText) findViewById(R.id.compound);
		editTextQuant = (EditText) findViewById(R.id.quantity);
		textView=(TextView) findViewById(R.id.text_view);
		textView.setVisibility(View.INVISIBLE);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		myList = getIntent().getParcelableArrayListExtra ("mylist"); 
		pTable= new Element[118];
		for (int i = 0; i < myList.size (); i++)
		{
			Element a = myList.get (i);
			pTable[i]=a;
			//Log.d (TAG, "state:" + a.getName ());
		}
		addListenerOnButton();

	}

	public void onRadioButtonClicked(View view) {
		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();

		// Check which radio button was clicked
		switch(view.getId()) {
		case R.id.radio_moles:
			if (checked)
				mass=true;
			break;
		case R.id.radio_mass:
			if (checked)
				mass=false;
			break;
		}
	}
	public void addListenerOnButton() {
		//Select a specific button to bundle it with the action you want
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {

               // this converts it using molar mass
				String abc= editText.getText().toString() ;//takes the formula
				String val= editTextQuant.getText().toString();//takes the amount
				boolean valid=true;//is the input valid?

				try{
					double temp = Double.parseDouble(val);
				}
				catch(NumberFormatException e){
					valid=false;
                    /*If the amount is not valid, the input will not be valid*/
				}
                //this textview will have the answer written on it
				textView.setVisibility(View.VISIBLE);
				textView.setText(abc);

				char[] userInput=abc.toCharArray();//takes the formula and puts in an array of char
				int[] userVal= new int[userInput.length];//another array is made with the same length
				for(int i=0;i<userInput.length;i++){
					userVal[i]=userInput[i];//everything is dumped in that new array
				}
                /* These counters will keep track on all capital letters, lower case letters
                brackets and subscripts
                */
				int counterEle=0;
				int counterLow=0;
				int brackets=0;
				int counterNum=0;
				ArrayList <String> listOfL =  new ArrayList <String>(0);
				for(int i=0;i<abc.length();i++){
					int temp = userVal[i];
					if(temp>=65&&temp<=90){//65-90 A-Z  //48-57 0-9 //91-122 a-z //40-41()
						counterEle++;
					}
					else if(temp>=97&&temp<=122){//65-90 A-Z  //48-57 0-9 //91-122 a-z //40-41()
						counterLow++;
					}
					else if(temp>=40&&temp<=41){//65-90
						brackets++;
					}
					else if(temp>=48&&temp<=57){//65-90
						counterNum++;
					}
					else{
						valid=false;
					}
				}
				for(int i=0;i<abc.length()-1;i++){
					int temp = abc.charAt(i);
					int temp2 = abc.charAt(i+1);
					if(temp>=48&&temp<=57&&temp2>=91&&temp2<=122){//65-90 A-Z  //48-57 0-9 //91-122 a-z //40-41()
						valid=false;
					}
					if(temp>=40&&temp<=41&&temp2>=91&&temp2<=122){//65-90 A-Z  //48-57 0-9 //91-122 a-z //40-41()
						valid=false;
					}
				}
				double finalVal=0;
				int counter=0;

				if(brackets==0&&counterLow==0&&counterEle==userInput.length&&valid==true){//for if there are only capital letters 
					for(int i=0;i<userInput.length;i++){
						String temp= Character.toString(userInput[i]);
						for(int s=0;s<pTable.length;s++){
							if(temp.equals(pTable[s].getSymbol())){
								System.out.print(pTable[s].getName()+ " ");
								double tempp = pTable[s].calculate(val);
								finalVal=finalVal+tempp;
								counter++;
							}
						}
					}
					if(counter!=abc.length()){
						valid=false;
					}
				}
				else if(brackets==0&&counterNum==0&&valid==true){//for if there are lower case stuff too 
					int [] subindex = new int [counterEle];
					counter=0;
					for(int i=0;i<abc.length();i++){
						if (userVal[i]>=65&&userVal[i]<=90){
							subindex[counter]=i;
							counter++;
						}
					}
					int k=0;
					for(int i=0;i<subindex.length-1;i++){
						String temp= abc.substring(subindex[i], subindex[i+1]);
						k=subindex[i+1];
						listOfL.add(temp);
					}
					String temp2= abc.substring(k, abc.length());
					listOfL.add(temp2);
					counter=0;
					for(int i=0;i<listOfL.size();i++){
						for(int s=0;s<pTable.length;s++){
							if(listOfL.get(i).equals(pTable[s].getSymbol())){
								double tempp = pTable[s].calculate(val);
								finalVal=finalVal+tempp;
								counter++;
							}
						}			
					}
					if(counter!=listOfL.size()){
						valid=false;
					}
				}
				else if(brackets==0&&counterNum!=0&&valid==true&&counterEle!=0){//for if there are numbers too
					//kk
					listOfL=splitInput(counterEle, abc, listOfL);

					for(int i=0;i<listOfL.size();i++){
						String content=listOfL.get(i);
						char[] contentVal= content.toCharArray();
						boolean numInWord=false;
						for(int s=0;s<contentVal.length;s++){	
							if((int)(contentVal[s])>=48&&(int)(contentVal[s])<=57){
								numInWord=true;
							}
						}
						double temp= calculateM(numInWord, contentVal,content, pTable, val);
						if (temp==-1){
							valid=false;
						}
						finalVal=finalVal+temp;
					}
				}
				else if(brackets!=0&&brackets%2==0&&valid==true&&counterEle!=0){//for if there are brackets too 
					int [] bracketindex = new int [brackets];
					counter=0;
					for(int i=0;i<abc.length();i++){
                        //store where the brackets are
						if (userVal[i]>=40&&userVal[i]<=41){
							bracketindex[counter]=i;
							counter++;
						}
					}
					////
					try{
						for(int i=0;i<bracketindex.length-1;i=i+2){
							String temp= abc.substring(bracketindex[i], bracketindex[i+1] +2);
							listOfL.add(temp);
						}
					}
					catch(StringIndexOutOfBoundsException e){}
					for(int i=0;i<listOfL.size();i++){
						abc=abc.replace(listOfL.get(i),"");
					}
					counterEle=0;
					for(int i=0;i<abc.length();i++){
						int temp = abc.charAt(i);
						if(temp>=65&&temp<=90){//65-90 A-Z  //48-57 0-9 //91-122 a-z //40-41()
							counterEle++;
						}
					}
					abc=abc.replaceAll(" ","");
					listOfL=splitInput(counterEle, abc, listOfL);

					for(int i=0;i<listOfL.size();i++){
						String content= listOfL.get(i);
						char[] contentVal = content.toCharArray();
						boolean isBracket=false;
						for(int s=0;s<content.length();s++){
							if(content.charAt(s)>=40&&content.charAt(s)<=41){//65-90
								isBracket=true;
							}
						}
						if(isBracket==false){
							boolean numInWord=false;
							for(int m=0;m<contentVal.length;m++){	
								if((int)(contentVal[m])>=48&&(int)(contentVal[m])<=57){
									numInWord=true;
								}
							}
							double temp= calculateM(numInWord, contentVal,content, pTable, val);
							if (temp==-1){
								valid=false;
							}
							finalVal=finalVal+temp;
						}
						else if(isBracket==true){
							double value=0;
							int pos[]= new int [2];
							int counter1=0;
							for(int m=0;m<content.length();m++){
								if((int)(contentVal[m])>=40&&(int)(contentVal[m])<=41){
									pos[counter1]=m;
									counter1++;
								}
							}
							String a= content.substring(pos[0]+1,pos[1]);
							String b= content.substring(pos[1]+1,content.length());
							System.out.print(a+" "+b+" ");
							counterEle=0;
							for(int m=0;m<a.length();m++){	
								if(a.charAt(m)>=65&&(int)(a.charAt(m))<=90){
									counterEle++;
								}
							}
							double finalVal2=0;
							ArrayList<String> last = new ArrayList<String>(0);
							last=splitInput(counterEle,a,last);
							for(int s=0;s<last.size();s++){
								//System.out.println(last.get(s));
							}
							for(int s=0;s<last.size();s++){
								boolean numInWord=false;
								String lastEle=last.get(s);
								for(int m=0;m<lastEle.length();m++){	
									if((int)(lastEle.charAt(m))>=48&&(int)(lastEle.charAt(m))<=57){
										numInWord=true;
									}
								}
								char[] input =lastEle.toCharArray();
								double temp= calculateM(numInWord, input,lastEle, pTable, val);
								if (temp==-1){
									valid=false;
								}
								else{
									temp=temp*Double.parseDouble(b);
								}
								value=temp;
								System.out.print(temp+" ; ");
								finalVal=finalVal+temp;
							}


						}
						//System.out.print(finalVal+";");
					}

				}
				else {
					valid=false;
				}

				if(valid==true){
					//textView.setText(String.valueOf(counterEle)+System.getProperty ("line.separator")+String.valueOf(counterLow)+System.getProperty ("line.separator")+String.valueOf(brackets));
					if(mass==true){
						//textView.setText(String.valueOf(finalVal)+" grams");
                       textView.setText((Double.toString((double)Math.round(finalVal * 100000) / 100000))+" grams");
					}
					else{
						double temp=Double.parseDouble(val);
						finalVal=finalVal/temp;
						finalVal=temp/finalVal;
						//textView.setText(String.valueOf(finalVal)+" moles");
                        textView.setText((Double.toString((double)Math.round(finalVal * 100000) / 100000))+" moles");
					}
				}
				else{
					textView.setText("Invalid Input");
				}
			}
		});
	}

	public static ArrayList<String> splitInput(int counterEle, String abc, ArrayList<String> listOfL){
		int [] subindex = new int [counterEle];
		int counter=0;
		for(int i=0;i<abc.length();i++){
			if (abc.charAt(i)>=65&&abc.charAt(i)<=90){
				subindex[counter]=i;
				counter++;
			}
		}
		int k=0;
		for(int i=0;i<subindex.length-1;i++){
			String temp= abc.substring(subindex[i], subindex[i+1]);
			k=subindex[i+1];
			listOfL.add(temp);
		}
		String temp2= abc.substring(k, abc.length());
		listOfL.add(temp2);
		return listOfL;
	}
	public static double calculateM (boolean numInWord, char[] contentVal, String content,Element[] pTable,String val){
		double finalVal=0.0;
		boolean valid=true;
		if(numInWord==true){
			int spot=0;
			for(int s=0;s<contentVal.length;s++){	
				if((int)(contentVal[s])>=48&&(int)(contentVal[s])<=57){
					spot=s;
					break;
				}
			}
			int counter1=0;
			String ele=content.substring(0,spot);
			double num=Double.parseDouble(content.substring(spot,content.length()));
			for(int s=0;s<pTable.length;s++){
				if(ele.equals(pTable[s].getSymbol())){
					double tempp = pTable[s].calculate(val) * num;
					finalVal=finalVal+tempp;
					counter1++;
				}
			}	
			if(counter1==0){
				valid=false;
				finalVal=-1;
			}
		}
		else if(numInWord==false){
			int counter1=0;
			for(int s=0;s<pTable.length;s++){
				if(content.equals(pTable[s].getSymbol())){
					double tempp = pTable[s].calculate(val);
					finalVal=finalVal+tempp;
					counter1++;
				}
			}	
			if(counter1==0){
				valid=false;
				finalVal=-1;
			}
		}
		return finalVal;
	}

}
