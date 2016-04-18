package htr.happytourist.Fragment;

import android.content.Intent;
import android.graphics.Typeface;
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
    TableLayout mViewEvents;
    //TextView mViewConcerts;
    //TextView mViewCinema;
    //TextView mViewSports;


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

        //The view that the events are displayed in
        mViewEvents = (TableLayout) v.findViewById(R.id.viewEvents);

        //Cinema button
        mBtnCinema = (Button) v.findViewById(R.id.btnCinema);

        //Display Cinema events
        mBtnCinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //First remove all views that already are present in the mViewEvents view
                mViewEvents.removeAllViews();

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

                //Then add titles to the table layout
                TableRow titles = new TableRow(getContext());

                TextView movie = new TextView(getContext());
                movie.setText("Movie");
                movie.setTypeface(null, Typeface.BOLD);
                titles.addView(movie);

                TextView restrictedAgeTitle = new TextView(getContext());
                restrictedAgeTitle.setText("Restricted");
                restrictedAgeTitle.setTypeface(null, Typeface.BOLD);
                titles.addView(restrictedAgeTitle);

                TextView movieTheaterTitle = new TextView(getContext());
                movieTheaterTitle.setText("Movie Theater");
                movieTheaterTitle.setTypeface(null, Typeface.BOLD);
                titles.addView(movieTheaterTitle);

                TextView movieScheduleTitle = new TextView(getContext());
                movieScheduleTitle.setText("Movie Schedule");
                movieScheduleTitle.setTypeface(null, Typeface.BOLD);
                titles.addView(movieScheduleTitle);

                mViewEvents.addView(titles);


                //Create a table row for all Cinema events and placing on the mViewEvents TableView
                for(int i=0; i<cinemaArrayList.size(); i++) {
                    TableRow tr = new TableRow(v.getContext());
                    tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                    TextView movieTitle = new TextView(v.getContext());
                    movieTitle.setPadding(10, 5, 10, 5);
                    movieTitle.setText(cinemaArrayList.get(i).movieTitle);
                    tr.addView(movieTitle);

                    TextView restrictedAge = new TextView(v.getContext());
                    restrictedAge.setPadding(10, 5, 10, 5);
                    restrictedAge.setText(cinemaArrayList.get(i).restrictedAge);
                    tr.addView(restrictedAge);

                    String theaters = "";
                    TextView movieTheater = new TextView(v.getContext());
                    for(int j=0; j<cinemaArrayList.get(i).movieTheater.length; j++){
                        theaters += cinemaArrayList.get(i).movieTheater[j];
                    }
                    movieTheater.setText(theaters);
                    tr.addView(movieTheater);

                    //thetta er ekki ad koma alveg rett ut, a eftir ad laga
                    String showTimes = "";
                    TextView movieSchedule = new TextView(v.getContext());
                    for(int j=0; j<cinemaArrayList.get(i).movieSchedule.length; j++) {
                        for(int k=0; k<cinemaArrayList.get(i).movieSchedule[j].length; k++){
                            showTimes += cinemaArrayList.get(i).movieSchedule[j][k];
                        }
                    }
                    movieSchedule.setText(showTimes);
                    tr.addView(movieSchedule);
                    mViewEvents.addView(tr);
                }
            }
        });

        //Concert button
        mBtnConcerts = (Button) v.findViewById(R.id.btnConcerts);

        //Display Concert events
        mBtnConcerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //First remove all views that already are present in the mViewEvents view
                mViewEvents.removeAllViews();

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

                //Then add titles to the table layout
                TableRow titles = new TableRow(getContext());

                TextView concertTitle = new TextView(getContext());
                concertTitle.setText("Concert");
                concertTitle.setTypeface(null, Typeface.BOLD);
                titles.addView(concertTitle);

                TextView dateTitle = new TextView(getContext());
                dateTitle.setText("Date");
                dateTitle.setTypeface(null, Typeface.BOLD);
                titles.addView(dateTitle);

                TextView timeTitle = new TextView(getContext());
                timeTitle.setText("Time");
                timeTitle.setTypeface(null, Typeface.BOLD);
                titles.addView(timeTitle);

                TextView concertHallTitle = new TextView(getContext());
                concertHallTitle.setText("Concert Hall");
                concertHallTitle.setTypeface(null, Typeface.BOLD);
                titles.addView(concertHallTitle);

                mViewEvents.addView(titles);

                //Create a table row for all Concert events and placing on the mViewEvents TableView
                for(int i=0; i<concertsArrayList.size(); i++) {
                    TableRow tr = new TableRow(v.getContext());
                    tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                    TextView eventDateName = new TextView(v.getContext());
                    eventDateName.setPadding(10, 5, 10, 5);
                    eventDateName.setText(concertsArrayList.get(i).eventDateName);
                    tr.addView(eventDateName);

                    /*
                    TextView concertName = new TextView(v.getContext());
                    concertName.setText(concertsArrayList.get(i).concertName);
                    tr.addView(concertName);
                       */

                    TextView concertDate = new TextView(v.getContext());
                    concertDate.setPadding(10, 5, 10, 5);
                    concertDate.setText(concertsArrayList.get(i).concertDate);
                    tr.addView(concertDate);

                    TextView concertTime = new TextView(v.getContext());
                    concertTime.setPadding(10, 5, 10, 5);
                    concertTime.setText(concertsArrayList.get(i).concertTime);
                    tr.addView(concertTime);

                    /*)
                    TextView userGroupName = new TextView(v.getContext());
                    userGroupName.setText(concertsArrayList.get(i).userGroupName);
                    tr.addView(userGroupName);
                    */

                    TextView concertHallName = new TextView(v.getContext());
                    concertHallName.setPadding(10, 5, 10, 5);
                    concertHallName.setText(concertsArrayList.get(i).concertHallName);
                    tr.addView(concertHallName);

                    mViewEvents.addView(tr);
                }
            }
        });

        //Sports button
        mBtnSports = (Button) v.findViewById(R.id.btnSports);

        //Go to sportsActivity
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
