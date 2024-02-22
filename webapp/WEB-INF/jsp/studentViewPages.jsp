<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
   <%@page isELIgnored ="false" %>  
  
<html>  
<head> 
<title> Student view Page</title>
</head>
<body> 
  
 
<h1 style="font-family: Didot; color: #7D0552;">Student details  </h1> 
<h2 style="font-family: Didot; color: #CC7A8B;">${message}</h2>

 <table border="2" width="70%" cellpadding="2">  
<tr><th>RollNum</th><th>Name</th><th>Mobile</th><th>Age</th><th>Std</th><th>Gender</th><th>Place</th><th>DateOfBirth</th>
                       <th>TeacherId</th><th>Marks</th> </tr></tr>  
                               
    
   <tr>  
   <td>${student.rollnum}</td>  
   <td>${student.name}</td>  
   <td>${student.mobile}</td>  
   <td>${student.age}</td>  
   <td>${student.std}</td>  
   <td>${student.gender}</td>  
   <td>${student.place}</td>  
   <td>${student.dob}</td>
   <td>${student.teacherId}</td>
    <td><a href="viewmarks/${student.rollnum}">Marks</a></td>
   
    
   </tr>  
   
   </table>  
   <br/>   
    
     
      
   <a href ="studentlogout"> Logout</a> <br>
  
</body>
</html>