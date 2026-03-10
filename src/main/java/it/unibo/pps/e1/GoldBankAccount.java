package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount {

    public static final int OVERDRAFT = 500;
    private final BankAccount base;

    public GoldBankAccount(final BankAccount bankAccount) {
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
        if (this.getBalance() + OVERDRAFT < amount){
            throw new IllegalStateException();
        }
        base.withdraw(amount);
    }
}
