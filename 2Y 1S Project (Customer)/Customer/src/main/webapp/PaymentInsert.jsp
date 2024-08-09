<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Details</title>
</head>
<body>

	<h1>Payment Details</h1>
	<form action="insert" method="post">
		
		<label for="name">Name : </label>
		<input type="text" name="name"><br>
		 
		<label for="email">Email : </label>
		<input type="email" name="email"><br>
		 
		<label for="address">Address : </label>
		<input type="text" name="address"><br>
		 
		<label for="username">UserName : </label>
		<input type="text" name="username"><br>
		
		<label for="password">Password : </label>
		<input type="password" name="password"><br>
		 
		<label for="method">Payment Method Type : </label>
		<select id="method" name="method" required>
			<option value="cash">Cash</option>
			<option value="card">Card</option>
			</select>
		<label for="amount">Amount : </label>
		<input type="text" name="amount"><br>
		
		
		<input type="submit" name="submit" value="submit">
	</form>
</body>
</html>
    