package com.studentManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.studentManagement.Student;
import com.studentManagement.Dao.StudentDao;
import com.studentManagement.Dao.StudentMarksDao;
import com.studentManagement.Dao.TeacherDao;


@Controller
public class StudentController {
	
	
	@Autowired
	TeacherDao teachObj;
	@Autowired
	StudentDao studObj;
	
	@Autowired
	StudentMarksDao studentMarksObj;
	
	
	
//		if(null!= teachInfo) {
//			
//			mav = new ModelAndView("welcome");
//			mav.addObject("message", teachInfo.getName());
//		}
//		else {
//			mav = 
//		}
		
    
    
   
    
    
    @RequestMapping(value="/savestudent",method = RequestMethod.POST) 
    public String saveStudent(@ModelAttribute("student")Student stud) {
    	
    	studObj.save(stud);
    	
    	return "redirect:/viewstudent";
    	
    	
    }
    
    @RequestMapping(value ="/viewstudent",  method = RequestMethod.GET)
	public String viewStudent(Model m) {
        
		List<Student> studentList = studObj.getStudents();
		m.addAttribute("studentInfo", studentList);
		String message = "Student Added successfully";
    	m.addAttribute("message", message);
		return "studentview";
	}
    
   
    
    @RequestMapping(value="/editstudent/{rollnum}")    
    public ModelAndView edit(@PathVariable int rollnum, ModelAndView m){    
        Student getStudent = studObj.getStudentByRollNum(rollnum);    
      
        ModelAndView mv = new ModelAndView();
        		mv.addObject("student", getStudent);
        		mv.setViewName("editStudentForm");
                return mv;
        
        // m.addAttribute("student",getStudent);  
       // return "editStudentForm";    
    } 
    
    @RequestMapping(value="/editsavestudent",method = RequestMethod.POST)    
    public String editSaveStudent(@ModelAttribute("student") Student studinfo){    
        studObj.update(studinfo);    
        
        return  "redirect:/viewstudent";    
    }  
    
    
    @RequestMapping(value="/deletestudent/{rollnum}",method = RequestMethod.GET)    
    public String deleteStudent(@PathVariable("rollnum") int rollnum){    
        studObj.delete(rollnum);    
        studentMarksObj.deleteStudentMarks(rollnum);
        return "redirect:/viewstudent";  
    }
    
    
    
    
    @RequestMapping(value ="/addAnotherStud")
    public String addStudent(Model m) {
    	
    	m.addAttribute("student", new Student());
		return "studentform";
    	
    }
    
      
}
