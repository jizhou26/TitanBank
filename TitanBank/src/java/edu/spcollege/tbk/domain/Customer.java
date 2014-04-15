/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.tbk.domain;


//import java.util.Objects;

/**
 *
 * @author Zhou
 */
public class Customer {
//    static private int customerId = 0;
//    private final int id;
    private final String firstName;
    private final String lastName;
    
    // Constructor
    public Customer(String firstName, String lastName) {
//        customerId++;
//        this.id = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getter/Setter
//    public int getId() {
//        return this.id;
//    }
    
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
    
    
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }
//        return this.id == ((Customer)other).id;
        //temp
        return this.getFullName().equals( ((Customer)other).getFullName() );
    }

    
    // Method
//    public boolean createLoginAccount(String username, String password) {
//        if (this.loginAccount == null) {
//            this.loginAccount = new User(this.id, username, password);
//            return true;
//        }
//        return false;
//    }
//
//    public double viewSavingBalance(String accountNumber) {
//        return this.bankAccounts.getSavingBalance(accountNumber);
//    }
//    
//    public double viewCheckingBalance(String accountNumber) {
//        return this.bankAccounts.getCheckingBalance(accountNumber);
//    }
//    
//    public String[][] viewTransferRecords() {
//        return this.transferRecords.getRecordsData();
//    }
//    
//    public boolean transferFunds(String fromAccountNumber,
//                                   BankAccountType fromType,
//                                   String toAccountNumber,
//                                   BankAccountType toType,
//                                   double amount,
//                                   Date activeDate)
//    {
//        BankAccount fromAccount;
//        BankAccount toAccount;
//
//        if (fromType == BankAccountType.Saving) {
//            fromAccount = this.bankAccounts.getSavingAccount(fromAccountNumber);
//        } else {
//            fromAccount = this.bankAccounts.getCheckingAccount(fromAccountNumber);
//        }
//        
//        if (toType == BankAccountType.Saving) {
//            toAccount = this.bankAccounts.getSavingAccount(toAccountNumber);
//        } else {
//            toAccount = this.bankAccounts.getCheckingAccount(toAccountNumber);
//        }
//
//        if (fromAccount == null || toAccount == null) {
//            return false;
//        }
//        
//        TransferActivity transferAct = new TransferActivity(this.id, fromAccount, toAccount, amount, activeDate);
//        if (transferAct.isReadyToTransfer()) {
//            transferAct.transfer();
//        }
//        this.transferRecords.addRecord(transferAct);
//
//        return true;
//    }
    
}
