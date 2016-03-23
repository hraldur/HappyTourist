package htr.happytourist.Events;

/**
 * Created by hlingunnlaugsdottir on 23/03/16.
 */
public class Event {

    public String eventType;

    public Event(String typeOfEvent) {
        eventType = typeOfEvent;
    }

    public Event() {
    }

    public String getEventType(){
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
