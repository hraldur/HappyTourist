package htr.happytourist.Reviews;

/**
 * Created by hlingunnlaugsdottir on 15/04/16.
 */
public class Reviews {
    public String review;
    public String user;
    public String date;

    public Reviews(String reviewStr, String userName, String dateOfpost){
        review = reviewStr;
        user = userName;
        date = dateOfpost;
    }

    public Reviews(){
    }

    public String getReview(){
        return review;
    }

    public String getUser(){
        return user;
    }

    public String getDate() {
        return date;
    }

    public void setReview(String review){
        this.review = review;
    }

    public void setUser(String user){
        this.user = user;
    }

    public void setDate(String date){
        this.date = date;
    }
}
