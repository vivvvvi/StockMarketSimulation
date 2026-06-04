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

public class OpenPosition {
    private String stockSymbol;
    private double pricePaid;
    private double lastPrice;
    private int quantity;
    private double originalMarketVal;
    private double marketVal;
    private double profitLoss;
    private String percent;
    private Stock stockLink;
    //private Stock stockLink = new Stock();
    private boolean shortType;
    
    /**
     * Constructor for open position class
     * 
     * @param string (stock symbol)
     * @param double price paid
     * @param stock object for stock link
     * @param boolean for short type (is short or not)
     * @return void
     */
    public OpenPosition(String stockSymbol, double pricePaid, int quantity, Stock stockLink, boolean shortType){
        this.stockSymbol = stockSymbol;
        this.pricePaid = pricePaid;
        this.lastPrice = pricePaid; //same at set up
        this.quantity = quantity;
        this.stockLink = stockLink;
        this.originalMarketVal = Math.round(this.pricePaid * this.quantity* 100.0)/100.0;
        
        this.marketVal = this.originalMarketVal;
        this.profitLoss = 0;
        this.percent = "0%";
        this.shortType = shortType;
        //this.shortType = shortType; //true/false
        //this.stockLink = stockLink;
    }
    
    /**
     * Sets values for new day, uses new price of stocks
     * 
     * @param none
     * @return void
     */
    public void setValues(){
        //going to have to set this.lastPrice
        this.lastPrice = Math.round(this.stockLink.getCurrentCost()* 100.0)/100.0;
        //Calculate Market Value
        this.marketVal = Math.round(this.lastPrice * this.quantity* 100.0)/100.0;
        this.profitLoss = Math.round((this.marketVal-this.originalMarketVal) * 100.0)/100.0;
        if (this.shortType==false){
            this.profitLoss = Math.round((this.marketVal-this.originalMarketVal) * 100.0)/100.0;
        } else if (this.shortType==true){
            this.profitLoss = Math.round((this.originalMarketVal-this.marketVal) * 100.0)/100.0;
        }
        //Calculate percent:
        if (this.profitLoss>0){ //Profit
            this.percent = String.valueOf(Math.round((this.profitLoss / originalMarketVal)*100)) + "%";
        } else if (marketVal<originalMarketVal){ //Loss
            this.percent = String.valueOf(Math.round((this.profitLoss / originalMarketVal)*100)) + "%";
        } else if (marketVal==originalMarketVal){
            this.percent = "0";
        }
    }
    
    /**
     * Sets returns true if it is a short position
     * 
     * @param none
     * @return boolean, true if it is a short position
     */
    public boolean getIsShort(){
        return this.shortType;
    }
    
    /**
     * Sets returns stock symbol
     * 
     * @param none
     * @return string of stock symbol
     */
    public String getStockSymbol(){
        return this.stockSymbol;
    }
    /**
     * Sets returns the price paid
     *  
     * @param none
     * @return double of price paid
     */
    public double getPricePaid(){
        return this.pricePaid;
    }
    /**
     * Sets returns the last price of the stock
     *  
     * @param none
     * @return double of last price
     */
    public double getLastPrice(){
        return this.lastPrice;
    }
    /**
     * Sets returns the quantity
     *  
     * @param none
     * @return int for QTY
     */
    public int getQuantity(){
        return this.quantity;
    }
    /**
     * Sets returns the stock object
     *  
     * @param none
     * @return stock object
     */
    public Stock getStockLink(){
        return this.stockLink;
    }
    /**
     * Sets returns the market value (price x qty)
     *  
     * @param none
     * @return double marketVal
     */
    public double getMarketVal(){
        return this.marketVal;
    }
    /**
     * For sells that are only partial
     *  
     * @param qty being sold
     * @return double - returns the change in balance
     */
    public double sellPartial(int qtyToSell){
        this.quantity -= qtyToSell;
        return this.lastPrice * qtyToSell;
    }
    /**
     * For covers that are only partial
     *  
     * @param qty being covered
     * @return double - returns the change in balance
     */
    public double coverPartial(int qtyToCover){
        this.quantity -= qtyToCover;
        return this.lastPrice * qtyToCover;
    }
    
    /**
     * For getting a string for QTY (negative for short)
     *  
     * @param none
     * @return String with QTY
     */
    public String getQTYString (){
        if (this.shortType==false){
            return String.valueOf(this.quantity);
        } else{
            return "-" + String.valueOf(this.quantity);
        }
    }
    
    /**
     * Returns the array of strings that is used in open positions table
     *  
     * @param none
     * @return array of strings
     */
    public String[] returnUsefulStr(){
        String[] usefulInfo = {
            this.stockSymbol,
            this.getQTYString(),
            String.valueOf(this.pricePaid),
            String.valueOf(this.lastPrice),
            String.valueOf(this.marketVal),
            String.valueOf(this.profitLoss),
            String.valueOf(this.percent),
            this.stockLink.getCategory()
        };
        return usefulInfo;
    }
    
}
