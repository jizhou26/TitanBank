<%-- 
    Document   : transferService
    Created on : Apr 13, 2014, 11:52:14 PM
    Author     : Zhou
--%>

<%@page import="edu.spcollege.tbk.domain.*, edu.spcollege.tbk.domain.transfer.*, java.util.List, java.util.Date"%>
<%@page import="java.text.DateFormat, java.text.ParseException, java.text.SimpleDateFormat"%>

<%! List<TransferRequest> transferRequests; %>
<%
    transferRequests = (List<TransferRequest>) request.getAttribute("transferRequests");
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
                    String info = "";
                    for(TransferRequest tr : transferRequests) {
                        info += "<tr><td>" + (tr.getActiveDate().getMonth()+1) + "/" + tr.getActiveDate().getDate() + "/" + (tr.getActiveDate().getYear()+1900) + "</td>";
                        info += "<td>" + tr.getFromAccount().getAccountName() + "</td>";
                        info += "<td>" + tr.getToAccount().getAccountName() + "</td>";
                        info += "<td>" + tr.getAmountString() + "</td>";
                        info += "<td>" + tr.getTransferStatus().toString() + "</td></tr>";
                    }
                    out.println(info);
%>
                </table>
            </div>
        </div> <!-- class="main" -->
        
        <jsp:include page="stdfooter.jsp" />
    </body>
</html>
