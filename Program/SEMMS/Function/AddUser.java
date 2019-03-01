package Function;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * This class provide method to add user to database.
 * Zhe Wang wrote the file(v1.0) and Yang Ding modified it(v1.5 - v3.0).
 * @author Zhe Wang
 * @author Yang Ding
 * @version 3.0
 */
public class AddUser {

    /**
     * check if teh user already exist
     * @param ID ID
     * @param psw password
     * @return boolean return true if user already exist, return false if not
     */
    public boolean check(String ID, String psw){
        String dataL = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(".\\userList.txt"));
            while((dataL = br.readLine()) != null){
                if(dataL.equals(ID)){
                    br.close();
                    return false;
                }
            }
            br.close();
            return true;
        }catch(Exception e){
            System.err.println(e);
            return false;
        }
    }

    /**
     * add new user to database
     * @param ID ID
     * @param psw password
     */
    public  void addToSys(String ID, String psw){
        String[] today = Calendar.getInstance().getTime().toString().split(" ");
        String date = today[5].substring(2) + "." + (Calendar.getInstance().get(Calendar.MONTH) + 1) + "." + String.format("%2s", today[2]);
        try{                                                                                                            //create files that are need for a new user
            new File(".\\" + ID + ".txt").createNewFile();
            new File(".\\" + ID + "D.txt").createNewFile();
            new File(".\\" + ID + "M.txt").createNewFile();
            new File(".\\" + ID + "TM.txt").createNewFile();

            BufferedWriter bw = new BufferedWriter(new FileWriter(".\\" + ID + ".txt"));                    //write the default data in to each file
            bw.write("50\r\n50\r\n");
            bw.close();
            bw = new BufferedWriter(new FileWriter(".\\" + ID + "D.txt"));
            bw.write(ID + "\t" + date + "\t0.0\t0.00\t0.0\t0.00\r\n");
            bw.close();
            bw = new BufferedWriter(new FileWriter(".\\" + ID + "TM.txt"));
            bw.write(ID + "\t" + date + "\t0.0\t0.00\t0.0\t0.00\r\n");
            bw.close();

            bw = new BufferedWriter(new FileWriter(".\\userList.txt",true));                        //add new user's information in to user list
            bw.write(ID + "\r\n");
            bw.close();
            bw = new BufferedWriter(new FileWriter(".\\userLogin.txt",true));                       //add new user's information in to user login database
            bw.write(ID + "\t" + psw  + "\r\n");
            bw.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }
}