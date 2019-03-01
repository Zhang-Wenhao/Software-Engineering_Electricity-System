package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class set up the page for User to check tariff.
 * Keke Wang wrote the file(v1.0) and Yang Ding modified it(v1.0 - v3.0).
 * @author Keke Wang
 * @author Yang Ding
 * @version 3.0
 */
public class UCheckTariffPage {

    //basic object that is needed for creating the page
    private JPanel uCheckTariff = new JPanel();
    private JLabel tariffToStringE = new JLabel("");
    private JLabel tariffToStringG = new JLabel("");

    /**
     * constructor
     */
    public UCheckTariffPage(){
        setUCheckTariffPage();
    }

    /**
     * getter for tariffToStringE
     * @return tariffToStringE
     */
    public JLabel getTariffToStringE() {
        return tariffToStringE;
    }

    /**
     *getter for tariffToStringG
     * @return tariffToStringG
     */
    public JLabel getTariffToStringG() {
        return tariffToStringG;
    }

    /**
     * getter for uCheckTariff
     * @return uCheckTariff
     */
    public JPanel getuCheckTariff() {
        return uCheckTariff;
    }

    /**
     * set up the page
     */
    public void setUCheckTariffPage(){
        //object that du not need a getter or setter
        JLabel text = new JLabel("Check tariff");

        //setup the attributes of object and add to panel
        text.setFont(new Font("ControlSys",Font.PLAIN, 25));
        tariffToStringE.setFont(new Font("ControlSys",Font.PLAIN, 20));
        tariffToStringG.setFont(new Font("ControlSys",Font.PLAIN, 20));

        //add panel into page
        uCheckTariff.setLayout(new GridLayout(5,0));
        uCheckTariff.add(new JPanel().add(text));
        uCheckTariff.add(tariffToStringE);
        uCheckTariff.add(tariffToStringG);
    }
}
