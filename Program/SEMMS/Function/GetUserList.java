package Function;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * This class provide the method to get a list of current user.
 * Zhe Wang wrote the file(v1.0) and Yang Ding modified it(v1.5 - v3.0).
 * @author Zhe Wang
 * @author Yang Ding
 * @version 3.0
 */
public class GetUserList {

    /**
     * list of username from database and return it the format of String[]
     * @return user list
     */
    public String[] getUserList(){
        String[] userList = {"-1"};
        try{
            BufferedReader br = new BufferedReader(new FileReader(".\\userList.txt"));              //read data from database
            String dataL = "";
            ArrayList<String> data = new ArrayList<>();
            while((dataL = br.readLine()) != null){
                data.add(dataL);                                                                        //store the list in ArrayList
            }
            if(data.size() > 0){
                userList = new String[data.size()];
                for(int i = 0; i < data.size();i++){
                    userList[i] = data.get(i);                                                          //change the list in to String[] format
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return userList;
    }
}