<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View your SaveTravels</title>
</head>
<body>
	<h1>Expense Details</h1>
	<p><a href="/expenses/">Go back</a></p>
	<table>
	    <tbody>
			<tr>
				<td>Expense Name:</td>
				<td style="padding-left: 24px;"><c:out value="${expense.name}"></c:out></td>
			</tr>
			<tr>
				<td>Expense Description:</td>
				<td style="padding-left: 24px;"><c:out value="${expense.description}"></c:out></td>
			</tr>
			<tr>
				<td>Vendor:</td>
				<td style="padding-left: 24px;"><c:out value="${expense.vendor}"></c:out></td>
			</tr>
			<tr>
				<td>Amount Spent:</td>
				<td style="padding-left: 24px;">$<fmt:formatNumber type="number" minFractionDigits="2" value="${expense.amount}"/></td>
			</tr>	
	    </tbody>
	</table>
</body>
</html>