package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class set up the page for provider to change the tariff.
 * Wrote and modified by Yang Ding.
 * @author Yang Ding
 * @version 3.0
 */
public class EPSetTariffPage {
    private JPanel epSetTariff = new JPanel();
    private JButton setTariffB = new JButton("OK");
    private JTextField newTText1 = new JTextField(7);
    private JTextField newTText2 = new JTextField(7);
    private JLabel cTariff = new JLabel("");
    private JLabel infoText = new JLabel("Enter new tariff if you want to change any of current tariff, and then click 'OK'");
    private JLabel setETDone = new JLabel("Electricity tariff changed!");
    private JLabel setGTDone = new JLabel("Gas tariff changed!");


    /**
     * constructor
     */
    public EPSetTariffPage(){
        setEPSetTariffPage();
    }

    /**
     * getter for SetTariffB
     * @return SetTariffB
     */
    public JButton getSetTariffB() {
        return setTariffB;
    }

    /**
     * getter for epSetTariff
     * @return epSetTariff
     */
    public JPanel getepSetTariff() {
        return epSetTariff;
    }

    /**
     * getter for cTariff
     * @return cTariff
     */
    public JLabel getcTariff() {
        return cTariff;
    }

    /**
     * getter for SetETDone
     * @return SetETDone
     */
    public JLabel getSetETDone() {
        return setETDone;
    }

    /**
     * getter for SetGTDone
     * @return SetGTDone
     */
    public JLabel getSetGTDone() {
        return setGTDone;
    }

    /**
     * getter for NewTText1
     * @return NewTText1
     */
    public JTextField getNewTText1() {
        return newTText1;
    }

    /**
     * getter for NewTText2
     * @return NewTText2
     */
    public JTextField getNewTText2() {
        return newTText2;
    }

    /**
     * set up the page
     */
    public void setEPSetTariffPage (){
        JLabel text = new JLabel("Set Tariff");
        JLabel tariffHead = new JLabel("                                        electricity                gas                ");
        JLabel nTariff = new JLabel("        New tariff:            ¡ê");
        JLabel nTariff0 = new JLabel("             ¡ê");
        JPanel pCT = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pNT = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel infoTPanel = new JPanel();
        JPanel setETFeedback = new JPanel();
        JPanel setGTFeedback = new JPanel();

        text.setFont(new Font("ControlSys",Font.PLAIN, 25));
        tariffHead.setFont(new Font("ControlSys",Font.PLAIN, 20));
        cTariff.setFont(new Font("ControlSys",Font.PLAIN, 20));
        nTariff.setFont(new Font("ControlSys",Font.PLAIN, 20));
        nTariff0.setFont(new Font("ControlSys",Font.PLAIN, 20));
        pCT.add(cTariff);
        pNT.add(nTariff);
        pNT.add(newTText1);
        pNT.add(nTariff0);
        pNT.add(newTText2);
        pNT.add(setTariffB);
        infoTPanel.add(infoText);
        setETDone.setForeground(Color.RED);
        setETDone.setVisible(false);;
        setETFeedback.add(setETDone);
        setGTDone.setForeground(Color.RED);
        setGTDone.setVisible(false);
        setGTFeedback.add(setGTDone);

        epSetTariff.setLayout(new GridLayout(7,0));
        epSetTariff.add(new JPanel().add(text));
        epSetTariff.add(new JPanel().add(tariffHead));
        epSetTariff.add(pCT);
        epSetTariff.add(pNT);
        epSetTariff.add(infoTPanel);
        epSetTariff.add(setETFeedback);
        epSetTariff.add(setGTFeedback);

    }
}
