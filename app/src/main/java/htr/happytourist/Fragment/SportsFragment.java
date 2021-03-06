package htr.happytourist.Fragment;

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

import htr.happytourist.Events.Football;
import htr.happytourist.Events.Handball;
import htr.happytourist.R;
import htr.happytourist.Service.EventService;

/**
 * Created by hlingunnlaugsdottir on 22/03/16.
 */
public class SportsFragment extends Fragment {

    private EventService mEventService;
    Button mBtnFootball;
    Button mBtnHandball;
    TableLayout mViewSportsEvents;


    public SportsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sports, container, false);

        //The view that the sport events are displayed in
        mViewSportsEvents = (TableLayout) v.findViewById(R.id.viewSportsEvents);

        // Football button
        mBtnFootball = (Button) v.findViewById(R.id.btnFootball);

        //Display football events
        mBtnFootball.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //First remove all views that already are present in the mViewSportsEvents view
                mViewSportsEvents.removeAllViews();

                mEventService = new EventService();
                ArrayList<Football> footballArrayList = null;
                try {
                    footballArrayList = mEventService.getFootballEvents();
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //Then add titles to the table layout
                TableRow titles = new TableRow(getContext());

                TextView tournamentTitle = new TextView(getContext());
                tournamentTitle.setText("Tournament");
                tournamentTitle.setTypeface(null, Typeface.BOLD);
                titles.addView(tournamentTitle);

                TextView dateTitle = new TextView(getContext());
                dateTitle.setText("Date");
                dateTitle.setTypeface(null, Typeface.BOLD);
                titles.addView(dateTitle);

                TextView timeTitle = new TextView(getContext());
                timeTitle.setText("Time");
                timeTitle.setTypeface(null, Typeface.BOLD);
                titles.addView(timeTitle);

                TextView homeTeamTitle = new TextView(getContext());
                homeTeamTitle.setText("Home Team");
                homeTeamTitle.setTypeface(null, Typeface.BOLD);
                titles.addView(homeTeamTitle);

                TextView awayTeamTitle = new TextView(getContext());
                awayTeamTitle.setText("Away Team");
                awayTeamTitle.setTypeface(null, Typeface.BOLD);
                titles.addView(awayTeamTitle);

                TextView stadiumTitle = new TextView(getContext());
                stadiumTitle.setText("Stadium");
                stadiumTitle.setTypeface(null, Typeface.BOLD);
                titles.addView(stadiumTitle);

                mViewSportsEvents.addView(titles);

                //Create a table row for all Football events and placing on the mViewSportsEvents TableView
                for (int i = 0; i < footballArrayList.size(); i++) {
                    TableRow tr = new TableRow(v.getContext());
                    tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                    TextView tournament = new TextView(v.getContext());
                    tournament.setPadding(15, 5, 15, 5);
                    tournament.setText(footballArrayList.get(i).sportTournament);
                    tr.addView(tournament);

                    TextView date = new TextView(v.getContext());
                    date.setPadding(15, 5, 15, 5);
                    date.setText(footballArrayList.get(i).sportDate);
                    tr.addView(date);

                    TextView time = new TextView(v.getContext());
                    time.setPadding(15, 5, 15, 5);
                    time.setText(footballArrayList.get(i).sportTime);
                    tr.addView(time);

                    TextView homeTeam = new TextView(v.getContext());
                    homeTeam.setPadding(15, 5, 15, 5);
                    homeTeam.setText(footballArrayList.get(i).homeTeam);
                    tr.addView(homeTeam);

                    TextView awayTeam = new TextView(v.getContext());
                    awayTeam.setPadding(15, 5, 15, 5);
                    awayTeam.setText(footballArrayList.get(i).awayTeam);
                    tr.addView(awayTeam);

                    TextView location = new TextView(v.getContext());
                    location.setPadding(15, 5, 15, 5);
                    location.setText(footballArrayList.get(i).gameLocation);
                    tr.addView(location);

                    mViewSportsEvents.addView(tr);
                }
            }
        });


        // Handball button
        mBtnHandball = (Button) v.findViewById(R.id.btnHandball);

        //Display handball events
        mBtnHandball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //First remove all views that already are present in the mViewSportsEvents view
                mViewSportsEvents.removeAllViews();

                mEventService = new EventService();
                ArrayList<Handball> handballArrayList = null;
                try {
                    handballArrayList = mEventService.getHandballEvents();
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //Then add titles to the table layout
                TableRow titles = new TableRow(getContext());

                TextView tournamentTitle = new TextView(getContext());
                tournamentTitle.setText("Tournament");
                tournamentTitle.setTypeface(null, Typeface.BOLD);
                titles.addView(tournamentTitle);

                TextView dateTitle = new TextView(getContext());
                dateTitle.setText("Date");
                dateTitle.setTypeface(null, Typeface.BOLD);
                titles.addView(dateTitle);

                TextView timeTitle = new TextView(getContext());
                timeTitle.setText("Time");
                timeTitle.setTypeface(null, Typeface.BOLD);
                titles.addView(timeTitle);

                TextView teamsTitle = new TextView(getContext());
                teamsTitle.setText("Teams");
                teamsTitle.setTypeface(null, Typeface.BOLD);
                titles.addView(teamsTitle);

                TextView stadiumTitle = new TextView(getContext());
                stadiumTitle.setText("Stadium");
                stadiumTitle.setTypeface(null, Typeface.BOLD);
                titles.addView(stadiumTitle);

                mViewSportsEvents.addView(titles);

                //Create a table row for all Handball events and placing on the mViewSportsEvents TableView
                for (int i = 0; i < handballArrayList.size(); i++) {
                    TableRow tr = new TableRow(v.getContext());
                    tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                    TextView tournament = new TextView(v.getContext());
                    tournament.setPadding(10, 5, 10, 5);
                    tournament.setText(handballArrayList.get(i).sportTournament);
                    tr.addView(tournament);

                    TextView date = new TextView(v.getContext());
                    date.setPadding(10, 5, 10, 5);
                    date.setText(handballArrayList.get(i).sportDate);
                    tr.addView(date);

                    TextView time = new TextView(v.getContext());
                    time.setPadding(10, 5, 10, 5);
                    time.setText(handballArrayList.get(i).sportTime);
                    tr.addView(time);

                    TextView teams = new TextView(v.getContext());
                    teams.setPadding(10, 5, 10, 5);
                    teams.setText(handballArrayList.get(i).handballTeams);
                    tr.addView(teams);

                    TextView venue = new TextView(v.getContext());
                    venue.setPadding(10, 5, 10, 5);
                    venue.setText(handballArrayList.get(i).handballVenue);
                    tr.addView(venue);

                    mViewSportsEvents.addView(tr);
                }
            }
        });
        return v;
    }
}
