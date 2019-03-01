package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class set up the page for user to check their bill history.
 * Wrote and modified by Yang Ding.
 * @author Yang Ding
 * @version 3.0
 */
public class UHisBillPage {

    //basic object that is needed for creating the page
    private JPanel uHisBill = new JPanel();
    private JTable hisBillTable = new JTable();
    private JScrollPane hisBillSP = new JScrollPane();
    private String title[] = {"Charge Date", "Electricity Consumption(kwh)", "Electricity Cost(¡ê)","Gas Consumption(m^3)", "Gas Cost(¡ê)"};

    /**
     * constructor
     */
    public UHisBillPage(){
        setUHisBillPage();
    }

    /**
     * getter for uHisBill
     * @return uHisBill
     */
    public JPanel getuHisBill() {
        return uHisBill;
    }

    /**
     * getter for hisBillSP
     * @return hisBillSP
     */
    public JScrollPane getHisBillSP() {
        return hisBillSP;
    }

    /**
     * getter for hisBillTable
     * @return hisBillTable
     */
    public JTable getHisBillTable() {
        return hisBillTable;
    }

    /**
     * getter for title
     * @return title
     */
    public String[] getTitle() {
        return title;
    }

    /**
     * setter for hisBillSP
     * @param hisBillSP JScrollPane for history billl
     */
    public void setHisBillSP(JScrollPane hisBillSP) {
        this.hisBillSP = hisBillSP;
    }

    /**
     * setter for hisBillTable
     * @param hisBillTable JTable for history bill
     */
    public void setHisBillTable(JTable hisBillTable) {
        this.hisBillTable = hisBillTable;
    }

    /**
     * set up the page
     */
    public void setUHisBillPage(){
        //object that du not need a getter or setter
        JLabel text = new JLabel("History Bill");
        JPanel headPanel = new JPanel();

        //setup the attributes of object and add to panel
        text.setFont(new Font("ControlSys",Font.PLAIN, 25));
        headPanel.add(text);

        //add panel into page
        uHisBill.setLayout(new BorderLayout());
        uHisBill.add(BorderLayout.NORTH, headPanel);
        uHisBill.add(BorderLayout.CENTER,hisBillSP);
    }

}
