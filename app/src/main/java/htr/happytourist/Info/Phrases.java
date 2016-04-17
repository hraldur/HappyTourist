package htr.happytourist.Info;

/**
 * Created by hlingunnlaugsdottir on 30/03/16.
 */
public class Phrases {

    private String english;
    private String icelandic;

    public Phrases() {

    }

    public Phrases(String english, String icelandic) {
        this.english = english;
        this.icelandic = icelandic;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getIcelandic() {
        return icelandic;
    }

    public void setIcelandic(String icelandic) {
        this.icelandic = icelandic;
    }
}
