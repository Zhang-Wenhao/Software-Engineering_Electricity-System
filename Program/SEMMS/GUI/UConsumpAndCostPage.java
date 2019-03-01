package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class set up the page for user to check their consumption and cost.
 * Wrote and modified by Yang Ding.
 * @author Yang Ding
 * @version 3.0
 */
public class UConsumpAndCostPage {

    //basic object that is needed for creating the page
    private JPanel uConsumpAndCost = new JPanel();
    private JLabel dEConsumpAndCost = new JLabel("");
    private JLabel dGConsumpAndCost  = new JLabel("");
    private JLabel tEConsumpAndCost = new JLabel("");
    private JLabel tGConsumpAndCost  = new JLabel("");

    /**
     * contructor
     */
    public UConsumpAndCostPage(){
        setUConsumpAndCostPage();
    }

    /**
     * getter for uConsumpAndCost
     * @return uConsumpAndCost
     */
    public JPanel getuConsumpAndCost() {
        return uConsumpAndCost;
    }

    /**
     * getter for dEConsumpAndCost
     * @return dEConsumpAndCost
     */
    public JLabel getdEConsumpAndCost() {
        return dEConsumpAndCost;
    }

    /**
     * getter for dGConsumpAndCost
     * @return dGConsumpAndCost
     */
    public JLabel getdGConsumpAndCost() {
        return dGConsumpAndCost;
    }

    /**
     * getter for tEConsumpAndCost
     * @return tEConsumpAndCost
     */
    public JLabel gettEConsumpAndCost() {
        return tEConsumpAndCost;
    }

    /**
     * getter for tGConsumpAndCost
     * @return tGConsumpAndCost
     */
    public JLabel gettGConsumpAndCost() {
        return tGConsumpAndCost;
    }

    /**
     * set up the page
     */
    public void setUConsumpAndCostPage(){
        //object that du not need a getter or setter
        JLabel text = new JLabel("Consumption and cost");
        JLabel dHead = new JLabel("      Today                                   consumption         cost                ");
        JLabel tHead = new JLabel("      Since last charge                 consumption         cost                ");

        //setup the attributes of object and add to panel
        text.setFont(new Font("ControlSys",Font.PLAIN, 25));
        dHead.setFont(new Font("ControlSys",Font.PLAIN, 20));
        dEConsumpAndCost.setFont(new Font("ControlSys",Font.PLAIN, 20));
        dGConsumpAndCost.setFont(new Font("ControlSys",Font.PLAIN, 20));
        tHead.setFont(new Font("ControlSys",Font.PLAIN, 20));
        tEConsumpAndCost.setFont(new Font("ControlSys",Font.PLAIN, 20));
        tGConsumpAndCost.setFont(new Font("ControlSys",Font.PLAIN, 20));

        //add panel into page
        uConsumpAndCost.setLayout(new GridLayout(9,0));
        uConsumpAndCost.add(text);
        uConsumpAndCost.add(dHead);
        uConsumpAndCost.add(dEConsumpAndCost);
        uConsumpAndCost.add(dGConsumpAndCost);
        uConsumpAndCost.add(new JPanel());
        uConsumpAndCost.add(tHead);
        uConsumpAndCost.add(tEConsumpAndCost);
        uConsumpAndCost.add(tGConsumpAndCost);
    }
}
