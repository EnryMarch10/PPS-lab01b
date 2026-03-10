package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public abstract class BankAccountTest {

    protected BankAccount account;

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        final int depositAmount = 1000;
        account.deposit(depositAmount);
        assertEquals(depositAmount, account.getBalance());
    }

//    @Test
//    void testInvalidDeposit() {
//        final int depositAmount = 1000;
//        account.deposit(depositAmount);
//        account.deposit(-depositAmount);
//        assertEquals(depositAmount, account.getBalance());
//    }

    @ParameterizedTest
    @CsvSource({
        "1000, 900",
        "100_000, 90_000"
    })
    public void testCanWithdraw(final int depositAmount, final int withdrawAmount) {
        assertTrue(withdrawAmount <= depositAmount);
        account.deposit(depositAmount);
        account.withdraw(withdrawAmount);
        assertEquals(depositAmount - withdrawAmount, account.getBalance());
    }

//    @Test
//    void testInvalidWithdraw() {
//        final int depositAmount = 1000;
//        account.deposit(depositAmount);
//        account.withdraw(-depositAmount);
//        assertEquals(depositAmount, account.getBalance());
//    }

//    @ParameterizedTest
//    @CsvSource({
//        "100, 101",
//        "100, 810"
//    })
//    public void testCannotWithdrawMoreThanAvailable(final int depositAmount, final int withdrawAmount){
//        assertTrue(withdrawAmount > depositAmount);
//        account.deposit(depositAmount);
//        account.withdraw(withdrawAmount);
//        assertEquals(depositAmount, account.getBalance());
//    }
}
