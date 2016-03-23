package htr.happytourist;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;

import htr.happytourist.Fragment.SportsFragment;
import htr.happytourist.R;

/**
 * Created by hlingunnlaugsdottir on 22/03/16.
 */
public class SportsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.sportsContainer, new SportsFragment()).commit();
        }

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }
}
