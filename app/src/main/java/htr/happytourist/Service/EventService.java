package htr.happytourist.Service;

import org.json.JSONException;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import htr.happytourist.Data.GetData;
import htr.happytourist.Events.Cinema;
import htr.happytourist.Events.Concert;
import htr.happytourist.Events.Football;
import htr.happytourist.Events.Handball;

/**
 * Created by hlingunnlaugsdottir on 16/03/16.
 */
public class EventService {

    public static ArrayList<Cinema> getCinemaEvents() throws ParseException, IOException, JSONException {
        String a = "cinema";
        GetData data = new GetData(a);
        Cinema [] cinema = data.createCinemaEvents();

        ArrayList<Cinema> cinemaList = new ArrayList<Cinema>(Arrays.asList(cinema));
        return cinemaList;
    }

    public static ArrayList<Concert> getConcertsEvents() throws ParseException, IOException, JSONException {
        String a = "concerts";
        GetData data = new GetData(a);
        Concert [] concerts = data.createConcertsEvents();

        ArrayList<Concert> concertsList = new ArrayList<Concert>(Arrays.asList(concerts));
        return concertsList;
    }

    public static ArrayList<Football> getFootballEvents() throws ParseException, IOException, JSONException {
        String a = "football";
        GetData data = new GetData(a);
        Football[] fotbolti = data.createFootballEvents();

        ArrayList<Football> fotboltiList = new ArrayList<Football>(Arrays.asList(fotbolti));
        return fotboltiList;
    }

    public static ArrayList<Handball> getHandballEvents() throws ParseException, IOException, JSONException {
        String a = "handball";
        GetData data = new GetData(a);
        Handball[] handball = data.createHandballEvents();

        ArrayList<Handball> handboltiList = new ArrayList<Handball>(Arrays.asList(handball));
        return handboltiList;
    }
}
