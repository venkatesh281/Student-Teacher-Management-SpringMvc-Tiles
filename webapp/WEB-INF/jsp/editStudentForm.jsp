<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<%@page isELIgnored ="false" %> 



<html>  
<head>  
    <title>Edit Student Form</title>  
</head>  
<h3>Edit Student</h3>  
<body>  
<form:form action="/teacher-student-management-tiles-security-annot/editsavestudent" modelAttribute="student" method="POST">



RollNum : <form:input path = "rollnum"/><br></br>

Name :<form:input path ="name"/><br></br>

Mobile :<form:input path ="mobile"/><br></br>

Age :<form:input path ="age"/><br></br>

std :<form:input path ="std"/><br></br>


Gender :
Male<form:radiobutton path="gender" value="Male"/>  
Female<form:radiobutton path="gender" value="Female"/> <br></br>

Place :<form:input path ="place"/><br></br>

DateOfBirth :<form:input path ="dob"/><br></br>

TeacherId : <form:input path = "teacherId"/><br></br>
<h4><input type="submit" value="Save" /></h4>

</form:form>
</body>  
</html> 