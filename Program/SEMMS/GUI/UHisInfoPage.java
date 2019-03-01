package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class set up the page for user to check their history information.
 * Wrote and modified by Yang Ding.
 * @author Yang Ding
 * @version 3.0
 */
public class UHisInfoPage {

    //basic object that is needed for creating the page
    private JPanel uHisInfo = new JPanel();
    private JTextField sDateText = new JTextField(15);
    private JTextField eDateText = new JTextField(15);
    private JButton hisInfoCheckB = new JButton("Check");
    private JScrollPane hisInfoSP = new JScrollPane();
    private String title[] = {"Date", "Electricity Consumption(kwh)", "Electricity Cost(¡ê)","Gas Consumption(m^3)", "Gas Cost(¡ê)"};
    private JTable hisInfoTable = new JTable();

    /**
     * constructor
     */
    public UHisInfoPage(){
        setUHisInfoPage();
    }

    /**
     * getter for hisInfoCheckB
     * @return hisInfoCheckB
     */
    public JButton getHisInfoCheckB() {
        return hisInfoCheckB;
    }

    /**
     * getter for uHisInfo
     * @return uHisInfo
     */
    public JPanel getuHisInfo() {
        return uHisInfo;
    }

    /**
     * getter for eDateText
     * @return eDateText
     */
    public JTextField geteDateText() {
        return eDateText;
    }

    /**
     * getter for hisInfoSP
     * @return hisInfoSP
     */
    public JScrollPane getHisInfoSP() {
        return hisInfoSP;
    }

    /**
     * getter for sDateText
     * @return sDateText
     */
    public JTextField getsDateText() {
        return sDateText;
    }

    /**
     * getter for title
     * @return title
     */
    public String[] getTitle() {
        return title;
    }

    /**
     * getter for hisInfoTable
     * @return hisInfoTable
     */
    public JTable getHisInfoTable() {
        return hisInfoTable;
    }

    /**
     * setter for JScrollPane of history information
     * @param hisInfoSP JScrollPane of history information
     */
    public void setHisInfoSP(JScrollPane hisInfoSP) {
        this.hisInfoSP = hisInfoSP;
    }

    /**
     * setter for JTable of history information
     * @param hisInfoTable JTable of history information
     */
    public void setHisInfoTable(JTable hisInfoTable) {
        this.hisInfoTable = hisInfoTable;
    }

    /**
     * set up the page
     */
    public void setUHisInfoPage(){
        //object that du not need a getter or setter
        JLabel text = new JLabel("History information");
        JLabel sDateT = new JLabel("          Start date:        ");
        JLabel eDateT = new JLabel("          Expiratoin date: ");
        JPanel headPanel = new JPanel(new GridLayout(4,0));
        JPanel selectSDate = new JPanel();
        JPanel selectEDate = new JPanel();
        JPanel checkPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        //setup the attributes of object and add to panel
        text.setFont(new Font("ControlSys",Font.PLAIN, 25));
        sDateT.setFont(new Font("ControlSys",Font.PLAIN, 20));
        eDateT.setFont(new Font("ControlSys",Font.PLAIN, 20));
        selectSDate.setLayout(new FlowLayout(FlowLayout.LEFT));
        selectSDate.add(sDateT);
        selectSDate.add(sDateText);
        selectEDate.setLayout(new FlowLayout(FlowLayout.LEFT));
        selectEDate.add(eDateT);
        selectEDate.add(eDateText);
        checkPanel.add(hisInfoCheckB);
        headPanel.add(text);
        headPanel.add(selectSDate);
        headPanel.add(selectEDate);
        headPanel.add(checkPanel);

        //add panel into page
        uHisInfo.setLayout(new BorderLayout());
        uHisInfo.add(BorderLayout.NORTH, headPanel);
        uHisInfo.add(BorderLayout.CENTER,hisInfoSP);

    }
}
