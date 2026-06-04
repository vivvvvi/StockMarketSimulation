/**
 * @author vivienne123
 * */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Control {
    
    //Dimensions
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    
    //ARRAY LIST OF ALL BUTTONS - to remove action listeners
    public static ArrayList<JButton> allButtons = new ArrayList<JButton>();
    
    // Build basic shapes - homescreen
    public static JFrame frame = new JFrame();
    public static JLabel titleLabel = new JLabel("STOCK MARKET");
    public static JButton buyButton = new JButton("Make a Transaction");
    public static JButton sellButton = new JButton("Tutorial");
    public static JButton viewMineButton = new JButton("View Your Stocks");
    public static JButton viewAllButton = new JButton("View All Stocks");
    public static JButton newDayButton = new JButton("initialtext");
    public static JButton themeButton = new JButton("Switch");
    
    //HOME BUTTON! - used on many screens
    public static ImageIcon homeIcon = new ImageIcon("images/homebutton.png");
    public static Image homeimg = homeIcon.getImage();
    
    public static Image scaledHome = homeimg.getScaledInstance(30,30, Image.SCALE_SMOOTH);
    public static JButton homeButton = new JButton(new ImageIcon(scaledHome));
    
    
    //SCREEN: Home background
    
    public static ImageIcon backgroundIcon = new ImageIcon("images/bg.png");
    public static Image backgroundImg = backgroundIcon.getImage();
    
    public static Image scaledBackground = backgroundImg.getScaledInstance(WIDTH,HEIGHT, Image.SCALE_SMOOTH);
    public static JLabel backgroundLabel = new JLabel(new ImageIcon(scaledBackground));
    
    //button 1
    public static ImageIcon add1Icon = new ImageIcon("images/button1.png");
    public static Image add1Img = add1Icon.getImage();
    public static Image scaledAdd1 = add1Img.getScaledInstance(140,90, Image.SCALE_SMOOTH);
    public static JButton add1Button = new JButton();
    
    //button 2
    public static ImageIcon add2Icon = new ImageIcon("images/button2.png");
    public static Image add2Img = add2Icon.getImage();
    public static Image scaledAdd2 = add2Img.getScaledInstance(140,90, Image.SCALE_SMOOTH);
    public static JButton add2Button = new JButton();
    
    //button 3
    public static ImageIcon add3Icon = new ImageIcon("images/button3.png");
    public static Image add3Img = add3Icon.getImage();
    public static Image scaledAdd3 = add3Img.getScaledInstance(140,90, Image.SCALE_SMOOTH);
    public static JButton add3Button = new JButton();
    
    //button 4
    public static ImageIcon add4Icon = new ImageIcon("images/button4.png");
    public static Image add4Img = add4Icon.getImage();
    public static Image scaledAdd4 = add4Img.getScaledInstance(140,90, Image.SCALE_SMOOTH);
    public static JButton add4Button = new JButton();
    
    //button 5
    public static ImageIcon add5Icon = new ImageIcon("images/button5.png");
    public static Image add5Img = add5Icon.getImage();
    public static Image scaledAdd5 = add5Img.getScaledInstance(85,60, Image.SCALE_SMOOTH);
    public static JButton add5Button = new JButton(new ImageIcon(scaledAdd5));
    
    
    //SCREEN: Transaction screen components
    public static JLabel buyTextLabel = new JLabel("Make a Transaction");
    public static JLabel buy1Label = new JLabel("Choose an Action:");
    public static JLabel buy2Label = new JLabel("Symbol of stock:");
    public static JLabel buy3Label = new JLabel("Quantity(max 500):");
    public static JButton buy1Button = new JButton("Preview Purchase");
    public static JButton buy2Button = new JButton("Confirm Purchase");
    public static JTextField whichStock = new JTextField("");
    public static JTextField quantity = new JTextField("");
    public static JButton resetButton = new JButton("Clear");
    //Error messages
    public static JLabel error1Label = new JLabel("Invalid: must input an integer between 1 and 500");
    public static String[] actions = { "Buy", "Sell", "Short", "Cover"};
    public static JComboBox<String> chooseAction = new JComboBox(actions);
    
    public static JLabel orderLabel = new JLabel("initial text");

    //SCREEN: purchase transition screen
    public static JLabel buy21Label = new JLabel("initial text ");
    public static JLabel buy22Label = new JLabel("initial text");
    public static JLabel buy23Label = new JLabel("initial text");
    public static JButton buy21Button = new JButton("Return to home");
    public static JButton buy22Button = new JButton("View open positions");
    public static JButton buy23Button = new JButton("Make another transaction");
    
    
    //SCREEN: OPEN POSITIONS PAGE
    public static JLabel opTLabel = new JLabel("Open Positions");
    public static JLabel op1Label = new JLabel("Symbol");
    public static JLabel op2Label = new JLabel("QTY");
    public static JLabel op3Label = new JLabel("Price Paid");
    public static JLabel op4Label = new JLabel("Last Price");
    public static JLabel op5Label = new JLabel("Days Change");
    public static JLabel op6Label = new JLabel("Market Value");
    public static JLabel op7Label = new JLabel("% Profit / Loss");
    public static JLabel op8Label = new JLabel("Trade?");

    //SCREEN: SHOW ALL STOCKS PAGE
    public static JLabel sTLabel = new JLabel("All Stocks");
    public static JLabel s1Label = new JLabel("initial text");
    public static JLabel whichDayLabel = new JLabel("initialtext");


    //Colors used across
    public static Color brownColor = new Color(106,90,41);
    public static Color niceGreenColor = new Color(200,238,177);
    public static Color pastelPinkColor = new Color(255,182,193);

    //More page
    public static JLabel t1Label = new JLabel("More Info");
    public static JTextArea tutorialArea = new JTextArea("initial text");
    public static JTextArea eventArea = new JTextArea("initial text");


    //INFORMATION
    StockMarket stockMarket;
    User user;
    int dayNum;
    boolean theme;
    
    /**
     * Constructor for control
     * 
     * @param none
     * @return none
     */
    public Control(){
        //Set up stock market and user
        this.stockMarket = new StockMarket();
        this.user = new User("user123",1000000);
        
        allButtons.add(buy1Button);
        allButtons.add(buy2Button);
        //allButtons.add(buy21Button);
        //allButtons.add(buy22Button);
        //allButtons.add(buy23Button);
        //allButtons.add(buyButton);
        //allButtons.add(sellButton);
        //allButtons.add(viewMineButton);
        //allButtons.add(viewAllButton);
        //allButtons.add(homeButton);
        allButtons.add(newDayButton);
        allButtons.add(add5Button);
        
        //Start at day 1
        this.dayNum = 1;
    }
    
    /**
     * Set up which runs before app starts
     * 
     * @param none
     * @return none
     */
    public void setUp(){
        frame.setSize(WIDTH,HEIGHT);
        frame.setLayout(null);
        frame.setVisible(true);
        
        
        //ACTION LISTENER - transaction button
        add1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                makeTransaction();
            }
        });
        
        //ACTION LISTENER - view your stocks
        add2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                viewOpenPositions1();
            }
        });
        
        //ACTION LISTENER - view all stocks
        add3Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                viewAllStocks();
            }
        });
        
        //ACTION LISTENER - view all stocks
        add4Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                moreScreen();
            }
        });
        
        //ACTION LISTENER for home button
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // here run new display for user to buy something 
                //System.out.print("hihihi");
                //frame.remove(titleLabel);
                homeScreen();
            }
        });
        
        //ACTION LISTENER for clear button
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                makeTransaction();
            }
        });
        
        
        //ACTION LISTENERS - for all three buttons
        buy21Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                homeScreen();
            }
        });
        buy22Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                viewOpenPositions1();
            }
        });
        buy23Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                makeTransaction();
            }
        });
    }
    
    /**
     * Home screen which gives user access to 4 other pages
     * through display of image buttons
     * 
     * @param none
     * @return none
     */
    public void homeScreen(){
        frame.getContentPane().removeAll();
        frame.revalidate();

        //CLEAR/REMOVE action listeners
        for (JButton button : allButtons){
            for (ActionListener al : button.getActionListeners()){
                button.removeActionListener(al);
            }
        }

        //WHAT DAY IT IS LABEL
        whichDayLabel.setText("Day: " + this.dayNum);
        whichDayLabel.setBounds(25*WIDTH/40,HEIGHT/150,100,40);
        whichDayLabel.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,12));
        whichDayLabel.setForeground(brownColor);
        frame.add(whichDayLabel);
        
        
        //BUTTON - make a transaction
        add1Button.setIcon(new ImageIcon(scaledAdd1));
        add1Button.setBounds(30,70,150,100);
        add1Button.setBackground(Color.WHITE);
        add1Button.setBorderPainted(false);
        frame.add(add1Button);
        
        
        //BUTTON - view your stocks
        add2Button.setIcon(new ImageIcon(scaledAdd2));
        add2Button.setBounds(210,70,150,100);
        add2Button.setBackground(Color.WHITE);
        add2Button.setBorderPainted(false);
        frame.add(add2Button);
        
        
        //BUTTON - view all stocks
        add3Button.setIcon(new ImageIcon(scaledAdd3));
        add3Button.setBounds(30,190,150,100);
        add3Button.setBackground(Color.WHITE);
        add3Button.setBorderPainted(false);
        frame.add(add3Button);
        

        //BUTTON - more
        add4Button.setIcon(new ImageIcon(scaledAdd4));
        add4Button.setBounds(210,190,150,100);
        add4Button.setBackground(Color.WHITE);
        add4Button.setBorderPainted(false);
        frame.add(add4Button);
        
        
        //BUTTON - next day
        add5Button.setBounds(310,0,90,60);
        add5Button.setBackground(Color.WHITE);
        add5Button.setContentAreaFilled(false);
        add5Button.setBorderPainted(false);
        add5Button.setOpaque(false);
        //add5Button.setFocusPainted(false);
        frame.add(add5Button);
        
        add5Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                newDay("home");
            }
        });
        
        
        int buttonWidth = 30;
        

        backgroundLabel.setBounds(0,0,WIDTH,HEIGHT);
        frame.add(backgroundLabel);
        
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }
    
    /**
     * New day, increases day by run and runs stock market
     * updates for a day passing, including -1 day in the event
     * 
     * @param string for which page to return to
     * @return none
     */
    public void newDay(String whichPageAt){
        this.dayNum +=1;
        this.stockMarket.newDay();
        this.user.newDay();
        if (whichPageAt.equals("home")){
            homeScreen();
        } else if (whichPageAt.equals("viewMine")){
            viewOpenPositions1();
        } else if (whichPageAt.equals("viewAll")){
            viewAllStocks();
        }
    }
    
    /**
     * Transactions including buy, sell, short and cover
     * the user can pick a stock and their QTY here
     * runs checks to ensure their order is possible then
     * updates the user's open positions
     * 
     * @param none
     * @return none
     */
    public void makeTransaction(){
        
        //CLEAR SCREEN
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
        
        Color lightBlue = new Color(165,225,217);
        
        Font acFont = new Font("Arial Rounded MT Bold",Font.PLAIN, 14);
        
        frame.getContentPane().setBackground(lightBlue);
        
        //CLEAR/REMOVE action listeners
        for (JButton button : allButtons){
            for (ActionListener al : button.getActionListeners()){
                button.removeActionListener(al);
            }
        }
        
        //RESET BUTTONS CLICKABILITY
        buy1Button.setEnabled(true);
        buy2Button.setEnabled(true);
        
        //CLEAR FIELDS
        whichStock.setText("");
        quantity.setText("");
        
        //MAKE THEM EDITABLE AGAIN
        whichStock.setEditable(true);
        quantity.setEditable(true);
        
        int label1Width = 120;
        
        //TITLE LABEL
        buyTextLabel.setBounds(WIDTH/2-(200/2),HEIGHT/10,200,30);
        buyTextLabel.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,18));
        buyTextLabel.setForeground(brownColor);
        frame.add(buyTextLabel);
        
        //HOME BUTTON
        int buttonWidth = 30;
        homeButton.setBounds(WIDTH/10 - buttonWidth/2,HEIGHT/30,30,30);
        //homeButton.setBackground(Color.lightGray);
        homeButton.setContentAreaFilled(false);
        homeButton.setBorderPainted(false);
        homeButton.setOpaque(false);
        frame.add(homeButton);
        
        
        //LABEL: Choose an action
        buy1Label.setBounds(2*WIDTH/9-(13*label1Width/20),3*HEIGHT/11,label1Width,11);
        buy1Label.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,11));
        buy1Label.setForeground(brownColor);
        frame.add(buy1Label);
        
        //LABEL: Enter symbol for the stock
        buy2Label.setBounds(WIDTH/2-(5*label1Width/8)+10,3*HEIGHT/11,label1Width,11);
        buy2Label.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,11));
        buy2Label.setForeground(brownColor);
        frame.add(buy2Label);
        
        //LABEL: Enter the quantity
        buy3Label.setBounds(8*WIDTH/9-(3*label1Width/4),3*HEIGHT/11,label1Width,11);
        buy3Label.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,11));
        buy3Label.setForeground(brownColor);
        frame.add(buy3Label);
        
        //DROPDOWN: Action
        chooseAction.setBounds(2*WIDTH/9-(3*label1Width/5),4*HEIGHT/11,label1Width-20,25);
        chooseAction.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,11));
        frame.add(chooseAction);
        
        //TEXT FIELD: Stock symbol
        whichStock.setBounds(WIDTH/2-(5*label1Width/8),4*HEIGHT/11,label1Width,25);
        whichStock.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,11));
        frame.add(whichStock);
        
        //TEXT FIELD: Quanitity
        quantity.setBounds(8*WIDTH/9-(3*label1Width/4),4*HEIGHT/11,label1Width,25);
        quantity.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,11));
        frame.add(quantity);
        
        //BUTTON: Preview purchase
        buy1Button.setBounds(WIDTH/2 - 130/2,11*HEIGHT/22,130,24);
        buy1Button.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,10));
        buy1Button.setBackground(niceGreenColor);
        frame.add(buy1Button);
        
        //BUTTON: Reset purchase
        resetButton.setBounds(28*WIDTH/30 - 130/2,HEIGHT/22,80,24);
        resetButton.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,10));
        resetButton.setBackground(Color.lightGray);
        resetButton.setBorderPainted(false);
        frame.add(resetButton);
        
        
        //ACTION LISTENER for preview purchase
        buy1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //CHECK which action
                boolean fullValid = false;
                String actionValue =  (String) chooseAction.getSelectedItem();
                int qqNum=555;
                try{
                    String qNum = quantity.getText();
                    qqNum = Integer.parseInt(qNum);            
                } catch (NumberFormatException q) {
                    qqNum = 555; //automatically invalid
                }
                String chosenStock = "emptyinitalize";
                try {
                    chosenStock = whichStock.getText().toLowerCase();
                } catch(Exception q){
                    chosenStock = "keep empty";
                }
                
                if (actionValue.equals("Buy")){
                    //PURCHASE
                    
                    boolean validQTY = false;
                    if (qqNum<=500){
                        validQTY = true;
                    }
                    if (validQTY==true){
                        quantity.setEditable(false);
                    }
                    boolean validSymbol = false;
                    Stock linkStock = new Stock("","",0,""); 
                    for (Stock elem :  Control.this.stockMarket.stocks){
                        //System.out.println(whichStock.getText().toLowerCase());
                        //System.out.println(elem.getStockSymbol().toLowerCase());
                        if (chosenStock.equals(elem.getStockSymbol().toLowerCase())){
                            validSymbol = true;
                            linkStock = elem;
                            
                            //System.out.print("check");
                        }
                    }
                    if (validSymbol==true){
                        //System.out.print("123");
                        whichStock.setEditable(false);
                        
                    }
                    if (validQTY==true && validSymbol==true){
                        fullValid = true;
                        buy1Button.setEnabled(false);
                        //make a label with cost * symbol = total
                        //add button to confirm purchase
                        //if button clicked it does a method

                        
                        
                        //STRING - to set label to for displaying order
                        double cCost = 20;
                        cCost = Math.round(linkStock.getCurrentCost()* 100.0)/100.0;
                        double totalOrder = Math.round(cCost * qqNum* 100.0)/100.0;
                        String strTotalOrder = String.valueOf(totalOrder);
                        String labelOrderPrint = "Total order cost: " + cCost + " x " + qqNum + "(QTY) = " + strTotalOrder;
                        
                        //LABEL
                        int label2Width = 320;
                        orderLabel.setText(labelOrderPrint);
                        orderLabel.setBounds(WIDTH/2-(label2Width/2),15*HEIGHT/22,label2Width,18);
                        //orderLabel.setBounds(200,150,200,30);
                        orderLabel.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,12));
                        orderLabel.setForeground(Color.BLACK);
                        frame.add(orderLabel);
                        //System.out.print(WIDTH/2-(label2Width/2));
                        
                        buy2Button.setBounds(WIDTH/2 - 130/2,18*HEIGHT/22,130,24);
                        buy2Button.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,10));
                        buy2Button.setBackground(niceGreenColor);
                        frame.add(buy2Button);
                        
                        frame.revalidate();
                        frame.repaint();

                        String stockTitle = linkStock.getStockTitle();
                        String stockSymbol = linkStock.getStockSymbol();
                        double pricePaid = cCost;
                        int quantityA = qqNum;
                        Stock stockLink = linkStock;
                        
                        buy2Button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e){
                                buy2Button.setEnabled(false);
                                Control.this.user.makePurchase(stockSymbol, pricePaid, quantityA, stockLink);
                                
                                //Then run transition page 
                                transitionScreen(quantityA, stockSymbol, strTotalOrder,"Purchase");
                                
                                
                                
                            }
                        });
                    }
                }
                
                //SELL
                else if (actionValue.equals("Sell")){
                    //String chosenStock = whichStock.getText().toLowerCase();
                    boolean validSymbol = false;
                    boolean validQTY = false;
                    Stock newStock =  new Stock("","",0,""); 
                    OpenPosition linkedOpenPosition = new OpenPosition("", 0, 0, newStock,false);
                    for (OpenPosition elem :  Control.this.user.getOpenPositions()){
                        if (elem.getIsShort()==false){
                            if (chosenStock.equals(elem.getStockSymbol().toLowerCase())){
                                validSymbol = true;
                                linkedOpenPosition = elem;
                                //System.out.println("yah");
                            }
                    }
                    if (validSymbol==true){
                        //System.out.print("123");
                        whichStock.setEditable(false);
                        
                        int maxSellQTY = linkedOpenPosition.getQuantity();
                        if (qqNum<=maxSellQTY){
                            validQTY = true;
                        } else{
                            //System.out.println("Trying to sell too much");
                        }
                    }
                    if (validSymbol==true && validQTY==true){
                        fullValid = true;
                        buy1Button.setEnabled(false);
                        quantity.setEditable(false);
                         //STRING - to set label to for displaying order
                        double cCost = 20;
                        cCost = linkedOpenPosition.getLastPrice(); 
                        double totalOrder = cCost * qqNum;
                        String strTotalOrder = String.valueOf(totalOrder);
                        String labelOrderPrint = "Sale gain: " + cCost + " x " + qqNum + "(QTY) = " + strTotalOrder;
                        
                        //LABEL
                        int label2Width = 320;
                        orderLabel.setText(labelOrderPrint);
                        orderLabel.setBounds(WIDTH/2-(label2Width/2),15*HEIGHT/22,label2Width,18);
                        orderLabel.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,12));
                        orderLabel.setForeground(Color.BLACK);
                        frame.add(orderLabel);

                        buy2Button.setBounds(WIDTH/2 - 130/2,18*HEIGHT/22,130,24);
                        buy2Button.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,10));
                        buy2Button.setBackground(niceGreenColor);
                        frame.add(buy2Button);
                        
                        frame.revalidate();
                        frame.repaint();
                        
                        String stockSymbol = linkedOpenPosition.getStockSymbol();
                        double pricePaid = cCost;
                        int quantityA = qqNum;
                        Stock stockLink = linkedOpenPosition.getStockLink();
                        OpenPosition finalOpenPosition = linkedOpenPosition;
                        
                        buy2Button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e){
                                buy2Button.setEnabled(false);

                                Control.this.user.makeSale(finalOpenPosition, quantityA);

                                //Then run transition page 
                                transitionScreen(quantityA, stockSymbol, strTotalOrder,"Sale");
                                
                                
                                
                            }
                        });
                    }
                        
                }
                }

                
                //SHORT 
                else if (actionValue.equals("Short")){
                    //PURCHASE
                    
                    boolean validQTY = false;
                    if (qqNum<=500 && qqNum>0){
                        validQTY = true;
                    }
                    if (validQTY==true){
                        quantity.setEditable(false);
                    }
                    boolean validSymbol = false;
                    Stock linkStock = new Stock("","",0,""); 
                    for (Stock elem :  Control.this.stockMarket.stocks){
                        if (chosenStock.equals(elem.getStockSymbol().toLowerCase())){
                            validSymbol = true;
                            linkStock = elem;
                        }
                    }
                    if (validSymbol==true){
                        whichStock.setEditable(false);
                    }
                    if (validQTY==true && validSymbol==true){
                        fullValid = true;
                        buy1Button.setEnabled(false);
                        //make a label with cost * symbol = total
                        //add button to confirm purchase
                        //if button clicked it does a method which
                        //will be inside user which i need to make
                        
                        
                        
                        //STRING - to set label to for displaying order
                        double cCost = 20;
                        cCost = Math.round(linkStock.getCurrentCost()* 100.0)/100.0;
                        double totalOrder = Math.round(cCost * qqNum* 100.0)/100.0;
                        String strTotalOrder = String.valueOf(totalOrder);
                        String labelOrderPrint = "Total order: " + cCost + " x " + qqNum + "(QTY) = " + strTotalOrder;
                        
                        //LABEL
                        int label2Width = 320;
                        orderLabel.setText(labelOrderPrint);
                        orderLabel.setBounds(WIDTH/2-(label2Width/2),15*HEIGHT/22,label2Width,18);
                        //orderLabel.setBounds(200,150,200,30);
                        orderLabel.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,12));
                        orderLabel.setForeground(Color.BLACK);
                        frame.add(orderLabel);
                        //System.out.print(WIDTH/2-(label2Width/2));
                        
                        buy2Button.setBounds(WIDTH/2 - 130/2,18*HEIGHT/22,130,24);
                        buy2Button.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,10));
                        buy2Button.setBackground(niceGreenColor);
                        frame.add(buy2Button);
                        
                        frame.revalidate();
                        frame.repaint();

                        String stockTitle = linkStock.getStockTitle();
                        String stockSymbol = linkStock.getStockSymbol();
                        double pricePaid = cCost;
                        int quantityA = qqNum;
                        Stock stockLink = linkStock;
                        
                        buy2Button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e){
                                buy2Button.setEnabled(false);
                                Control.this.user.makeShort(stockSymbol, pricePaid, quantityA, stockLink);
                                
                                //Then run transition page 
                                transitionScreen(quantityA, stockSymbol, strTotalOrder,"Short");
                                
                                
                                
                            }
                        });
                    }
                }
                
                //COVER
                else if (actionValue.equals("Cover")){
                    //Need to check slightly different things
                    //String chosenStock = whichStock.getText().toLowerCase();
                    boolean validSymbol = false;
                    boolean validQTY = false;
                    Stock newStock =  new Stock("","",0,""); 
                    OpenPosition linkedOpenPosition = new OpenPosition("", 0, 0, newStock,false);
                    for (OpenPosition elem :  Control.this.user.getOpenPositions()){
                        //System.out.println(whichStock.getText().toLowerCase());
                        //System.out.println(elem.getStockSymbol().toLowerCase());
                        //System.out.println(chosenStock);//asdfgh
                        //System.out.println(elem.getStockSymbol().toLowerCase());
                        if (elem.getIsShort()==true){
                            if (chosenStock.equals(elem.getStockSymbol().toLowerCase())){
                                validSymbol = true;
                                linkedOpenPosition = elem;
                            }
                        }
                    }
                    if (validSymbol==true){
                        //System.out.print("123");
                        whichStock.setEditable(false);
                        
                        int maxSellQTY = linkedOpenPosition.getQuantity();
                        if (qqNum<=maxSellQTY){
                            validQTY = true;
                        } else{
                            //System.out.println("Trying to sell too much");
                        }
                    }
                    if (validSymbol==true && validQTY==true){
                        fullValid = true;
                        buy1Button.setEnabled(false);
                        quantity.setEditable(false);
                         //STRING - to set label to for displaying order
                        double cCost = 20;
                        cCost = linkedOpenPosition.getLastPrice(); 
                        double totalOrder = cCost * qqNum;
                        String strTotalOrder = String.valueOf(totalOrder);
                        String labelOrderPrint = "Sale gain: " + cCost + " x " + qqNum + "(QTY) = " + strTotalOrder;
                        
                        //LABEL
                        int label2Width = 320;
                        orderLabel.setText(labelOrderPrint);
                        orderLabel.setBounds(WIDTH/2-(label2Width/2),15*HEIGHT/22,label2Width,18);
                        //orderLabel.setBounds(200,150,200,30);
                        orderLabel.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,12));
                        orderLabel.setForeground(Color.BLACK);
                        frame.add(orderLabel);
                        //System.out.print(WIDTH/2-(label2Width/2));
                        
                        buy2Button.setBounds(WIDTH/2 - 130/2,18*HEIGHT/22,130,24);
                        buy2Button.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,10));
                        buy2Button.setBackground(niceGreenColor);
                        frame.add(buy2Button);
                        
                        frame.revalidate();
                        frame.repaint();
                        
                        //String stockTitle = linkedOpenPosition.getStockTitle();
                        String stockSymbol = linkedOpenPosition.getStockSymbol();
                        double pricePaid = cCost;
                        int quantityA = qqNum;
                        Stock stockLink = linkedOpenPosition.getStockLink();
                        OpenPosition finalOpenPosition = linkedOpenPosition;
                        
                        buy2Button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e){
                                buy2Button.setEnabled(false);
                                //System.out.println("hiiii");
                                
                                Control.this.user.makeCover(finalOpenPosition, quantityA);

                                //Then run transition page 
                                //System.out.println("HI");
                                transitionScreen(quantityA, stockSymbol, strTotalOrder,"Cover");
                                
                            }
                        });
                    }
                        
                }
                if (fullValid ==false){
                    error1Label.setText("Invalid Order: make edits or clear.");
                    error1Label.setBounds((WIDTH/2)-(220/2),16*HEIGHT/22,220,24);
                    error1Label.setFont(new Font(titleLabel.getFont().getName(),Font.PLAIN,13));
                    error1Label.setForeground(Color.BLACK);
                    frame.add(error1Label);
                    frame.revalidate();
                    frame.repaint();
                } else{
                    frame.remove(error1Label);
                    frame.revalidate();
                    frame.repaint();
        
                }
            }
        });
    }
    
    /**
     * Transition screen after user makes a transaction
     * this screen displays the user's order and directs
     * them to 3 screens (another transaction, home, and open positions)
     * 
     * @param integer for qty, string for the symbol, string for total cost, and string for what type of transaction
     * @return none
     */
    public void transitionScreen(int QTY, String symbol, String totalCost, String buyOrSell){
        
        //CLEAR/REMOVE action listeners
        for (JButton button : allButtons){
            for (ActionListener al : button.getActionListeners()){
                button.removeActionListener(al);
            }
        }
        
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
        
        int titleWidth = 230;
        int label1Width = 160;
        int label2Width = 180;
        
        //LABEL - TITLE - transaction complete
        buy21Label.setText("Transaction Complete!");
        buy21Label.setBounds(WIDTH/2-(titleWidth/2),2*HEIGHT/11,titleWidth,24);
        buy21Label.setFont(new Font(titleLabel.getFont().getName(),Font.PLAIN,20));
        buy21Label.setForeground(brownColor);
        frame.add(buy21Label);
        
        //LABEL 1 - Purchase of ___ ____ stock 
        String setToThis = buyOrSell + " of " + QTY + " "+ symbol;
        buy22Label.setText(setToThis);
        buy22Label.setBounds(WIDTH/2-(label1Width/2),7*HEIGHT/22,label1Width,10);
        buy22Label.setFont(new Font(titleLabel.getFont().getName(),Font.PLAIN,13));
        buy22Label.setForeground(brownColor);
        frame.add(buy22Label);
        
        //LABEL 2 - For $______
        String setToThis2 = "For a cost of $" + totalCost;
        buy23Label.setText(setToThis2);
        buy23Label.setBounds(WIDTH/2-(label1Width/2),4*HEIGHT/11,label1Width,10);
        buy23Label.setFont(new Font(titleLabel.getFont().getName(),Font.PLAIN,13));
        buy23Label.setForeground(brownColor);
        frame.add(buy23Label);
        
        int buttonWidth = 180;
        //BUTTON 1 - Return to home page
        buy21Button.setBounds(WIDTH/2 - buttonWidth/2,10*HEIGHT/22,180,28);
        buy21Button.setFont(new Font(buy1Button.getFont().getName(), Font.PLAIN,10));
        buy21Button.setBackground(pastelPinkColor);
        frame.add(buy21Button);
        
        //BUTTON 2 - View your open positions
        buy22Button.setBounds(WIDTH/2 - buttonWidth/2,13*HEIGHT/22,180,28);
        buy22Button.setFont(new Font(buy1Button.getFont().getName(), Font.PLAIN,10));
        buy22Button.setBackground(pastelPinkColor);
        frame.add(buy22Button);
        
        //BUTTON 3 - Make another transaction
        buy23Button.setBounds(WIDTH/2 - buttonWidth/2,16*HEIGHT/22,180,28);
        buy23Button.setFont(new Font(buy1Button.getFont().getName(), Font.PLAIN,10));
        buy23Button.setBackground(pastelPinkColor);
        frame.add(buy23Button);
        
    }

    /**
     * Displays all of users open positions on a table
     * User can view profit/loss and all other features of each 
     * open position
     * Also displays the user's cash balance
     * 
     * @param none
     * @return none
     */
    public void viewOpenPositions1(){
        //CLEAR/REMOVE action listeners
        for (JButton button : allButtons){
            for (ActionListener al : button.getActionListeners()){
                button.removeActionListener(al);
            }
        }
        
        //CLEAR SCREEN
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
        
        //System.out.println("HI");
        
        Color lightPink = new Color(252,211,189);
        Color headingPink = new Color(210,120,140);
        
        frame.getContentPane().setBackground(lightPink);
        
        
        int titleWidth = 200;
        int label1Width = 200;
        
        //HOME BUTTON
        int buttonWidth = 30;
        homeButton.setBounds(WIDTH/10 - buttonWidth/2,HEIGHT/30,30,30);
        homeButton.setContentAreaFilled(false);
        homeButton.setBorderPainted(false);
        homeButton.setOpaque(false);
        frame.add(homeButton);
        
        
        //NEXT DAY BUTTON - make it smaller than on home
        add5Button.setBounds(310,0,90,60);
        add5Button.setBackground(Color.WHITE);
        add5Button.setContentAreaFilled(false);
        add5Button.setBorderPainted(false);
        add5Button.setOpaque(false);
        //add5Button.setFocusPainted(false);
        frame.add(add5Button);
        
        add5Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                newDay("viewMine");
            }
        });
        
        
        //TITLE - Open Positions
        opTLabel.setBounds(9*WIDTH/20-(titleWidth/2),HEIGHT/30,titleWidth,30);
        opTLabel.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,18));
        opTLabel.setForeground(brownColor);
        frame.add(opTLabel);
        
        //LABEL - Day #
        op1Label.setText("Day: "+this.dayNum);
        op1Label.setBounds(11*WIDTH/18,(HEIGHT/30)+10,label1Width,10);
        op1Label.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,10));
        op1Label.setForeground(brownColor);
        frame.add(op1Label);
        
        //LABEL - Display cash balance
        String currentCashBal = "Cash Balance: $" + String.valueOf(this.user.getCashBalance());
        op2Label.setText(currentCashBal);
        op2Label.setBounds(WIDTH/45,28*HEIGHT/30,label1Width,10);
        op2Label.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,10));
        op2Label.setForeground(brownColor);
        frame.add(op2Label);
        
        JTable openPositionsTable;
        
        //Use a forloop to make 
        //user.openPositions
        String [][] data = this.user.returnOpenPositions();
        
        String[] columnNames = {"Symbol","QTY","<html>Price<br>Paid</html>","<html>Last<br>Price</html>","<html>Market<br>Value</html>","Profit/Loss","%","Industry"};
        
        openPositionsTable = new JTable(data,columnNames){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        openPositionsTable.getTableHeader().setFont(new Font(titleLabel.getFont().getName(),Font.PLAIN,10));
        openPositionsTable.getTableHeader().setPreferredSize(new Dimension(100,35));
        
        //openPositionsTable.getTableHeader().setDefaultRenderer(new MultiLineHeaderRenderer());
        openPositionsTable.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,9));
        openPositionsTable.setBounds(0,2*HEIGHT/20,WIDTH,HEIGHT-(2*HEIGHT/20));
        
        openPositionsTable.getColumnModel().getColumn(5).setCellRenderer(new colorRenderer());
        
        openPositionsTable.setBackground(lightPink);
        
        JScrollPane sp = new JScrollPane (openPositionsTable);
        
        sp.setBounds(0,3*HEIGHT/20,WIDTH,HEIGHT-(3*HEIGHT/20));
        
        sp.getViewport().setBackground(lightPink);
        
        frame.add(sp);
        frame.setVisible(true);
        
        //
    }

    /**
     * View all availble stocks: the user can see all the stocks
     * they could buy/short, this shows 50 different stocks
     * which come from 10 different industries (5 from each)
     * 
     * @param none
     * @return none
     */
    public void viewAllStocks(){
        //CLEAR/REMOVE action listeners
        for (JButton button : allButtons){
            for (ActionListener al : button.getActionListeners()){
                button.removeActionListener(al);
            }
        }
        
        //CLEAR SCREEN
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
        
        frame.getContentPane().setBackground(niceGreenColor);
        

        int titleWidth = 200;
        int label1Width = 100;
        
        //Color goodGreenColor = new Color();
        
        //HOME BUTTON
        int buttonWidth = 30;
        homeButton.setBounds(WIDTH/10 - buttonWidth/2,HEIGHT/30,30,30);
        homeButton.setContentAreaFilled(false);
        homeButton.setBorderPainted(false);
        homeButton.setOpaque(false);
        frame.add(homeButton);
        
       //NEXT DAY BUTTON - make it smaller than on home
        add5Button.setBounds(310,0,90,60);
        add5Button.setBackground(Color.WHITE);
        add5Button.setContentAreaFilled(false);
        add5Button.setBorderPainted(false);
        add5Button.setOpaque(false);
        //add5Button.setFocusPainted(false);
        frame.add(add5Button);
        
        add5Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                newDay("viewAll");
            }
        });
        
        
        
        
        //TITLE - All Stocks
        sTLabel.setBounds(7*WIDTH/16-(titleWidth/2),HEIGHT/30,titleWidth,30);
        sTLabel.setFont(new Font(titleLabel.getFont().getName(),Font.BOLD,18));
        sTLabel.setForeground(brownColor);
        frame.add(sTLabel);
        
        //LABEL - Current day
        s1Label.setText("Current Day:" + this.dayNum);
        s1Label.setBounds(15*WIDTH/30,(HEIGHT/30)+10,label1Width,10);
        s1Label.setFont(new Font(titleLabel.getFont().getName(),Font.PLAIN,10));
        s1Label.setForeground(brownColor);
        frame.add(s1Label);
        
        JTable allStocksTable;
        
        //Use a forloop to make for stock market
        String [][] data = this.stockMarket.returnAllStocks();
        
        //Set Heading names
        String[] columnNames = {"Symbol","Stock Title","<html>Day 1<br>Price</html>","<html>Last<br>Price</html>","Industry"};
        
        allStocksTable = new JTable(data,columnNames){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        allStocksTable.getTableHeader().setFont(new Font(titleLabel.getFont().getName(),Font.PLAIN,10));
        allStocksTable.getTableHeader().setPreferredSize(new Dimension(100,35));
        
        allStocksTable.setFont(new Font(titleLabel.getFont().getName(),Font.PLAIN,10));
        allStocksTable.setBounds(0,2*HEIGHT/20,WIDTH,HEIGHT-(3*HEIGHT/20));
        
        allStocksTable.setBackground(niceGreenColor);

        
        JScrollPane sp = new JScrollPane (allStocksTable);
        
        
        
        sp.setBounds(0,3*HEIGHT/20,WIDTH,HEIGHT-(3*HEIGHT/20));
        
        sp.getViewport().setBackground(niceGreenColor);
        
        frame.add(sp);
        frame.setVisible(true);
        
    }
    
    /**
     * More screen which displays the instructions and tells 
     * the user the current event and how many days are remaining on it
     * 
     * @param none
     * @return none
     */
    public void moreScreen(){
        //CLEAR/REMOVE action listeners
        for (JButton button : allButtons){
            for (ActionListener al : button.getActionListeners()){
                button.removeActionListener(al);
            }
        }
        
        //CLEAR SCREEN
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
        
        Color yellowLight = new Color(255,252,201);

        int titleWidth = 200;
        int label1Width = 100;
        
        //HOME BUTTON
        int buttonWidth = 30;
        homeButton.setBounds(WIDTH/10 - buttonWidth/2,HEIGHT/30,30,30);
        homeButton.setContentAreaFilled(false);
        homeButton.setBorderPainted(false);
        homeButton.setOpaque(false);
        frame.add(homeButton);
        
        
        
        //TITLE - Open Positions
        t1Label.setBounds((WIDTH/2)-50,HEIGHT/30,150,30);
        t1Label.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,20));
        t1Label.setForeground(Color.BLACK);
        frame.add(t1Label);
        
        //Add Text Area to Explain how to play
        String tutorial = "INSTRUCTIONS: 1 - Find stock symbols in view all stocks \n 2 - Make transactions with the symbols (Buy/Sell) \n 3 - Click next day to see how your stocks have increased / decreased in value \n 4 - Sell stocks to make a profit";
        //Purchase the stocks you would like by using their symbols \n 2. Click next day to see how stocks increase or decrease 3. Sell stocks to make a profit";
        tutorialArea.setText(tutorial);
        tutorialArea.setEditable(false);
        tutorialArea.setLineWrap(true);
        tutorialArea.setWrapStyleWord(true);
        tutorialArea.setBounds((WIDTH/2)+10,5*HEIGHT/30,(WIDTH/2)-20,HEIGHT-20);
        tutorialArea.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,15));
        frame.add(tutorialArea);
        
        //Add Text Area - Display current event
        String eventDisplay = this.stockMarket.getCurrentEvent();
        //Purchase the stocks you would like by using their symbols \n 2. Click next day to see how stocks increase or decrease 3. Sell stocks to make a profit";
        eventArea.setText(eventDisplay);
        eventArea.setEditable(false);
        eventArea.setLineWrap(true);
        eventArea.setWrapStyleWord(true);
        eventArea.setBounds(10,5*HEIGHT/30,(WIDTH/2)-20,HEIGHT-20);
        eventArea.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,15));
        frame.add(eventArea);
        frame.getContentPane().setBackground(yellowLight);

    }
    
}
