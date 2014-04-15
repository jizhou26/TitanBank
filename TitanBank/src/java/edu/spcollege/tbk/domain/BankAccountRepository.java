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
public class BankAccountRepository implements IBankAccountRepository {
    
    @Override
    public List<BankAccount> findByUser(User user) {
        return findByCustomer(user.getCustomer());
    }
    
    @Override
    public List<BankAccount> findByCustomer(Customer customer) {
        
        ArrayList<BankAccount> results = new ArrayList<>();
        
        FakeDatabase db = new FakeDatabase();
        for (BankAccount account : db.getBankAccounts()) {
            if (customer.equals(account.getCustomer())) {
                results.add(account);
            }
        }
        return Collections.unmodifiableList(results);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public BankAccount findByAccountNumber(String accountNumber) {
        ArrayList<BankAccount> results = new ArrayList<>();
        
        FakeDatabase db = new FakeDatabase();
        for (BankAccount account : db.getBankAccounts()) {
            // temp. should be accountNumber
            if (accountNumber.equals(account.getAccountName())) {
                return account;
            }
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
