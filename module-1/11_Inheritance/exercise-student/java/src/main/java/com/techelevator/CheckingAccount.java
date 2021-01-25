package com.techelevator;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {

        int overdraftFee = 10;
        int minBalance = -100;
        int currentBalance = getBalance();
        if (currentBalance > minBalance && currentBalance <= 0) {
            currentBalance = super.withdraw(amountToWithdraw + overdraftFee);
        } if (currentBalance > amountToWithdraw) {
            currentBalance = super.withdraw(amountToWithdraw);
        }
        return currentBalance;
    }
}
