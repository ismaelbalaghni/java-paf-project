package us.charterbank.online.models;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountTest {

    private static final Account ACCOUNT = new Account("Mark Johnson", "SAVINGS", 9541.22);

    @Test
    @Order(1)
    void getHolderName() {
        String name = ACCOUNT.getHolderName();
        assertEquals("Mark Johnson", name, "Les noms ne sont pas identiques.");
    }

    @Test
    @Order(2)
    void getAccountType() {
        String accountType = ACCOUNT.getAccountType();
        assertEquals("SAVINGS", accountType, "Les types de comptes ne sont pas identiques.");
    }

    @Test
    @Order(3)
    void getAccountMovements() {
        ArrayList<BankTransaction> bankTransactions = (ArrayList<BankTransaction>) ACCOUNT.getAccountMovements();
        Assertions.assertThat(bankTransactions).as("Transactions du compte").isEqualTo(new ArrayList<BankTransaction>());
    }

    @Test
    @Order(4)
    void addAccountOperation() {
        BankTransaction transaction = new BankTransaction("DEBIT", "AT&T Autopay", 65.20);
        ACCOUNT.addAccountOperation(transaction);
        Assertions.assertThat(ACCOUNT.getAccountMovements()).as("Transactions du compte").contains(transaction);
    }

    @Test
    @Order(5)
    void depositMoney() {
        double depositAmount = 144.322;
        double newAccountBalance = ACCOUNT.depositMoney(depositAmount);
        Assertions.assertThat(newAccountBalance).as("Nouveau solde").isEqualTo(9541.22+144.322);
        BankTransaction transaction = new BankTransaction("Credit", "One-time Deposit", depositAmount);
        Assertions.assertThat(ACCOUNT.getAccountMovements()).containsExactlyInAnyOrder(transaction);
    }

    @ParameterizedTest
    @CsvSource({
            "15.20, true",
            "410.22, true",
            "1400.21, true",
            "98774.321, false"
    })
    @Order(6)
    void withdrawMoney(double withdraw, boolean expectedResult) {
        boolean result = ACCOUNT.withdrawMoney(withdraw);
        Assertions.assertThat(result).as("Résultat du retrait d'argent").isEqualTo(expectedResult);
    }
}