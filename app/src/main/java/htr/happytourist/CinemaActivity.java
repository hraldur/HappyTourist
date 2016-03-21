package htr.happytourist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import htr.happytourist.Fragment.CinemaFragment;
import htr.happytourist.Fragment.EventFragment;
import android.os.StrictMode;
import htr.happytourist.Fragment.TouristFragment;

/**
 * Created by hlingunnlaugsdottir on 21/03/16.
 */
public class CinemaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.cinemaContainer, new CinemaFragment()).commit();
        }

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }
}