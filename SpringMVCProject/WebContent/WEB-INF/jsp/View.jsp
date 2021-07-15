<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

       <table border="3" bgcolor="yellow">
       <tr><td>UName</td><td>Add</td><td>Mobile</td> </tr>
       
       <c:forEach items="${lst}" var="b">
       <tr>
       
       <td><c:out value="${b.uname}"></c:out>   </td>
       <td><c:out value="${b.add}"></c:out>   </td>
       <td><c:out value="${b.mobile}"></c:out>   </td>
       
       
       
       </tr>
       
       </c:forEach>
       
       
       </table>


</body>
</html>