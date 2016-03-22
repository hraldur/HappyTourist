package htr.happytourist.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import htr.happytourist.ConcertActivity;
import htr.happytourist.Events.Cinema;
import htr.happytourist.Events.Concert;
import htr.happytourist.R;
import htr.happytourist.Service.EventService;
import htr.happytourist.SportsActivity;

/**
 * Created by hlingunnlaugsdottir on 20/03/16.
 */
public class EventFragment extends Fragment {

    private EventService mEventService;
    Button mBtnConcerts;
    Button mBtnCinema;
    Button mBtnSports;
    //TextView mViewConcerts;
    //TextView mViewCinema;
    //TextView mViewSports;
    TableLayout mViewEvents;

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

        mViewEvents = (TableLayout) v.findViewById(R.id.viewEvents);


        //See Cinema events
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

                for(int i=0; i<cinemaArrayList.size(); i++) {
                    TableRow tr = new TableRow(v.getContext());
                    tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                    TextView movieTitle = new TextView(v.getContext());
                    movieTitle.setText(cinemaArrayList.get(i).movieTitle);
                    tr.addView(movieTitle);

                    TextView restrictedAge = new TextView(v.getContext());
                    restrictedAge.setText(cinemaArrayList.get(i).restrictedAge);
                    tr.addView(restrictedAge);

                    TextView movieTheater = new TextView(v.getContext());
                    movieTheater.setText(cinemaArrayList.get(i).movieTheater[0]);
                    tr.addView(movieTheater);

                    TextView movieSchedule = new TextView(v.getContext());
                    movieSchedule.setText(cinemaArrayList.get(i).movieSchedule[0][0]);
                    tr.addView(movieSchedule);

                    mViewEvents.addView(tr);
                }
            }
        });





        //See Concert events
        mBtnConcerts = (Button) v.findViewById(R.id.btnConcerts);
        mBtnConcerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(v.getContext(), ConcertActivity.class);
                //startActivityForResult(intent, 0);

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

                for(int i=0; i<concertsArrayList.size(); i++) {
                    TableRow tr = new TableRow(v.getContext());
                    tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                    TextView eventDateName = new TextView(v.getContext());
                    eventDateName.setText(concertsArrayList.get(i).eventDateName);
                    tr.addView(eventDateName);

                    TextView concertName = new TextView(v.getContext());
                    concertName.setText(concertsArrayList.get(i).concertName);
                    tr.addView(concertName);

                    TextView concertDate = new TextView(v.getContext());
                    concertDate.setText(concertsArrayList.get(i).concertDate);
                    tr.addView(concertDate);

                    TextView concertTime = new TextView(v.getContext());
                    concertTime.setText(concertsArrayList.get(i).concertTime);
                    tr.addView(concertTime);

                    TextView userGroupName = new TextView(v.getContext());
                    userGroupName.setText(concertsArrayList.get(i).userGroupName);
                    tr.addView(userGroupName);

                    TextView concertHallName = new TextView(v.getContext());
                    concertHallName.setText(concertsArrayList.get(i).concertHallName);
                    tr.addView(concertHallName);

                    mViewEvents.addView(tr);
                }
            }
        });

        //See sport events
        mBtnSports = (Button) v.findViewById(R.id.btnSports);
        mBtnSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SportsActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        return v;
    }
}
