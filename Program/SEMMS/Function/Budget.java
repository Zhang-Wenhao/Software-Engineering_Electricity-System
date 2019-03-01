package Function;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * This class provide the method to set budget and get budget for user.
 * Wenhao Zhang wrote the file(v1.0) and Yang Ding modified it(v1.5 - v3.0).
 * @author Wenhao Zhang
 * @author Yang Ding
 * @version 3.0
 */
public class Budget{

    /**
     * get budget for the user
     * @param ID ID
     * @return Budget for User
     */
    public ArrayList<String> getBudget(String ID){
        ArrayList<String> budget = new ArrayList<>();
        try {
            BufferedReader buf = new BufferedReader(new FileReader(".\\" + ID + ".txt"));           //read budget from database
            String dataL = "";
            while ((dataL = buf.readLine()) != null) {
                budget.add(dataL);
            }
            buf.close();
        }catch (Exception e){
            System.err.println(e);
        }
        return budget;
    }

    /**
     * /save new budget and write it into database
     * @param budget budget
     * @param ID ID
     */
    public void setBudget(ArrayList<String> budget, String ID) {
        try {
            BufferedWriter buf2 = new BufferedWriter(new FileWriter(".\\" + ID + ".txt"));
            buf2.write(budget.get(0) + "\r\n");
            buf2.write(budget.get(1) + "\r\n");
            buf2.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }
}