package it.unibo.pps.e1;

public class SilverBankAccount implements BankAccount {

    public static final int FEE_AMOUNT = 1;
    private final BankAccount base;

    public SilverBankAccount(final BankAccount bankAccount) {
        base = bankAccount;
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(final int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(final int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        base.withdraw(amount + FEE_AMOUNT);
    }
}
