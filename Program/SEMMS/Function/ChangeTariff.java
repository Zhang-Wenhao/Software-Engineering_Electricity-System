package Function;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * This class provide the method to change the tariff for provider.
 * Keke Wang wrote the file(v1.0) and Yang Ding modified it(v1.5 - v3.0).
 * @author Keke Wang
 * @author Yang Ding
 * @version 3.0
 */
public class ChangeTariff {
    String[] tariff = {"", ""};                                                             //tariff

    /**
     * getter for tariff
     * @return tariff
     */
    public String[] getTariff() {
        return tariff;
    }

    /**
     * save new tariff and write it into database
     * @param tariff new tariff
     */
    public void setTariff(String[] tariff) {
        for(int i = 0; i < 2; i++){
            tariff[i] = String.format("%.1f",Double.parseDouble(tariff[i]));
        }
        this.tariff[0] = tariff[0];                                                         //store new tariff in this object
        this.tariff[1] = tariff[1];
        try{
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(".\\genInfo.txt"));      //write new tariff into database
            for(int i = 0; i < 2; i++){
                bWriter.write(tariff[i] + "\t01");
                bWriter.newLine();
            }
            bWriter.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }

    /**
     * read tariff from database
     */
    public void readT(){
        try {
            BufferedReader buf = new BufferedReader(new FileReader(".\\genInfo.txt"));
            for(int i = 0;i < 2; i++){
                tariff[i] = buf.readLine().split("\t")[0];
            }
        }catch (Exception e){
            System.err.println(e);
        }
    }
}
