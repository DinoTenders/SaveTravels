<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Expense Form</title>
</head>
<body>
<div>
	<form:form action="<c:out value='/expenses/edit/${expense.id}'/>" method="post" modelAttribute="expense">
        <div>
            <form:label path="name">Expense Name: </form:label><br />
            <form:errors path="name"/>
            <form:input path="name"/>
        </div>
    
        <div>
            <form:label path="vendor">Vendor: </form:label><br />
            <form:errors path="vendor"/>
            <form:input path="vendor"/>
        </div>
        
        <div>
            <form:label path="amount">Amount: </form:label><br />
            <form:errors path="amount"/>
            <form:input  type="number" step="0.01" min="0" path="amount"/>
        </div>
        
        <div>
            <form:label path="description">Description: </form:label><br />
            <form:errors path="description"/>
            <form:textarea rows="3" path="description"/>
        </div>
        
        <div>
            <input type="submit" value="Submit"/>
        </div>
    </form:form>
</div>
</body>
</html>