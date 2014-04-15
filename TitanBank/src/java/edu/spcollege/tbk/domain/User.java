/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.tbk.domain;

/**
 *
 * @author Zhou
 */
public class User extends LoginAccount {
    private final Customer customer;
    
    // Constructor
    public User(String username, String password, Customer customer) {
        super(username, password, LoginAccount.LoginType.CUSTOMER);
        this.customer = customer;
    }

    // Getter/Setter
    public Customer getCustomer() {
        return this.customer;
    }
}
