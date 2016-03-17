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
public class Cinema {
    public String movieTitle;
    public String restrictedAge;
    public String[] movieTheater;
    public String [][] movieSchedule;

    public Cinema(String title, String age, String[] theater, String[][] schedule ){
        movieTitle = title;
        restrictedAge = age;
        movieTheater = theater;
        movieSchedule = schedule;
    }

    public Cinema(){}

    public String getMovieTitle() {
        return movieTitle;
    }
    public String getRestrictedAge(){
        return restrictedAge;
    }

    public String[] getMovieTheater() {
        return movieTheater;
    }

    public String[][] getMovieSchedule() {
        return movieSchedule;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setRestrictedAge(String restrictedAge) {
        this.restrictedAge = restrictedAge;
    }

    public void setMovieTheater(String[] movieTheater) {
        this.movieTheater = movieTheater;
    }

    public void setMovieSchedule(String[][] movieSchedule) {
        this.movieSchedule = movieSchedule;
    }
}
