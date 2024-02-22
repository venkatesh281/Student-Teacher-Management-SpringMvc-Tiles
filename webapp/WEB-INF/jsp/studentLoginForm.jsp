<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@page isELIgnored="false"%>

<html>
<head>

<title>Student Login</title>
<style>  
.error{color:red}  
</style> 
</head>
<body>
<h1 style="font-family: Lucida Bright; color: #FA2A55" align="center">Student Login </h1>
<h3 >${message}</h3>
<form action="studentlogincheck" >  

RollNum: <input  type="text" name="rollnum"/> 
<br><br>   
DateOfBirth(dd/mm/yyyy) : <input type="text" name="dob"/> <br><br>   
<form:errors path="dob" cssClass="error"/><br><br>  
<input type="submit" value="submit">  
</form>  

</body>
</html>