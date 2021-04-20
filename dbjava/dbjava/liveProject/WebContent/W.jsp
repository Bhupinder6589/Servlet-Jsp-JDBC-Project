<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
     String ud=(String)session.getAttribute("uid");
%>
  <table border="3" bgcolor="red" align="center">
  <tr><td>kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk <a href=Logout.jsp?uid=<%=ud%>><%=ud%></a> </td>  </tr>
  </table>
  <jsp:include page="jsp/shg.jsp"></jsp:include>
 
</body>
</html>