import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	static Scanner userInput = new Scanner(System.in);
	static Client exampleClient = new Client("John Adams", "2501 W 3rd St, Bloomington, 47404 IA");
	static ArrayList<Client> bankClients = new ArrayList<Client>();

	public static void generateReceipt(Client client) {
		System.out.println("\t\t\tCharter Bank\t\t\t\n1451, Smith Ave, Rochester Hills, 03501 NY");
		System.out.println("Client: " + client.getClientName());
		System.out.println("Client Address: " + client.getClientAddress());
		System.out.println("Bank Account Number: 0214145521");
		System.out.println("Account balance: $99643.32");
	}

	public static void main(String args[]) {
		bankClients.add(exampleClient);
		Client activeClient = null;

		System.out.print("Welcome to Charter Bank. Please enter your username: ");
		String userName = userInput.nextLine();
		System.out.print("Welcome " + userName + ". Please enter your password: ");
		String userPassword = userInput.nextLine();
		for (Client client : bankClients) {
			if (client.getClientUserName().equals(userName) && client.getClientUserPassword().equals(userPassword)) {
				activeClient = client;
			}
		}
		try {
			System.out.println("Welcome " + activeClient.getClientName());
		} catch (NullPointerException e) {
			activeClient = exampleClient;
			System.out.println("Welcome " + activeClient.getClientName());
		}
		int withdrawAmount = 0, depositAmount = 0;
		if (activeClient.getUserAccountsAmount() == 0) {
			System.out.print("It appears that you do not own any bank account with us. Would you like to open one? ");
			if (userInput.nextLine().equals("y")) {
				createAccount(activeClient);
			} else {
				System.out.println("Good bye.");
				userInput.close();
				System.exit(0);
			}
		}
		System.out.println("Your total balance is: $" + Double.toString(activeClient.getGeneralBalance()));
		System.out.println(
				"Here is what you can do:\n1. Withdraw money\n2. Deposit money\n3. Contact your counselor\n4. Order a new card\n5. Order a new cheque\n6. Make a bank transfer\n7. Log out.");
		System.out.print("Enter your choice (1/2/3/4/5/6/7): ");
		int userChoice = userInput.nextInt();
		switch (userChoice) {
		case 1:
			System.out.println("Here are your accounts:");
			System.out.println(activeClient.getUserAccounts());
			System.out.print("From which account you want to withdraw money? ");
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		default:
			System.out.println("Unknown command.");
			break;
		}
		userInput.close();
	}

	private static void createAccount(Client client) {
		int depositAmount;
		System.out.print("To open a checking account, you need to deposit money. How much would you like to deposit? $");
		depositAmount = userInput.nextInt();
		client.addNewAccount("CHECKING", depositAmount);
		System.out.println("Welcome! Your bank account is open.");
	}
}
