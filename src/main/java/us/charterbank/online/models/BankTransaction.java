package us.charterbank.online.models;

import java.io.Serializable;

public class BankTransaction implements Serializable {

    private final String transactionType;

    private final String transactionName;

    private final double transactionAmount;

    public BankTransaction(String transactionType, String transactionName, double transactionAmount) {
        this.transactionType = transactionType;
        this.transactionName = transactionName;
        this.transactionAmount = transactionAmount;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    /*@Override
    public String toString() {
        return String.format("%-21s%-21s%-12f", transactionName, transactionType, transactionAmount);
    }*/
}
