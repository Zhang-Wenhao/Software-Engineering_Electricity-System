package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class set up the page for provider to check the information of users.
 * Wrote and modified by Yang Ding.
 * @author Yang Ding
 * @version 3.0
 */
public class EPInfoManagPage {
    private JPanel epInfoManag = new JPanel();
    private JTextField nameText = new JTextField(10);
    private JButton checkUB = new JButton("OK");

    /**
     * constructor
     */
    public EPInfoManagPage(){
        setEPInfoManagPage();
    }

    /**
     * getter for NameText
     * @return NameText
     */
    public JTextField getNameText() {
        return nameText;
    }

    /**
     * getter for CheckUB
     * @return CheckUB
     */
    public JButton getCheckUB() {
        return checkUB;
    }

    /**
     * getter for EpInfoManag
     * @return EpInfoManag
     */
    public JPanel getEpInfoManag() {
        return epInfoManag;
    }

    /**
     * set up the page
     */
    public void setEPInfoManagPage(){
        JLabel text = new JLabel("Information Management");
        JLabel selectUser = new JLabel("        Please enter the user you want to check:");
        JLabel userName = new JLabel("        User Name: ");
        JPanel head = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        text.setFont(new Font("ControlSys",Font.PLAIN, 25));
        head.setLayout(new FlowLayout(FlowLayout.LEFT));
        head.add(text);
        selectUser.setFont(new Font("ControlSys",Font.PLAIN, 20));
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        p1.add(selectUser);
        userName.setFont(new Font("ControlSys",Font.PLAIN, 20));
        nameText.setFont(new Font("ControlSys",Font.PLAIN, 20));
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p2.add(userName);
        p2.add(nameText);
        p3.setLayout(new FlowLayout(FlowLayout.CENTER));
        p3.add(checkUB);

        epInfoManag.setLayout(new GridLayout(5,0));
        epInfoManag.add(head);
        epInfoManag.add(p1);
        epInfoManag.add(p2);
        epInfoManag.add(p3);
    }
}
