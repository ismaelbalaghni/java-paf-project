package us.charterbank.online.controllers;

import us.charterbank.online.models.Bank;
import us.charterbank.online.models.Client;
import us.charterbank.online.models.Employee;

import java.util.Scanner;

public class Main{

    public enum Positions{
        BRANCH_MANAGER, COUNSELOR
    }

    static Scanner userInput = new Scanner(System.in);

    static Bank bank;

    static Employee branchManager;
    static Employee counselor1;
    static Employee counselor2;
    static Employee counselor3;
    static Employee counselor4;

    static Client exampleClient;
    static Client exampleClient2;
    static Client exampleClient3;

    public static void initializeBank(){
        bank = new Bank("Charter Bank", "2605 Farland St, Foxborough, MA 02035", "Mon-Sat 09.00am-05.00pm");
        exampleClient = new Client("John Adams", "Tenmile Rd, 115, Foxborough, 02035, MA");
        exampleClient2 = new Client("Mark Spencer", "Kovar Rd, 3375, Foxborough, 02035, MA");
        exampleClient3 = new Client("Sue Johnson", "Christie Way, 404, Foxborough, 02035, MA");
        bank.addClient(exampleClient);
        bank.addClient(exampleClient2);
        bank.addClient(exampleClient3);
        branchManager = new Employee("John Sweeney", "Pearlman Ave, 1094, Franklin, 02038, MA", 1, "1987/06/25", Positions.BRANCH_MANAGER.name());
        counselor1 = new Employee("April Griffin", "Randolph St, 2949, Mattapoisett, 02739, MA", 1988, "1993/04/30", Positions.COUNSELOR.name());
        counselor2 = new Employee("Jack Harvey", "Cedar Lane, 2331, Boston, 02109, MA", 6544, "2006/10/21", Positions.COUNSELOR.name());
        counselor3 = new Employee("Thomas Blankenship", "Valley View Dr, 2214, Boston, 02107, MA", 3501, "2001/04/10", Positions.COUNSELOR.name());
        counselor4 = new Employee("Helen Banks", "Valley View Dr, 2061, Brookline, 02146, MA", 4788, "2003/12/01", Positions.COUNSELOR.name());
        bank.hireEmployee(branchManager);
        bank.hireEmployee(counselor1);
        bank.hireEmployee(counselor2);
        bank.hireEmployee(counselor3);
        bank.hireEmployee(counselor4);
        exampleClient.assignCounselor(counselor2);
        exampleClient2.assignCounselor(counselor4);
        exampleClient3.assignCounselor(counselor1);
    }

    public static void main(String[] args) {
        initializeBank();
		Client activeClient;
        boolean appRunning = true;

        // Verifies that the client exists in the "database"
        System.out.format("Welcome to %s. Please enter your username: ", bank.getBankName());
        String userName = userInput.nextLine();
        activeClient = bank.getClients().stream().filter(clt -> clt.getClientUserName().equals(userName)).findFirst().orElse(null);

        // The client does not exist
		if(activeClient == null){
			System.out.print("It appears that you are not a client yet. Would you like to create an account with us? ");
			if(userInput.nextLine().equals("y")){
				System.out.print("We need some information about you. What's your name? ");
				String clientName = userInput.nextLine();
				System.out.format("Welcome %s. Where do you live (street name, street no, city, zip code, state)? ", clientName);
				String clientAddress = userInput.nextLine();
				activeClient = new Client(clientName, clientAddress);
                System.out.println(activeClient.getClientAddress());
			} else {
                System.out.println("You do not need to use this application. Good bye.");
                userInput.close();
                System.exit(1);
            }
		} else {
			int tries = 1;
            System.out.format("Welcome %s.%n", userName);
			do {
                System.out.format("Please enter your password (attempt %d of 3): ", tries);
                String userPassword = userInput.nextLine();
				if (activeClient.getClientUserPassword().equals(userPassword)) {
					System.out.println("Logging...");
                    break;
				} else {
					System.err.println("Incorrect password!");
                    if(tries == 3){
                        System.out.println("It seems you have forgotten your password. Please call your local branch to reset it. Good bye.");
                        System.exit(1);
                    }
                    tries++;
				}
			} while(tries <= 3);

		}
        if (activeClient.getUserAccountsAmount() == 0) {
            System.out.print("It appears that you do not own any account with us. Would you like to open one? ");
            if (userInput.nextLine().equals("y")) {
                activeClient.addNewAccount(userInput);
            } else {
                System.out.println("You do not need to use this application. Good bye.");
                userInput.close();
                System.exit(1);
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        do {
            System.out.format("Your total balance is: $%(,.2f%n", activeClient.getGeneralBalance());
            System.out.println("""
                    Here is what you can do:
                    1/\tWithdraw money
                    2/\tDeposit money
                    3/\tOpen a new account
                    4/\tContact your counselor
                    5/\tOrder a new card
                    6/\tOrder a new cheque
                    7/\tMake a bank transfer
                    8/\tShow account operations
                    9/\tLog out.""");
            System.out.print("Enter your choice (1/2/3/4/5/6/7/8/9): ");
            int userChoice = userInput.nextInt();
            userInput.nextLine();
            switch (userChoice) {
                case 1 -> activeClient.withdrawMoney(userInput);
                case 2 -> activeClient.depositMoney(userInput);
                case 3 -> activeClient.addNewAccount(userInput);
                case 4 -> activeClient.showCounselorInfo();
                case 5 -> System.out.println("The Card order feature is not yet implemented.");
                case 6 -> System.out.println("The Cheque order feature is not yet implemented");
                case 7 -> activeClient.transferMoney(userInput);
                case 8 -> activeClient.showAccountOperations();
                case 9 -> {
                    System.out.println("Logging out... Good bye.");
                    appRunning = false;
                    System.exit(0);
                }
                default -> System.out.println("Unknown command.");
            }
        } while(appRunning);
        userInput.close();
    }
} // END OF Main
