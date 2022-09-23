package us.charterbank.online.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assertions;

class AccountTest {

    private static final Account ACCOUNT = new Account("Mark Johnson", "SAVINGS", 9541.22);

    @Test
    void getHolderName() {
        String name = ACCOUNT.getHolderName();
        assertEquals("Mark Johnson", name, "Les noms ne sont pas identiques.");
    }

    @Test
    void getAccountType() {
        String accountType = ACCOUNT.getAccountType();
        assertEquals("SAVINGS", accountType, "Les types de comptes ne sont pas identiques.");
    }

}