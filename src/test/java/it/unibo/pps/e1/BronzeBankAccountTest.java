package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class BronzeBankAccountTest extends BankAccountTest {

    @BeforeEach
    void init(){
        this.account = new BronzeBankAccount(new CoreBankAccount());
    }

    @ParameterizedTest
    @CsvSource({
        "3000, 99",
        "3000, 100"
    })
    @Override
    public void testCanWithdraw(final int depositAmount, final int withdrawAmount) {
        assertTrue(withdrawAmount < depositAmount);
        account.deposit(depositAmount);
        account.withdraw(withdrawAmount);
        assertEquals(depositAmount - withdrawAmount - (withdrawAmount < 100 ? 0 : 1), account.getBalance());
    }

    @ParameterizedTest
    @CsvSource({
        "100, 101",
        "100, 810"
    })
    public void testCannotWithdrawMoreThanAvailable(final int depositAmount, final int withdrawAmount) {
        assertTrue(withdrawAmount > depositAmount);
        account.deposit(depositAmount);
        assertThrows(IllegalStateException.class, () -> account.withdraw(withdrawAmount));
    }
}
