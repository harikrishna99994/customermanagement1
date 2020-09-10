<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Customer</title>
</head>
<body>
  <h2>Add Customer</h2>
  <div>
  <form:form action="saveCustomer" method="post" modelAttribute="customer">
   <table>
    <tr>
       <td>Name:</td>
       <td>
          <form:input path="name"/>
       </td>
    </tr>
    <tr>
       <td>E-mail:</td>
       <td>
         <form:input path="email"/>
       </td>
    </tr>
    <tr>
       <td>Address:</td>
       <td>
        <form:input path="address"/>
       </td>
    </tr>
  </table>
  <input type="submit">
  </form:form> 
  </div>
</body>
</html>