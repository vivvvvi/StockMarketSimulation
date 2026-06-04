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

public class User {
    private String username;
    private double startCash;
    private double cashBalance;
    private ArrayList<OpenPosition> openPositions= new ArrayList<>();
    
    /**
     * Constructor for user class
     * 
     * @param string username
     * @param double for start cash
     * @return void
     */
    public User(String username, double startCash){
        this.username = username;
        this.startCash = startCash;
        this.cashBalance = startCash;
        
    }
    
    /**
     * Transaction: purchase
     * updates the user's open positions and cash balance
     * 
     * @param string - stock symbol
     * @param double - price paid
     * @param int - qty
     * @param stock object for stock link
     * @return void
     */
    public void makePurchase(String stockSymbol, double pricePaid, int quantity, Stock stockLink){
        //Need to make a new open position and put it in openPositions 
        OpenPosition buyNewYay = new OpenPosition(stockSymbol, pricePaid, quantity,stockLink,false);
        this.openPositions.add(buyNewYay);
        //Need to take away from cash balance
        this.cashBalance -= pricePaid * quantity;
        this.cashBalance = Math.round(this.cashBalance* 100.0)/100.0;
    }
    
    /**
     * Transaction: sale
     * updates the user's open positions and cash balance
     * 
     * @param open position object
     * @param int of qty to sell
     * @return void
     */
    public void makeSale(OpenPosition openPosition, int qtyToSell){
        //go into Open Positon and get quanitty
        int qtyOfPosition = openPosition.getQuantity();
        if (qtyOfPosition==qtyToSell){
            this.cashBalance += openPosition.getMarketVal();
            this.openPositions.remove(openPosition);
        } else if (qtyOfPosition>qtyToSell){
            this.cashBalance += openPosition.sellPartial(qtyToSell);
        }
        this.cashBalance = Math.round(this.cashBalance* 100.0)/100.0;
    }
    
    /**
     * Transaction: short
     * updates the user's open positions and cash balance
     * 
     * @param string - stock symbol
     * @param double - price paid
     * @param int - qty
     * @param stock object for stock link
     * @return void
     */
    public void makeShort(String stockSymbol, double price, int quantity, Stock stockLink){
        //Need to make a new open position and put it in openPositions 
        OpenPosition shortNewYay = new OpenPosition(stockSymbol, price, quantity,stockLink,true);
        this.openPositions.add(shortNewYay);
        //Need to take away from cash balance
        this.cashBalance += price * quantity;
        this.cashBalance = Math.round(this.cashBalance* 100.0)/100.0;
    }
    
    /**
     * Transaction: cover
     * updates the user's open positions and cash balance
     * 
     * @param open position object
     * @param int of qty to cover
     * @return void
     */
    public void makeCover(OpenPosition openPosition, int qtyToCover){
        //go into Open Positon and get quanitty
        int qtyOfPosition = openPosition.getQuantity();
        if (qtyOfPosition==qtyToCover){
            //this.cashBalance -= openPosition.getMarketVal();
            this.cashBalance -= openPosition.coverPartial(qtyToCover);
            this.openPositions.remove(openPosition);
        } else if (qtyOfPosition>qtyToCover){
            this.cashBalance -= openPosition.coverPartial(qtyToCover);
        }
        this.cashBalance = Math.round(this.cashBalance* 100.0)/100.0;
    }
    
    
    /**
     * Runs new day for each open position
     * updates profit, market val, etc
     * updates the user's open positions and cash balance
     * 
     * @param none
     * @return void
     */
    public void newDay(){
        for (OpenPosition o : this.openPositions){
            o.setValues();
        }
        
    }
    
    
    /**
     * Returns a multi array of strings to use 
     * in making the table which displays all open positions
     * 
     * @param none
     * @return multi array of strings
     */
    public String[][] returnOpenPositions(){
        int count = this.openPositions.size();
        String[][] data = new String[count][9];
        int j = 0;
        for (OpenPosition elem : this.openPositions){
            data[j]=elem.returnUsefulStr();
            j=j+1;
        }
        return data;
    }
    
    /**
     * Returns cash balance
     * 
     * @param none
     * @return double
     */
    public double getCashBalance(){
        return this.cashBalance;
    }
    
    /**
     * Returns open positions
     * 
     * @param none
     * @return arraylist of open positon objects
     */
    public ArrayList<OpenPosition> getOpenPositions(){
        return this.openPositions;
    }
}
