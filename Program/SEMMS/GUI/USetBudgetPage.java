package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class set up the page for user to set their budget.
 * Wrote and modified by Yang Ding.
 * @author Yang Ding
 * @version 3.0
 */
public class USetBudgetPage {

    //basic object that is needed for creating the page
    private JPanel uSetBudget = new JPanel();
    private JButton setBudgB = new JButton("OK");
    private JButton setBudgBinC = new JButton("OK");
    private JTextField newBText1 = new JTextField(7);
    private JTextField newBText2 = new JTextField(7);
    private JLabel cBudget = new JLabel("");
    private JTextField newBText1inC = new JTextField(7);
    private JTextField newBText2inC = new JTextField(7);
    private JLabel infoText = new JLabel("Enter new budget in right line (pounds or kwh/m^3) if you want to change any of your current budget, and then click 'OK'");
    private JLabel setEBDone = new JLabel("Electricity budget changed!");
    private JLabel setGBDone = new JLabel("Gas budget changed!");

    /**
     * constructor
     */
    public USetBudgetPage(){
        setUSetBudgetPage();
    }

    /**
     * getter for setBudgB
     * @return setBudgB
     */
    public JButton getSetBudgB() {
        return setBudgB;
    }

    /**
     * getter for uSetBudget
     * @return uSetBudget
     */
    public JPanel getuSetBudget() {
        return uSetBudget;
    }

    /**
     * getter for cBudget
     * @return cBudget
     */
    public JLabel getcBudget() {
        return cBudget;
    }

    /**
     * getter for setEBDone
     * @return setEBDone
     */
    public JLabel getSetEBDone() {
        return setEBDone;
    }

    /**
     * getter for setGBDone
     * @return setGBDone
     */
    public JLabel getSetGBDone() {
        return setGBDone;
    }

    /**
     *  getter for newBText1
     * @return newBText1
     */
    public JTextField getNewBText1() {
        return newBText1;
    }

    /**
     * getter for newBText2
     * @return newBText2
     */
    public JTextField getNewBText2() {
        return newBText2;
    }

    /**
     * getter for newBText1inC
     * @return newBText1inC
     */
    public JTextField getNewBText1inC() {
        return newBText1inC;
    }

    /**
     * getter for newBText2inC
     * @return newBText2inC
     */
    public JTextField getNewBText2inC() {
        return newBText2inC;
    }

    /**
     * getter for setBudgBinC
     * @return setBudgBinC
     */
    public JButton getSetBudgBinC() {
        return setBudgBinC;
    }

    /**
     * set up the page
     */
    public void setUSetBudgetPage (){
        //object that du not need a getter or setter
        JLabel text = new JLabel("Set budget");
        JLabel budgetHead = new JLabel("                                                           electricity                gas                ");
        JLabel nBudget = new JLabel("        New budget(in cost):              ¡ê");
        JLabel nBudget0 = new JLabel("              ¡ê");
        JLabel nBudgetinC = new JLabel("        New budget(in usage):             ");
        JLabel nBudget0inC = new JLabel("kwh         ");
        JLabel nBudget1inC = new JLabel("m^3");
        JPanel pCB = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pNB = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pNBinC = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel infoTPanel = new JPanel();
        JPanel setEBFeedback = new JPanel();
        JPanel setGBFeedback = new JPanel();

        //setup the attributes of object and add to panel
        text.setFont(new Font("ControlSys",Font.PLAIN, 25));
        budgetHead.setFont(new Font("ControlSys",Font.PLAIN, 20));
        cBudget.setFont(new Font("ControlSys",Font.PLAIN, 20));
        nBudget.setFont(new Font("ControlSys",Font.PLAIN, 20));
        nBudget0.setFont(new Font("ControlSys",Font.PLAIN, 20));
        nBudgetinC.setFont(new Font("ControlSys",Font.PLAIN, 20));
        nBudget0inC.setFont(new Font("ControlSys",Font.PLAIN, 20));
        nBudget1inC.setFont(new Font("ControlSys",Font.PLAIN, 20));
        pCB.add(cBudget);
        pNB.add(nBudget);
        pNB.add(newBText1);
        pNB.add(nBudget0);
        pNB.add(newBText2);
        pNB.add(setBudgB);
        pNBinC.add(nBudgetinC);
        pNBinC.add(newBText1inC);
        pNBinC.add(nBudget0inC);
        pNBinC.add(newBText2inC);
        pNBinC.add(nBudget1inC);
        pNBinC.add(setBudgBinC);
        infoTPanel.add(infoText);
        setEBDone.setForeground(Color.RED);
        setEBDone.setVisible(false);;
        setEBFeedback.add(setEBDone);
        setGBDone.setForeground(Color.RED);
        setGBDone.setVisible(false);
        setGBFeedback.add(setGBDone);

        //add panel into page
        uSetBudget.setLayout(new GridLayout(8,0));
        uSetBudget.add(new JPanel().add(text));
        uSetBudget.add(new JPanel().add(budgetHead));
        uSetBudget.add(pCB);
        uSetBudget.add(pNB);
        uSetBudget.add(pNBinC);
        uSetBudget.add(infoTPanel);
        uSetBudget.add(setEBFeedback);
        uSetBudget.add(setGBFeedback);

    }

}
