package htr.happytourist;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;

import htr.happytourist.Fragment.EventFragment;

/**
 * Created by hlingunnlaugsdottir on 20/03/16.
 */
public class EventActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.eventsContainer, new EventFragment()).commit();
        }

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }
}
