package us.charterbank.online.models;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Client extends Person implements Serializable {
    private int userAccountsAmount = 0;
    private double generalBalance = 0.0;
    private final String clientUserName;
    private final String clientUserPassword;
    private final ArrayList<Account> userAccounts = new ArrayList<>();
    private final ArrayList<Card> cards = new ArrayList<>();


    public Client(String clientName, String clientAddress) {
        super(clientName, clientAddress);
        this.clientUserName = clientName.trim().replace(" ", "").toLowerCase();
        this.clientUserPassword = this.clientUserName + "123";
    }

    public void addAccount(String accountType, double deposit) {
        Account newAccount = new Account(clientUserName, accountType, deposit);
        BankTransaction transaction = new BankTransaction("Credit", "Account Opening", deposit);
        newAccount.addAccountOperation(transaction);
        userAccounts.add(newAccount);
        userAccountsAmount++;
        generalBalance += deposit;
    }

    public void depositMoney(String accountNumber, double deposit) {
        Account activeAccount = this.userAccounts.stream()
                .filter(acct -> Integer.parseInt(acct.getAccountNumber()) == Integer.parseInt(accountNumber))
                .findFirst()
                .orElse(null);
        if (activeAccount != null) {
            activeAccount.depositMoney(deposit);
            generalBalance += deposit;
        }
    }

    public boolean orderNewCard() {
        SecureRandom rand = new SecureRandom();
        if(rand.ints(1, 100, 1000).findFirst().isPresent()){
            int cvv = rand.ints(1, 100, 1000).findFirst().getAsInt();
            String verificationCode = String.format("%03d", cvv);
            Card newCard = new Card(this.getClientName(), "5123456789102345", "07/07", verificationCode);
            Account linkedAccount = this.userAccounts.stream()
                    .filter(acct -> acct.getAccountType().equals("CHECKING")
                            && acct.getHolderName().equals(getClientName()))
                    .findFirst()
                    .orElse(null);

            newCard.setLinkedAccount(linkedAccount);
            return cards.add(newCard);
        } else {
            return false;
        }
    }

    public boolean removeCard(Card card) {
        return cards.remove(card);
    }

    public void withdrawMoney(String accountNumber, double withdraw) {
        Account activeAccount = this.userAccounts.stream()
                .filter(acct -> Integer.parseInt(acct.getAccountNumber()) == Integer.parseInt(accountNumber))
                .findFirst()
                .orElse(null);
        if (activeAccount != null) {
            activeAccount.withdrawMoney(withdraw);
            generalBalance -= withdraw;
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public final Address getClientAddress() {
        return this.getAddress();
    }

    public final String getClientName() {
        return this.getName();
    }

    public String getClientUserName() {
        return clientUserName;
    }

    public String getClientUserPassword() {
        return clientUserPassword;
    }

    public double getGeneralBalance() {
        return generalBalance;
    }

    public List<Account> getUserAccounts() {
        return userAccounts;
    }

    public int getUserAccountsAmount() {
        return userAccountsAmount;
    }

}