/**
 * @author vivienne123
 * */
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Event {
    private String eventName;
    private int totalDays;
    private int remainingDays;
    //use hashmap to show how each industry gets affected
    private HashMap<String,Double> industryEffects;//industry,factor
    
    /**
     * Constructer for event class, which represents
     * different events which would impact the stock market
     * 
     * @param string (event name)
     * @param int for total days in event
     * @param int for remaining days
     * @param hashmap for how each industry gets affected
     * @return void
     */
    public Event(String eventName, int totalDays, int remainingDays, HashMap<String, Double> mapOf){
        this.eventName = eventName;
        this.totalDays = totalDays;
        this.remainingDays = remainingDays;
        this.industryEffects = mapOf;
    }
    
    /**
     * Returns double of the factor each stock should be 
     * multiplied by (in additon to random val) based on 
     * the stocks industry
     * 
     * @param String for stocks industry
     * @return double - multiplication factor
     */
    public double getFactor(String industry){
        //return what to multiply it by
        return this.industryEffects.get(industry);
    }
    
    /**
     * Returns event information such as days remaining and name
     * 
     * @param none
     * @return string which event info
     */
    public String getEventName(){
        return "Days remaining on event: " + this.remainingDays + "\nEvent: " + this.eventName ;
    }
    
    /**
     * Runs next day for the event and checks if it is over
     * 
     * @param none
     * @return returns true if event is over so it can be reset
     */
    public boolean nextDay(){
        this.remainingDays -= 1;
        if (this.remainingDays == 0){
            this.remainingDays = this.totalDays;
            return true;
        } else{
            return false;
        }
    }
}
