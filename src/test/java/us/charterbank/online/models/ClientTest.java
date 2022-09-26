package us.charterbank.online.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClientTest {

    static final Client CLIENT = new Client("Mark Spencer", "Kovar Rd, 3375, Foxborough, 02035, MA, USA");

    @Test
    @Order(9)
    void addAccount() {
        CLIENT.addAccount("CHECKING", 0.0);
        Assertions.assertThat(CLIENT.getUserAccountsAmount()).isEqualTo(1);
    }

    @Test
    @Order(13)
    void depositMoney() {
    }

    @Test
    @Order(10)
    void orderNewCard() {
        boolean result = CLIENT.orderNewCard();
        Assertions.assertThat(result).isTrue();
        Assertions.assertThat(CLIENT.getCards().size()).isEqualTo(1);
    }

    @Test
    @Order(11)
    void removeCard() {
    }

    @Test
    @Order(12)
    void withdrawMoney() {
    }

    @Test
    @Order(1)
    void getCards() {
        Assertions.assertThat(CLIENT.getCards()).isNullOrEmpty();
    }

    @Test
    @Order(2)
    void getClientAddress() {
        Address clientAddress = CLIENT.getClientAddress();
        Assertions.assertThat(clientAddress).hasToString("3375 Kovar Rd, Foxborough, MA 02035, USA");
    }

    @Test
    @Order(3)
    void getClientName() {
        String clientName = CLIENT.getClientName();
        Assertions.assertThat(clientName).isEqualTo("Mark Spencer");
    }

    @Test
    @Order(4)
    void getClientUserName() {
        String clientUserName = CLIENT.getClientUserName();
        Assertions.assertThat(clientUserName).isEqualTo("markspencer");
    }

    @Test
    @Order(5)
    void getClientUserPassword() {
        String clientUserPassword = CLIENT.getClientUserPassword();
        Assertions.assertThat(clientUserPassword).isEqualTo("markspencer123");
    }

    @Test
    @Order(6)
    void getGeneralBalance() {
        double generalBalance = CLIENT.getGeneralBalance();
        Assertions.assertThat(generalBalance).isEqualTo(0.0);
    }

    @Test
    @Order(7)
    void getUserAccounts() {
        Assertions.assertThat(CLIENT.getUserAccounts()).isNullOrEmpty();
    }

    @Test
    @Order(8)
    void getUserAccountsAmount() {
        int userAccountsAmount = CLIENT.getUserAccountsAmount();
        Assertions.assertThat(userAccountsAmount).isEqualTo(0);
    }
}