package com.studentManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.studentManagement.Student;
import com.studentManagement.StudentMarks;
import com.studentManagement.Dao.StudentDao;
import com.studentManagement.Dao.StudentMarksDao;

@Controller
public class StudentMarksController {

	@Autowired
	StudentMarksDao studentMarksObj;
	
	@Autowired
	StudentDao studObj;

	@RequestMapping(value = "/addmarks")
	public String addmarks(Model m) {

		 

		m.addAttribute("message", "Enter Student Correct RollNo and Name ");
		m.addAttribute("studentmarks", new StudentMarks());
		return "studentmarksform";
	}

	@RequestMapping(value = "/savestudentmarks", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") StudentMarks studentmarks, Model m) {

		Student studentdeatils = studObj.getStudentByRollNum(studentmarks.getRollnum());
		
		int total = studentmarks.getTotal();
		
		if(studentmarks.getRollnum()==studentdeatils.getRollnum() && studentmarks.getName().equalsIgnoreCase(studentdeatils.getName())
				&& total <=500) {
		
			studentMarksObj.saveStudentMarks(studentmarks);

		StudentMarks marks=	studentMarksObj.getStudentMarksByRollNum(studentmarks.getRollnum());
		
		m.addAttribute("studentmarks", marks);
		
		
		
		m.addAttribute("total", total);
	
		return "studentmarksdetails";
		
		
		}else {
			
			m.addAttribute("message", " Please check your RollNo, Name, Marks");
			
			return "studentmarksform";
		}

	}
	
	@RequestMapping(value = {"/viewmarks/{rollnum}"},  method = RequestMethod.GET)
	public String viewStudentMarks(@PathVariable("rollnum") int rollnum, Model m) {
        
		StudentMarks studentmarks =studentMarksObj.getStudentMarksByRollNum(rollnum);
		m.addAttribute("studentmarks", studentmarks);
		
		int total = studentmarks.getTamil()+studentmarks.getEnglish()+studentmarks.getMaths()
		+studentmarks.getScience()+studentmarks.getSocialScience()/5;
		
		m.addAttribute("total", total);
	
		return "studentmarksdetails";
	}
	
//	@RequestMapping(value="/deletestudentmarks/{rollnum}",method = RequestMethod.GET)    
//	  public String deleteTeacher(@PathVariable("rollnum") int rollnum){    
//		    studentMarksObj.deleteStudentMarks(rollnum) ;  
//	        return "redirect:/viewstudent";  
//	    }
	
}
