package User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * This is the provider class.
 * Wrote and modified by Yang Ding.
 * @author Yang Ding
 * @version 3.0
 */
public class User {
    private String ID = "";                     //User's name
    private String psw = "";                    //User's password
    private ArrayList<String> genInfo = new ArrayList<>();          //tariff and charge date

    /**
     * constructor
     * @param ID user ID
     * @param psw password
     */
    public User(String ID, String psw){
        getUser(ID, psw);
    }

    /**
     * getter for ID
     * @return ID
     */
    public String getID() {
        return ID;
    }

    /**
     * getter for general information (tariff and charge date)
     * @return general info
     */
    public ArrayList<String> getGenInfo() {
        return genInfo;
    }

    /**
     * refresh tariff
     */
    public void rfGenInfo(){
        String td[] = new String[2];
        genInfo.clear();
        try {
            BufferedReader buf = new BufferedReader(new FileReader(".\\genInfo.txt"));
            String dataL = "";
            while ((dataL = buf.readLine()) != null) {
                td = dataL.split("\t");
                genInfo.add(td[0]);
                genInfo.add(td[1]);
            }
            buf.close();
        }catch (Exception e){
            System.err.println(e);
        }
    }

    /**
     * this method only used my constructor
     * @param ID ID
     * @param psw password
     */

    public void getUser(String ID, String psw){
        this.ID = ID;
        this.psw = psw;
        rfGenInfo();
    }
}
