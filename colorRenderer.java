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
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;

public class colorRenderer extends DefaultTableCellRenderer {
    
    /**
     * Overides regular method for table, 
     * used so cells in profit column can be red/green depending on 
     * if they are + or -
     * 
     * @param JTable components:
     * JTable of open positions
     * Object value
     * boolean is selected
     * boolean has focus
     * int row
     * int column
     * @return
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
        
        Component c = super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
        
        if (!isSelected){
            try{
                String valueStr = value.toString();
                double checkNum = Double.parseDouble(valueStr);
                if(checkNum>0){
                    c.setBackground(Color.GREEN);
                }else if(checkNum<0){
                    c.setBackground(Color.RED);
                } else{
                    c.setBackground(Color.gray);
                    //c.setBackground(table.getBackground());
                }
                
            } catch (Exception e){
                
                c.setBackground(Color.gray);
                //c.setBackground(table.getBackground());
            }
        }
        return c;
        
    }
}
