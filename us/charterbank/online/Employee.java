package us.charterbank.online;

public class Employee extends Person{

    protected int employeeNumber = 0;
    protected String hireDate, fireDate;

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

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getFireDate() {
        return fireDate;
    }

    public void setFireDate(String fireDate) {
        this.fireDate = fireDate;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
