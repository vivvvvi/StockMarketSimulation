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

public class StockMarket {
    public static Stock[] stocks;
    //public static ArrayList <Stock> stocks = new ArrayList<>();
    public static int dayNum;
    
    private ArrayList<Event> events = new ArrayList<>();
    private Event currentEvent;
    
    /**
     * Constructor for stock market class
     * builds the stocks and the events
     * 
     * @param none
     * @return void
     */
    public StockMarket(){
        //make them all here//title, symbol, current cost, category
        this.stocks = new Stock[] { //5 of 10 categories
            //TECH
            new Stock("Apple Inc.","AAPL", 255.92, "Tech"),
            new Stock("Microsoft Corporation","MSFT", 373.46,"Tech"),
            new Stock("NIVIDIA Corporation","NVDA",177.39,"Tech"),
            new Stock("Alphabet Inc.","GOOGL",295.77,"Tech"),
            new Stock("Meta Platforms Inc.","META",574.46,"Tech"),
            
            //FINANCE
            new Stock("JPMorgan Chase & Co.","JPM",250.00,"Finance"),
            new Stock("Bank of America Corporation","BAC",39.85,"Finance"),
            new Stock("Goldman Sachs Group Inc.","GS",410.22,"Finance"),
            new Stock("Morgan Stanley","MS",102.34,"Finance"),
            new Stock("Visa Inc","V",287.36,"Finance"),
            
            //FOOD
            new Stock("McDonald's Corporation","MCD",312.44,"Food"),
            new Stock("Coco-Cola Company","KO",71.84,"Food"),
            new Stock("PepsiCo Inc.","PEP",168.42,"Food"),
            new Stock("Starbucks Corporation","SBUX",95.10,"Food"),
            new Stock("Chipotle Mexican Grill","CMG",2850.00,"Food"),
            
            //OIL
            new Stock("Exxon Mobil Corporation","XOM",118.72,"Oil"),
            new Stock("Chevron Corporation","CVX",158.33,"Oil"),
            new Stock("ConocoPhillips","COP",123.45,"Oil"),
            new Stock("Shell plc","SHEL",70.21,"Oil"),
            new Stock("BP plc","BP",37.88,"Oil"),
            
            //DEFENSE
            new Stock("Lockheed Martin Corporation","LMT",637.90,"Defense"),
            new Stock("Raytheon Technologies","RTX",102.55,"Defense"),
            new Stock("Northrop Grumman Corporation","NOC",480.66,"Defense"),
            new Stock("General Dynamics Corporation","GD",290.14,"Defense"),
            new Stock("Boeing Company","BA",215.67,"Defense"),
            
            //ETFS
            new Stock("Vanguard S&P 500 ETF","VOO",480.12,"ETF"),
            new Stock("Invesco QQQ Trust","QQQ",445.33,"ETF"),
            new Stock("SPDR S&P 500 ETF Trust","SPY",510.45,"ETF"),
            new Stock("iShares Core MSCI EAFE ETF","IEFA",72.18,"ETF"),
            new Stock("ARK Innovation ETF","ARKK",52.67,"ETF"),
            
            //HEALTHCARE
            new Stock("Johnson & Johnson","JNJ",162.45,"Healthcare"),
            new Stock("Pfizer Inc.","PFE",28.90,"Healthcare"),
            new Stock("UnitedHealth Group","UNH",498.77,"Healthcare"),
            new Stock("Merck & Co.","MRK",132.56,"Healthcare"),
            new Stock("AbbVie Inc.","ABBV",172.22,"Healthcare"),
            
            //REAL ESTATE
            new Stock("Reality Income Corporation","O",54.33,"Real Estate"),
            new Stock("Simon Property Group","SPG",145.67,"Real Estate"),
            new Stock("Prologis Inc.","PLD",130.12,"Real Estate"),
            new Stock("Digital Realty Trust","DLR",150.45,"Real Estate"),
            new Stock("VICI Properties","VICI",31.88,"Real Estate"),
            
            //UTILTIES 
            new Stock("NextEra Energy","NEE",70.22,"Utilities"),
            new Stock("Duke Energy","DUK",98.55,"Utilities"),
            new Stock("Southern Company","SO",72.91,"Utilities"),
            new Stock("Dominion Energy","D",49.87,"Utilities"),
            new Stock("Exelon Corporation","EXC",40.66,"Utilities"),
            
            //GOLD
            new Stock("Barrick Gold Corporation","GOLD",18.92,"Gold"),
            new Stock("Newont Corporation","NEM",42.75,"Gold"),
            new Stock("Franco-Nevada Corporation","FNV",135.40,"Gold"),
            new Stock("Agnico Eagle Mines Limited","AEM",68.22,"Gold"),
            new Stock("Kinross Gold Corporation","KGC",6.45,"Gold")
            
        };
        this.dayNum = 1;
        this.events = new ArrayList<>();
        //Use map and then clear for each
        HashMap<String,Double> map1 = new HashMap<>();
        HashMap<String,Double> map2 = new HashMap<>();
        HashMap<String,Double> map3 = new HashMap<>();
        HashMap<String,Double> map4 = new HashMap<>();
        HashMap<String,Double> map5 = new HashMap<>();
        HashMap<String,Double> map6 = new HashMap<>();
        HashMap<String,Double> map7 = new HashMap<>();
        HashMap<String,Double> map8 = new HashMap<>();
        HashMap<String,Double> map9 = new HashMap<>();
        HashMap<String,Double> map10 = new HashMap<>();
        //Add all events
        
        //1 - War
        map1.put("Tech",-4.0);
        map1.put("Finance",-6.0);
        map1.put("Food",2.0);
        map1.put("Oil",8.0);
        map1.put("Defense",10.0);
        map1.put("ETF",-5.0);
        map1.put("Healthcare",4.0);
        map1.put("Real Estate",-7.0);
        map1.put("Utilities",2.0);
        map1.put("Gold",9.0);
        
        events.add(new Event("War & Global Military Conflicts",10,10,map1));
        

        //2 - Cure to cancer comes out
        map2.put("Tech",4.0);
        map2.put("Finance",3.0);
        map2.put("Food",1.0);
        map2.put("Oil",1.0);
        map2.put("Defense",-3.0);
        map2.put("ETF",5.0);
        map2.put("Healthcare",10.0);
        map2.put("Real Estate",2.0);
        map2.put("Utilities",1.0);
        map2.put("Gold",-3.0);
        
        events.add(new Event("The Cure to Cancer Comes Out",10,10,map2));
        

        //3 - 2008 housing market crash
        map3.put("Tech",-6.0);
        map3.put("Finance",-8.0);
        map3.put("Food",-1.0);
        map3.put("Oil",-5.0);
        map3.put("Defense",-3.0);
        map3.put("ETF",-3.0);
        map3.put("Healthcare",1.0);
        map3.put("Real Estate",-10.0);
        map3.put("Utilities",1.0);
        map3.put("Gold",5.0);
        
        events.add(new Event("2008 Housing Market Crash",10,10,map3));
        

        //4 - Covid 19 Pandemic
        map4.put("Tech",5.0);
        map4.put("Finance",-4.0);
        map4.put("Food",6.0);
        map4.put("Oil",-5.0);
        map4.put("Defense",-4.0);
        map4.put("ETF",3.0);
        map4.put("Healthcare",10.0);
        map4.put("Real Estate",6.0);
        map4.put("Utilities",3.0);
        map4.put("Gold",7.0);
        
        events.add(new Event("Covid-19 Pandemic: Start of Lockdown",10,10,map4));
        

        //5 - Tech Bubble burst
        map5.put("Tech",-10.0);
        map5.put("Finance",-7.0);
        map5.put("Food",1.0);
        map5.put("Oil",1.0);
        map5.put("Defense",-4.0);
        map5.put("ETF",-2.0);
        map5.put("Healthcare",-2.0);
        map5.put("Real Estate",2.0);
        map5.put("Utilities",3.0);
        map5.put("Gold",7.0);
        
        events.add(new Event("Tech Bubble Burst (Tech Crash)",10,10,map5));
        

        //6 - Economic boom
        map6.put("Tech",9.0);
        map6.put("Finance",9.0);
        map6.put("Food",4.0);
        map6.put("Oil",4.0);
        map6.put("Defense",3.0);
        map6.put("ETF",10.0);
        map6.put("Healthcare",4.0);
        map6.put("Real Estate",9.0);
        map6.put("Utilities",2.0);
        map6.put("Gold",-5.0);
        
        events.add(new Event("Economic Boom",10,10,map6));
        

        //Everyone starts eating triple the food as usual
        map7.put("Tech",3.0);
        map7.put("Finance",2.0);
        map7.put("Food",10.0);
        map7.put("Oil",-4.0);
        map7.put("Defense",-4.0);
        map7.put("ETF",3.0);
        map7.put("Healthcare",8.0);
        map7.put("Real Estate",4.0);
        map7.put("Utilities",2.0);
        map7.put("Gold",-5.0);
        
        events.add(new Event("Everyone starts eating triple the food as usual",10,10,map7));
        

        //Millions of new houses are built
        map8.put("Tech",2.0);
        map8.put("Finance",5.0);
        map8.put("Food",1.0);
        map8.put("Oil",-3.0);
        map8.put("Defense",-4.0);
        map8.put("ETF",5.0);
        map8.put("Healthcare",-2.0);
        map8.put("Real Estate",10.0);
        map8.put("Utilities",8.0);
        map8.put("Gold",-4.0);
        
        events.add(new Event("Millions of new houses are built",10,10,map8));
        

        //Everyone decides to disconnect to technology and never use it again
        map9.put("Tech",-10.0);
        map9.put("Finance",-4.0);
        map9.put("Food",-1.0);
        map9.put("Oil",-4.0);
        map9.put("Defense",1.0);
        map9.put("ETF",2.0);
        map9.put("Healthcare",1.0);
        map9.put("Real Estate",3.0);
        map9.put("Utilities",3.0);
        map9.put("Gold",6.0);
        
        events.add(new Event("Everyone decides to disconnect to technology and never use it again",10,10,map9));
        

        //Reccession 
        map10.put("Tech",-10.0);
        map10.put("Finance",-10.0);
        map10.put("Food",-10.0);
        map10.put("Oil",-10.0);
        map10.put("Defense",-10.0);
        map10.put("ETF",-10.0);
        map10.put("Healthcare",-10.0);
        map10.put("Real Estate",-10.0);
        map10.put("Utilities",-10.0);
        map10.put("Gold",10.0);
        
        events.add(new Event("Reccession",10,10,map10));
        

        chooseNewEvent();
        

    }
    
