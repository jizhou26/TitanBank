/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.tbk.domain;

import java.util.List;

/**
 *
 * @author Zhou
 */
public interface ITransferRepository {
    List findByCustomer(Customer customer);
    List findByCustomerAndStatus(Customer cusotomer, TransferRequest.TransferStatus status);
}
