package Provider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * This is the User class.
 * Wrote and modified by Yang Ding.
 * @author Yang Ding
 * @version 3.0
 */

public class Provider{
    private String ID = "";                         //provider's name
    private String psw = "";                        //provider's password
    private ArrayList<String> genInfo = new ArrayList<>();          //tariff and charge date

    /**
     * constructor
     * @param ID ID
     * @param psw password
     */
    public Provider(String ID, String psw){
        getProvider(ID, psw);
    }

    /**
     * getters for ID
     * @return String ID
     */
    public String getID() {
        return ID;
    }

    /**
     * getter for password
     * @return password
     */
    public String getPsw() {
        return psw;
    }

    /**
     * getter for general information
     * @return general information
     */
    public ArrayList<String> getGenInfo() {
        try{
            BufferedReader br = new BufferedReader(new FileReader(".\\genInfo.txt"));
            String dataL = "";
            while ((dataL = br.readLine()) != null) {
                genInfo.add(dataL.split("\t")[0]);
                genInfo.add(dataL.split("\t")[1]);
            }
            br.close();
        }catch(Exception e){
            System.err.println(e);
        }
        return genInfo;
    }

    /**
     * this method only used by constructor
     * @param ID ID
     * @param psw password
     */
    public void getProvider(String ID, String psw){
        this.ID = ID;
        this.psw = psw;
        getGenInfo();
    }

}
