<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.Date" %>
    <%@ page import="java.util.List" %>
    <%@ page import="max.login.dl.DistBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript">
function getAdharDetail() {
var adhar=document.getElementById("adhar").value;
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
//document.getElementById("fname").value
 var s=xmlhttp.responseText;
       t=s.split(",");
     document.getElementById("t1").value=t[0];
     document.getElementById("t2").value=t[1];
}
  
 }
  xmlhttp.open("GET","AdharDetailservlet?adhar="+adhar,true);
      xmlhttp.send();
}


function getDistrictName() {
var sCode=document.getElementById("stateCode").value;
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

document.getElementById("print").value=xmlhttp.responseText;
}
  
 }
  xmlhttp.open("GET","StateMasterServlet?sCode="+sCode,true);
      xmlhttp.send();
}

   function addRow()
   {
   var table=document.getElementById("child");
   var rowCount=table.rows.length;
   var row=table.insertRow(rowCount);
   
   var cell1=row.insertCell(0);
   cell1.innerHTML=rowCount;
   var cell2=row.insertCell(1);
   
   var element2=document.createElement("input");
   element2.type="checkbox";
   element2.name="chk";
   cell2.appendChild(element2);
   var cell3=row.insertCell(2);
   
   var element3=document.createElement("input");
   element3.type="text";
   element3.name="cname";
   cell3.appendChild(element3);
   var cell4=row.insertCell(3);
   
   var element4=document.createElement("input");
   element4.type="text";
   element4.name="age";
   cell4.appendChild(element4);
   var cell5=row.insertCell(4);
   
   var element5=document.createElement("input");
   element5.type="text";
   element5.name="cadhar";
   cell5.appendChild(element5);
   }
  
   function deleteRow()
   {
     var table=document.getElementById("child");
	 var i=1;
	 if(chkbox==cheked)
	 {
	   table.deleteRow(i);
	   i++;
	 }
	
   }
   
</script>
</head>
<body>
<form action="SHGsDetailServlet">
<%
 String stname=(String)request.getAttribute("stName");
String stcode=(String)request.getAttribute("stCode");
List<DistBean> list=(List<DistBean>)request.getAttribute("lst");
%>
<table id="parent" bgcolor="green" border ="3" align="center">
<tr>
   <td colspan="4" align="center">SHGs Details</td>
</tr>
<tr><td>State Name</td><td><input type="hidden" name="stateCode" value="<%=stcode%>" >   <%=stname%> </td>


<td>District Name</td>
                      <td><select name="districtCode">
                      
                                   <option value="0">select District</option>
                               
                                 <%
                                 for(DistBean p:list)
                                 {
                                	 %>
                                     <option value="<%=p.getDistcode()%>"> <%=p.getDistName() %></option>
   								   <%} %> 
   								  </select></td>
   </tr>
<tr>    
<td>SHG Name</td><td><input type="text" name="shgname"></td></tr>
<tr><td>Account No </td><td><input type="text" name="account" ></td>
<td>IFSC</td><td><input type="text" name="ifsc"></td></tr>



<tr><td>Created Date</td><td><select name="ddate">
                                 <%
                                 for(int i=1;i<=31;i++)
                                 {
                                 
                                 %>
                                <option value="<%=i%>"><%=i%></option> 
                                 <%}%>
                                 
								  </select>
								  <select name="mdate">
								  <option value="1">Jan</option>
								  <option value="2">Feb</option>
								  <option value="3">Mar</option>
								  
								  <option value="4">Apl</option>
								  <option value="5">May</option>
								  <option value="6">Jun</option>
								  <option value="7">Jul</option>
								  
								  <option value="8">Aug</option>
								  <option value="9">Sep</option>
								  <option value="10">Oct</option>
								  <option value="11">Nov</option>
								  
								  <option value="12">Dec</option>
								  </select>
								  <%
								  Date d=new Date();  
							        int year=d.getYear();  
							        int currentYear=year+1900; 
								  %>
								  
								  <select name="ydate">
								  <option value="<%=currentYear%>"><%=currentYear%></option>
								  
								  </select>
								      </td>
</table>



<table id="child" bgcolor="yellow" border ="3" align="center">
  <tr>
   <td colspan="4" align="center">Member's Detail </td><td align="right"> <input type="button"  value ="ADD Member" id="b1"  onclick="addRow();"></td>
</tr>

  <tr>
     <td>S.No.</td><td>Select</td><td>Member Name</td><td>Age</td><td>Adhar</td>
  </tr>
  <tr>
     <td>1</td><td><input type="checkbox" name="chk"></td>
     <td><input type="text" name="cname"></td>
     <td><input type="text" name="age"></td>
     <td><input type="text" name="cadhar"></td>
  </tr>
  
</table>
<table>
<tr><td><input type="submit" value="Save"></td>
<td><a href=jsp/view.jsp>View</a></td>
</tr>
</table>

</form>
</body>
</html>
