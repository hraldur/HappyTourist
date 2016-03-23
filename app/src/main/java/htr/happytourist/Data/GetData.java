package htr.happytourist.Data;

<<<<<<< HEAD
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
=======




import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

>>>>>>> master
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;

<<<<<<< HEAD
import htr.happytourist.Events.Cinema;
import htr.happytourist.Events.Concert;
import htr.happytourist.Events.Football;
import htr.happytourist.Events.Handball;
import htr.happytourist.Info.CurrencyConverter;

/**
 * Created by hlingunnlaugsdottir on 16/03/16.
 */
public class GetData {
    private String dataType;

    public GetData(String dataType) {
        this.dataType = dataType;
    }

    //reads data and returns as a string
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    //reads from url
    public static JSONObject readData(String typeOfData) throws IOException, JSONException {
        InputStream is = new URL("http://apis.is/"+typeOfData).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public CurrencyConverter[] createCurrencyConverter()throws JSONException, ParseException, IOException {
        JSONObject currency = readData("currency");
        JSONArray result = currency.getJSONArray("results");


        CurrencyConverter[] currencyConverters = new CurrencyConverter[result.length()];
        for(int i = 0; i < result.length(); i++){
            JSONObject converter = result.getJSONObject(i);

            String shortName  = converter.getString("shortName");
            double value = converter.getDouble("value");


            currencyConverters[i] = new CurrencyConverter();
            currencyConverters[i].setCurrencyShortName(CurrencyConverter.Currency.valueOf(shortName));
            currencyConverters[i].setValue(value);

        }
        return currencyConverters;
    }

    public Football[] createFootballEvents() throws JSONException, ParseException, IOException {
        JSONObject sportsFootball = readData("sports/football");
        JSONArray result = sportsFootball.getJSONArray("results");
        Football[] fotbolti = new Football[result.length()];
        for(int i=0; i < result.length(); i++) {
            JSONObject footballEvent = result.getJSONObject(i);

            int counter = footballEvent.getInt("counter");

            String date = footballEvent.getString("date");
            String time = footballEvent.getString("time");
            String tournament = footballEvent.getString("tournament");
            String homeTeam = footballEvent.getString("homeTeam");
            String awayTeam = footballEvent.getString("awayTeam");
            String location = footballEvent.getString("location");

            fotbolti[i] = new Football();
            fotbolti[i].setSportDate(date);
            fotbolti[i].setSportTime(time);
            fotbolti[i].setSportTournament(tournament);
            fotbolti[i].setHomeTeam(homeTeam);
            fotbolti[i].setAwayTeam(awayTeam);
            fotbolti[i].setGameLocation(location);
        }
        return fotbolti;
    }

    public Handball[] createHandballEvents() throws IOException, JSONException, ParseException {
        JSONObject sportsHandball = readData("sports/handball");
        JSONArray result = sportsHandball.getJSONArray("results");
        Handball [] handbolti = new Handball[result.length()];
        for(int i=0; i<result.length(); i++) {
            JSONObject handballEvent = result.getJSONObject(i);
            String teams = handballEvent.getString("Teams");
            String venue = handballEvent.getString("Venue");
            String tournament = handballEvent.getString("Tournament");

            String date = handballEvent.getString("Date");
            String time = handballEvent.getString("Time");

            handbolti[i] = new Handball();
            handbolti[i].setHandballTeams(teams);
            handbolti[i].setHandballVenue(venue);
            handbolti[i].setSportTournament(tournament);
            handbolti[i].setSportDate(date);
            handbolti[i].setSportTime(time);
        }
        return handbolti;
    }

    public Concert[] createConcertsEvents() throws IOException, JSONException, ParseException {
        JSONObject concerts = readData("concerts");
        JSONArray result = concerts.getJSONArray("results");
        Concert [] tonleikar = new Concert[result.length()];
        for(int i=0; i<result.length(); i++) {
            JSONObject concertsEvent = result.getJSONObject(i);
            String eventDateName = concertsEvent.getString("eventDateName");
            String name = concertsEvent.getString("name");
            String dateOfShow = concertsEvent.getString("dateOfShow");
            String timeOfShow = "time not available";
            boolean contains = dateOfShow.contains("T");
            if(contains){
                String[] dateTime = dateOfShow.split("T");
                dateOfShow = dateTime[0];
                timeOfShow = dateTime[1];
            }
            String userGroupName = concertsEvent.getString("userGroupName");
            String eventHallName = concertsEvent.getString("eventHallName");

            tonleikar[i] = new Concert();
            tonleikar[i].setEventDateName(eventDateName);
            tonleikar[i].setConcertName(name);
            tonleikar[i].setConcertDate(dateOfShow);
            tonleikar[i].setConcertTime(timeOfShow);
            tonleikar[i].setUserGroupName(userGroupName);
            tonleikar[i].setConcertHallName(eventHallName);
        }
        return tonleikar;
    }

    public Cinema[] createCinemaEvents() throws IOException, JSONException, ParseException {
        JSONObject cinema = readData("cinema");
        JSONArray result = cinema.getJSONArray("results");
        Cinema [] bio = new Cinema[result.length()];
        for(int i=0; i< result.length(); i++) {
            JSONObject cinemaEvent = result.getJSONObject(i);
            String title = cinemaEvent.getString("title");
            String restricted = cinemaEvent.getString("restricted");

            JSONArray showTimes = cinemaEvent.getJSONArray("showtimes");
            String[] theater = new String[showTimes.length()];
            String[][] schedule = new String[result.length()][showTimes.length()];
            for(int j=0; j<showTimes.length(); j++) {
                JSONObject showTime = showTimes.getJSONObject(j);
                theater[j] = showTime.getString("theater");
                schedule[i][j] = showTime.getString("schedule");
            }

            bio[i] = new Cinema();
            bio[i].setMovieTitle(title);
            bio[i].setRestrictedAge(restricted);
            bio[i].setMovieTheater(theater);
            bio[i].setMovieSchedule(schedule);

        }
        return bio;
    }
=======
import htr.happytourist.Info.CurrencyConverter;

/**
 * Created by hrabby on 2.3.2016.
 */
public class GetData {

        private String dataType;

        public GetData(String dataType) {this.dataType = dataType;}


        //reads data and returns as a string
        private static String readAll(Reader rd) throws IOException {
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            return sb.toString();
        }


        //reads from url
        public static JSONObject readData(String typeOfData) throws IOException, JSONException {
            InputStream is = new URL("http://apis.is/"+typeOfData).openStream();
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                String jsonText = readAll(rd);
                JSONObject json = new JSONObject(jsonText);
                return json;
            } finally {
                is.close();
            }
        }


        public CurrencyConverter[] createCurrencyConverter()throws JSONException, ParseException, IOException {
            JSONObject currency = readData("currency");
            JSONArray result = currency.getJSONArray("results");


            CurrencyConverter[] currencyConverters = new CurrencyConverter[result.length()];
            for(int i = 0; i < result.length(); i++){
                JSONObject converter = result.getJSONObject(i);

                String shortName  = converter.getString("shortName");
                double value = converter.getDouble("value");


                currencyConverters[i] = new CurrencyConverter();
                currencyConverters[i].setCurrencyShortName(CurrencyConverter.Currency.valueOf(shortName));
                currencyConverters[i].setValue(value);

            }
            return currencyConverters;
        }
>>>>>>> master
}
