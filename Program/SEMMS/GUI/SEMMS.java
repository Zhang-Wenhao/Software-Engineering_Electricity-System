package GUI;

import User.User;
import Provider.Provider;
import Meter.Meter;
import ControlSys.ControlSys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * This is the main frame of GUI.
 * Shiyuan Wang wrote the Timer "simuEGUsed"(v1.0 - v2.0) and
 * other part wrote  and modified(v1.0 - v3.0)by Yang Ding.
 * @author Shiyuan Wang
 * @author Yang Ding
 * @version 3.0
 */

public class SEMMS {

    //object that need in the whole program
    private String logType = "";                                        //store login type("U" - user; "EP" - energy provider)
    private String currPage = "";                                       //store the page that is show on th top
    private int ifWarned = 0;                                           //store if user has been warned about cost overflow since login
    private User cUser = null;                                          //store User object
    private Provider ep = null;                                         //store Provider object
    private ControlSys controlSys = new ControlSys();                   //store control System object

    //objects that are need to create the window
    private JFrame myFrame = new JFrame();                              //main frame
    private JPanel mainPage = new JPanel();                             //panel to store every page
    private JPanel backPage = new JPanel();                             //panel that store the back bottom
    private CardLayout cardL = new CardLayout();                        //layout of mainPage
    private WarningDialog warning = null;                               //waring dialog for every warning
    private Timer dataRefreshTimer = null;                              //background timer to refresh data for User
    private Timer simuEGUsed = null;                                    //background timer to simulate user using electricity and gas

    //JPanels that are needed
    private HomePage homepage = new HomePage();                                     //home page
    private LogPage logpage = new LogPage();                                        //login page
    private UFunctionPage uFunction = new UFunctionPage();                          //user's "main" page
    private UConsumpAndCostPage uConsumpAndCost = new UConsumpAndCostPage();        //user's page for checking consumption and cost  today and this month
    private USetBudgetPage uSetBudget = new USetBudgetPage();                       //user's page for setting budget
    private UHisInfoPage uHisInfo = new UHisInfoPage();                             //user's page for checking all history information
    private UHisBillPage uHisBill = new UHisBillPage();                             //user's page for checking all the bill
    private UCheckTariffPage uCheckTariff = new UCheckTariffPage();                 //user's page for checking current tariff
    private EPFunctionPage epFunction = new EPFunctionPage();                       //provider's "main" page
    private EPUserManagPage epUserManag = new EPUserManagPage();                    //provider's page for user management
    private EPAddUserPage epAddUser = new EPAddUserPage();                          //provider's page for adding user
    private EPRemoveUserPage epRemoveUser = new EPRemoveUserPage();                 //provider's page for removing user
    private EPInfoManagPage epInfoManag = new EPInfoManagPage();                    //provider's page for checking user's information
    private EPUserInfoPage epUserInfo = new EPUserInfoPage();                       //provider's "main" page for checking user
    private  EPSetTariffPage epSetTariff = new EPSetTariffPage();                   //provider's page for setting tariff
    private JButton backB = new JButton("back");


    /**
     * this is the main method
     * @param args this is never used
     */
    public static void main(String[] args){
        SEMMS semmSystem = new SEMMS();                                                                                 //Create a instant of this class.
        semmSystem.startSEMMS();                                                                                        //Run the program.
    }

    /**
     * method to seart the program
     */
    public void startSEMMS(){

        //add listener and timer and setup all page
        addListener();
        addTimer();
        setMainPage();
        setBackPage();

        //set the layout
        myFrame.getContentPane().add(BorderLayout.CENTER, mainPage);
        myFrame.getContentPane().add(BorderLayout.SOUTH, backPage);

        currPage = "H";
        myFrame.getContentPane().getComponent(1).setVisible(false);

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        myFrame.setTitle("S.E.M.M. System by group 102");
        myFrame.setSize(850,600);
        myFrame.setVisible(true);
        simuEGUsed.start();
    }

    /**
     * setup main page
     */
    public void setMainPage(){
        //setup layout and add all panel into it
        mainPage.setLayout(cardL);
        mainPage.add("H", homepage.getHome());
        mainPage.add("L", logpage.getLogin());
        mainPage.add("U", uFunction.getuFunction());
        mainPage.add("UCAC", uConsumpAndCost.getuConsumpAndCost());
        mainPage.add("USB", uSetBudget.getuSetBudget());
        mainPage.add("UHI", uHisInfo.getuHisInfo());
        mainPage.add("UHB", uHisBill.getuHisBill());
        mainPage.add("UCT", uCheckTariff.getuCheckTariff());
        mainPage.add("EP", epFunction.getEpFunction());
        mainPage.add("EPUM",epUserManag.getEpUserManag());
        mainPage.add("EPAU",epAddUser.getEpAddUser());
        mainPage.add("EPRU",epRemoveUser.getEpRemoveUser());
        mainPage.add("EPIM",epInfoManag.getEpInfoManag());
        mainPage.add("EPUI", epUserInfo.getEpUserInfo());
        mainPage.add("EPST", epSetTariff.getepSetTariff());
    }

    /**
     * setup the panel for back bottom
     */
    public void setBackPage(){
        backPage.setLayout(new FlowLayout(FlowLayout.LEFT));
        backPage.add(backB);
    }

