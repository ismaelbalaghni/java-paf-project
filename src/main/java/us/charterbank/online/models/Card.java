package us.charterbank.online.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Card implements Serializable {

	private String cardholderName;
	private String cardNumber;
	private String expirationDate;
	private String verificationCode;
	private Account linkedAccount;
	private double cardBalance = 0.0;

	private final ArrayList<BankTransaction> bankTransactions = new ArrayList<>();

	public Card(String cardholderName) {
		this.cardholderName = cardholderName;
	}

	public Card(String cardholderName, Account linkedAccount) {
		this(cardholderName);
		this.linkedAccount = linkedAccount;
	}

	public Card(String cardholderName, String cardNumber, String expirationDate, String verificationCode) {
		this.cardholderName = cardholderName;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.verificationCode = verificationCode;
	}

	public Account getLinkedAccount() {
		return linkedAccount;
	}

	public void setLinkedAccount(Account linkedAccount) {
		this.linkedAccount = linkedAccount;
	}

	public double getCardBalance() {
		return cardBalance;
	}

	public List<BankTransaction> getBankTransactions() {
		return bankTransactions;
	}

	public void addTransaction(BankTransaction transaction){
		bankTransactions.add(transaction);
		cardBalance += transaction.getTransactionAmount();
	}
}
