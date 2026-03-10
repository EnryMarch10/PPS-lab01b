package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class SilverBankAccountTest extends BankAccountTest {

    @BeforeEach
    void init(){
        this.account = new SilverBankAccount(new CoreBankAccount());
    }

    @ParameterizedTest
    @CsvSource({
        "1000, 900",
        "100_000, 90_000"
    })
    @Override
    public void testCanWithdraw(final int depositAmount, final int withdrawAmount) {
        account.deposit(depositAmount);
        account.withdraw(withdrawAmount);
        assertEquals(depositAmount - withdrawAmount - SilverBankAccount.FEE_AMOUNT, account.getBalance());
    }

    @ParameterizedTest
    @CsvSource({
        "100, 101",
        "100, 810"
    })
    public void testCannotWithdrawMoreThanAvailable(final int depositAmount, final int withdrawAmount) {
        assertTrue(withdrawAmount > depositAmount);
        account.deposit(depositAmount);
        assertThrows(IllegalStateException.class,
            () -> account.withdraw(withdrawAmount));
    }
}
