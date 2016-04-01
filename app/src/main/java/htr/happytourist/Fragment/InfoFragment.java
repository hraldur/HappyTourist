package htr.happytourist.Fragment;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.ArrayList;

//import htr.happytourist.Info.UsefulInfoHelper;
import htr.happytourist.R;
import htr.happytourist.Service.EventService;

/**
 * Created by hlingunnlaugsdottir on 31/03/16.
 */
public class InfoFragment extends Fragment {

    Button mBtnPhrases;
    Button mBtnUsefulPhoneNumbers;

    public InfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_info, container, false);

        //Phrases button
        mBtnPhrases = (Button) v.findViewById(R.id.btnPhrases);

        /*
        mBtnPhrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // UsefulInfoHelper usefulInfoHelper = new UsefulInfoHelper(v.getContext());
                //SQLiteDatabase db = usefulInfoHelper.getReadableDatabase();
            }
        });

        */
        return v;
    }
}
