<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>  
<%@page isELIgnored ="false" %> 

<html>  
<head>  
    <title>Add Student Form</title>  
</head>  
<h3>Add Student</h3>  
<body>  
<form:form action="savestudent" modelAttribute="student" method ="POST">

RollNum : <form:input path = "rollnum"/><br></br>

Name :<form:input path ="name"/><br></br>

Mobile :<form:input path ="mobile"/><br></br>

Age :<form:input path ="age"/><br></br>

std :<form:input path ="std"/><br></br>


Gender :
Male<form:radiobutton path="gender" value="Male"/>  
Female<form:radiobutton path="gender" value="Female"/><br></br>

Place :<form:input path ="place"/><br></br>

DateOfBirth(dd/mm/yyyy): <form:input path ="dob"/><br></br>

TeacherId : <form:input path = "teacherId"/><br></br>
<input type="submit" value="Save" />
</form:form>
</body>  
</html> 