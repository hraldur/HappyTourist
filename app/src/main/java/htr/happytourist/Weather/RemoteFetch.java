package htr.happytourist.Weather;


import android.content.Context;
import org.json.JSONObject;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import htr.happytourist.R;
import htr.happytourist.WeatherActivity;

/**
 * Created by audurgudjons on 14/04/16.
 */
public class RemoteFetch {

    private static final String OPEN_WEATHER_MAP_API =
            "http://api.openweathermap.org/data/2.5/weather?id=6692263&appid=d8c07ce9918863952caaac0572435749";

    public static JSONObject getJSON(Context context, String city){
        try{
            URL url = new URL(String.format(OPEN_WEATHER_MAP_API, city));
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            connection.addRequestProperty("x-api-key",
                    context.getString(R.string.open_weather_maps_app_id));

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuffer json = new StringBuffer(1024);
            String tmp="";
            while((tmp=reader.readLine())!=null)
                json.append(tmp).append("\n");
            reader.close();

            JSONObject data = new JSONObject(json.toString());

            // this value will be 404 if the request was not successful
            if(data.getInt("cod") != 200) {
                return null;
            }

            return data;

        }
        catch(Exception e){
            return null;
        }
    }
}
