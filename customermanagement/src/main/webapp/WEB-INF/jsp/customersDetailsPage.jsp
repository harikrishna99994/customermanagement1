<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Details</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container" align="center">
		<h1>Customer Manager</h1>
		<form action="/searchCustomer">
			<input type="text" name="id" placeholder="Enter Customer ID"
				required="required" /> <input type="submit" value="search" /> <font
				color="Red">${errorCustomer}</font>
		</form>
		<br>
		<c:set var="customer" value="${SearchCust}" />
		<c:if test="${customer!=null}">
			<table border="1" class="table">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>E-mail</th>
					<th>Address</th>
				</tr>
				<tr>
					<td>${customer.id}</td>
					<td>${customer.name}</td>
					<td>${customer.email}</td>
					<td>${customer.address}</td>
				</tr>
			</table>
		</c:if>
	</div>
	<div align="center">
		<a href="addCustomer" class="btn">New Customer</a><br>
		<br>
	</div>

	<div class="container" align="center">
		<table border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>E-mail</th>
					<th>Address</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customers}" var="customer">
					<tr>
						<td>${customer.id}</td>
						<td>${customer.name}</td>
						<td>${customer.email}</td>
						<td>${customer.address }</td>
						<td><a href="/editCustomer?id=${customer.id}">Edit</a> <a
							href="/deleteCustomer?id=${customer.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>