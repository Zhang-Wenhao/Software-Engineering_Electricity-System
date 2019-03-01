package Function;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;
import Meter.Meter;

/**
 * This class provide the method to send new bill to all user every month for provider.
 * Shiyuan Wang wrote the file(v1.0) and Yang Ding modified it(v1.5 - v3.0).
 * @author Shiyuan Wang
 * @author Yang Ding
 * @version 3.0
 */
public class SendBill {
    String date = "";                                                   //today

    /**
     * check if today is the day to send the bill
     * @return true if there is new bill need to be send, false id not
     */
    public boolean ifSend(){
        String[] today = Calendar.getInstance().getTime().toString().split(" ");
        date = today[5].substring(2) + "." + (Calendar.getInstance().get(Calendar.MONTH) + 1) + "." + String.format("%2s", today[2]);
        if(today[2].equals("1") || today[2].equals("01")){
            return true;
        }
        return false;
    }

    /**
     * calculate the bill last month and send it to user
     * @return true if all bills successfully send
     */
    public boolean sendNewBill(){
        String[] userList = new GetUserList().getUserList();

        try{
            for(String m : userList){
                Meter meter= new Meter(m);                                          //use meter to check consumption and cost
                meter.checkCAC();
                String[] cacNumber = meter.getCac().gettConsumptionAndCostS();
                String bill = m + "\t" + date + "\t" + cacNumber[0] + "\t" + cacNumber[1] + "\t" + cacNumber[2] + "\t" + cacNumber[3];

                //do the operation to start a new month in database
                BufferedWriter bw = new BufferedWriter(new FileWriter(".\\" + m + "D.txt",true));
                bw.write("*\r\n");
                bw.write(m + "\t" + date + "\t0.0\t0.00\t0.0\t0.00\r\n");
                bw.close();

                bw = new BufferedWriter(new FileWriter(".\\" + m + "M.txt",true));
                bw.write(bill + "\r\n");
                bw.close();

                bw = new BufferedWriter(new FileWriter(".\\" + m + "TM.txt"));
                bw.write(m + "\t" + date + "\t0.0\t0.00\t0.0\t0.00\r\n");
                bw.close();

                bw = new BufferedWriter(new FileWriter(".\\billList.txt",true));
                bw.write(bill + "\r\n");
                bw.close();
            }
            return true;
        }catch(Exception e){
            System.err.println(e);
            return false;
        }
    }
}
