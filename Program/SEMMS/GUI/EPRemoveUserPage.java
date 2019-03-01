package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class set up the page for provider to remove user.
 * Wrote and modified by Yang Ding.
 * @author Yang Ding
 * @version 3.0
 */
public class EPRemoveUserPage {
    private JPanel epRemoveUser = new JPanel();
    private JTextField nameText = new JTextField(10);
    private JButton removeUB = new JButton("remove");

    /**
     * constructor
     */
    public EPRemoveUserPage(){
        setEPRemoveUserPage();
    }

    /**
     * getter for getNameText
     * @return getNameText
     */
    public JTextField getNameText() {
        return nameText;
    }

    /**
     * getter for getRemoveUB
     * @return getRemoveUB
     */
    public JButton getRemoveUB() {
        return removeUB;
    }

    /**
     * getter for getEpRemoveUser
     * @return getEpRemoveUser
     */
    public JPanel getEpRemoveUser() {
        return epRemoveUser;
    }

    /**
     * set up the page
     */
    public void setEPRemoveUserPage(){
        JPanel head = new JPanel();
        JPanel infPanel1 = new JPanel();
        JPanel bPanel = new JPanel();
        JLabel text = new JLabel("Remove User");
        JLabel name = new JLabel("        User Name:");

        text.setFont(new Font("ControlSys",Font.PLAIN, 25));
        head.setLayout(new FlowLayout(FlowLayout.LEFT));
        head.add(text);
        infPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        name.setFont(new Font("ControlSys",Font.PLAIN, 20));
        nameText.setFont(new Font("ControlSys",Font.PLAIN, 20));
        infPanel1.add(name);
        infPanel1.add(nameText);
        bPanel.add(removeUB);
        bPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        epRemoveUser.setLayout(new GridLayout(6,0));
        epRemoveUser.add(head);
        epRemoveUser.add(infPanel1);
        epRemoveUser.add(bPanel);
    }
}
