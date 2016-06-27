package mySci.mySciApps.mySciAPP;

import com.example.androidhive.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/*This was to load all the images on to the grid, I suggest you don;t edit this 
 * class unless there's a more efficient way to display the periodic table. 
 * I basically have a giant grid with black squares drawn in on parts where 
 * there are no elements.*/

public class ImageAdapter extends BaseAdapter {
	private Context mContext;
	
	// Keep all Images in array
	public Integer[] mThumbIds = {
			R.drawable.hydrogen, R.drawable.blank,
			R.drawable.blank, R.drawable.blank,
			R.drawable.blank, R.drawable.blank,
			R.drawable.blank, R.drawable.blank,
			R.drawable.blank, R.drawable.blank,
			R.drawable.blank, R.drawable.blank,
			R.drawable.blank, R.drawable.blank,
			R.drawable.blank, R.drawable.blank,
			R.drawable.blank, R.drawable.helium,
			R.drawable.lithium, R.drawable.beryllium,
			R.drawable.blank, R.drawable.blank,
			R.drawable.blank, R.drawable.blank,
			R.drawable.blank, R.drawable.blank,
			R.drawable.blank, R.drawable.blank,
			R.drawable.blank, R.drawable.blank,
			R.drawable.boron, R.drawable.carbon,
			R.drawable.nitrogen, R.drawable.oxygen,
			R.drawable.fluorine, R.drawable.neon,
			R.drawable.sodium, R.drawable.magnesium,
			R.drawable.blank, R.drawable.blank,
			R.drawable.blank, R.drawable.blank,
			R.drawable.blank, R.drawable.blank,
			R.drawable.blank, R.drawable.blank,
			R.drawable.blank, R.drawable.blank,
			R.drawable.aluminum, R.drawable.silicon,
			R.drawable.phosphorus, R.drawable.sulfur,
			R.drawable.chlorine, R.drawable.argon,			
			R.drawable.potassium, R.drawable.calcium,
			R.drawable.scandium, R.drawable.titanium,
			R.drawable.vanadium, R.drawable.chromium,
			R.drawable.manganese, R.drawable.iron,
			R.drawable.cobalt, R.drawable.nickel,
			R.drawable.copper, R.drawable.zinc,
			R.drawable.gallium, R.drawable.germanium,
			R.drawable.arsenic, R.drawable.selenium,
			R.drawable.bromine, R.drawable.krypton,
			R.drawable.rubidium, R.drawable.strontium,
			R.drawable.yttrium, R.drawable.zirconium,
			R.drawable.niobium, R.drawable.molybdenum,
			R.drawable.technetium, R.drawable.ruthenium,
			R.drawable.rhodium, R.drawable.palladium,
			R.drawable.silver, R.drawable.cadmium,
			R.drawable.indium, R.drawable.tin,
			R.drawable.antimony, R.drawable.tellurium,
			R.drawable.iodine, R.drawable.xenon,
			R.drawable.cesium, R.drawable.barium,
			R.drawable.lanthanum, R.drawable.hafnium,
			R.drawable.tantalum, R.drawable.tungsten,
			R.drawable.rhenium, R.drawable.osmium,
			R.drawable.iridium, R.drawable.platinum,
			R.drawable.gold, R.drawable.mercury,
			R.drawable.thallium, R.drawable.lead,
			R.drawable.bismuth, R.drawable.polonium,
			R.drawable.astatine, R.drawable.radon,
			R.drawable.francium, R.drawable.radium,
			R.drawable.actinium, R.drawable.rutherfordium,
			R.drawable.dubnium, R.drawable.seaborgium,
			R.drawable.bohrium, R.drawable.hassium,
			R.drawable.meitnerium, R.drawable.darmstadtium,
			R.drawable.roentgenium, R.drawable.copernicium,
			R.drawable.ununtrium, R.drawable.flerovium,
			R.drawable.ununpentium, R.drawable.livermorium,
			R.drawable.ununseptium, R.drawable.ununoctium,
			R.drawable.blank, R.drawable.blank,		
			R.drawable.blank, R.drawable.blank,	
			R.drawable.blank, R.drawable.blank,	
			R.drawable.blank, R.drawable.blank,	
			R.drawable.blank, R.drawable.blank,	
			R.drawable.blank, R.drawable.blank,	
			R.drawable.blank, R.drawable.blank,	
			R.drawable.blank, R.drawable.blank,	
			R.drawable.blank, R.drawable.blank,
			R.drawable.blank, R.drawable.blank,	
			//R.drawable.blank, R.drawable.blank,	
			R.drawable.cerium, R.drawable.praseodymium,	
			R.drawable.neodymium, R.drawable.promethium,	
			R.drawable.samarium, R.drawable.europium,	
			R.drawable.gadolinium, R.drawable.terbium,	
			R.drawable.dysprosium, R.drawable.holmium,	
			R.drawable.erbium, R.drawable.thulium,	
			R.drawable.ytterbium, R.drawable.lutetium,
			R.drawable.blank, R.drawable.blank,
			R.drawable.blank, R.drawable.blank,
			R.drawable.thorium, R.drawable.protactinium,
			R.drawable.uranium, R.drawable.neptunium,
			R.drawable.plutonium, R.drawable.americium,
			R.drawable.curium, R.drawable.berkelium,
			R.drawable.californium, R.drawable.einsteinium,
			R.drawable.fermium, R.drawable.mendelevium,
			R.drawable.nobelium, R.drawable.lawrencium,			
		};
	
	// Constructor
	public ImageAdapter(Context c){
		mContext = c;
	}

	@Override
	public int getCount() {
		return mThumbIds.length;
	}
	
	 @Override
     public boolean isEnabled(int position) {
         if (position==0||position>=17&&position<=19||position>=30&&position<=37||
					position>=48&&position<=125||position>=146&&position<=159||position>=164&&position<=177) {
              return true;
         }
         return false;
     }

	@Override
	public Object getItem(int position) {
		return mThumbIds[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {			
		ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(80, 80));
     
        return imageView;
	}

}
