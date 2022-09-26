package us.charterbank.online.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonTest {

    private final Person testPerson = new Person("John Adams", "Tenmile Rd, 115, Foxborough, 02035, MA, USA");

    @Test
    void getName() {
        String name = testPerson.getName();
        Assertions.assertThat(name).as("Nom de la personne").isEqualTo("John Adams");
    }

    @Test
    void setName() {
        testPerson.setName("Andrew");
        String name = testPerson.getName();
        Assertions.assertThat(name).as("Nom de la personne").isEqualTo("Andrew");
    }

}