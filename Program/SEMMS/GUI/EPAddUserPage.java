package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class set up the page for provider to add user.
 * Wrote and modified by Yang Ding.
 * @author Yang Ding
 * @version 3.0
 */
public class EPAddUserPage {
    private JPanel epAddUser = new JPanel();
    private JTextField nameText = new JTextField(10);
    private JPasswordField pswText = new JPasswordField(20);
    private JPasswordField pswTextCheck = new JPasswordField(20);
    private JButton addUB = new JButton("OK");

    /**
     * constructor
     */
    public EPAddUserPage(){
        setEPAddUserPage();
    }

    /**
     * getter for name text
     * @return name text
     */
    public JTextField getNameText() {
        return nameText;
    }

    /**
     * getter for password text
     * @return password text
     */
    public JPasswordField getPswText() {
        return pswText;
    }

    /**
     * getter for add user button
     * @return AddUB
     */
    public JButton getAddUB() {
        return addUB;
    }

    /**
     * getter for this page
     * @return epAddUser
     */
    public JPanel getEpAddUser() {
        return epAddUser;
    }

    /**
     * getter for second password text
     * @return pswTextCheck
     */
    public JPasswordField getPswTextCheck() {
        return pswTextCheck;
    }

    /**
     * set the page
     */
    public void setEPAddUserPage(){
        JPanel head = new JPanel();
        JPanel infPanel1 = new JPanel();
        JPanel infPanel2 = new JPanel();
        JPanel infPanel3 = new JPanel();
        JPanel bPanel = new JPanel();
        JLabel text = new JLabel("Add User");
        JLabel name = new JLabel("        User Name:");
        JLabel password = new JLabel("        Password:");
        JLabel passwordCheck = new JLabel("        Password check:");

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
        infPanel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        passwordCheck.setFont(new Font("ControlSys",Font.PLAIN, 20));
        pswTextCheck.setFont(new Font("ControlSys",Font.PLAIN, 20));
        infPanel3.add(passwordCheck);
        infPanel3.add(pswTextCheck);
        bPanel.add(addUB);
        bPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        epAddUser.setLayout(new GridLayout(6,0));
        epAddUser.add(head);
        epAddUser.add(infPanel1);
        epAddUser.add(infPanel2);
        epAddUser.add(infPanel3);
        epAddUser.add(bPanel);
    }

}
