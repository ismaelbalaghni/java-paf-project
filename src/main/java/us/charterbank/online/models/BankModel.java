package us.charterbank.online.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankModel {
    private String bankName;
    private String bankAddress;
    private String bankOpeningHours;
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();

    private Client activeClient;

    public BankModel(String bankName, String bankAddress, String bankOpeningHours) {
        this.bankName = bankName;
        this.bankAddress = bankAddress;
        this.bankOpeningHours = bankOpeningHours;
    }

    public String getBankName() {
        return bankName;
    }

    public void hireEmployee(Employee newEmployee){
        employees.add(newEmployee);
    }

    public boolean fireEmployee(Employee employee){
        employee.setFireDate(new Date().toString());
        return this.employees.remove(employee);
    }

    public List<Client> getClients() {
        return clients;
    }

    public boolean addClient(Client client){
        return this.clients.add(client);
    }

    public boolean removeClient(Client client){
        return this.clients.remove(client);
    }

    public void login(String userName, String userPassword) {
        for (Client client: clients) {
            if (client.getClientUserName().equals(userName) && client.getClientUserPassword().equals(userPassword)){
                activeClient = client;
                break;
            }
        }
    }

    public Client getActiveClient(){
        return activeClient;
    }
}
