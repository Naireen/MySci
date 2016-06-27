package mySci.mySciApps.mySciAPP;

import com.example.androidhive.R;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

public class AndroidGridLayoutActivity extends Activity {

    Button button;
    Element[] pTable;
    GridView gridView;
	@Override

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setContentView(R.layout.grid_layout);

        ArrayList<Element> myList = new ArrayList<Element>(0);

        pTable = new Element[118];
        pTable[0]= new Element ("Hydrogen", 0, 1.00794,"H",2.20,"1,-1","1s¹");
        pTable[1]= new Element ("Helium", 17, 4.00260,"He",1,"Not Applicable","1s²");
        pTable[2]= new Element ("Lithium", 18, 6.941,"Li",0.98,"1","[He] 2s¹");
        pTable[3]= new Element ("Beryllium", 19, 9.012182,"Be",1.57,"2","[He] 2s²");
        pTable[4]= new Element ("Boron", 30, 10.811,"B",2.04,"3","[He] 2s² 2p¹");
        pTable[5]= new Element ("Carbon", 31, 12.0107,"C",2.55,"±4,2","[He] 2s² 2p²" );
        pTable[6]= new Element ("Nitrogen", 32, 14.0067,"N",3.04,"±3,5,4,2","[He] 2s² 2p³");
        pTable[7]= new Element ("Oxygen", 33, 15.9994,"O",3.44,"-2,-1","[He] 2s² 2p⁴");
        pTable[8]= new Element ("Fluorine", 34, 18.99840,"F",3.98,"-1","[He] 2s² 2p⁵");
        pTable[9]= new Element ("Neon", 35, 20.1797,"Ne",-1,"Not Applicable","[He] 2s" +"² 2p⁶");
        pTable[10]= new Element ("Sodium", 36, 22.989770,"Na",0.93,"1","[Ne] 3s¹");
        pTable[11]= new Element ("Magnesium", 37, 24.3050,"Mg",1.31,"2","[Ne] 3s²");
        pTable[12]= new Element ("Aluminum", 48, 26.981538,"Al",1.61,"3","[Ne] 3s² 3p¹");
        pTable[13]= new Element ("Silicon", 49, 28.0855,"Si",1.90,"4,2","[Ne] 3s² 3p²");
        pTable[14]= new Element ("Phosphorus", 50, 30.97376,"P",2.19,"±3,5,4","[Ne] 3s² 3p³");
        pTable[15]= new Element ("Sulfur", 51, 32.065,"S",2.58,"6,±2,4","[Ne] 3s² 3p⁴");
        pTable[16]= new Element ("Chlorine", 52, 35.453,"Cl",3.16,"±1,7,5,3","[Ne] 3s² 3p⁵");
        pTable[17]= new Element ("Argon", 53, 39.948,"Ar",-1,"Not Applicable","[Ne] 3s² 3p⁶");
        pTable[18]= new Element ("Potassium", 54, 39.0983,"K",0.82,"1","[Ar] 4s¹");
        pTable[19]= new Element ("Calcium", 55, 40.078,"Ca",1.00,"2","[Ar] 4s²");
        pTable[20]= new Element ("Scandium", 56, 44.95591,"Sc",1.36,"3","[Ar] 3d¹ 4s²");
        pTable[21]= new Element ("Titanium", 57, 47.867,"Ti",1.54, "4,3,2","[Ar] 3d² 4s²");
        pTable[22]= new Element ("Vanadium", 58, 50.9415,"V",1.63,"5,4,3,2","[Ar] 3d³ 4s²");
        pTable[23]= new Element ("Chromium", 59, 51.996,"Cr",1.66,"3,6,2","[Ar] 3d⁵ 4s¹");
        pTable[24]= new Element ("Manganese", 60, 54.9380,"Mn",1.55,"2,3,4,6,7","[Ar] 3d⁵ 4s²");
        pTable[25]= new Element ("Iron", 61, 55.845,"Fe",1.83,"3,2,6","[Ar] 3d⁶ 4s²");
        pTable[26]= new Element ("Cobalt", 62, 58.9332,"Co",1.88,"2,3","[Ar] 3d⁷ 4s²");
        pTable[27]= new Element ("Nickel", 63, 58.6934,"Ni",1.91,"2,3","[Ar] 3d⁸ 4s²");
        pTable[28]= new Element ("Copper", 64, 63.546,"Cu",1.90,"2,1","[Ar] 3d¹⁰ 4s¹");
        pTable[29]= new Element ("Zinc", 65, 65.409,"Zn",1.65,"2","[Ar] 3d¹⁰ 4s²");
        pTable[30]= new Element ("Gallium", 66, 69.723,"Ga",1.81,"1,3","[Ar] 3d¹⁰ 4s² 4p¹");
        pTable[31]= new Element ("Germanium", 67, 72.64,"Ge",2.01,"4","[Ar] 3d¹⁰ 4s² 4p²");
        pTable[32]= new Element ("Arsenic", 68, 74.9216,"As",2.18,"±3,5","[Ar] 3d¹⁰ 4s² 4p³");
        pTable[33]= new Element ("Selenium", 69, 78.96,"Se",2.55,"4,6,-2","[Ar] 3d¹⁰ 4s² 4p⁴");
        pTable[34]= new Element ("Bromine", 70, 79.904,"Br",2.96,"±1,7,5,3","[Ar] 3d¹⁰ 4s² 4p⁵");
        pTable[35]= new Element ("Krypton", 71, 83.80,"Kr",-1,"0,2","[Ar] 3d¹⁰ 4s² 4p⁶");
        pTable[36]= new Element ("Rubidium", 72, 85.4678,"Rb",0.82,"1","[Kr] 5s¹");
        pTable[37]= new Element ("Strontium", 73, 87.62,"Sr",0.95,"2","[Kr] 5s²");
        pTable[38]= new Element ("Yttrium", 74, 88.9059,"Y",1.22,"3","[Kr] 4d¹ 5s²");
        pTable[39]= new Element ("Zirconium", 75, 91.224,"Zr",1.33,"4","[Kr] 4d² 5s²");
        pTable[40]= new Element ("Niobium", 76, 92.90638,"Nb",1.6,"5,3,4","[Kr] 4d⁴ 5s¹");
        pTable[41]= new Element ("Molybdenum", 77, 95.99,"Mo",2.16,"6,5,4,3,2","[Kr] 4d⁵ 5s¹");
        pTable[42]= new Element ("Technetium", 78, 98.0,"Tc",1.9,"7,5,4","[Kr] 4d⁵ 5s²");
        pTable[43]= new Element ("Ruthenium", 79, 101.07,"Ru",2.2,"2,3,4,6,7","[Kr] 4d⁷ 5s¹");
        pTable[44]= new Element ("Rhodium", 80, 102.90550,"Rh",2.28,"2,3,4","[Kr] 4d⁸ 5s¹");
        pTable[45]= new Element ("Palladium", 81, 106.42,"Pd",2.2,"2,4","[Kr] 4d¹⁰");
        pTable[46]= new Element ("Silver", 82, 107.8682,"Ag",1.93,"1","[Kr] 4d¹⁰ 5s¹");
        pTable[47]= new Element ("Cadmium", 83, 112.41,"Cd",1.69,"2","[Kr] 4d¹⁰ 5s²");
        pTable[48]= new Element ("Indium", 84, 114.82,"In",1.78,"3","[Kr] 4d¹⁰ 5s² 5p¹");
        pTable[49]= new Element ("Tin", 85, 118.710,"Sn",1.96,"4,2","[Kr] 4d¹⁰ 5s² 5p²");
        pTable[50]= new Element ("Antimony", 86, 121.76,"Sb",2.05,"±3,5","[Kr] 4d¹⁰ 5s² 5p³");
        pTable[51]= new Element ("Tellurium", 87, 127.6,"Te",2.1,"4,6,-2","[Kr] 4d¹⁰ 5s² 5p⁴");
        pTable[52]= new Element ("Iodine", 88, 126.90447,"I",2.66,"±1,5,7","[Kr] 4d¹⁰ 5s² 5p⁵");
        pTable[53]= new Element ("Xenon", 89, 131.20,"Xe",-1,"0,2,4,6,8","[Kr] 4d¹⁰ 5s² 5p⁶");
        pTable[54]= new Element ("Cesium", 90, 132.90545,"Cs",0.79,"1","[Xe] 6s¹");
        pTable[55]= new Element ("Barium", 91, 137.327,"Ba",0.89,"2","[Xe] 6s²");
        pTable[56]= new Element ("Lanthanum",92, 138.9055,"La",1.10,"3","[Xe] 5d¹ 6s²");
        pTable[57]= new Element ("Hafnium", 93, 178.49,"Hf",1.3,"4","[Xe] 4f¹⁴ 5d² 6s²");
        pTable[58]= new Element ("Tantalum", 94, 180.9479,"Ta",1.5,"5,4","[Xe] 4f¹⁴ 5d³ 6s²");
        pTable[59]= new Element ("Tungsten", 95, 183.84,"W", 2.36,"6,5,4,3,2","[Xe] 4f¹⁴ 5d⁴ 6s²");
        pTable[60]= new Element ("Rhenium", 96, 186.207,"Re",1.9,"7,6,5,4,3,2","[Xe] 4f¹⁴ 5d⁵ 6s²");
        pTable[61]= new Element ("Osmium", 97, 190.23,"Os",2.2,"4,8,6,3,2","[Xe] 4f¹⁴ 5d⁶ 6s²");
        pTable[62]= new Element ("Iridum", 98, 192.217,"Ir",2.20,"4,2,6,3","[Xe] 4f¹⁴ 5d⁷ 6s²");
        pTable[63]= new Element ("Platinum", 99, 195.08,"Pt",2.28,"4,2","[Xe] 4f¹⁴ 5d⁹ 6s¹");
        pTable[64]= new Element ("Gold", 100, 196.96655,"Au",2.54,"3,1","[Xe] 4f¹⁴ 5d¹⁰ 6s¹");
        pTable[65]= new Element ("Mercury", 101, 200.59,"Hg",2.0,"2,1","[Xe] 4f¹⁴ 5d¹⁰ 6s²");
        pTable[66]= new Element ("Thallium", 102, 204.3833,"Tl",2.04,"3,1","[Xe] 4f¹⁴ 5d¹⁰ 6s² 6p¹");
        pTable[67]= new Element ("Lead", 103, 207.2,"Pb",2.33,"2,4","[Xe] 4f¹⁴ 5d¹⁰ 6s² 6p²");
        pTable[68]= new Element ("Bismuth", 104, 208.9804,"Bi",2.02,"3,5","[Xe] 4f¹⁴ 5d¹⁰ 6s² 6p³");
        pTable[69]= new Element ("Polonium", 105, 209,"Po",2.0,"4,2,6","[Xe] 4f¹⁴ 5d¹⁰ 6s² 6p⁴");
        pTable[70]= new Element ("Astatine", 106, 210,"At",2.2,"±1,7,5,3","[Xe] 4f¹⁴ 5d¹⁰ 6s² 6p⁵");
        pTable[71]= new Element ("Radon", 107, 222,"Rn",-1,"0,2","[Xe] 4f¹⁴ 5d¹⁰ 6s² 6p⁶");
        pTable[72]= new Element ("Francium", 108, 223,"Fr",0.7,"1","[Rn] 7s¹");
        pTable[73]= new Element ("Radium", 109, 226,"Ra",0.9,"2","[Rn] 7s²");
        pTable[74]= new Element ("Actinium", 110, 227,"Ac",1.1,"3","[Rn] 6d¹ 7s²");
        pTable[75]= new Element ("Rutherfordium", 111, 261,"Rf",-1,"Unknown","[Rn] 5f¹⁴ 6d² 7s²");
        pTable[76]= new Element ("Dubnium", 112, 262,"Dd",-1,"Unknown","[Rn] 5f¹⁴ 6d³ 7s²");
        pTable[77]= new Element ("Seaborgium", 113, 266,"Sg",-1,"Unknown","[Rn] 5f¹⁴ 6d⁴ 7s²");//⁷⁸⁸
        pTable[78]= new Element ("Bohrium", 114, 264,"Bh",-1,"Unknown","[Rn] 5f¹⁴ 6d⁵ 7s²");
        pTable[79]= new Element ("Hassium", 115, 277,"Hs",-1,"Unknown","[Rn] 5f¹⁴ 6d⁶ 7s²");
        pTable[80]= new Element ("Meitnerium", 116, 268,"Mt",-1,"Unknown","[Rn] 5f¹⁴ 6d⁷ 7s²");
        pTable[81]= new Element ("Darmstadtium", 117, 269,"Ds",-1,"Unknown","[Rn] 5f¹⁴ 6d⁸ 7s²");
        pTable[82]= new Element ("Roentgenium", 118, 272,"Rg",-1,"Unknown","[Rn] 5f¹⁴ 6d⁹ 7s²");
        pTable[83]= new Element ("Copernicium", 119, 285,"Cn",-1,"Unknown","[Rn] 5f¹⁴ 6d¹⁰ 7s²");
        pTable[84]= new Element ("Ununtrium", 120, 284,"Uut",-1,"Unknown","[Rn] 5f¹⁴ 6d¹⁰ 7s² 7p¹");
        pTable[85]= new Element ("Flerovium", 121, 289,"Fl",-1,"Unknown","[Rn] 5f¹⁴ 6d¹⁰ 7s²,7p²");
        pTable[86]= new Element ("Ununpentium", 122, 288,"Uup",-1,"Unknown","[Rn] 5f¹⁴ 6d¹⁰ 7s² 7p³");
        pTable[87]= new Element ("Livermorium", 123, 293,"Lv",-1,"Unknown","[Rn] 5f¹⁴ 6d¹⁰ 7s²,7p⁴");
        pTable[88]= new Element ("Ununseptium", 124, -1.0,"Uus",-1,"Unknown","Unknown");
        pTable[89]= new Element ("Ununoctium", 125, -1,"Uuo",-1,"Unknown","Unknown");
        pTable[90]= new Element ("Cerium", 146, 140.116,"Ce",1.12,"3,4","[Xe] 4f¹ 5d¹ 6s²");
        pTable[91]= new Element ("Praseodymium", 147, 140.90765,"Pr",1.13,"3,4","[Xe] 4f³ 6s²");
        pTable[92]= new Element ("Neodymium", 148, 144.24,"Nd",1.14,"3","[Xe] 4f⁴ 6s²");
        pTable[93]= new Element ("Prometium", 149, 145,"Pm",1.13,"3","[Xe] 4f⁵ 6s²");
        pTable[94]= new Element ("Samarium", 150, 150.36,"Sm",1.17,"3,2","[Xe] 4f⁶ 6s²");
        pTable[95]= new Element ("Europium", 151, 151.964,"Eu",1.2,"3,2","[Xe] 4f⁷ 6s²");
        pTable[96]= new Element ("Gadolinium", 152, 157.25,"Gd",1.2,"3","[Xe] 4f⁷ 5d¹ 6s²");
        pTable[97]= new Element ("Terbium", 153, 158.92534,"Tb",1.1,"3,4","[Xe] 4f⁹ 6s²");
        pTable[98]= new Element ("Dysprosium", 154, 162.50,"Dy",1.22,"3","[Xe] 4f¹⁰ 6s²");
        pTable[99]= new Element ("Holmium", 155, 164.9303,"Ho",1.23,"3","[Xe] 4f¹¹ 6s²");
        pTable[100]= new Element ("Erbium", 156, 167.26,"Er",1.24,"3","[Xe] 4f¹² 6s²");
        pTable[101]= new Element ("Thulium", 157, 168.9342,"Tm",1.25,"3,2","[Xe] 4f¹³ 6s²");
        pTable[102]= new Element ("Ytterbium", 158, 173.04,"Yb",1.1,"3,2","[Xe] 4f¹⁴ 6s²");
        pTable[103]= new Element ("Lutetium", 159, 174.967,"Lu",1.27,"3","[Xe] 4f¹⁴ 5d¹ 6s²");
        pTable[104]= new Element ("Thorium", 164, 232.0381,"Th",1.3,"4","[Rn] 6d² 7s²");
        pTable[105]= new Element ("Protactinium", 165, 231.0359,"Pa",1.5,"5,4","[Rn] 5f² 6d¹ 7s²");
        pTable[106]= new Element ("Uranium", 166, 238.0287,"U",1.38,"6,5,4,3,2","[Rn] 5f³ 6d¹ 7s²");
        pTable[107]= new Element ("Neptunium", 167, 237,"Np",1.36,"5,6,4,3","[Rn] 5f⁴ 6d¹ 7s²");
        pTable[108]= new Element ("Plutonium", 168, 244,"Pu",1.28,"4,6,5,3","[Rn] 5f⁶ 7s²");
        pTable[109]= new Element ("Americium", 169, 243,"Am",1.3,"3,6,5,4,2","[Rn] 5f⁷ 7s²");
        pTable[110]= new Element ("Curium", 170, 247,"Cm",1.3,"3","[Rn] 5f⁷ 6d¹ 7s²");
        pTable[111]= new Element ("Berkelium", 171, 247,"Bk",1.3,"2,3,4","[Rn] 5f⁹ 7s²");
        pTable[112]= new Element ("Californium", 172, 251,"Cf",1.3,"2,3,4","[Rn] 5f¹⁰ 7s²");
        pTable[113]= new Element ("Einsteinium", 173, 252,"Es",1.3,"3","[Rn] 5f¹¹ 7s²");
        pTable[114]= new Element ("Fermium", 174, 257,"Fm",1.3,"3","[Rn] 5f¹² 7s²");
        pTable[115]= new Element ("Mendelevium", 175, 258,"Md",3,"3","[Rn] 5f¹³ 7s²");
        pTable[116]= new Element ("Nobelium", 176, 259,"No",1.3,"2,3","[Rn] 5f¹⁴ 7s²");
        pTable[117]= new Element ("Lawrencium", 177, 262,"Lr",1.3,"3","[Rn] 5f¹⁴ 6d¹ 7s²");

