 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
   <%@page isELIgnored ="false" %> 

<html>  
<head> 
<title> welcome Page</title>

<style>

button{
 
 style="font-family: Lucida Bright;"
  color: white;
  
  background-color:#583759;
  width:300px;
  font-size: 20px;
  
  
   }
 
</style>

</head>

<body> 
  <% 
String name=(String)session.getAttribute("user"); 
//out.print("Hello User: You have entered the name: "+name );

if(name!=null)  {%>
	
<h2 style="font-family: Lucida Bright; color: #F67280;" align="center"  > Welcome ${user}</h2>


	<h3 align="center">
		<a href="viewteacher">
			<button>Teacher details</button></a>
		<br>
		
		<br> <a href="viewstudent">
			<button >Student details</button></a>
		
		
		<br>

	</h3>

	
     
   
    <a  href ="logout"> LogOut</a> </p><br><br>
    
<% } else {%>
<h3><a href = "loginteacher">LogIn</a><br><br></h3>

<%} %>


<%--  <c:choose>
<c:when test="${name}!=null">
</c:when>
<c:otherwise>
<p>login failed</p>

</c:otherwise>
</c:choose> --%>
</body>
</html>  

