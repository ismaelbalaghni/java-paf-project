package us.charterbank.online.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Account implements Serializable {

	private String holderName;
	private final String accountType;
	private final String accountNumber;
	private double accountBalance = 0.0;
	private final ArrayList<BankTransaction> bankTransactions = new ArrayList<>();

	public Account(String holderName, String accountType) {
		this.holderName = holderName;
		this.accountType = accountType;
		Random rand = new Random();
		int acctNumber = rand.ints(1, 1, 1000000000).findFirst().getAsInt();
		this.accountNumber = String.format("%08d", acctNumber);
	}

	public Account(String holderName, String accountType, double accountBalance) {
		this(holderName, accountType);
		this.holderName = holderName;
		this.accountBalance += accountBalance;
	}

	public final String getHolderName() {
		return holderName;
	}

	public final String getAccountType() {
		return accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public List<BankTransaction> getAccountMovements() {
		return bankTransactions;
	}

	public void addAccountOperation(BankTransaction accountOperation) {
		this.bankTransactions.add(accountOperation);
	}

	public double depositMoney(double deposit) {
		BankTransaction transaction = new BankTransaction("Credit", "One-time Deposit", deposit);
		accountBalance += deposit;
		addAccountOperation(transaction);
		return accountBalance;
	}

	public boolean withdrawMoney(double withdraw) {
		BankTransaction transaction = new BankTransaction("Debit", "One-time Withdraw", withdraw);
		if (accountBalance - withdraw < 0) {
			return false;
		} else {
			accountBalance -= withdraw;
			addAccountOperation(transaction);
			return true;
		}
	}

	@Override
	public String toString() {
		return String.format("%-21sNO. %-17sBALANCE: $%-12f", accountType, accountNumber, accountBalance);
	}

}
