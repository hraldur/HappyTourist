package htr.happytourist.Fragment;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import htr.happytourist.CurrencyActivity;
import htr.happytourist.R;
import htr.happytourist.UserActivity;


public class TouristFragment extends Fragment {


    private Button mBtnCurrency;
    private Button mBtnLogin;

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


        mBtnCurrency = (Button) v.findViewById(R.id.btnCurrency);
        mBtnCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CurrencyActivity.class);
                startActivityForResult(intent, 0);

           }
        });

        mBtnLogin = (Button) v.findViewById(R.id.btnLogin);
        mBtnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), UserActivity.class);
                startActivityForResult(intent, 0);
                }
        });





        return v;
    }



}
