package us.charterbank.online.models;

import java.io.Serializable;

public class Employee extends Person implements Serializable {

    protected int employeeNumber = 0;
    protected String hireDate;
    protected String fireDate;

    protected String service;

    public Employee(String name, String address, int employeeNumber, String hireDate, String service) {
        super(name, address);
        this.employeeNumber = employeeNumber;
        this.hireDate = hireDate;
        this.service = service;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getHireDate() {
        return hireDate;
    }

    public String getFireDate() {
        return fireDate;
    }

    public void setFireDate(String fireDate) {
        this.fireDate = fireDate;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", hireDate='" + hireDate + '\'' +
                ", fireDate='" + fireDate + '\'' +
                ", service='" + service + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
