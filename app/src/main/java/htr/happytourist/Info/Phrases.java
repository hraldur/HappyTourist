package htr.happytourist.Info;

/**
 * Created by hlingunnlaugsdottir on 30/03/16.
 */
public class Phrases {

    public String ISL;
    public String ENG;

    public Phrases(String icelandic, String english){
        ISL = icelandic;
        ENG = english;
    }

    public Phrases(){
    }

    public String getISL(){
        return ISL;
    }

    public String getENG(){
        return ENG;
    }

    public void setISL(String ISL){
        this.ISL = ISL;
    }

    public void setENG(String ENG){
        this.ENG = ENG;
    }
}
