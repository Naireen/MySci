package mySci.mySciApps.mySciAPP;
/*This is the elements object. We should eventually put the calculate method 
 * here once we get it working. 
 * 
 * */
import android.os.Parcel;
import android.os.Parcelable;

public class Element implements Parcelable {

	private double molarMass;
	private String name;
	private int ID;
	private String symbol;
    private double electronegativity;
    private String oxidation;
    private String config;
	
	public Element (String elementName,  int id, double mass, String sym){
		name=elementName;
		molarMass=mass;
		ID= id;
		symbol=sym;
        electronegativity=0;
        oxidation="b";
    config="a";
	}

    public Element (String elementName,  int id, double mass, String sym, double electro, String oxy,String con){
        name=elementName;
        molarMass=mass;
        ID= id;
        symbol=sym;
        electronegativity=electro;
        oxidation= oxy;
        config=con;
    }

	public Element(Parcel in) {
	name=in.readString();
	ID=in.readInt();
	molarMass=in.readDouble();
	symbol=in.readString();
        electronegativity=in.readDouble();
        oxidation=in.readString();
        config=in.readString();
	}

	public String getName (){

		return name;
	}

	public double getMass (){

        return molarMass;
	}

	public int getID (){

		return ID;
	}
	
	public String getSymbol (){

		return symbol;
	}

    public String getOxidation (){
        return oxidation;
    }
    public double getElectro (){

        return electronegativity;
    }

    public String getConfig (){
        return config;
    }
	public double calculate (String s){
		double m= Double.parseDouble(s);
		m= m*molarMass;
		return m;
	}


	public static final Parcelable.Creator<Element> CREATOR
	= new Parcelable.Creator<Element>() {
		public Element createFromParcel(Parcel in) {
			return new Element(in);
		}

		public Element[] newArray(int size) {
			return new Element[size];
		}
	};

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		  dest.writeString (name);
	       dest.writeInt (ID);
	       dest.writeDouble (molarMass);
	       dest.writeString (symbol);
        dest.writeDouble(electronegativity);
        dest.writeString(oxidation);
        dest.writeString(config);

	}

}