    /**
     * method to check login
     * @param ty login type
     * @param ID login ID
     * @param psw password
     * @return ty + "LoginAllowed" if login success, ty + "LoginFailed" if login failed
     */
    public String checkLogin(String ty, String ID, String psw){
        String file = "";
        String[] idAndPsw = new String[2];

        if(ty.equals("U")){
            file = ".\\userLogin.txt";
        }else if(ty.equals("EP")){
            file = ".\\ep.txt";
        }

        try{
            BufferedReader bReader = new BufferedReader(new FileReader(file));
            String dataL = "";
            while((dataL = bReader.readLine()) != null){
                idAndPsw = dataL.split("\t");
                if(idAndPsw[0].equals(ID) && idAndPsw[1].equals(psw)){
                    return ty + "LoginAllowed";
                }
            }
        }catch(Exception e){
            System.err.println(e);
        }
        return ty + "LoginFailed";
    }

    /**
     * method that add all ActoinListener
     */
    public void addListener(){

        //this method setup all the button in teh program

        homepage.getUserLogB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logType = "U";
                currPage = "L";
                cardL.show(mainPage,"L");
                //reset the page to br shown
                logpage.getNameText().setText("");
                logpage.getPswText().setText("");
                myFrame.getContentPane().getComponent(1).setVisible(true);
            }
        });

        homepage.getEpLogB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logType = "EP";
                currPage = "L";
                //reset the page to br shown
                logpage.getNameText().setText("");
                logpage.getPswText().setText("");
                cardL.show(mainPage,"L");
                myFrame.getContentPane().getComponent(1).setVisible(true);
            }
        });

        backB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currPage.equals("U") || currPage.equals("EP")){                  //when user click back botton to logout the account
                    warning = new WarningDialog(myFrame,"Are you sure you want to logout?","YES", "NO");
                    warning.getButtonA().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            warning.getWarningDia().dispose();
                            if(logType.equals("U")){
                                dataRefreshTimer.stop();
                            }
                            logType = "";
                            currPage = "H";
                            cardL.first(mainPage);
                            backB.setText("back");
                            myFrame.getContentPane().getComponent(1).setVisible(false);
                        }
                    });
                    warning.getButtonB().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            warning.getWarningDia().dispose();
                        }
                    });
                    warning.getWarningDia().setVisible(true);
                }else if(currPage.equals("L")){                                 //when current page is login page
                    logType = "";
                    currPage = "H";
                    cardL.first(mainPage);
                    myFrame.getContentPane().getComponent(1).setVisible(false);
                } else if(currPage.substring(0,1).equals("U")){                 //when current page is for user
                    if(logType.equals("EP")){                                   //when it's provider checking user account
                        currPage = "EPUI";
                        cardL.show(mainPage, "EPUI");
                    }else{
                        backB.setText("logout");                                //when it's really a user login
                        currPage = "U";
                        cardL.show(mainPage, "U");
                    }
                }else if(currPage.equals("EPUM") || currPage.equals("EPIM") || currPage.equals("EPST")){    //when current page is provider's page
                    backB.setText("logout");
                    currPage = "EP";
                    cardL.show(mainPage, "EP");
                }else if(currPage.equals("EPAU") || currPage.equals("EPRU")){
                    currPage = "EPUM";
                    cardL.show(mainPage, "EPUM");
                }else if(currPage.equals("EPUI")){
                    dataRefreshTimer.stop();
                    currPage = "EPIM";
                    cardL.show(mainPage, "EPIM");
                }
            }
        });

        logpage.getLoginB().addActionListener(new ActionListener(){
                @Override
            public void actionPerformed(ActionEvent e) {
                if(logpage.getNameText().getText().isEmpty() || String.valueOf(logpage.getPswText().getPassword()).isEmpty()){
                }else{                  //when both ID and password has been entered
                    try {
                        String answer = checkLogin(logType, logpage.getNameText().getText(), String.valueOf(logpage.getPswText().getPassword()));
                        if(answer.equals(logType + "LoginAllowed")){            //if login is allowed
                            backB.setText("logout");
                            cardL.show(mainPage,logType);
                            currPage = logType;
                            if(logType.equals("U")){                            //when user login, check if there is new bill for this ID
                                cUser = new User(logpage.getNameText().getText(), String.valueOf(logpage.getPswText().getPassword()));
                                if(controlSys.getBillGet().ifNewBill(cUser.getID())){
                                    warning = new WarningDialog(myFrame, "You have new bill arrived, please remember to check it. ", "OK");
                                    warning.getButtonA().addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            warning.getWarningDia().dispose();
                                        }
                                    });
                                    warning.getWarningDia().setVisible(true);
                                }
                                dataRefreshTimer.start();
                            }
                            if(logType.equals("EP")){                           //when provider login, check if it's need to generate the bill of last month
                                ep = new Provider(logpage.getNameText().getText(), String.valueOf(logpage.getPswText().getPassword()));
                                simuEGUsed.stop();
                                if(controlSys.getSendBill().ifSend()){
                                    controlSys.getSendBill().sendNewBill();
                                    warning = new WarningDialog(myFrame, "New charge date arrived, the bill last month has been send to your users", "OK");
                                    warning.getButtonA().addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            warning.getWarningDia().dispose();
                                        }
                                    });
                                    warning.getWarningDia().setVisible(true);
                                }
                                simuEGUsed.start();
                            }
                            logpage.getNameText().setText("");
                            logpage.getPswText().setText("");
                        }else if(answer.equals(logType + "LoginFailed")){       //show warning if login is not allowed
                            warning = new WarningDialog(myFrame, "Wrong user name or password, please try again", "OK");
                            warning.getButtonA().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    warning.getWarningDia().dispose();
                                }
                            });
                            warning.getWarningDia().setVisible(true);
                        }
                    }catch(Exception exception){
                        System.out.println("ERROR: " + exception);
                    }
                }
            }
        });

        logpage.getClearB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logpage.getNameText().setText("");
                logpage.getPswText().setText("");
            }
        });

        uFunction.getCacB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backB.setText("back");
                //read consumption and cost from meter and show it on page
                Meter meter = new Meter(cUser.getID());
                meter.checkCAC();
                uConsumpAndCost.getdEConsumpAndCost().setText("        Electricity:                           " + meter.getCac().getdConsumptionAndCostS()[0] +
                        "kwh                ¡ê" +  meter.getCac().getdConsumptionAndCostS()[1]);
                uConsumpAndCost.getdGConsumpAndCost().setText("        Gas:                                    " +  meter.getCac().getdConsumptionAndCostS()[2] +
                        "m^3                ¡ê" +  meter.getCac().getdConsumptionAndCostS()[3]);
                uConsumpAndCost.gettEConsumpAndCost().setText("        Electricity:                           " +  meter.getCac().gettConsumptionAndCostS()[0] +
                        "kwh              ¡ê" +  meter.getCac().gettConsumptionAndCostS()[1]);
                uConsumpAndCost.gettGConsumpAndCost().setText("        Gas:                                    " +  meter.getCac().gettConsumptionAndCostS()[2] +
                        "m^3                ¡ê" +  meter.getCac().gettConsumptionAndCostS()[3]);
                currPage = "UCAC";
                cardL.show(mainPage,"UCAC");
            }
        });

        uFunction.getSbB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backB.setText("back");
                //reset current page
                uSetBudget.getNewBText1().setText("");
                uSetBudget.getNewBText2().setText("");
                uSetBudget.getSetGBDone().setVisible(false);
                uSetBudget.getSetEBDone().setVisible(false);
                currPage = "USB";
                //reload current budget and show it on page
                int budgetE = Integer.parseInt(controlSys.getBudget().getBudget(cUser.getID()).get(0));
                int budgetG = Integer.parseInt(controlSys.getBudget().getBudget(cUser.getID()).get(1));
                cUser.rfGenInfo();
                double geninfoE = Double.parseDouble(cUser.getGenInfo().get(0));
                double geninfoG = Double.parseDouble(cUser.getGenInfo().get(2));
                uSetBudget.getcBudget().setText("        Current budget:                         ¡ê" + budgetE + "(" + String.format("%.2f", budgetE / geninfoE) + "kwh)      ¡ê"
                        + controlSys.getBudget().getBudget(cUser.getID()).get(1) + "(" + String.format("%.2f", budgetG / geninfoG) + "m^3)");
                cardL.show(mainPage,"USB");
            }
        });

        uFunction.getHiB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backB.setText("back");
                //reset current page
                uHisInfo.getsDateText().setText("");
                uHisInfo.geteDateText().setText("");
                uHisInfo.getuHisInfo().remove(uHisInfo.getHisInfoSP());
                String eString[][] = new String[1][5];
                uHisInfo.setHisInfoTable(new JTable(eString, uHisInfo.getTitle()));
                uHisInfo.getHisInfoTable().setEnabled(false);
                uHisInfo.setHisInfoSP(new JScrollPane(uHisInfo.getHisInfoTable()));
                uHisInfo.getuHisInfo().add(BorderLayout.CENTER, uHisInfo.getHisInfoSP());
                uHisInfo.getuHisInfo().updateUI();

                currPage = "UHI";
                cardL.show(mainPage,"UHI");
            }
        });

        uFunction.getHbB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backB.setText("back");
                //reset current page and refresh the bill
                uHisBill.getuHisBill().remove(uHisBill.getHisBillSP());
                uHisBill.setHisBillTable(new JTable(controlSys.getBillGet().billListGet(cUser.getID()), uHisBill.getTitle()));
                uHisBill.getHisBillTable().setEnabled(false);
                uHisBill.setHisBillSP(new JScrollPane(uHisBill.getHisBillTable()));
                uHisBill.getuHisBill().add(BorderLayout.CENTER, uHisBill.getHisBillSP());
                uHisBill.getuHisBill().updateUI();

                currPage = "UHB";
                cardL.show(mainPage,"UHB");
            }
        });

        uSetBudget.getSetBudgB().addActionListener(new ActionListener() {
            //if user want to set budget by cost
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!uSetBudget.getNewBText1().getText().isEmpty()){     //if text field for electricity has something
                    try{
                        if(Integer.parseInt(uSetBudget.getNewBText1().getText()) > 0){  //if what entered is legal
                            //change electricity budget and reset textField
                            ArrayList<String> budget = controlSys.getBudget().getBudget(cUser.getID());
                            budget.set(0, uSetBudget.getNewBText1().getText());
                            controlSys.getBudget().setBudget(budget, cUser.getID());
                            uSetBudget.getSetEBDone().setVisible(true);
                            uSetBudget.getNewBText1().setText("");
                        }else{                                                          //if what entered is illegal
                            warning = new WarningDialog(myFrame,"Error: electricity budget should be a integer larger than 0","OK");
                            warning.getButtonA().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    warning.getWarningDia().dispose();
                                }
                            });
                            warning.getWarningDia().setVisible(true);
                        }
                    }catch(Exception err){                                              //if what been entered is not a integer
                        warning = new WarningDialog(myFrame,"Error: electricity budget should be a integer larger than 0","OK");
                        warning.getButtonA().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                warning.getWarningDia().dispose();
                            }
                        });
                        warning.getWarningDia().setVisible(true);
                    }
                }
                if(!uSetBudget.getNewBText2().getText().isEmpty()){     //if text field for gas has something
                    try{
                        if(Integer.parseInt(uSetBudget.getNewBText2().getText()) > 0){      //if what entered is legal
                            //change gas budget and reset textField
                            ArrayList<String> budget = controlSys.getBudget().getBudget(cUser.getID());
                            budget.set(1, uSetBudget.getNewBText2().getText());
                            controlSys.getBudget().setBudget(budget, cUser.getID());
                            uSetBudget.getSetGBDone().setVisible(true);
                            uSetBudget.getNewBText2().setText("");
                        }else{                                                              //if what entered is illegal
                            warning = new WarningDialog(myFrame,"Error: gas budget should be a number larger than 0","OK");
                            warning.getButtonA().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    warning.getWarningDia().dispose();
                                }
                            });
                            warning.getWarningDia().setVisible(true);
                        }
                    }catch(Exception err){                                                  //if what been entered is not a integer
                        warning = new WarningDialog(myFrame,"Error: gas budget should be a number larger than 0","OK");
                        warning.getButtonA().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                warning.getWarningDia().dispose();
                            }
                        });
                        warning.getWarningDia().setVisible(true);
                    }
                }
                //refresh budgets on screen
                controlSys.getBudget().setBudget(controlSys.getBudget().getBudget(cUser.getID()), cUser.getID());
                int budgetE = Integer.parseInt(controlSys.getBudget().getBudget(cUser.getID()).get(0));
                int budgetG = Integer.parseInt(controlSys.getBudget().getBudget(cUser.getID()).get(1));
                cUser.rfGenInfo();
                double geninfoE = Double.parseDouble(cUser.getGenInfo().get(0));
                double geninfoG = Double.parseDouble(cUser.getGenInfo().get(2));
                uSetBudget.getcBudget().setText("        Current budget:                         ¡ê" + budgetE + "(" + String.format("%.2f", budgetE / geninfoE) + "kwh)      ¡ê"
                        + controlSys.getBudget().getBudget(cUser.getID()).get(1) + "(" + String.format("%.2f", budgetG / geninfoG) + "m^3)");
            }
        });

        uSetBudget.getSetBudgBinC().addActionListener(new ActionListener() {
            //if user want to set budget by consumption
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!uSetBudget.getNewBText1inC().getText().isEmpty()){              //if text field for electricity has something
                    try{
                        if(Integer.parseInt(uSetBudget.getNewBText1inC().getText()) > 0){       //if what entered is legal
                            //change electricity budget and reset textField
                            ArrayList<String> budget = controlSys.getBudget().getBudget(cUser.getID());
                            double geninfoE = Double.parseDouble(cUser.getGenInfo().get(0));
                            double budgetInD = Double.parseDouble(uSetBudget.getNewBText1inC().getText()) * geninfoE;
                            budget.set(0, String.format("%.0f", budgetInD));
                            controlSys.getBudget().setBudget(budget, cUser.getID());
                            uSetBudget.getSetEBDone().setVisible(true);
                            uSetBudget.getNewBText1inC().setText("");
                        }else{                                                              //if what entered is illegal
                            warning = new WarningDialog(myFrame,"Error: electricity budget should be a integer larger than 0","OK");
                            warning.getButtonA().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    warning.getWarningDia().dispose();
                                }
                            });
                            warning.getWarningDia().setVisible(true);
                        }
                    }catch(Exception err){                                                  //if what been entered is not a integer
                        warning = new WarningDialog(myFrame,"Error: electricity budget should be a integer larger than 0","OK");
                        warning.getButtonA().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                warning.getWarningDia().dispose();
                            }
                        });
                        warning.getWarningDia().setVisible(true);
                    }
                }
                if(!uSetBudget.getNewBText2inC().getText().isEmpty()){      //if text field for gas has something
                    try{
                        if(Integer.parseInt(uSetBudget.getNewBText2inC().getText()) > 0){       //if what entered is legal
                            //change gas budget and reset textField
                            ArrayList<String> budget = controlSys.getBudget().getBudget(cUser.getID());
                            double geninfoG = Double.parseDouble(cUser.getGenInfo().get(2));
                            double budgetInD = Double.parseDouble(uSetBudget.getNewBText2inC().getText()) * geninfoG;
                            budget.set(1, String.format("%.0f", budgetInD));
                            controlSys.getBudget().setBudget(budget, cUser.getID());
                            uSetBudget.getSetGBDone().setVisible(true);
                            uSetBudget.getNewBText2inC().setText("");
                        }else{                                                                  //if what entered is illegal
                            warning = new WarningDialog(myFrame,"Error: gas budget should be a number larger than 0","OK");
                            warning.getButtonA().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    warning.getWarningDia().dispose();
                                }
                            });
                            warning.getWarningDia().setVisible(true);
                        }
                    }catch(Exception err){                                                      //if what been entered is not a integer
                        warning = new WarningDialog(myFrame,"Error: gas budget should be a number larger than 0","OK");
                        warning.getButtonA().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                warning.getWarningDia().dispose();
                            }
                        });
                        warning.getWarningDia().setVisible(true);
                    }
                }
                //refresh budgets on screen
                controlSys.getBudget().setBudget(controlSys.getBudget().getBudget(cUser.getID()), cUser.getID());
                int budgetE = Integer.parseInt(controlSys.getBudget().getBudget(cUser.getID()).get(0));
                int budgetG = Integer.parseInt(controlSys.getBudget().getBudget(cUser.getID()).get(1));
                cUser.rfGenInfo();
                double geninfoE = Double.parseDouble(cUser.getGenInfo().get(0));
                double geninfoG = Double.parseDouble(cUser.getGenInfo().get(2));
                uSetBudget.getcBudget().setText("        Current budget:                         ¡ê" + budgetE + "(" + String.format("%.2f", budgetE / geninfoE) + "kwh)      ¡ê"
                        + controlSys.getBudget().getBudget(cUser.getID()).get(1) + "(" + String.format("%.2f", budgetG / geninfoG) + "m^3)");
            }
        });

        uFunction.getCtB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backB.setText("back");
                //refresh the counsumptin and cost on the page
                uCheckTariff.getTariffToStringE().setText("        Current tariff:        electricity:     ¡ê" + cUser.getGenInfo().get(0) + "/kwh");
                uCheckTariff.getTariffToStringG().setText("                                      gas:              ¡ê" + cUser.getGenInfo().get(2) + "/m^3");
                currPage = "UCT";
                cardL.show(mainPage,"UCT");
            }
        });

        uHisInfo.getHisInfoCheckB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Meter meter = null;
                if(logType.equals("U")){                                //if is user using the page
                    meter = new Meter(cUser.getID());
                }else if(logType.equals("EP")){                         //if is a provider checking user's information
                    meter = new Meter(epUserInfo.getID());
                }
                String sDate = uHisInfo.getsDateText().getText();
                String eDate = uHisInfo.geteDateText().getText();
                if(sDate.matches("\\d{2}\\.\\d{1,2}\\.\\d{1,2}") &&
                        eDate.matches("\\d{2}\\.\\d{1,2}\\.\\d{1,2}")){     //check the format of date
                    sDate = sDate.replace(".0", ".");
                    eDate = eDate.replace(".0", ".");

                    if(meter.getHi().checkData(meter.getID(), sDate, eDate) == 2){      //if the date is legal
                        //refresh the String[] and put it on screen
                        uHisInfo.getuHisInfo().remove(uHisInfo.getHisInfoSP());
                        uHisInfo.setHisInfoTable(new JTable(meter.getHi().getrDataSList(), uHisInfo.getTitle()));
                        uHisInfo.getHisInfoTable().setEnabled(false);
                        uHisInfo.setHisInfoSP(new JScrollPane(uHisInfo.getHisInfoTable()));
                        uHisInfo.getuHisInfo().add(BorderLayout.CENTER, uHisInfo.getHisInfoSP());
                        uHisInfo.getuHisInfo().updateUI();
                    }else{                                                              //if data is illegal
                        warning = new WarningDialog(myFrame,"The information of some part of period you enter doesn't exist, please try again","OK");
                        warning.getButtonA().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                warning.getWarningDia().dispose();
                            }
                        });
                        warning.getWarningDia().setVisible(true);
                    }

                }else{                                                              //if date format id illegal
                    warning = new WarningDialog(myFrame,"Please enter two date in fallowing rules: yy.mm/m.dd/d","OK");
                    warning.getButtonA().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            warning.getWarningDia().dispose();
                        }
                    });
                    warning.getWarningDia().setVisible(true);
                }
            }
        });

        epFunction.getUmB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backB.setText("back");
                currPage = "EPUM";
                cardL.show(mainPage, "EPUM");
            }
        });

        epFunction.getCtB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backB.setText("back");
                //reset current page and put current tariff on teh page
                epSetTariff.getNewTText2().setText("");
                epSetTariff.getNewTText2().setText("");
                epSetTariff.getSetETDone().setVisible(false);
                epSetTariff.getSetGTDone().setVisible(false);
                controlSys.getChangeTariff().readT();
                epSetTariff.getcTariff().setText("        Current tariff:        ¡ê" + controlSys.getChangeTariff().getTariff()[0] + "                      ¡ê" + controlSys.getChangeTariff().getTariff()[1]);
                currPage = "EPST";
                cardL.show(mainPage, "EPST");
            }
        });

        epFunction.getImB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                epInfoManag.getNameText().setText("");
                backB.setText("back");
                currPage = "EPIM";
                cardL.show(mainPage, "EPIM");
            }
        });

        epUserManag.getAuB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //reset the page
                epAddUser.getNameText().setText("");
                epAddUser.getPswText().setText("");
                epAddUser.getPswTextCheck().setText("");
                currPage = "EPAU";
                cardL.show(mainPage, "EPAU");
            }
        });

        epUserManag.getRuB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //reset the page
                epRemoveUser.getNameText().setText("");
                currPage = "EPRU";
                cardL.show(mainPage, "EPRU");
            }
        });

        epAddUser.getAddUB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(epAddUser.getNameText().getText().isEmpty() ||
                        String.valueOf(epAddUser.getPswText().getPassword()).isEmpty() ||
                        String.valueOf(epAddUser.getPswTextCheck().getPassword()).isEmpty()){       //if not all textfield have something entered
                }else if(String.valueOf(epAddUser.getPswText().getPassword()).equals(String.valueOf(epAddUser.getPswTextCheck().getPassword()))){   //if two password are teh same
                    if(controlSys.getAddUser().check(epAddUser.getNameText().getText(),String.valueOf(epAddUser.getPswText().getPassword()))){      //if user doesn't exist
                        simuEGUsed.stop();
                        controlSys.getAddUser().addToSys(epAddUser.getNameText().getText(),String.valueOf(epAddUser.getPswText().getPassword()));   //add user
                        simuEGUsed.start();
                        warning = new WarningDialog(myFrame, "User has been added", "OK");
                        warning.getButtonA().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                warning.getWarningDia().dispose();
                            }
                        });
                        warning.getWarningDia().setVisible(true);
                    }else{                                                                          //if already exist
                        warning = new WarningDialog(myFrame, "User already exist", "OK");
                        warning.getButtonA().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                warning.getWarningDia().dispose();
                            }
                        });
                        warning.getWarningDia().setVisible(true);
                    }
                }else{                                                                              //if two passwprd is not teh same
                    warning = new WarningDialog(myFrame, "Password you entered are different, please try again", "OK");
                    warning.getButtonA().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            warning.getWarningDia().dispose();
                        }
                    });
                    warning.getWarningDia().setVisible(true);
                }
            }
        });

        epRemoveUser.getRemoveUB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(epRemoveUser.getNameText().getText().isEmpty()){                                 //if the textfield has something in it
                }else if(controlSys.getRemoveUser().IDExist(epRemoveUser.getNameText().getText())){     //if the ID been entered exist
                    //show a warning to double check the operation
                    warning = new WarningDialog(myFrame, "Are you sure you want to remove user: " + epRemoveUser.getNameText().getText(), "Yes", "NO");
                    warning.getButtonA().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            simuEGUsed.stop();
                            controlSys.getRemoveUser().rmID(epRemoveUser.getNameText().getText());
                            simuEGUsed.start();
                            warning.getWarningDia().dispose();
                            warning = new WarningDialog(myFrame, "User removed", "OK");
                            warning.getButtonA().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    warning.getWarningDia().dispose();
                                }
                            });
                            warning.getWarningDia().setVisible(true);
                        }
                    });
                    warning.getButtonB().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            warning.getWarningDia().dispose();
                        }
                    });
                    warning.getWarningDia().setVisible(true);
                }else{                                                                              //if te ID been entered doesn't exist
                    warning = new WarningDialog(myFrame, "User doesn't exist", "OK");
                    warning.getButtonA().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            warning.getWarningDia().dispose();
                        }
                    });
                    warning.getWarningDia().setVisible(true);
                }
            }
        });

        epInfoManag.getCheckUB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(epInfoManag.getNameText().getText().isEmpty()){
                }else if(new Meter(epInfoManag.getNameText().getText()).ifMeterExist()){            //if user provider want to check exist
                    dataRefreshTimer.start();
                    epUserInfo.setID(epInfoManag.getNameText().getText());
                    epUserInfo.getText().setText("You are now checking information on User " + epUserInfo.getID());
                    currPage = "EPUI";
                    cardL.show(mainPage, "EPUI");
                    epInfoManag.getNameText().setText("");
                }else{                                                                              //if the user doesn't exist
                    warning = new WarningDialog(myFrame, "The user you are looking for doesn't exist", "OK");
                    warning.getButtonA().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            warning.getWarningDia().dispose();
                        }
                    });
                    warning.getWarningDia().setVisible(true);
                }
            }
        });

        epUserInfo.getCacB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //check the neter and refresh consumption and cost on page
                Meter meter = new Meter(epUserInfo.getID());
                meter.checkCAC();
                uConsumpAndCost.getdEConsumpAndCost().setText("        Electricity:                           " + meter.getCac().getdConsumptionAndCostS()[0] +
                        "kwh                ¡ê" +  meter.getCac().getdConsumptionAndCostS()[1]);
                uConsumpAndCost.getdGConsumpAndCost().setText("        Gas:                                    " +  meter.getCac().getdConsumptionAndCostS()[2] +
                        "m^3                ¡ê" +  meter.getCac().getdConsumptionAndCostS()[3]);
                uConsumpAndCost.gettEConsumpAndCost().setText("        Electricity:                           " +  meter.getCac().gettConsumptionAndCostS()[0] +
                        "kwh              ¡ê" +  meter.getCac().gettConsumptionAndCostS()[1]);
                uConsumpAndCost.gettGConsumpAndCost().setText("        Gas:                                    " +  meter.getCac().gettConsumptionAndCostS()[2] +
                        "m^3                ¡ê" +  meter.getCac().gettConsumptionAndCostS()[3]);
                currPage = "UCAC";
                cardL.show(mainPage,"UCAC");
            }
        });

        epUserInfo.getHiB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //reset the page
                uHisInfo.getsDateText().setText("");
                uHisInfo.geteDateText().setText("");
                uHisInfo.getuHisInfo().remove(uHisInfo.getHisInfoSP());
                String eString[][] = new String[1][5];
                uHisInfo.setHisInfoTable(new JTable(eString, uHisInfo.getTitle()));
                uHisInfo.getHisInfoTable().setEnabled(false);
                uHisInfo.setHisInfoSP(new JScrollPane(uHisInfo.getHisInfoTable()));
                uHisInfo.getuHisInfo().add(BorderLayout.CENTER, uHisInfo.getHisInfoSP());
                uHisInfo.getuHisInfo().updateUI();

                currPage = "UHI";
                cardL.show(mainPage,"UHI");
            }
        });

        epUserInfo.getHbB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //reset the page
                uHisBill.getuHisBill().remove(uHisBill.getHisBillSP());
                uHisBill.setHisBillTable(new JTable(controlSys.getBillGet().billListGet(epUserInfo.getID()), uHisBill.getTitle()));
                uHisBill.getHisBillTable().setEnabled(false);
                uHisBill.setHisBillSP(new JScrollPane(uHisBill.getHisBillTable()));
                uHisBill.getuHisBill().add(BorderLayout.CENTER, uHisBill.getHisBillSP());
                uHisBill.getuHisBill().updateUI();

                currPage = "UHB";
                cardL.show(mainPage,"UHB");
            }
        });

        epSetTariff.getSetTariffB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlSys.getChangeTariff().readT();
                if(!epSetTariff.getNewTText1().getText().isEmpty()){            //if there is something entered in textField for electricity tariff
                    try{
                        if(Integer.parseInt(epSetTariff.getNewTText1().getText()) > 0){     //if what been entered is integer larger than 0
                            String[] tariff = controlSys.getChangeTariff().getTariff();
                            tariff[0] = epSetTariff.getNewTText1().getText();
                            controlSys.getChangeTariff().setTariff(tariff);
                            epSetTariff.getSetETDone().setVisible(true);
                            epSetTariff.getNewTText1().setText("");
                        }else{                                                              //if it's not a integer larger than 0
                            warning = new WarningDialog(myFrame,"Error: electricity tariff should be a integer larger than 0","OK");
                            warning.getButtonA().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    warning.getWarningDia().dispose();
                                }
                            });
                            warning.getWarningDia().setVisible(true);
                        }
                    }catch(Exception err){                                                  //if what been entered is not a integer
                        warning = new WarningDialog(myFrame,"Error: electricity tariff should be a integer larger than 0","OK");
                        warning.getButtonA().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                warning.getWarningDia().dispose();
                            }
                        });
                        warning.getWarningDia().setVisible(true);
                    }
                }
                if(!epSetTariff.getNewTText2().getText().isEmpty()){                        //if there is something entered in textField for electricity tariff
                    try{
                        if(Integer.parseInt(epSetTariff.getNewTText2().getText()) > 0){     //if what been entered is integer larger than 0
                            String[] tariff = controlSys.getChangeTariff().getTariff();
                            tariff[1] = epSetTariff.getNewTText2().getText();
                            controlSys.getChangeTariff().setTariff(tariff);
                            epSetTariff.getSetGTDone().setVisible(true);
                            epSetTariff.getNewTText2().setText("");
                        }else{                                                              //if it's not a integer larger than 0
                            warning = new WarningDialog(myFrame,"Error: gas tariff should be a number larger than 0","OK");
                            warning.getButtonA().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    warning.getWarningDia().dispose();
                                }
                            });
                            warning.getWarningDia().setVisible(true);
                        }
                    }catch(Exception err){                                                  //if what been entered is not a integer
                        warning = new WarningDialog(myFrame,"Error: gas tariff should be a number larger than 0","OK");
                        warning.getButtonA().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                warning.getWarningDia().dispose();
                            }
                        });
                        warning.getWarningDia().setVisible(true);
                    }
                }
                //refresh the data shown on screen
                controlSys.getChangeTariff().readT();
                epSetTariff.getcTariff().setText("        Current tariff:        ¡ê" + controlSys.getChangeTariff().getTariff()[0] + "                      ¡ê" + controlSys.getChangeTariff().getTariff()[1]);
            }
        });

    }

    /**
     * add Timer for refresh data and simulate user using electricity and cost
     */
    public void addTimer(){
        dataRefreshTimer = new Timer(1000, new ActionListener() {       //Timer for refresh consumption and cost today and this month
            @Override
            public void actionPerformed(ActionEvent e) {
                Meter meter = null;
                if(logType.equals("U")){                                        //if it's user login the system
                    meter = new Meter(cUser.getID());
                }else if(logType.equals("EP")){                                 //if it's provider checking user's inforamtion
                    meter = new Meter(epUserInfo.getID());
                }

                //refresh the data on page
                meter.checkCAC();
                uConsumpAndCost.getdEConsumpAndCost().setText("        Electricity:                           " +  meter.getCac().getdConsumptionAndCostS()[0] +
                            "kwh                ¡ê" +  meter.getCac().getdConsumptionAndCostS()[1]);
                uConsumpAndCost.getdGConsumpAndCost().setText("        Gas:                                    " +  meter.getCac().getdConsumptionAndCostS()[2] +
                            "m^3                ¡ê" +  meter.getCac().getdConsumptionAndCostS()[3]);
                uConsumpAndCost.gettEConsumpAndCost().setText("        Electricity:                           " +  meter.getCac().gettConsumptionAndCostS()[0] +
                            "kwh              ¡ê" +  meter.getCac().gettConsumptionAndCostS()[1]);
                uConsumpAndCost.gettGConsumpAndCost().setText("        Gas:                                    " +  meter.getCac().gettConsumptionAndCostS()[2] +
                            "m^3                ¡ê" +  meter.getCac().gettConsumptionAndCostS()[3]);

                if(logType.equals("U")){                                    //check if the usage is larger than budget when it's user using the system
                    if(ifWarned !=15){
                        if((ifWarned != 5) && (Double.parseDouble(controlSys.getBudget().getBudget(meter.getID()).get(0)) < Double.parseDouble(meter.getCac().gettConsumptionAndCostS()[1]))){
                            warning = new WarningDialog(myFrame,"Warning: your electricity cost this month has overflow!","Got it");
                            warning.getButtonA().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    ifWarned += 5;
                                    warning.getWarningDia().dispose();
                                }
                            });
                            warning.getWarningDia().setVisible(true);
                        }
                        if((ifWarned != 10) && (Double.parseDouble(controlSys.getBudget().getBudget(cUser.getID()).get(1)) < Double.parseDouble(meter.getCac().gettConsumptionAndCostS()[3]))){
                            warning = new WarningDialog(myFrame,"Warning: your gas cost this month has overflow!","Got it");
                            warning.getButtonA().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    ifWarned += 10;
                                    warning.getWarningDia().dispose();
                                }
                            });
                            warning.getWarningDia().setVisible(true);
                        }
                    }
                }
            }
        });

        simuEGUsed = new Timer(20000, new ActionListener() {        //Timer for simulate user using electricity and gas

            //this timer add 0.01kwh and 0.01m^3 to data every 20 second
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = 0;
                ArrayList<String> nameL= new ArrayList<>();
                ArrayList<String> dataD= new ArrayList<>();
                ArrayList<String> dataTM= new ArrayList<>();
                String dataL = "";
                String[] lastLine = new String[6];
                String[] genInfomation = new String[2];

                try{                                                            //get tariff
                    BufferedReader br = new BufferedReader(new FileReader(".\\genInfo.txt"));
                    int t = 0;
                    while((dataL = br.readLine()) != null){
                        genInfomation[t] = dataL.split("\t")[0];
                        t++;
                    }
                    br.close();
                }catch(Exception err){
                    System.err.println(err);
                }

                try{                                                            //get user list
                    BufferedReader bReader = new BufferedReader(new FileReader(".\\userList.txt"));
                    BufferedWriter bWriter = null;
                    while((dataL = bReader.readLine()) != null){
                        nameL.add(dataL);
                    }

                    for(int i = 0; i < nameL.size(); i++) {                     //for each user, add consumption and cost
                        dataD= new ArrayList<>();
                        dataTM= new ArrayList<>();
                        String fileName1 = ".\\" + nameL.get(i) + "D.txt";
                        String fileName2 = ".\\" + nameL.get(i) + "TM.txt";
                        bReader = new BufferedReader(new FileReader(fileName1));
                        while ((dataL = bReader.readLine()) != null) {
                            dataD.add(dataL);
                        }
                        bReader = new BufferedReader(new FileReader(fileName2));
                        while ((dataL = bReader.readLine()) != null) {
                            dataTM.add(dataL);
                        }

                        lastLine = dataD.get(dataD.size() - 1).split("\t");
                        lastLine[2] = String.format("%.2f", (Double.parseDouble(lastLine[2]) + 0.01));
                        lastLine[3] = String.format("%.2f", (Double.parseDouble(lastLine[3]) + (Double.parseDouble(genInfomation[0]) * 0.01)));
                        lastLine[4] = String.format("%.2f", (Double.parseDouble(lastLine[4]) + 0.01));
                        lastLine[5] = String.format("%.2f", (Double.parseDouble(lastLine[5]) + (Double.parseDouble(genInfomation[1]) * 0.01)));

                        dataL = "";
                        for(int j= 0; j < 5; j++){
                            dataL = dataL.concat(lastLine[j] + "\t");
                        }
                        dataL = dataL.concat(lastLine[5]);

                        bWriter = new BufferedWriter(new FileWriter(fileName1));
                        for(int j = 0; j < (dataD.size() - 1); j++){
                            bWriter.write(dataD.get(j) + "\r\n");
                            bWriter.flush();
                        }
                        bWriter.write(dataL + "\r\n");
                        bWriter.flush();
                        bWriter = new BufferedWriter(new FileWriter(fileName2));
                        for(int j = 0; j < (dataTM.size() - 1); j++){
                            bWriter.write(dataTM.get(j) + "\r\n");
                            bWriter.flush();
                        }
                        bWriter.write(dataL + "\r\n");
                        bWriter.flush();
                    }
                    bReader.close();
                    bWriter.close();
                }catch(Exception err){
                    System.err.println(err);
                }
            }
        });
    }
}