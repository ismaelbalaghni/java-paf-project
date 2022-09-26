package us.charterbank.online.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BankTransactionTest {

    @ParameterizedTest
    @CsvSource({
            "Credit,AT&T Autopay,144.50,144.50",
            "Credit,Salary,3520.21,3520.21",
            "Debit,Netflix,19.99,19.99"
    })
    void getTransactionAmount(String transactionType, String transactionInfo, double transactionAmount, double expectedTransactionAmount) {
        BankTransaction transaction = new BankTransaction(transactionType, transactionInfo, transactionAmount);
        double amount = transaction.getTransactionAmount();
        Assertions.assertThat(amount).isEqualTo(expectedTransactionAmount);
    }

}