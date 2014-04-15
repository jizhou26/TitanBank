<%-- 
    Document   : transferService
    Created on : Apr 13, 2014, 11:52:14 PM
    Author     : Zhou
--%>

<%@page import="edu.spcollege.tbk.domain.*, java.util.List, java.util.Date"%>
<%@page import="java.text.DateFormat, java.text.ParseException, java.text.SimpleDateFormat"%>
<%! String username = ""; %>
<%! BankAccount fromAccount = null; %>
<%! BankAccount toAccount = null; %>
<%! double amount = 0; %>
<%! Date activeDate = null; %>
<%
    username = (String) session.getAttribute("username");
    
    UserRepository userRepo = new UserRepository();
    User user = userRepo.findByUsername(username);
    
    BankAccountRepository bankAcctRepo = new BankAccountRepository();

    
    fromAccount = bankAcctRepo.findByAccountNumber( request.getParameter("fromAccount") );
    toAccount = bankAcctRepo.findByAccountNumber( request.getParameter("toAccount") );
    amount = Double.parseDouble( request.getParameter("transferAmount") );
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    try {
        activeDate = dateFormat.parse( request.getParameter("activeDate") );
    } catch (ParseException ex) {
        activeDate = new Date();
    }
    
    TransferService transferServ = new TransferService();
    
    TransferRequest transferRequest = new TransferRequest(fromAccount, toAccount, amount, activeDate);
    
    transferServ.transfer(transferRequest);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transfer Service</title>
    </head>
    <body>
        <jsp:include page="stdnav.jsp" />
        
        <div class="main">
            <div>
                <h3>Scheduled Transfers</h3>
                <table border="1">
                    <tr>
                        <th>Date</th>
                        <th>From</th>
                        <th>To</th>
                        <th>Amount</th>
                        <th>Status</th>
                    </tr>
<%

                    List<TransferRequest> transferRequests = transferServ.getTransactions();
                    String info = "";
                    for(TransferRequest tr : transferRequests) {
                        info += "<tr><td>" + (tr.getActiveDate().getMonth()+1) + "/" + tr.getActiveDate().getDate() + "/" + (tr.getActiveDate().getYear()+1900) + "</td>";
                        info += "<td>" + tr.getFromAccount().getAccountName() + "</td>";
                        info += "<td>" + tr.getToAccount().getAccountName() + "</td>";
                        info += "<td>" + tr.getAmountString() + "</td>";
                        info += "<td>" + tr.getTransferStatus().toString() + "</td></tr>";
                        out.println(info);
                    }
%>
                </table>
            </div>
        </div> <!-- class="main" -->
        
        <jsp:include page="stdfooter.jsp" />
    </body>
</html>
