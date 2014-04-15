/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.tbk.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Zhou
 */
public class FakeDatabase {
    private ArrayList<User> users;
    private ArrayList<BankAccount> bankAccounts;
    
    public FakeDatabase() {
        this.users = new ArrayList<>();
        this.bankAccounts = new ArrayList<>();

        Customer myCustomer = new Customer("Ji", "Zhou");

        // Fake user database
        User myUser = new User("user", "user", myCustomer);
        this.users.add(myUser);
        
        // Fake accounts database
        BankAccount myCheckingAccount = new CheckingAccount(myCustomer, 1000);
        BankAccount mySavingAccount = new SavingAccount(myCustomer, 1000);
        this.bankAccounts.add(myCheckingAccount);
        this.bankAccounts.add(mySavingAccount);
    }
    
    public List<User> getUsers(){
        return Collections.unmodifiableList(this.users);
    }
    
    public List<BankAccount> getBankAccounts(){
        return Collections.unmodifiableList(this.bankAccounts);
    }
}
