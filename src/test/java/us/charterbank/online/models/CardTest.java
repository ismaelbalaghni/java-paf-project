package us.charterbank.online.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CardTest {

    private static final Card CARD = new Card("Arun Bleachley", "4123456789012345", "09/27", "914");
    BankTransaction transaction = new BankTransaction("DEBIT", "STARBUCKS FRESNO", 84.20);


    @Test
    void getLinkedAccount() {
        Assertions.assertThat(CARD.getLinkedAccount()).as("Compte bancaire lié à la carte").isNull();
    }

    @Test
    void setLinkedAccount() {
        Account testAccount = new Account("Arun Bleachley", "CHECKING", 14788.21);
        CARD.setLinkedAccount(testAccount);
        Assertions.assertThat(CARD.getLinkedAccount()).as("Compte bancaire lié à la carte").isEqualTo(testAccount);
    }

    @Test
    void getCardBalance() {
        double cardBalance = CARD.getCardBalance();
        Assertions.assertThat(cardBalance).as("Encours de la carte").isEqualTo(84.20);
    }

    /*@Test
    void getBankTransactions() {
        Assertions.assertThat(CARD.getBankTransactions()).as("Liste des transactions de la carte").contains(transaction);
    }*/

    @Test
    void addTransaction() {
        CARD.addTransaction(transaction);
        Assertions.assertThat(CARD.getCardBalance()).as("Encours de la carte après transaction").isEqualTo(84.20);
        Assertions.assertThat(CARD.getBankTransactions()).as("Liste des transactions de la carte").contains(transaction);
    }
}