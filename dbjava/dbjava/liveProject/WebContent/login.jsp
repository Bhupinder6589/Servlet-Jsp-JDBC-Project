<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function getMobile()
 {
	var mobile=document.getElementById("mobile").value;
	 var xmlhttp;
	 if (window.XMLHttpRequest)
	 {
	 // code for IE7+, Firefox, Chrome, Opera, Safari
	      xmlhttp=new XMLHttpRequest();
	 }
	 else
	 {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	 
	xmlhttp.onreadystatechange=function()
	 {
	 if (xmlhttp.readyState==4 && xmlhttp.status==200)
	{
	
	 var s=xmlhttp.responseText;
	     t= s.split("");
	     document.getElementById("otp1").value=t[0];
	     document.getElementById("otp2").value=t[1];
	     document.getElementById("otp3").value=t[2];
	     document.getElementById("otp4").value=t[3];
	     
	}
	  
	 }
	 
 xmlhttp.open("GET","OtpServlet?mobile="+mobile,true);
     xmlhttp.send();
	 
	 
	
	}

</script>


</head>
<body>
  <form action="LoginServlet" method="get">
  <table border="3" bgcolor="yellow">
  <tr><td>UID</td><td><input type="text" name="uid">  </td> </tr>
  <tr><td>Pass</td><td><input type="password" name="pass">  </td> </tr>
  <tr><td>Mobile</td><td><input type="text" name="mobile" id="mobile" size="10" onblur="getMobile();">
  <input type="text" name="otp1" id="otp1" readonly="readonly" size="1">
  <input type="text" name="otp2" id="otp2" readonly="readonly" size="1">
  <input type="text" name="otp3" id="otp3" readonly="readonly" size="1">
  <input type="text" name="otp4" id="otp4" readonly="readonly" size="1">
  
  
  
  </td> </tr>
  <tr><td><input type="submit" value="login">  </td> </tr>
 
  </table>
  
  
  </form>
  
</body>
</html>