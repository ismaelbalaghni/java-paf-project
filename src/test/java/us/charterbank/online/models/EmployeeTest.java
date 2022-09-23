package us.charterbank.online.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class EmployeeTest {

    private static final Employee EMPLOYEE = new Employee("John Sweeney", "Pearlman Ave, 1094, Franklin, 02038, MA", 1, "1987/06/25", "Counselor");

    @Test
    void getEmployeeNumber() {
        int employeeNumber = EMPLOYEE.getEmployeeNumber();
        Assertions.assertThat(employeeNumber).as("Numéro d'employé").isEqualTo(1);
    }

    @Test
    void getHireDate() {
        String hireDate = EMPLOYEE.getHireDate();
        Assertions.assertThat(hireDate).as("Date d'embauche de l'employé").isEqualTo("1987/06/25");
    }

    @Test
    void getFireDate() {
        String fireDate = EMPLOYEE.getFireDate();
        Assertions.assertThat(fireDate).isBlank();
    }

}