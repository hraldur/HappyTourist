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
public class Concert {
    public String eventDateName;
    public String concertName;
    public String concertDate;
    public String concertTime;
    public String userGroupName;
    public String concertHallName;

    public Concert(String eventName, String name, String date, String time, String groupName, String hallName){
        eventDateName = eventName;
        concertName = name;
        concertDate = date;
        concertTime = time;
        userGroupName = groupName;
        concertHallName = hallName;
    }

    public Concert() {

    }

    public String getEventDateName() {
        return eventDateName;
    }

    public String getConcertName() {
        return concertName;
    }

    public String getConcertDate() {
        return concertDate;
    }

    public String getConcertTime() {
        return concertTime;
    }

    public String getUserGroupName() {
        return userGroupName;
    }

    public String getConcertHallName() {
        return concertHallName;
    }

    public void setEventDateName(String eventDateName) {
        this.eventDateName = eventDateName;
    }

    public void setConcertName(String concertName) {
        this.concertName = concertName;
    }

    public void setConcertDate(String concertDate) {
        this.concertDate = concertDate;
    }

    public void setConcertTime(String concertTime) {
        this.concertTime = concertTime;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    public void setConcertHallName(String concertHallName) {
        this.concertHallName = concertHallName;
    }
}

