package it.unibo.pps.e1;

class CoreBankAccount implements BankAccount {

    private int balance;

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void deposit(final int amount) {
        balance = balance + amount;
    }

    @Override
    public void withdraw(final int amount) {
        balance = balance - amount;
    }
}
