package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class set up the page for provider to select the option they want.
 * Wrote and modified by Yang Ding.
 * @author Yang Ding
 * @version 3.0
 */
public class EPFunctionPage {

    private JPanel epFunction = new JPanel();
    private JButton umB = new JButton("User Managent");
    private JButton imB = new JButton("Information Checking");
    private JButton ctB = new JButton("Change Tariff");

    /**
     * constructor
     */
    public EPFunctionPage(){
        setEPFunctionPage();
    }

    /**
     * getter for getCtB
     * @return getCtB
     */
    public JButton getCtB() {
        return ctB;
    }

    /**
     * getter for ImB
     * @return ImB
     */
    public JButton getImB() {
        return imB;
    }

    /**
     * getter for UmB
     * @return UmB
     */
    public JButton getUmB() {
        return umB;
    }

    /**
     * getter for EpFunction
     * @return EpFunction
     */
    public JPanel getEpFunction() {
        return epFunction;
    }

    /**
     * set up the page
     */
    public void setEPFunctionPage(){
        JLabel text = new JLabel("Please choose the function you want:",JLabel.LEFT);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        text.setFont(new Font("ControlSys",Font.PLAIN, 25));

        epFunction.setLayout(new GridLayout(4,0));
        umB.setPreferredSize(new Dimension(200,60));
        imB.setPreferredSize(new Dimension(200,60));
        ctB.setPreferredSize(new Dimension(200,60));

        p1.add(umB);
        p2.add(imB);
        p3.add(ctB);


        epFunction.add(new JPanel().add(text));
        epFunction.add(p1);
        epFunction.add(p2);
        epFunction.add(p3);
    }
}
