<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@page isELIgnored="false"%>





<html>  
<head>  
<title>login Form</title>  
<style>  
.error{color:red}  
</style>  
</head>  
<body>  
<h1 style="font-family: Lucida Bright; color: #FA2A55" align="center">Teacher Login </h1>
<h3 >${message}</h3>
<form action="teacherlogincheck" >  

Id: <input  type="text" name="id"/> 
<br><br>   
Password : <input type="text" name="password"/> <br><br>   
<form:errors path="password" cssClass="error"/><br><br>  
<input type="submit" value="submit">  
</form>  





<h4 style="font-family:Lucida Bright; color: #00008B">If you don't have an account! Please Register </h4>
<h4><a href = "register">Register</a></h4>
</body>  
</html>  