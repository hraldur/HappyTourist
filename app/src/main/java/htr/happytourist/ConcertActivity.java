package htr.happytourist;

/**
 * Created by hlingunnlaugsdottir on 15/03/16.
*/

/*** !!! This class is not used yet !!! ***/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import htr.happytourist.Fragment.ConcertFragment;

public class ConcertActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concert);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.concertContainer, new ConcertFragment()).commit();
        }
    }
}
