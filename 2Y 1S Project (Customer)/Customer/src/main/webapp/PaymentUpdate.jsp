<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Payment Details</title>
	<style type="text/css">
		table {
  			border-collapse: collapse;
		}

		table, th, td {
		  border: 1px solid black;
		}
	</style>
</head>
<body>

	<%
		String Id = request.getParameter("Id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String method = request.getParameter("method");
		String amount = request.getParameter("amount");		
	%>
	
	
	<form action="update" method="post">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="payId" value="<%= Id %>" readonly></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type="text" name="name" value="<%= name %>"></td>
		</tr>
		<tr>
		<td>Email</td>
		<td><input type="email" name="email" value="<%= email %>"></td>
	</tr>
	<tr>
		<td>Address</td>
		<td><input type="text" name="address" value="<%= address %>"></td>
	</tr>
	<tr>
		<td>User Name</td>
		<td><input type="text" name="username" value="<%= username %>"></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name="password" value="<%= password %>"></td>
	</tr>
	<tr>
		<td>Payment Method</td>
		<td><input type="text" name="method" value="<%= method %>"></td>
	</tr>
	<tr>
		<td>Amount</td>
		<td><input type="text" name="amount" value="<%= amount %>"></td>
	</tr>		
	</table>
	<br>
	<input type="submit" name="submit" value="Update My Data">
	</form>

</body>
</html>