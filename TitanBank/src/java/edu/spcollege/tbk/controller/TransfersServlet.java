/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.tbk.controller;

import edu.spcollege.tbk.domain.bankaccount.BankAccountRepository;
import edu.spcollege.tbk.domain.bankaccount.BankAccount;
import edu.spcollege.tbk.domain.user.UserRepository;
import edu.spcollege.tbk.domain.Customer;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zhou
 */
public class TransfersServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        String username = (String) session.getAttribute("username");
        Customer customer = new UserRepository().findByUsername(username).getCustomer();

        BankAccountRepository bankAcctRepo = new BankAccountRepository();
        List<BankAccount> bankAccounts = bankAcctRepo.findByCustomer(customer);
        
        request.setAttribute("bankAccounts", bankAccounts);
        // Then display accounts information
        String url = "/transfers.htm";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
        
/*
        BankAccountRepository bankAcctRepo = new BankAccountRepository();

        BankAccount fromAccount = bankAcctRepo.findByAccountNumber(request.getParameter("fromAccount"));
        BankAccount toAccount = bankAcctRepo.findByAccountNumber(request.getParameter("toAccount"));
        double amount = Double.parseDouble( request.getParameter("amount") );
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Date activeDate = null;
        try {
            activeDate = dateFormat.parse( request.getParameter("activeDate") );
        } catch (ParseException ex) {
            Logger.getLogger(TransfersServlet.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }
        
        TransferRequest transferRequest = new TransferRequest(fromAccount, toAccount, amount, activeDate);
        TransferService transferServ = new TransferService();
        transferServ.transfer(transferRequest);
        
        List<TransferRequest> requests = transferServ.getTransactions();
        for (TransferRequest tr : requests) {
            // then display information
        }
    */
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
