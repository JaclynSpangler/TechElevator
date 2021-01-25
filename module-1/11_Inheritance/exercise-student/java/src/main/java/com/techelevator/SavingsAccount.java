package com.techelevator;

public class SavingsAccount extends BankAccount{
    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        int fee = 2;
        int minBalance = 150;
        int currentBalance = getBalance();
        if(currentBalance - amountToWithdraw < minBalance && currentBalance- (amountToWithdraw + fee) >= 0) {
            currentBalance = super.withdraw(amountToWithdraw + 2);
        }else if(currentBalance > amountToWithdraw){
            currentBalance = super.withdraw(amountToWithdraw);
        }
        return currentBalance;
    }
}
