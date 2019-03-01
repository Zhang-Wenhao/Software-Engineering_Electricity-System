package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class set up the page for provider to check the information of users.
 * Wrote and modified by Yang Ding.
 * @author Yang Ding
 * @version 3.0
 */
public class EPUserInfoPage {
    private JPanel epUserInfo = new JPanel();
    private String ID = "";
    private JLabel text = new JLabel("You are now checking information on User " + ID,JLabel.LEFT);
    private JButton cacB = new JButton("Consumption and Cost");
    private JButton hiB = new JButton("History Information");
    private JButton hbB = new JButton("History Bill");

    /**
     * constructor
     */
    public EPUserInfoPage(){
        setEPUserInfoPage();
    }

    /**
     * setter for ID
     * @param ID ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * getter for ID
     * @return ID
     */
    public String getID() {
        return ID;
    }

    /**
     * getter for text
     * @return text
     */
    public JLabel getText() {
        return text;
    }

    /**
     * getter for hbB
     * @return hbB
     */
    public JButton getHbB() {
        return hbB;
    }

    /**
     * getter for hiB
     * @return hiB
     */
    public JButton getHiB() {
        return hiB;
    }

    /**
     * getter for cacB
     * @return cacB
     */
    public JButton getCacB() {
        return cacB;
    }

    /**
     * getter for epUserInfo
     * @return epUserInfo
     */
    public JPanel getEpUserInfo() {
        return epUserInfo;
    }

    /**
     * set up the page
     */
    public void setEPUserInfoPage(){
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        text.setFont(new Font("ControlSys",Font.PLAIN, 25));

        epUserInfo.setLayout(new GridLayout(4,0));
        cacB.setPreferredSize(new Dimension(200,60));
        hiB.setPreferredSize(new Dimension(200,60));
        hbB.setPreferredSize(new Dimension(200,60));

        p1.add(cacB);
        p2.add(hiB);
        p3.add(hbB);


        epUserInfo.add(new JPanel().add(text));
        epUserInfo.add(p1);
        epUserInfo.add(p2);
        epUserInfo.add(p3);

    }
}
