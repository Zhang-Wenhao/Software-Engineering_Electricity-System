package Meter;

import ControlSys.ControlSys;
import Function.ConsumptionAndCostInfo;
import Function.HistoricalInformation;

/**
 * This is the meter class of every user.
 * Wrote and modified by Yang Ding.
 * @author Yang Ding
 * @version 3.0
 */
public class Meter {
    String ID = "";                                                             //meter's user ID
    private ConsumptionAndCostInfo cac = new ConsumptionAndCostInfo();          //control class for reading consumption and cost today and this month
    private HistoricalInformation hi = new HistoricalInformation();             //control class for reading any consumption and cost

    /**
     * constructor
     * @param ID ID of user
     */
    public Meter(String ID){
        this.ID = ID;
    }

    /**
     * getter for ID
     * @return ID
     */
    public String getID() {
        return ID;
    }

    /**
     * getter for ConsumptionAndCost
     * @return ConsumptionAndCostInfo
     */
    public ConsumptionAndCostInfo getCac() {
        return cac;
    }

    /**
     * getter for HistoricalInformation
     * @return HistoricalInformation
     */
    public HistoricalInformation getHi() {
        return hi;
    }

    /**
     * check history consumption and cost
     */
    public void checkCAC(){
        cac.checkCAC(ID);
    }

    /**
     * check if the User exist
     * @return true if user exist, false if user don't exist
     */
    public boolean ifMeterExist(){
        for (String m : new ControlSys().getGetUserList().getUserList()) {
            if(ID.equals(m))
                return true;
        }
        return false;
    }
}
