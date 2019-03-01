package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class set up the login page for GUI.
 * Wrote and modified by Yang Ding.
 * @author Yang Ding
 * @version 3.0
 */
public class LogPage {

    //basic object that is needed for creating the page
    private JPanel login = new JPanel();
    private JTextField nameText = new JTextField(10);
    private JPasswordField pswText = new JPasswordField(20);
    private JButton loginB = new JButton("Login");
    private JButton clearB = new JButton("clear");

    /**
     * constructor
     */
    public LogPage(){
        setLogPage();
    }

    /**
     * getter for clearB
     * @return clearB
     */
    public JButton getClearB() {
        return clearB;
    }

    /**
     * getter for loginB
     * @return loginB
     */
    public JButton getLoginB() {
        return loginB;
    }

    /**
     * getter for login
     * @return login
     */
    public JPanel getLogin() {
        return login;
    }

    /**
     * getter for pswText
     * @return pswText
     */
    public JPasswordField getPswText() {
        return pswText;
    }

    /**
     * getter for nameText
     * @return nameText
     */
    public JTextField getNameText() {
        return nameText;
    }

    /**
     * set up the page
     */
    public void setLogPage(){
        //object that du not need a getter or setter
        JPanel head = new JPanel();
        JPanel infPanel1 = new JPanel();
        JPanel infPanel2 = new JPanel();
        JPanel bPanel = new JPanel();
        JPanel backPanel = new JPanel();
        JLabel text = new JLabel("Login");
        JLabel name = new JLabel("        User Name:");
        JLabel password = new JLabel("        Password:");

        //setup the attributes of object and add to panel
        text.setFont(new Font("ControlSys",Font.PLAIN, 25));
        head.setLayout(new FlowLayout(FlowLayout.LEFT));
        head.add(text);
        infPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        name.setFont(new Font("ControlSys",Font.PLAIN, 20));
        nameText.setFont(new Font("ControlSys",Font.PLAIN, 20));
        infPanel1.add(name);
        infPanel1.add(nameText);
        infPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
        password.setFont(new Font("ControlSys",Font.PLAIN, 20));
        pswText.setFont(new Font("ControlSys",Font.PLAIN, 20));
        infPanel2.add(password);
        infPanel2.add(pswText);
        infPanel2.add(clearB);
        bPanel.add(loginB);
        bPanel.add(new JLabel("                 "));
        backPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        //add panel into page
        login.setLayout(new GridLayout(6,0));
        login.add(head);
        login.add(infPanel1);
        login.add(infPanel2);
        login.add(bPanel);
    }

}
