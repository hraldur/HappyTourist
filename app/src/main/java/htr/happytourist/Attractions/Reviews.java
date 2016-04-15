package htr.happytourist.Attractions;

/**
 * Created by hrabby on 14.4.2016.
 */
public class Reviews {

    private String comment;
    //private Date time;
    private String username;


    public Reviews() {
    }

    public Reviews(String comment, String username) {
        this.comment = comment;
        this.username = username;
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
}
