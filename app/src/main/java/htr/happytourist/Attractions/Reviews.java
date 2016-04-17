package htr.happytourist.Attractions;

/**
 * Created by hrabby on 14.4.2016.
 */
public class Reviews extends Attraction {

    private String comment;
    private String time;
    private String username;
    private String userID;

    public Reviews() {
    }

    public Reviews(String comment, String time, String username, String userID) {
        this.comment = comment;
        this.time = time;
        this.username = username;
        this.userID = userID;
    }

    public Reviews(String attractionName, String rating, String ID, String comment, String time, String username, String userID) {
        super(attractionName, rating, ID);
        this.comment = comment;
        this.time = time;
        this.username = username;
        this.userID = userID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
