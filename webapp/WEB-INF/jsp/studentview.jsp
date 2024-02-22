<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
   <%@page isELIgnored ="false" %> 
 
 <html>
 <head>
 <style >
 
 
 
 
 </style>
 
 </head>
 </body>
<h1 style="font-family: Didot; color: #7D0552;">Student details  </h1> 
<h2 style="font-family: Didot; color: #CC7A8B;">${message}</h2>
<table border="2" width="70%" cellpadding="2">  
<tr><th>RollNum</th><th>Name</th><th>Mobile</th><th>Age</th><th>Std</th><th>Gender</th><th>Place</th><th>DateOfBirth</th>
                         <th>TeacherId</th><th>Marks</th><th>Edit</th><th>Delete</th></tr></tr>  
                               
   <c:forEach var="stud" items="${studentInfo}">   
   <tr>  
   <td>${stud.rollnum}</td>  
   <td>${stud.name}</td>  
   <td>${stud.mobile}</td>  
   <td>${stud.age}</td>  
   <td>${stud.std}</td>  
   <td>${stud.gender}</td>  
   <td>${stud.place}</td>  
   <td>${stud.dob}</td>
    <td>${stud.teacherId}</td>
   <td><a href="viewmarks/${stud.rollnum}"><button style="background-color: #FFCE44; ">Marks</button></a></td> 
   <td><a href="editstudent/${stud.rollnum}"> <button style="background-color: #2E8B57; color: white;"> Edit</button></a></td>  
   <td><a href="deletestudent/${stud.rollnum}"> <button style="background-color: red; color: white;">Delete</button></a></td>  
    
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   
  
   <a href="addAnotherStud">Add Student</a>  ||
   <a href="viewteacher">Teacher Details</a>  ||
   <a href ="addmarks">Add Marks For Students</a>  ||
 
 
  <br></br>
  
  <a href ="logout"> Logout</a> <br>
 </body>
  </html> 