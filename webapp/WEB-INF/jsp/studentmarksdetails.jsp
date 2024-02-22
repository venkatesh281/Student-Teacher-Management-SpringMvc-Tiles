<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
   <%@page isELIgnored ="false" %>  
  
<html>  
<head> 
<title> Student login Page</title>
</head>
<body> 
  
 
<h1 style="font-family: Didot; color: #7D0552;">Student Marks details  </h1> 
<h2 style="font-family: Didot; color: #CC7A8B;">${message}</h2>

 <table border="2" width="70%" cellpadding="2">  
<tr><th>RollNum</th><th>Name</th><th>Tamil</th><th>English</th><th>Maths</th><th>Science</th><th>Social Science</th>
                            <th>Total</th><th>Grade</th></tr>  
                               
    
   <tr>  
   <td>${studentmarks.rollnum}</td>  
   <td>${studentmarks.name}</td>  
   <td>${studentmarks.tamil}</td>  
   <td>${studentmarks.english}</td>  
   <td>${studentmarks.maths}</td>  
   <td>${studentmarks.science}</td>  
   <td>${studentmarks.socialScience}</td>  
   <td>${studentmarks.total}</td> 
   <td>${studentmarks.grade}</td>
  
    
   </tr>  
   
   </table>  
   <br/>   
    
     
      
   
  
</body>
</html>