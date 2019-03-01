package Function;

import java.io.*;
import java.util.ArrayList;

/**
 * This class provide the method to remove a user from system for provider.
 * Wenhao Zhang wrote the file(v1.0) and Yang Ding modified it(v1.5 - v3.0).
 * @author Wenhao Zhang
 * @author Yang Ding
 * @version 3.0
 */
public class RemoveUser {

    /**
     * check if the user you want to remove exist
     * @param ID ID
     * @return true if ID exist, return false if not
     */
    public boolean IDExist(String ID){
        return new File(".\\" + ID + ".txt").exists();
    }

    /**
     * remove the User you want
     * @param ID ID of the user been  removed
     */
    public void rmID(String ID){
        rmIDinList(ID);                                                 //remove user data that store with other users' data
        new File(".\\" + ID + ".txt").delete();              //remove user data that can be removed by delete the file
        new File(".\\" + ID + "D.txt").delete();
        new File(".\\" + ID + "M.txt").delete();
        new File(".\\" + ID + "TM.txt").delete();
    }

    /**
     * remove the user data store in userList.txt and userLogin.txt
     * @param ID ID of the user been removed
     */
    public void rmIDinList(String ID){
        ArrayList<String> data = new ArrayList<>();
        String dataL = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(".\\userLogin.txt"));
            while((dataL = br.readLine()) != null){
                if(!(dataL.split("\t")[0].equals(ID))){
                    data.add(dataL);
                }
            }
            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter(".\\userLogin.txt"));
            for(int i = 0; i < data.size(); i++){
                bw.write(data.get(i) + "\r\n");
            }
            bw.close();

            data.clear();
            BufferedReader br1 = new BufferedReader(new FileReader(".\\userList.txt"));
            while((dataL = br1.readLine()) != null){
                if(!dataL.equals(ID)){
                    data.add(dataL);
                }
            }
            br1.close();
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(".\\userList.txt"));
            for(int i = 0; i < data.size(); i++){
                bw1.write(data.get(i) + "\r\n");
            }
            bw1.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
