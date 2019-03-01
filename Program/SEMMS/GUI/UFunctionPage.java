package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class set up the page for user to select option they want.
 * Wrote and modified by Yang Ding.
 * @author Yang Ding
 * @version 3.0
 */
public class UFunctionPage {

    //basic object that is needed for creating the page
    private JPanel uFunction = new JPanel();
    private JButton cacB = new JButton("Consumption and Cost");
    private JButton sbB = new JButton("Set Your Budget");
    private JButton hiB = new JButton("History Information");
    private JButton hbB = new JButton("History Bill");
    private JButton ctB = new JButton("Check Tariff");

    /**
     * constructor
     */
    public UFunctionPage(){
        setUFunctionPage();
    }

    /**
     * getter for uFunction
     * @return uFunction
     */
    public JPanel getuFunction() {
        return uFunction;
    }

    /**
     * getter for cacB
     * @return cacB
     */
    public JButton getCacB() {
        return cacB;
    }

    /**
     * getter for sbB
     * @return sbB
     */
    public JButton getSbB() {
        return sbB;
    }

    /**
     * getter for hiB
     * @return hiB
     */
    public JButton getHiB() {
        return hiB;
    }

    /**
     * getter for hbB
     * @return hbB
     */
    public JButton getHbB() {
        return hbB;
    }

    /**
     * getter for ctB
     * @return ctB
     */
    public JButton getCtB() {
        return ctB;
    }

    /**
     * set up the page
     */
    public void setUFunctionPage(){
        //object that du not need a getter or setter
        JLabel text = new JLabel("Please choose the function you want:",JLabel.LEFT);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();

        //setup the attributes of object and add to panel
        text.setFont(new Font("ControlSys",Font.PLAIN, 25));
        uFunction.setLayout(new GridLayout(6,0));
        cacB.setPreferredSize(new Dimension(200,60));
        sbB.setPreferredSize(new Dimension(200,60));
        hiB.setPreferredSize(new Dimension(200,60));
        hbB.setPreferredSize(new Dimension(200,60));
        ctB.setPreferredSize(new Dimension(200,60));
        p1.add(cacB);
        p2.add(sbB);
        p3.add(hiB);
        p4.add(hbB);
        p5.add(ctB);

        //add panel into page
        uFunction.add(new JPanel().add(text));
        uFunction.add(p1);
        uFunction.add(p2);
        uFunction.add(p3);
        uFunction.add(p4);
        uFunction.add(p5);
    }
}
