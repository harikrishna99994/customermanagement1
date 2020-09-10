<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Customer</title>
</head>
<body>
  <h2>Edit Customer</h2>
  <form:form action="editSaveCustomer" method="post" modelAttribute="customer">
  <table>
    <tr>
       <td>ID:</td>
       <td>
         ${customer.id}
         <form:hidden path="id"/>
       </td>
    </tr>
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

</body>
</html>