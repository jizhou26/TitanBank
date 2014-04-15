/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.tbk.domain;

//import java.util.Objects;

import java.text.DecimalFormat;


/**
 *
 * @author Zhou
 */
public class BankAccount {
    
//    static private int bankAccountId = 0;
    
    public enum AccountType {
        SAVING,
        CHECKING
    }
    
    private final Customer customer;
//    private final String accountNumber;
    private String accountName;
    private final AccountType type;
    private double balance;
    
    // Constructor
    public BankAccount(Customer customer, double startingBalance, AccountType type) {
//        bankAccountId++;
        
//        this.accountNumber = Integer.toString(bankAccountId);
        this.customer = customer;
        this.type = type;
        this.balance = startingBalance;
    }
    
    // Getter/Setter
    public Customer getCustomer() {
        return this.customer;
    }
    
//    public String getAccountNumber() {
//        return this.accountNumber;
//    }

    public String getAccountName() {
        return accountName;
    }
    
    public AccountType getType() {
        return type;
    }
    
    public double getBalance() {
        return this.balance;
    }

    public void setAccountName(String accoutName) {
        this.accountName = accoutName;
    }
    
//    @Override
//    public boolean equals(Object other) {
//        if (other == null) {
//            return false;
//        }
//        if (this.getClass() != other.getClass()) {
//                return false;
//        }
//        if (this.type != ((BankAccount)other).type) {
//            return false;
//        }
//        if (this.customerId != ((BankAccount)other).customerId) {
//            return false;
//        }
//        return this.accountNumber.equals(((BankAccount)other).accountNumber);
//    }

    // Method
    public String getBalanceString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return "$" + df.format(this.balance);
    }

    public boolean hasSufficientFunds(double amount){
        return this.balance >= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
    
    public void withdraw(double amount) throws InsufficientFundsException {
        if (hasSufficientFunds(amount)) {
            this.balance -= amount; 
        } else {
            throw new InsufficientFundsException();
        }
    }
}
