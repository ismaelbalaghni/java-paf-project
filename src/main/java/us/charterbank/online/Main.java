package us.charterbank.online;

import us.charterbank.online.models.Employee;
import us.charterbank.online.controllers.BankController;
import us.charterbank.online.models.BankModel;
import us.charterbank.online.models.Client;
import us.charterbank.online.views.BankView;

public class Main{

    public enum Positions{
        BRANCH_MANAGER, COUNSELOR
    }

    public static void initializeBank(BankModel bankModel){
        bankModel.addClient(new Client("John Adams", "Tenmile Rd, 115, Foxborough, 02035, MA"));
        bankModel.addClient(new Client("Mark Spencer", "Kovar Rd, 3375, Foxborough, 02035, MA"));
        bankModel.addClient(new Client("Sue Johnson", "Christie Way, 404, Foxborough, 02035, MA"));
        bankModel.hireEmployee(new Employee("John Sweeney", "Pearlman Ave, 1094, Franklin, 02038, MA", 1, "1987/06/25", Positions.BRANCH_MANAGER.name()));
        bankModel.hireEmployee(new Employee("April Griffin", "Randolph St, 2949, Mattapoisett, 02739, MA", 1988, "1993/04/30", Positions.COUNSELOR.name()));
        bankModel.hireEmployee(new Employee("Jack Harvey", "Cedar Lane, 2331, Boston, 02109, MA", 6544, "2006/10/21", Positions.COUNSELOR.name()));
        bankModel.hireEmployee(new Employee("Thomas Blankenship", "Valley View Dr, 2214, Boston, 02107, MA", 3501, "2001/04/10", Positions.COUNSELOR.name()));
        bankModel.hireEmployee(new Employee("Helen Banks", "Valley View Dr, 2061, Brookline, 02146, MA", 4788, "2003/12/01", Positions.COUNSELOR.name()));
    }

    public static void main(String[] args) {

        BankView bankView = new BankView();
        BankModel bankModel = new BankModel("Charter Bank", "2605 Farland St, Foxborough, MA 02035", "Mon-Sat 09.00am-05.00pm");
        initializeBank(bankModel);
        BankController bankController = new BankController(bankView, bankModel);
        bankView.setVisible(true);
    }
} // END OF Main
