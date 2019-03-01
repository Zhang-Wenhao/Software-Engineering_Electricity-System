package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class set up the home page of GUI.
 * Wrote and modified by Yang Ding.
 * @author Yang Ding
 * @version 3.0
 */
public class HomePage {

    //basic object that is needed for creating the page
    private JPanel home = new JPanel();
    private JButton userLogB = new JButton("USER LOGIN");
    private JButton epLogB = new JButton("PROVIDER LOGIN");

    /**
     * constructor
     */
    public HomePage(){
        setHomePage();
    }

    /**
     * getter for home
     * @return home
     */
    public JPanel getHome() {
        return home;
    }

    /**
     * getter for epLogB
     * @return epLogB
     */
    public JButton getEpLogB() {
        return epLogB;
    }

    /**
     * getter for userLogB
     * @return userLogB
     */
    public JButton getUserLogB() {
        return userLogB;
    }

    /**
     * set up the page
     */
    public void setHomePage(){
        //object that du not need a getter or setter
        JPanel welcome = new JPanel();
        JPanel logButton = new JPanel();
        JPanel uLogButton = new JPanel();
        JPanel epLogButton = new JPanel();
        JLabel text1 = new JLabel("Smart Energy", JLabel.CENTER);
        JLabel text2 = new JLabel("Management And Monitoring", JLabel.CENTER);
        JLabel text3 = new JLabel("ControlSys", JLabel.CENTER);

        //setup the attributes of object and add to panel
        text1.setFont(new Font("ControlSys",Font.PLAIN, 50));
        text2.setFont(new Font("ControlSys",Font.PLAIN, 50));
        text3.setFont(new Font("ControlSys",Font.PLAIN, 50));
        userLogB.setPreferredSize(new Dimension(220,70));
        epLogB.setPreferredSize(new Dimension(220,70));
        welcome.setLayout(new GridLayout(3,0));
        welcome.add(text1);
        welcome.add(text2);
        welcome.add(text3);
        uLogButton.add(userLogB);
        epLogButton.add(epLogB);
        logButton.setLayout(new GridLayout(3,0));
        logButton.add(uLogButton);
        logButton.add(epLogButton);

        //add panel into page
        home.setLayout(new BorderLayout());
        home.add(BorderLayout.CENTER, welcome);
        home.add(BorderLayout.SOUTH, logButton);
    }

}
