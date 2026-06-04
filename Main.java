/**
 * @author vivienne123
 */
 
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

public class Main {
    public static JFrame frame = new JFrame();
	
    /**
     * Stock Market App - User can invest in stocks then watch their stock increase
     * or decrease, then sell for a profit or a loss.
     *
     * @param args the command line arguments
     * @return void
     */
    public static void main(String[] args) {
        
        frame.setSize(400,300);
        
        Control appControl = new Control();
        
        appControl.setUp();
        //appControl.viewAllStocks();
        //appControl.viewOpenPositions1();
        //appControl.viewOpenPositions();
        //appControl.runPurchase();
        appControl.homeScreen();
        
    }
}
