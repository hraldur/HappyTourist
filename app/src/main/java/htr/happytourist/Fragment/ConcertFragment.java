package htr.happytourist.Fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import htr.happytourist.Events.Concert;
import htr.happytourist.R;
import htr.happytourist.Service.EventService;

/**
 * Created by hlingunnlaugsdottir on 16/03/16.
**/

public class ConcertFragment extends Fragment {

    public ConcertFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_concert, container, false);
    }
}