package Function;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * This class provide the method to get history consumption and cost form a start date and an end date.
 * Wrote and modified by Yang Ding.
 * @author Yang Ding
 * @version 3.0
 */

public class HistoricalInformation {

    private ArrayList<String> rData = new ArrayList<>();                                    //the history data user want

    /**
     * get the history data in format of String[]
     * @return history data in String[] format
     */
    public String[][] getrDataSList(){
        String rDataSL[][] = new String[rData.size() + 1][5];
        String dataL[];
        String total[] = {"Total","0","0","0","0"};

        rDataSL[rData.size()] = total;
        for(int i = 0; i < rData.size(); i++){
            dataL = rData.get(i).split("\t");
            for(int j = 0; j < 5; j++){
                rDataSL[i][j] = dataL[j +1];
            }
            for(int j = 1; j < 5;j++){                                                       //calculate the total consumption and cost in time zone and put it in the last line of String
                rDataSL[rData.size()][j] = String.format("%.2f",(Double.parseDouble(rDataSL[rData.size()][j]) + Double.parseDouble(dataL[j + 1])));
            }
        }

        return rDataSL;
    }

    //check if the time zone is legal(days in sDate and eDate exist in database) and get the data if it's legal
    public int checkData(String ID, String sDate,String eDate){
        String dFName = ".\\" + ID + "D.txt";
        String dataD[] = new String[6];
        boolean ifread = false;
        int readable = 0;

        try{
            BufferedReader bReader = new BufferedReader(new FileReader(dFName));
            String dataL = "";
            while((dataL = bReader.readLine()) != null){
                if(!dataL.equals("*")){
                    dataD = dataL.split("\t");
                    if(dataD[1].equals(sDate)){
                        ifread = true;
                        readable++;
                    }
                    if(ifread){
                        rData.add(dataL);
                    }
                    if(dataD[1].equals(eDate)){
                        ifread = false;
                        readable++;
                    }
                }
            }
            bReader.close();
        }catch(Exception e){
            System.err.println(e);
        }
        return readable;
    }
}
