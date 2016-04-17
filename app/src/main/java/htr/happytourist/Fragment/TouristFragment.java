package htr.happytourist.Fragment;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

import htr.happytourist.CurrencyActivity;
import htr.happytourist.EventActivity;
import htr.happytourist.InfoActivity;
import htr.happytourist.MapsActivity;
import htr.happytourist.R;
import htr.happytourist.UserActivity;
import htr.happytourist.WeatherActivity;


public class TouristFragment extends Fragment {


    private Button mBtnCurrency;
    private Button mBtnLogin;
    private Button mBtnMap;
    private Button mBtnEvents;


    private Button mBtnInfo;
    private Button mBtnWeather;
    private TextView mTextViewDateTime;



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

        //Display Time and date
        mTextViewDateTime = (TextView) v.findViewById(R.id.textViewDateTime);
        String currentDateTimeString = DateFormat.getDateInstance().format(new Date());
        String happytourist = "Happy Tourist Reykjavík" + "\n" + currentDateTimeString;
        mTextViewDateTime.setText(happytourist);


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

        mBtnInfo = (Button) v.findViewById(R.id.btnInfo);
        mBtnInfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InfoActivity.class);
                startActivityForResult(intent,0);
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


        mBtnWeather = (Button) v.findViewById(R.id.btnWeather);
        mBtnWeather.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WeatherActivity.class);
                startActivityForResult(intent,0);
            }
        });


        return v;
    }



}
