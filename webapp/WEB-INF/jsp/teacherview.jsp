 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
   <%@page isELIgnored ="false" %> 
  
<h1 style="font-family: Lucida Bright; color: #F67280;"> Registered Successfully</h1> 
<h2 style="font-family: Didot; color: #550A35;" > Staff Details </h2> 
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Email</th><th>MaritalStatus</th><th>Gender</th><th>Age</th><th>State</th>
                               <th>District</th><th>Designation</th><th>Subject</th><th>Password</th><th>Edit</th><th>Delete</th> </tr>  
                               
   <c:forEach var="teacher" items="${teacherInfo}">   
   <tr>  
   <td>${teacher.id}</td>  
   <td>${teacher.name}</td>  
   <td>${teacher.email}</td>  
   <td>${teacher.maritalStatus}</td>  
   <td>${teacher.gender}</td>  
   <td>${teacher.age}</td>  
   <td>${teacher.state}</td>  
   <td>${teacher.district}</td>  
   <td>${teacher.designation}</td>
   <td>${teacher.subject}</td>
   <td>${teacher.password}</td>  
    <td><a href="editteacher/${teacher.id}"> <button style="background-color: #2E8B57;">Edit</button> </a></td>  
    <td><a href="deleteteacher/${teacher.id}"><button style="background-color: red;">Delete</button> </a></td>
   </tr>  
   </c:forEach>  
   </table>  
   <br></br>
 
   
 <a href ="logout"> Logout</a> <br>


   
   