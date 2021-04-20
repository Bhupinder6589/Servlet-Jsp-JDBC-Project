<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="userDAO" class="max.login.dl.UserDAO"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
   if(userDAO.logout(request.getParameter("uid")))
   {
	   out.println("User Logout successfull");
	   request.getRequestDispatcher("login.jsp").include(request, response);
   }
   
  
%>
</body>
</html>