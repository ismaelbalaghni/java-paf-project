package us.charterbank.online.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeTest {

    private static final Employee EMPLOYEE = new Employee("John Sweeney", "Pearlman Ave, 1094, Franklin, 02038, MA, USA", 1, "1987/06/25", "Counselor");

    @Test
    @Order(1)
    void getEmployeeNumber() {
        int employeeNumber = EMPLOYEE.getEmployeeNumber();
        Assertions.assertThat(employeeNumber).as("Numéro d'employé").isEqualTo(1);
    }

    @Test
    @Order(2)
    void getHireDate() {
        String hireDate = EMPLOYEE.getHireDate();
        Assertions.assertThat(hireDate).as("Date d'embauche de l'employé").isEqualTo("1987/06/25");
    }

    @Test
    @Order(3)
    void getFireDate() {
        String fireDate = EMPLOYEE.getFireDate();
        Assertions.assertThat(fireDate).isBlank();
    }


    @Test
    @Order(4)
    void setFireDate() {
        EMPLOYEE.setFireDate("2003/11/21");
        String fireDate = EMPLOYEE.getFireDate();
        Assertions.assertThat(fireDate).as("Date de licenciement de l'employé").isEqualTo("2003/11/21");
    }

    @Test
    @Order(5)
    void setService() {
        EMPLOYEE.setService("Regional Manager");
        Assertions.assertThat(EMPLOYEE.service).isEqualTo("Regional Manager");
    }
}