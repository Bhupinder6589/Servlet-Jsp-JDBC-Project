<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="js/jquery-1.7.2.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function getDistName() {

		var scode = document.getElementById("stateCode").value;
		alert("hiii " + scode);

		$.ajax({
					url : "http://localhost:8989/SpringMVCProject/dist.do?stCode="
							+ scode,
					type : "GET",
					contentType : "application/json",
					dataType : 'json',
                    success : function(response) {
                    	alert("hi");
						for (var i = 0; i < response.length; i++) {
							val = new Option(response[i].distName,
									response[i].distCode);
							$('#st').append(val);
							//$('#tbodyId').append(html1);
						}
					},

					error : function(jqXHR, exception) {
						console.log(exception);
					}
				});
	}
</script>
</head>
<body>
  <f:form action="registSub.do" commandName="rgt" method="post">
  <table border="3" bgcolor="yellow">
  <tr><td>State Name</td> 
  
  <td><f:select path="stateCode" id="stateCode"   onchange="getDistName();">
						<f:option value="0" label="Select" />
						<f:options items="${stateList}" itemValue="stateCode"
							itemLabel="stateName" />
					</f:select></td>
</tr>
   
   <tr>
   <td>District Name</td>
				<td><f:select path="distCode" id="st">


					</f:select></td>
   </tr>
   
 
  <tr><td>User Name</td> <td><f:input path="uname"/> <f:errors path="uname"></f:errors></td> </tr>
  <tr><td>Address</td> <td><f:input path="add"/><f:errors path="add"/>  </td> </tr>
  <tr><td>Mobile</td> <td><f:input path="mobile"/><f:errors path="mobile"/>  </td> </tr>
  <tr> <td><input type="submit" value="Registration">  </td>
  <td><a href=view.do> VIEW </a>
  <a href=update.do> UPDATE </a> </td> </tr>
  </table>
  
  
  </f:form>
</body>
</html>