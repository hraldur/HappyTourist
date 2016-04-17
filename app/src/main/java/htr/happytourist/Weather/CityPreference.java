package htr.happytourist.Weather;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by audurgudjons on 14/04/16.
 */
public class CityPreference {

    SharedPreferences prefs;

    public CityPreference(Activity activity){
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    // If the user hasn't chosen a city yet, return Reykjavik as the
    // default city

    public String getCity(){
        return prefs.getString("city", "Reykjavík, IS");
    }

    public void setCity(String city){
        prefs.edit().putString("city", city).commit();
    }
}
