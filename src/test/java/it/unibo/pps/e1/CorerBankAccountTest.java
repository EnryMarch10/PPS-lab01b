package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;

public class CorerBankAccountTest extends BankAccountTest {

    @BeforeEach
    void init(){
        this.account = new CoreBankAccount();
    }
}
