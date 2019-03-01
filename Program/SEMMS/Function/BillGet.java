package Function;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * This class provide the method to get the new bill (bills haven't read) for User.
 * Jindou Wei wrote the file(v1.0) and Yang Ding modified it(v1.5 - v3.0).
 * @author Jindou Wei
 * @author Yang Ding
 * @version 3.0
 */
public class BillGet {

    /**
     * check if there is new Bill for this user
     * @param ID ID
     * @return boolean return true is there are new bills for the user, return false if no new bills
     */
    public boolean ifNewBill(String ID){
        try{
            String dataL = "";
            BufferedReader br = new BufferedReader(new FileReader(".\\billList.txt"));
            while((dataL = br.readLine()) != null){
                if(dataL.split("\t")[0].equals(ID) ){
                    br.close();
                    return true;
                }
            }
            br.close();
        }catch(Exception e){
            System.err.println(e);
        }
        return false;
    }

    /**
     * get new bill for this user
     * @param ID ID
     * @return String[][] All the new bill fro this user
     */
    public String[][] billListGet(String ID){
        String[][] stringOut = new String[24][1];
        stringOut[0][0] = "1";
        try{
            String dataL = "";
            ArrayList<String> dataOut = new ArrayList<>();
            ArrayList<String> data = new ArrayList<>();

            BufferedReader br = new BufferedReader(new FileReader(".\\billList.txt"));          //read bill from new bills
            while((dataL = br.readLine()) != null){
                if(!dataL.split("\t")[0].equals(ID) ){                                            //pick up all the bills that's not needed
                    data.add(dataL);
                }
            }
            br.close();

            br = new BufferedReader(new FileReader(".\\" + ID + "M.txt"));                      //read bill
            while((dataL = br.readLine()) != null){
                dataOut.add(dataL);
            }
            br.close();

            stringOut = new String[dataOut.size()][5];
            for(int i = 0; i < dataOut.size(); i++){                                                        //split bill into format that can be put into JTable
                stringOut[i][0] = dataOut.get(i).split("\t")[1];
                stringOut[i][1] = dataOut.get(i).split("\t")[2];
                stringOut[i][2] = dataOut.get(i).split("\t")[3];
                stringOut[i][3] = dataOut.get(i).split("\t")[4];
                stringOut[i][4] = dataOut.get(i).split("\t")[5];
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(".\\billList.txt"));          //rewrite the new bill database
            for(int i = 0; i < data.size(); i++){
                bw.write(data.get(i) + "\r\n");
            }
            bw.close();
        }catch (Exception e){
            System.err.println(e);
        }
        return stringOut;
    }

}
