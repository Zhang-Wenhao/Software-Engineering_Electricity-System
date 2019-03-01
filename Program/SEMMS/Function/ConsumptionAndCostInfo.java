package Function;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * This class provide the method to  check consumption and cost of today and this month.
 * Wenhao Zhang and Shiyuan Wang wrote the file(v1.0) and Yang Ding modified it(v1.5 - v3.0).
 * @author Wenhao Zhang
 * @author Yang Ding
 * @version 3.0
 */

public class ConsumptionAndCostInfo {
    // these are two double[] that store the consumption and cost
    private double tConsumptionAndCostS[] = {0.0, 0.0, 0.0, 0.0};
    private double dConsumptionAndCostS[] = {0.0, 0.0, 0.0, 0.0};

    /**
     * get today and this month consumption and cost from database and store in the object
     * @param ID ID
     */
    public void checkCAC(String ID) {
        for(int i = 0; i < 4; i++){
            tConsumptionAndCostS[i] = 0;
            dConsumptionAndCostS[i] = 0;
        }
        long pos = 0;
        try
        {
            String str = "";
            RandomAccessFile randomAccessFile = new RandomAccessFile(".\\" + ID + "TM.txt", "rw");      //read data from database
            randomAccessFile.seek(pos);
            while( (str = randomAccessFile.readLine()) != null)
            {
                String[] str1 = str.split("\t");
                for(int i = 0; i < 4; i++){
                    tConsumptionAndCostS[i] += Double.parseDouble(str1[i + 2]);                             //store this month consumption and cost
                    dConsumptionAndCostS[i] = Double.parseDouble(str1[i + 2]);                              //store today consumption and cost
                }
            }
            randomAccessFile.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * getters for total consumption and cost (return string instead of ArrayList)
     * @return total consumption and cost in String[] format
     */
    public String[] gettConsumptionAndCostS() {
        String a[] = {"", "", "", ""};
        for(int i = 0; i < 4; i++){
            a[i] = String.format("%.2f", tConsumptionAndCostS[i]);
        }
        return a;
    }

    /**
     * getters for today consumption and cost (return string instead of ArrayList)
     * @return today consumption and cost in String[] format
     */
    public String[] getdConsumptionAndCostS() {
        String a[] = {"", "", "", ""};
        for(int i = 0; i < 4; i++){
            a[i] = String.format("%.2f", dConsumptionAndCostS[i]);
        }
        return a;
    }
}