package Szerviz;

import java.awt.BorderLayout;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class SzervizMain {
    JTabbedPane tab;
    
    public static void main(String[] args) throws SQLException{        
        SzervizMain szMain = new SzervizMain();
    }
    
    public  SzervizMain() throws SQLException{
           
        JFrame frame = new JFrame("Munkalap karbantartó");
        tab = new JTabbedPane();
        //tab.setSize(800, 660);        
        frame.add(tab, BorderLayout.BEFORE_FIRST_LINE);
        
        tabUgyfel tbUgyfel = new tabUgyfel();
        tabDolgozo tbDolg = new tabDolgozo();
        tabMunkalap tbMunka = new tabMunkalap();
        
        
        tab.add("Munkalap karbantartó", tbMunka);
        tab.add("Ügyfél karbantartó",tbUgyfel);
        tab.add("Dolgozó karbantartó",tbDolg);
                
        frame.setSize(630, 660);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
}

