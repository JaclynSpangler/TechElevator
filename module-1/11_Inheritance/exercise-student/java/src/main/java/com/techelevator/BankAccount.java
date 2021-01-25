package com.techelevator;

import java.math.BigDecimal;

public class BankAccount {

    private String accountHolderName;
    private String accountNumber;
    private BigDecimal balance;

    //constructor

    public BankAccount(String accountHolderName, String accountNumber){
        this.accountHolderName = accountHolderName;
        this.accountNumber= accountNumber;
        this.balance = BigDecimal.ZERO;
    }

    public BankAccount(String accountHolderName, String accountNumber, int balance){
        this.accountHolderName = accountHolderName;
        this.accountNumber= accountNumber;
        this.balance= BigDecimal.valueOf(balance);
    }

    //getters
    public String getAccountHolderName(){
        return accountHolderName;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public int getBalance(){
        return balance.intValue();
    }

    //methods

    public int deposit(int amountToDeposit) {
        int currentBalance = balance.intValue();
        if (amountToDeposit > 0) {
            currentBalance += amountToDeposit;
            balance = BigDecimal.valueOf(currentBalance);

        }
        return currentBalance;
    }

        public int withdraw ( int amountToWithdraw){
        int currentBalance = balance.intValue();
            if (amountToWithdraw > 0) {
                currentBalance -= amountToWithdraw;
                balance = BigDecimal.valueOf(currentBalance);

            }
            return currentBalance;
        }
    }
