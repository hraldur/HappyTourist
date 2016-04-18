package htr.happytourist.Attractions;

/**
 * Created by hrabby on 16.4.2016.
 */
public class Attraction {

    private String mAttractionName;
    private String mRating;
    private String mID;

    //Empty constructor
    public Attraction() {
    }

    public String getAttractionName() {
        return mAttractionName;
    }

    public void setAttractionName(String attractionName) {
        mAttractionName = attractionName;
    }

    public String getRating() {
        return mRating;
    }

    public void setRating(String rating) {
        mRating = rating;
    }

    public String getID() {
        return mID;
    }

    public void setID(String ID) {
        mID = ID;
    }

    public Attraction(String attractionName, String rating, String ID) {


        mAttractionName = attractionName;
        mRating = rating;
        mID = ID;
    }
}
