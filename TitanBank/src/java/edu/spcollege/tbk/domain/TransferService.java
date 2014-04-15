/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.tbk.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zhou
 */
public class TransferService {
    
    private ArrayList<TransferRequest> transactions;
    
    // Constructor
    public TransferService() {
        this.transactions = new ArrayList<>();
    }
    
    public void transfer(TransferRequest transferRequest) {
        if (!transferRequest.isReadyToTransfer()) {
            this.transactions.add(transferRequest);
            return;
        }

        try {
            transferRequest.getFromAccount().withdraw(transferRequest.getAmount());
            transferRequest.getToAccount().deposit(transferRequest.getAmount());
            transferRequest.completeTransaction();
            this.transactions.add(transferRequest);
        } catch (InsufficientFundsException ex) {
            Logger.getLogger(TransferService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<TransferRequest> getTransactions(){
        return Collections.unmodifiableList(this.transactions);
    }
    
    public List<TransferRequest> getTransactions(TransferRequest.TransferStatus status){
        ArrayList<TransferRequest> results = new ArrayList<>();
        for (TransferRequest request: transactions){
            if (request.getTransferStatus() == status)
                results.add(request);
        }
        return Collections.unmodifiableList(results);
    }
    
    public List<TransferRequest> getTransactions(User user){
        ArrayList<TransferRequest> results = new ArrayList<>();
        
        for (TransferRequest request: transactions){
            if (request.getFromAccount().getCustomer().equals(user.getCustomer()) ||
                    request.getToAccount().getCustomer().equals(user.getCustomer()))
            {
                results.add(request);
            }
        }
        return Collections.unmodifiableList(results);
    }
}
