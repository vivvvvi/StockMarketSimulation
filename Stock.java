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

public class Stock {
    private String stockTitle;
    private String stockSymbol;
    private double currentCost;
    private HashMap<Integer, Double> prices;
    private String category; //ex: oil, gold, etc
    
    /**
     * Constructor for stock class
     * 
     * @param string stock title
     * @param string (stock symbol)
     * @param double current cost 
     * @param string for category
     * @return void
     */
    public Stock(String stockTitle, String stockSymbol, double currentCost, String category){
        this.stockTitle = stockTitle;
        this.stockSymbol = stockSymbol;
        this.currentCost = currentCost;
        this.prices = new HashMap<>();
        this.prices.put(1,currentCost); //day 1, and starting cost
        this.category = category;
    }
    
    /**
     * New day - updates values for stock 
     * 
     * @param int number of day
     * @param double factor to use in calculating new cost
     * @return void
     */
    public void newDay(int newDayNum, double factor){
        
        //Get factor based on current event
        //double factor = event.getFactor(this.category);
        
        double randomVal = 0.5 * (Math.random()* 0.2) * (factor/10.0);
        //double randomVal = 1.2;
        this.currentCost = Math.round(this.currentCost * (1+ randomVal) * 100.0)/100.0;
        this.prices.put(newDayNum,this.currentCost);
    }
    /**
     * Returns the stock title 
     * 
     * @param none
     * @return string
     */
    public String getStockTitle(){
        return this.stockTitle;
    }
    /**
     * Returns the stock symbol 
     * 
     * @param none
     * @return string
     */
    public String getStockSymbol(){
        return this.stockSymbol;
    }
    /**
     * Returns the stock's current cost 
     * 
     * @param none
     * @return double
     */
    public double getCurrentCost(){
        return this.currentCost;
    }
    /**
     * Returns the stock's category/industry 
     * 
     * @param none
     * @return string
     */
    public String getCategory(){
        return this.category;
    }
    /**
     * Returns the array of strings that is used in view all stocks table
     *  
     * @param none
     * @return array of strings
     */
    public String[] returnUsefulStr(){
        String[] usefulInfo = {
            this.stockSymbol,
            this.stockTitle,
            String.valueOf(this.prices.get(1)),
            String.valueOf(this.currentCost),
            this.category
        };
        return usefulInfo;
    }
    
}
