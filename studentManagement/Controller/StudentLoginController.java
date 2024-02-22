package com.studentManagement.Controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentManagement.Student;
import com.studentManagement.Dao.StudentDao;


@Controller
public class StudentLoginController {

	@Autowired
	StudentDao studObj;
	
	
	
	@RequestMapping("/studentfrontpage")
	public String teacherFrontPage() {
		return "studentFrontPage";
	}
	
	
	
	
	
	@RequestMapping("/loginstudent")
	public String studentloginForm(Model m) {

		String message = "Enter Your Correct RollNo and DOB ";

		m.addAttribute("message", message);

   
		return "studentLoginForm";
	}
	
	@RequestMapping(value = "/studentlogincheck", method = RequestMethod.GET)
	public String loginStudent(@Valid @RequestParam("rollnum") int rollnum, @RequestParam("dob") String dob,
			                                                            HttpServletRequest request, Model m) {
    
		//Student studentInfo = studObj.getStudentByRollNum(rollnum); 
		//this case student dob not binding properly so that i have used getStudent method to get dob
		
		List<Student> allStudents = studObj.getStudents();
		
		String returnPage = "";
		
		for(Student result : allStudents) {
		
			if(result.getRollnum()==rollnum) {
				Student studentInfo = result;
				
			if (studentInfo != null && dob.equalsIgnoreCase(studentInfo.getDob()) && rollnum == (studentInfo.getRollnum())) {//dob.equalsIgnoreCase(studentInfo.getDob()) &&

			request.getSession().setAttribute("user", studentInfo.getName());

			
			m.addAttribute("student", studentInfo);
			
	    	
			returnPage= "studentViewPages";

		} else {

			String msg = "login failed! Please Enter Correct Id And Password";
			m.addAttribute("message", msg);

			returnPage = "studentLoginForm";

		}
			}
		
		  }
		return	returnPage;
		
	}
	
	@RequestMapping(value = "/studentlogout", method = RequestMethod.GET)
	public String logoutStudent(HttpServletRequest request, Model m) {
		if (request.getSession() != null) {
			request.getSession().invalidate();
		}

		return "studentFrontPage";
     //return "index";
	}
	
	
	
	
}
