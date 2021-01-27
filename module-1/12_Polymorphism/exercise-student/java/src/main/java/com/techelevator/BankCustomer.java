package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer implements Accountable{
    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();
//getter & setters

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public Accountable[] getAccounts(){
        return accounts.toArray(new Accountable[0]);
    }

    @Override
    public int getBalance() {
        return 0;
    }
    public void addAccount(Accountable newAccount){
        accounts.add(newAccount);

    }
    public boolean isVip(){
        boolean vip = false;
        int vipMin = 25000;
        int accountTotal= 0;
        for(Accountable account : accounts) {
            accountTotal = accountTotal + account.getBalance();
        } if(accountTotal >= vipMin){
                vip = true;
            }
        return vip;
    }

}
