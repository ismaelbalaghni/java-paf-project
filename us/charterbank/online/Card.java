package us.charterbank.online;

import java.util.ArrayList;

public class Card {

	private String cardholderName;
	private String cardNumber;
	private String expirationDate;
	private String verificationCode;
	private Account linkedAccount;
	private double cardBalance = 0.0;

	private ArrayList<BankTransaction> bankTransactions = new ArrayList<BankTransaction>();

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

	public String getCardholderName() {
		return cardholderName;
	}

	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
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

	public void setCardBalance(double cardBalance) {
		this.cardBalance = cardBalance;
	}

	public ArrayList<BankTransaction> getBankTransactions() {
		return bankTransactions;
	}

	public void addTransaction(BankTransaction transaction){
		getBankTransactions().add(transaction);
	}
}
