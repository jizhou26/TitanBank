/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.tbk.domain;

import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author Zhou
 */
public class TransferRequest {
    
    public enum ScheduleStatus{
        IMMEDIATE,
        FUTURE
    }
    
    public enum TransferStatus{
        PENDING,
        COMPLETED
    }
    
    private final BankAccount fromAccount;
    private final BankAccount toAccount;
    private final double amount;
    private final Date activeDate;
    private ScheduleStatus scheduleStatus;
    private TransferStatus transferStatus;
    
    // Constructor
    public TransferRequest(BankAccount fromAccount, BankAccount toAccount, double amount, Date activeDate) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.activeDate = activeDate;
        
        this.transferStatus = TransferStatus.PENDING;
        Date today = new Date();
        if (this.activeDate.getYear() == today.getYear() &&
            this.activeDate.getMonth() == today.getMonth() && 
            this.activeDate.getDate() == today.getDate())
        {
            this.scheduleStatus = ScheduleStatus.IMMEDIATE;
        }
        else {
            this.scheduleStatus = ScheduleStatus.FUTURE;
        }
    }
    
    // Getter/Setter
    public BankAccount getFromAccount() {
        return this.fromAccount;
    }

    public BankAccount getToAccount() {
        return this.toAccount;
    }

    public double getAmount() {
        return this.amount;
    }

    public TransferStatus getTransferStatus() {
        return this.transferStatus;
    }
    
    public ScheduleStatus getScheduleStatus() {
        return this.scheduleStatus;
    }

    public Date getActiveDate() {
        return this.activeDate;
    }
    
    // Method
    public String getAmountString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return "$" + df.format(this.amount);
    }
    
    public boolean isReadyToTransfer() {
        if (this.scheduleStatus == ScheduleStatus.IMMEDIATE) {
            return true;
        }

        Date today = new Date();
        if (this.activeDate.getYear() == today.getYear() &&
            this.activeDate.getMonth() == today.getMonth() && 
            this.activeDate.getDate() == today.getDate())
        {
            this.scheduleStatus = ScheduleStatus.IMMEDIATE;
            return true;
        }

        return false;
    }
    
    public void completeTransaction() {
        this.transferStatus = TransferStatus.COMPLETED;
    }
}
