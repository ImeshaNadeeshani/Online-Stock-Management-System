<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Payment Details</title>
	
	<style type="text/css">
		body{
			font-family: Hind SemiBold;
		}
	
		table, th, td {
  			border: 1px solid black;
		}
	</style>
</head>
<body>

	<table>
	<c:forEach var="pay" items="${payDetails}">
	
	<c:set var="Id" value="${pay.id}"/>
	<c:set var="name" value="${pay.name}"/>
	<c:set var="email" value="${pay.email}"/>
	<c:set var="address" value="${pay.address}"/>
	<c:set var="username" value="${pay.username}"/>
	<c:set var="password" value="${pay.password}"/>
	<c:set var="method" value="${pay.method}"/>
	<c:set var="amount" value="${pay.amount}"/>
	
	<tr>
		<td>ID</td>
		<td>${pay.id}</td>
	</tr>
	<tr>
		<td>Name</td>
		<td>${pay.name}</td>
	</tr>
	<tr>
		<td>Email</td>
		<td>${pay.email}</td>
	</tr>
	<tr>
		<td>Address</td>
		<td>${pay.address}</td>
	</tr>
	<tr>
		<td>UserName</td>
		<td>${pay.username}</td>
	</tr>
	<tr>
		<td>Password</td>
		<td>${pay.password}</td>
	</tr>
	<tr>
		<td>Payment Method Type</td>
		<td>${pay.method}</td>
	</tr>
	<tr>
		<td>Amount</td>
		<td>${pay.amount}</td>
	</tr>

	</c:forEach>
	</table>
	
	<c:url value="PaymentUpdate.jsp" var="payupdate">
		<c:param name="Id" value="${Id}"/>
		<c:param name="name" value="${name}"/>
		<c:param name="email" value="${email}"/>
		<c:param name="address" value="${address}"/>
		<c:param name="username" value="${username}"/>
		<c:param name="password" value="${password}"/>
		<c:param name="method" value="${method}"/>
		<c:param name="amount" value="${amount}"/>
	</c:url>
	
	<a href="${payupdate}">
	<input type="button" name="update" value="Update My Payment Details">
	</a>
	
	<br>
	<c:url value="PaymentDelete.jsp" var="paydelete">
		<c:param name="Id" value="${Id}" />
		<c:param name="name" value="${name}" />
		<c:param name="email" value="${email}" />
		<c:param name="address" value="${address}" />
		<c:param name="username" value="${username}" />
		<c:param name="password" value="${password}" />
		<c:param name="method" value="${method}"/>
		<c:param name="amount" value="${amount}"/>
	</c:url>
	<a href="${paydelete}">
	<input type="button" name="delete" value="Delete My Payment Details">
	</a>
	
</body>
</html>