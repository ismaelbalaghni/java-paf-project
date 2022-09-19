package us.charterbank.online.models;

public class BankTransaction {

    private String transactionType;

    private String transactionName;

    private double transactionAmount;

    public BankTransaction(String transactionType, String transactionName, double transactionAmount) {
        this.transactionType = transactionType;
        this.transactionName = transactionName;
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Override
    public String toString() {
        return String.format("%-21s%-21s%-12f", transactionName, transactionType, transactionAmount);
    }
}
