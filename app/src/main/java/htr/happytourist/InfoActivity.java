package htr.happytourist;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import htr.happytourist.Fragment.InfoFragment;

/**
 * Created by hlingunnlaugsdottir on 31/03/16.
 */
public class InfoActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.infoContainer, new InfoFragment()).commit();
        }

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }
}