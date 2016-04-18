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
public class Football extends Sport {

    public String homeTeam;
    public String awayTeam;
    public String gameLocation;

    public Football(String hTeam, String aTeam, String location, String tournament, String date, String time){
        super(tournament, date, time);
        homeTeam = hTeam;
        awayTeam = aTeam;
        gameLocation = location;
    }

    //Empty constructor
    public Football(){

    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getGameLocation() {
        return gameLocation;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setGameLocation(String gameLocation) {
        this.gameLocation = gameLocation;
    }
}


