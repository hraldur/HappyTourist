package htr.happytourist.Info;

/**
 * Created by hlingunnlaugsdottir on 06/04/16.
 */
public class UsefulPhoneNumbers {

    public String OWNER;
    public String PHONENUMBER;

    public UsefulPhoneNumbers(String owner, String phonenumber){
        OWNER = owner;
        PHONENUMBER = phonenumber;
    }

    public UsefulPhoneNumbers(){
    }

    public String getOWNER(){
        return OWNER;
    }

    public String getPHONENUMBER(){
        return PHONENUMBER;
    }

    public void setOWNER(String OWNER){
        this.OWNER = OWNER;
    }

    public void setPHONENUMBER(String PHONENUMBER){
        this.PHONENUMBER = PHONENUMBER;
    }
}
