package us.charterbank.online.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Client extends Person {
    private int userAccountsAmount = 0;
    private double generalBalance = 0.0;
    private String clientUserName;
    private String clientUserPassword;
    private final ArrayList<Account> userAccounts = new ArrayList<>();
    private final ArrayList<Card> cards = new ArrayList<>();
    private Employee counselor;

    public Client(String clientName, String clientAddress) {
        super(clientName, clientAddress);
        this.clientUserName = clientName.trim().replace(" ", "").toLowerCase();
        this.clientUserPassword = this.clientUserName + "123";
    }

    public boolean addExistingCard(Card card, Account account) {
        card.setLinkedAccount(account);
        return cards.add(card);
    }

    public void addNewAccount(Scanner scanner) {
        System.out.print("What kind of account do you want to create [CHECKING/SAVINGS/STOCKS]? ");
        String desiredAcctType = scanner.nextLine();
        System.out.print("You need to deposit money to open the account. How much would you like to deposit? $");
        double depositAmount = scanner.nextInt();
        scanner.nextLine();
        Account newAccount = new Account(getClientName(), desiredAcctType, depositAmount);
        BankTransaction transaction = new BankTransaction("Credit", "Account Opening", depositAmount);
        newAccount.addAccountOperation(transaction);
        getUserAccounts().add(newAccount);
        userAccountsAmount++;
        generalBalance += depositAmount;
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void depositMoney(Scanner scanner) {
        System.out.println("Here are your accounts:");
        System.out.println(getUserAccounts());
        System.out.print("To which account you want to deposit money? ");
        int accountNumber = scanner.nextInt();
        System.out.print("How much money would you like to deposit? $");
        double depositAmount = scanner.nextInt();
        scanner.nextLine();

        Account activeAccount = this.userAccounts.stream()
                .filter(acct -> Integer.parseInt(acct.getAccountNumber()) == accountNumber)
                .findFirst()
                .orElse(null);
        if (activeAccount != null) {
            activeAccount.depositMoney(depositAmount);
            generalBalance += depositAmount;
        } else {
            System.err.println("You have no accounts!");
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public boolean orderNewCard() {
        Random rand = new Random();
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

    public void withdrawMoney(Scanner scanner) {
        // Show user accounts
        System.out.println("Here are your accounts:");
        System.out.println(getUserAccounts());
        System.out.print("From which account you want to withdraw money? ");
        int accountNumber = scanner.nextInt();
        System.out.print("How much money would you like to withdraw? $");
        double withdrawAmount = scanner.nextInt();
        scanner.nextLine();

        Account activeAccount = this.userAccounts.stream()
                .filter(acct -> Integer.parseInt(acct.getAccountNumber()) == accountNumber)
                .findFirst()
                .orElse(null);
        if (activeAccount != null) {
            activeAccount.withdrawMoney(withdrawAmount);
            generalBalance -= withdrawAmount;
        } else {
            System.err.println("You have no accounts!");
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void transferMoney(Scanner scanner){
        System.out.print("How much would you like to transfer? ");
        double transferAmount = scanner.nextDouble();
        withdrawMoney(scanner);
        System.out.print("Please enter the account number of the recipient: ");
        scanner.nextLine();
        int recipientAcctNumber = scanner.nextInt();
        System.out.format("Transferring $%f to the account number %d...%n", transferAmount, recipientAcctNumber);
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public int getCardAmounts() {
        return cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }

    public final Address getClientAddress() {
        return this.getAddress();
    }

    public final void setClientAddress(String clientAddress) {
        this.setAddress(clientAddress);
    }

    public final String getClientName() {
        return this.getName();
    }

    public final void setClientName(String clientName) {
        this.setName(clientName);
    }

    public String getClientUserName() {
        return clientUserName;
    }

    public void setClientUserName(String clientUserName) {
        this.clientUserName = clientUserName;
    }

    public String getClientUserPassword() {
        return clientUserPassword;
    }

    public void setClientUserPassword(String clientUserPassword) {
        this.clientUserPassword = clientUserPassword;
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

    public void showAccountOperations(){
        System.out.println("\tAll Accounts Operations\t");
        for(Account account : getUserAccounts()){
            System.out.println(account);
            System.out.format("%-21s%-21s%-12s%n", "Transaction name", "Transaction type", "Amount");
            for (BankTransaction transaction : account.getAccountMovements()){
                System.out.println(transaction);
            }
        }
        System.out.println("\tAll Cards Operations\t");
        for(Card card : getCards()){
            System.out.println(card);
            for(BankTransaction transaction : card.getBankTransactions()){
                System.out.println(transaction);
            }
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();
    } // END OF showAccountOperations

    public void assignCounselor(Employee counselor){
        this.counselor = counselor;
    }

    public Employee getCounselor(){
        return counselor;
    }

    public void showCounselorInfo(){
        System.out.println(getCounselor());
    }
}