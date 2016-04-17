package htr.happytourist.Info;

/**
 * Created by hlingunnlaugsdottir on 06/04/16.
 */
public class UsefulPhoneNumbers {

    public String owner;
    public String number;

    public UsefulPhoneNumbers() {
    }

    public UsefulPhoneNumbers(String owner, String number) {
        this.owner = owner;
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
