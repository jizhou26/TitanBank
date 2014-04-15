<%-- 
    Document   : header
    Created on : Apr 13, 2014, 6:27:04 PM
    Author     : Zhou
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%! String username = ""; %>
<%
    Boolean loggedIn = (Boolean) session.getAttribute("loginStatus");
    if (loggedIn == null || !loggedIn.booleanValue()) {
%>
        <jsp:forward page="login.jsp" />
<%
    } else {
        username = (String) session.getAttribute("username");
    }
%>


        <div class="content">
        <div class="header">
        <div class="logo">
            <h1>Titan Bank</h1>
        </div>

        <div class="logout">
        <p class="text">
            <a class="loginCtrl" href="login.htm"> Log Out (<%=username%>) </a>
        </p>
        </div> <!-- class="logout" -->
        </div> <!-- class="header" -->

        <div class="clear"></div>

        <div class="nav">
        <div class="nav1">
            <span class="text3"><a href="accounts.htm">Accounts</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="transfers.htm">Transfers</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="">Check Manage</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="">Settings</a></span>
        </div> <!-- class="nav1" -->
        </div> <!-- class="nav" -->

        <div class="clear"></div>

