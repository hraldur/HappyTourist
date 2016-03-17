package htr.happytourist.Events;

import org.json.JSONException;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import htr.happytourist.Data.GetData;

/**
 * Created by hlingunnlaugsdottir on 16/03/16.
 */
public class Handball extends Sport {
    public String handballTeams;
    public String handballVenue;

    public Handball(String teams, String venue, String tournament, String date, String time) {
        super(tournament, date, time);
        handballTeams = teams;
        handballVenue = venue;
    }

    public Handball() {

    }

    public String getHandballTeams() {
        return handballTeams;
    }

    public String getHandballVenue() {
        return handballVenue;
    }

    public void setHandballTeams(String handballTeams) {
        this.handballTeams = handballTeams;
    }

    public void setHandballVenue(String handballVenue) {
        this.handballVenue = handballVenue;
    }
}
