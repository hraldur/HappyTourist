package htr.happytourist.Events;

/**
 * Created by hlingunnlaugsdottir on 16/03/16.
 */
public class Sport {
    public String sportTournament;
    public String sportDate;
    public String sportTime;

    public Sport(String tournament, String date, String time) {
        sportTournament = tournament;
        sportDate = date;
        sportTime = time;
    }

    public Sport() {
    }

    public String getSportTournament() {
        return sportTournament;
    }

    public String getSportDate() {
        return sportDate;
    }

    public String getSportTime() {
        return sportTime;
    }

    public void setSportTournament(String sportTournament) {
        this.sportTournament = sportTournament;
    }

    public void setSportDate(String sportDate) {
        this.sportDate = sportDate;
    }

    public void setSportTime(String sportTime) {
        this.sportTime = sportTime;
    }
}
