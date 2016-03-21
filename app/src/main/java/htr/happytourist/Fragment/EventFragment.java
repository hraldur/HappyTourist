package htr.happytourist.Fragment;

import android.animation.AnimatorSet;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import htr.happytourist.CinemaActivity;
import htr.happytourist.Events.Cinema;
import htr.happytourist.Events.Concert;
import htr.happytourist.R;
import htr.happytourist.Service.EventService;

/**
 * Created by hlingunnlaugsdottir on 20/03/16.
 */
public class EventFragment extends Fragment {

    private Cinema mCinema;
    private EventService mEventService;
    Button mBtnCinema;
    Button mBtnConcerts;
    Button mBtnSports;
    TextView mViewEvents;
    TextView mViewConcerts;



    public EventFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_events, container, false);

        //See Cinema events
        mViewEvents = (TextView) v.findViewById(R.id.viewConcerts);


/*
        mBtnCinema = (Button) v.findViewById(R.id.btnCinema);
        mBtnCinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(v.getContext(), CinemaActivity.class);
                //startActivityForResult(intent, 0);

                mEventService = new EventService();
                ArrayList<Cinema> cinemaArrayList = null;
                try {
                    cinemaArrayList = mEventService.getCinemaEvents();
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                StringBuilder builder = new StringBuilder();
                for (Cinema details : cinemaArrayList) {
                    builder.append(details + "\n");
                }
                mViewEvents.setText(builder.toString());
            }
        });
*/



        //See Concert events
        mBtnConcerts = (Button) v.findViewById(R.id.btnConcerts);
        mBtnConcerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CinemaActivity.class);
                startActivityForResult(intent, 0);

                mEventService = new EventService();
                ArrayList<Concert> concertsArrayList = null;
                try {
                    concertsArrayList = mEventService.getConcertsEvents();
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                /*
                StringBuilder builder = new StringBuilder();
                for (Concert details : concertsArrayList) {
                    builder.append(details + "\n");
                }
                */
                for(int i=0; i<10; i++){
                    String e = concertsArrayList.get(i).concertName;
                    //Log.d(e)
                    mViewConcerts.setText(e);
                }
            }
        });
        //See sport events
        mBtnSports = (Button) v.findViewById(R.id.btnSports);

        return v;
    }
}
