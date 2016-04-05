package htr.happytourist.Info;

/**
 * Created by hlingunnlaugsdottir on 30/03/16.
 */
public class Phrases {

    public String ENG;
    public String ISL;

    public Phrases(String english, String icelandic){
        ENG = english;
        ISL = icelandic;
    }

    public Phrases(){
    }

    public String getENG(){
        return ENG;
    }

    public String getISL(){
        return ISL;
    }

    public void setENG(String ENG){
        this.ENG = ENG;
    }

    public void setISL(String ISL){
        this.ISL = ISL;
    }
}
