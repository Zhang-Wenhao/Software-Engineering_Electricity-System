package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class set up the warning dialog in GUI.
 * Jindou Wei wrote the file(v1.0) and Yang Ding modified it(v1.5 - v3.0).
 * @author Jindou Wei
 * @author Yang Ding
 * @version 3.0
 */
public class WarningDialog {

    //basic object that is needed for creating the window
    private JLabel title = new JLabel("Warning");
    private JLabel text = new JLabel("",JLabel.CENTER);
    private  JButton  buttonA = new JButton();
    private JButton buttonB = new JButton();
    private JDialog warningDia = null;

    /**
     * constructor for building warning with two button
     * @param frame main frame
     * @param text text to show
     * @param buttonTA button A
     * @param buttonTB button B
     */
    public WarningDialog(JFrame frame, String text, String buttonTA, String buttonTB){
        JPanel panel = new JPanel();

        setText(text);
        setButtonA(buttonTA);
        setButtonB(buttonTB);
        panel.add(buttonA);
        panel.add(buttonB);
        warningDia = new JDialog(frame,true);
        warningDia.setLayout(new GridLayout(2,0));
        warningDia.setSize(new Dimension(350,100));
        warningDia.add(this.text);
        warningDia.add(panel);
        warningDia.setLocationRelativeTo(frame);

    }

    /**
     * constructor for building warning with one button
     * @param frame main frame
     * @param text text to show
     * @param buttonTA button
     */
    public WarningDialog(JFrame frame, String text, String buttonTA){
        JPanel panel = new JPanel();

        setText(text);
        setButtonA(buttonTA);
        panel.add(buttonA);
        warningDia = new JDialog(frame,true);
        warningDia.setLayout(new GridLayout(2,0));
        warningDia.setSize(new Dimension(500,150));
        warningDia.add(this.text);
        warningDia.add(panel);
        warningDia.setLocationRelativeTo(frame);
    }

    /**
     * setter for text
     * @param text text to show
     */
    public void setText(String text) {
        this.text.setText(text);
        this.text.setForeground(Color.RED);
    }

    /**
     * setter fr button A
     * @param buttonTA button A
     */
    public void setButtonA(String buttonTA) {
        buttonA.setText(buttonTA);
    }

    /**
     * setter fr button b
     * @param buttonTB button b
     */
    public void setButtonB(String buttonTB) {
        buttonB.setText(buttonTB);
    }

    /**
     * getter for buttonA
     * @return buttonA
     */
    public JButton getButtonA() {
        return buttonA;
    }

    /**
     * getter for buttonB
     * @return buttonB
     */
    public JButton getButtonB() {
        return buttonB;
    }

    /**
     * getter for warningDia
     * @return warningDia
     */
    public JDialog getWarningDia() {
        return warningDia;
    }
}
