package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class set up the for user to manage user(add/remove).
 * Wrote and modified by Yang Ding.
 * @author Yang Ding
 * @version 3.0
 */
public class EPUserManagPage {

    //basic object that is needed for creating the page
    private JPanel epUserManag = new JPanel();
    private JButton auB = new JButton("Add User");
    private JButton ruB = new JButton("Remove User");

    /**
     * constructor
     */
    public EPUserManagPage(){
        setEPUserManagPage();
    }

    /**
     * getter for auB
     * @return auB
     */
    public JButton getAuB() {
        return auB;
    }

    /**
     * getter for ruB
     * @return ruB
     */
    public JButton getRuB() {
        return ruB;
    }

    /**
     * getter for epUserManag
     * @return epUserManag
     */
    public JPanel getEpUserManag() {
        return epUserManag;
    }

    /**
     * set up the page
     */
    private void setEPUserManagPage(){
        //object that du not need a getter or setter
        JLabel text = new JLabel("User Management",JLabel.LEFT);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        //setup the attributes of object and add to panel
        text.setFont(new Font("ControlSys",Font.PLAIN, 25));
        epUserManag.setLayout(new GridLayout(3,0));
        auB.setPreferredSize(new Dimension(200,60));
        ruB.setPreferredSize(new Dimension(200,60));
        p1.add(auB);
        p2.add(ruB);

        //add panel into page
        epUserManag.add(new JPanel().add(text));
        epUserManag.add(p1);
        epUserManag.add(p2);
    }
}
