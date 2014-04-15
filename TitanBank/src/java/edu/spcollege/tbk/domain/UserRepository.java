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
public class UserRepository implements IUserRepository {
    
    @Override
    public User findByUsername(String username) {
        FakeDatabase db = new FakeDatabase();
        
        for (User user : db.getUsers()) {
            if (username.equals(user.getUsername())) {
                return user;
            }
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
