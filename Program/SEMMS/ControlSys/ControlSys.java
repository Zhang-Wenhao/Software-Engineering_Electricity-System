package ControlSys;

import Function.*;

/**
 * This is the system that deal with all operation between meter, provider and user.
 * Wrote and modified by Yang Ding.
 * @author Yang Ding
 * @version 3.0
 */
public class ControlSys {
    private AddUser addUser = new AddUser();                                //control class for add user
    private BillGet billGet = new BillGet();                                //control class for user to get bill from provider
    private Budget budget = new Budget();                                   //control class for user to check and change budget
    private ChangeTariff changeTariff = new ChangeTariff();                 //control class for provider to change tariff
    private GetUserList getUserList = new GetUserList();                    //control class for getting user list
    private RemoveUser removeUser = new RemoveUser();                       //control class for provider to remove user
    private SendBill sendBill = new SendBill();                             //control class for provider to send bill to user

    /**
     * getters for AddUser
     * @return AddUser
     */
    public AddUser getAddUser() {
        return addUser;
    }

    /**
     * getters for BillGet
     * @return BillGet
     */
    public BillGet getBillGet() {
        return billGet;
    }

    /**
     * getters for Budget
     * @return Budget
     */
    public Budget getBudget() {
        return budget;
    }

    /**
     * getters for ChangeTariff
     * @return ChangeTariff
     */
    public ChangeTariff getChangeTariff() {
        return changeTariff;
    }

    /**
     * getters for GetUserList
     * @return GetUserList
     */
    public GetUserList getGetUserList() {
        return getUserList;
    }

    /**
     * getters for RemoveUser
     * @return RemoveUser
     */
    public RemoveUser getRemoveUser() {
        return removeUser;
    }

    /**
     * getters for SendBill
     * @return SendBill
     */
    public SendBill getSendBill() {
        return sendBill;
    }
}