    /**
     * Calls each stock and updates new price, sends in 
     * the factor which is based on industry
     * 
     * @param none
     * @return void
     */
    public void newDay(){
        this.dayNum+=1;
        boolean check = this.currentEvent.nextDay();
        if (check==true){ //new event
            chooseNewEvent();
        }
        for (Stock s : this.stocks){
            s.newDay(dayNum,this.currentEvent.getFactor(s.getCategory()));
        }
    }
    
    /**
     * Chooses a new event randomly
     * 
     * @param none
     * @return void
     */
    public void chooseNewEvent(){
        Collections.shuffle(events);
        this.currentEvent = events.get(0);
    }
    
    /**
     * Returns a string with the current event name and
     * the days remaining in the event
     * 
     * @param none
     * @return string
     */
    public String getCurrentEvent(){
        return this.currentEvent.getEventName();
    }
    
    /**
     * Returns a multi array of strings to use 
     * in making the table which displays all stocks
     * 
     * @param none
     * @return multi array of strings
     */
    public String[][] returnAllStocks(){
        int count = this.stocks.length;
        String[][] data = new String[count][5];
        int j = 0;
        for (Stock elem : this.stocks){
            data[j]=elem.returnUsefulStr();
            j=j+1;
        }
        return data;
        /*String [][] data = {
            {"Hello","1234","qwertyu","4","5","6","7","8"},
            {"1234","asdfghjk","asdfghjkl","4","5","6","7","8",}
        };*/
        
    }
}