        for(int s=0;s<pTable.length;s++){
            myList.add(pTable[s]);
        }

        click();

		 gridView = (GridView) findViewById(R.id.grid_view);
       		// Instance of ImageAdapter Class
		gridView.setAdapter(new ImageAdapter(this));
		
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
						
				if(position==0||position>=17&&position<=19||position>=30&&position<=37||
						position>=48&&position<=125||position>=146&&position<=159||position>=164&&position<=177){
				// Sending image id to FullScreenActivity
				Intent i = new Intent(getApplicationContext(), FullImageActivity.class);
                    ArrayList<Element> myList2 = new ArrayList<Element>(0);
                    for(int s=0;s<pTable.length;s++){
                        myList2.add(pTable[s]);
                    }
				// passing array index
				i.putExtra("id", position);
                i.putParcelableArrayListExtra ("mylist", myList2);
				startActivity(i);
				}
			}
					
		});
	}



    public void click() {
        //Select a specific button to bundle it with the action you want
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cal = new Intent(getApplicationContext(),MolarMass.class);
                ArrayList<Element> myList2 = new ArrayList<Element>(0);
                for(int s=0;s<pTable.length;s++){
                    myList2.add(pTable[s]);
                }
                cal.putParcelableArrayListExtra ("mylist", myList2);

                startActivity(cal);
            }
        });
    }


}