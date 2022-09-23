package us.charterbank.online.controllers;

import us.charterbank.online.views.BankView;
import us.charterbank.online.models.BankModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankController {

    private BankView bankView;
    private BankModel bankModel;

    public BankController(BankView bankView, BankModel bankModel) {
        this.bankView = bankView;
        this.bankModel = bankModel;

        this.bankView.addLoginListener(new LoginListener());
    }

    class LoginListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            String userName, userPassword = "";
            try {
                userName = bankView.getUserName();
                userPassword = bankView.getUserPass();
                bankModel.login(userName, userPassword);
                bankView.setLoginMessage(bankModel.getActiveClient().getClientName());
            } catch (Exception exception){
                bankView.showErrorMessage(exception.getMessage());
            }
        }
    }
}
