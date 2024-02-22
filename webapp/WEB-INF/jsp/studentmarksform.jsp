<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>  
<%@page isELIgnored ="false" %> 

<html>  
<head>  
    <title>Add Student Marks </title>  
</head>  
<h3>Add Student Marks</h3>  
<h4>"${message}"</h4>
<body>  
<form:form action="savestudentmarks" modelAttribute="studentmarks" method ="POST">

RollNum : <form:input path = "rollnum"/><br></br>

Name :<form:input path ="name"/><br></br>

Tamil :<form:input path ="tamil" /><br></br>

English :<form:input path ="english"/><br></br>

Maths :<form:input path ="maths"/><br></br>


Science :<form:input path ="science"/><br></br>

Social Science: <form:input path ="socialScience"/><br></br>



<input type="submit" value="Save" />
</form:form>
</body>  
</html> 