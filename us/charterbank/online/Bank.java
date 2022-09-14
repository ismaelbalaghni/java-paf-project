package us.charterbank.online;

import java.util.ArrayList;
import java.util.Date;

public class Bank {
    private String bankName;
    private String bankAddress;
    private String bankOpeningHours;
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();

    public Bank(String bankName, String bankAddress, String bankOpeningHours) {
        this.bankName = bankName;
        this.bankAddress = bankAddress;
        this.bankOpeningHours = bankOpeningHours;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public String getBankOpeningHours() {
        return bankOpeningHours;
    }

    public void setBankOpeningHours(String bankOpeningHours) {
        this.bankOpeningHours = bankOpeningHours;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void hireEmployee(Employee newEmployee){
        employees.add(newEmployee);
    }

    public boolean fireEmployee(Employee employee){
        employee.setFireDate(new Date().toString());
        return this.employees.remove(employee);
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public boolean addClient(Client client){
        return this.clients.add(client);
    }

    public boolean removeClient(Client client){
        return this.clients.remove(client);
    }
}
