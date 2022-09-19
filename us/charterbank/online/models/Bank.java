package us.charterbank.online.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = (ArrayList<Employee>) employees;
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

    public void setClients(List<Client> clients) {
        this.clients = (ArrayList<Client>) clients;
    }

    public boolean addClient(Client client){
        return this.clients.add(client);
    }

    public boolean removeClient(Client client){
        return this.clients.remove(client);
    }
}
