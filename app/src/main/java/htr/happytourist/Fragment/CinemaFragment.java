package htr.happytourist.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import htr.happytourist.R;

/**
 * Created by hlingunnlaugsdottir on 21/03/16.
 */



/*** This class is not used yet ***/
public class CinemaFragment extends Fragment {

    public CinemaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cinema, container, false);
        return v;
    }

}
