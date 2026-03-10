package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class GoldBankAccountTest extends BankAccountTest {

    @BeforeEach
    void init(){
        this.account = new GoldBankAccount(new CoreBankAccount());
    }

    @ParameterizedTest
    @CsvSource({
        "100, 101",
        "100, 600"
    })
    public void testCanWithdrawMoreThanAvailableUpToFiveHundred(final int depositAmount, final int withdrawAmount) {
        account.deposit(depositAmount);
        account.withdraw(withdrawAmount);
        assertEquals(account.getBalance(), depositAmount - withdrawAmount);
    }

    @ParameterizedTest
    @CsvSource({
        "100, 700",
        "100, 601"
    })
    public void testCannotWithdrawMoreThanAvailablePlusFiveHundred(final int depositAmount, final int withdrawAmount) {
        assertTrue(withdrawAmount > depositAmount);
        account.deposit(depositAmount);
        assertThrows(IllegalStateException.class, () -> account.withdraw(withdrawAmount));
    }
}
