<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
    <font color="green">${msg}</font>

<h3>User Registration Form</h3>
<form:form action="userAcc" modelAttribute="userModel" method="POST">
<table>
<tr>
<td>Enter Username</td>
<td><form:input path="uname"/></td>
</tr>
<tr>
<td>Enter email id</td>
<td><form:input path="email"/></td>
</tr>
<tr>
<td>Enter PhoneNumber</td>
<td><form:input path="phno"/></td>
</tr>
<tr>
<td><input type="reset" value="remove"/></td>
<td><input type="submit" value="submit"/></td>
</tr>
</table>
</form:form>