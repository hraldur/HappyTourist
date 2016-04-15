package htr.happytourist.Fragment;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import htr.happytourist.CurrencyActivity;
import htr.happytourist.EventActivity;
import htr.happytourist.MapsActivity;
import htr.happytourist.R;
import htr.happytourist.ReviewActivity;
import htr.happytourist.UserActivity;



public class TouristFragment extends Fragment {


    private Button mBtnCurrency;
    private Button mBtnLogin;
    private Button mBtnMap;
    private Button mBtnEvents;
    private Button mBtnReview;


    public TouristFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tourist, container, false);


        //See Events button click
        mBtnEvents = (Button) v.findViewById(R.id.btnEvents);
        mBtnEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EventActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        //See Currency converter button click
        mBtnCurrency = (Button) v.findViewById(R.id.btnCurrency);
        mBtnCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CurrencyActivity.class);
                startActivityForResult(intent, 0);
            }
        });



    mBtnLogin=(Button)v.findViewById(R.id.btnLogin);
    mBtnLogin.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), UserActivity.class);
            startActivityForResult(intent, 0);
        }


    });


        mBtnMap = (Button) v.findViewById(R.id.btnMap);
        mBtnMap.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MapsActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        mBtnReview = (Button) v.findViewById(R.id.btnReview);
        mBtnReview.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ReviewActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        return v;
    }



}
