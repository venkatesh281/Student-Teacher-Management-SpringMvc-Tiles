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
import com.studentManagement.Teacher;
import com.studentManagement.Dao.StudentDao;
import com.studentManagement.Dao.TeacherDao;

@Controller
public class CommonLoginController {

	@Autowired
	StudentDao studObj;

	@Autowired
	TeacherDao teachObj;

	@RequestMapping("/commonlogin")
	public String commonLoginPage(Model m) {

		String message = "Enter Your Correct RollNo/Id and DOB ";

		m.addAttribute("message", message);

		return "commonloginpage";
	}

	@RequestMapping(value = "/commonlogincheck", method = RequestMethod.GET)
	public String commonLoginCheck(@Valid @RequestParam("idRollno") int idRollno, @RequestParam("dobPw") String dobPw,
			HttpServletRequest request, Model m) {

		// Student studentInfo = studObj.getStudentByRollNum(rollnum);
		// this case student dob not binding properly so that i have used getStudent
		// method to get dob

		List<Student> allStudents = studObj.getStudents();

		Teacher teacherInfo = teachObj.getTeacherById(idRollno);

		String returnPage = "";

		Student studentInfo = null;
		for (Student result : allStudents) {

			if (result.getRollnum() == idRollno) {
				studentInfo = result;
			}
		}

		if (studentInfo != null && dobPw.equalsIgnoreCase(studentInfo.getDob())
				&& idRollno == (studentInfo.getRollnum())) {// dob.equalsIgnoreCase(studentInfo.getDob()) &&

			request.getSession().setAttribute("user", studentInfo.getName());

			m.addAttribute("student", studentInfo);

			returnPage = "studentViewPages";

		} else if (teacherInfo != null && dobPw.equals(teacherInfo.getPassword())
				&& idRollno == (teacherInfo.getId())) {

			request.getSession().setAttribute("user", teacherInfo.getName());

			returnPage = "welcome";

		} else {

			String msg = "login failed! Please Enter Correct Id And Password";
			m.addAttribute("message", msg);

			returnPage = "commonloginpage";

		}

		return returnPage;
	}
}
