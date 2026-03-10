package it.unibo.pps.e1;

public class BronzeBankAccount implements BankAccount {

    private final BankAccount base;

    public BronzeBankAccount(final BankAccount bankAccount) {
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
        final int fee = amount < 100 ? 0 : 1;
        base.withdraw(amount + fee);
    }
}
