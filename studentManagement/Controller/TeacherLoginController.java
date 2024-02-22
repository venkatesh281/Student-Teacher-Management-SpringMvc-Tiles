package com.studentManagement.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentManagement.Teacher;
import com.studentManagement.Dao.StudentDao;
import com.studentManagement.Dao.TeacherDao;

@Controller
public class TeacherLoginController {

	@Autowired
	TeacherDao teachObj;
	

	@RequestMapping("/teacherfrontpage")
	public String teacherIndex() {
		return "teacherFrontPage";
	}
	
	
	// url for login form
	@RequestMapping("/loginteacher")
	public String loginForm(Model m) {

		String message = "Enter Your Correct Id and Password ";

		m.addAttribute("message", message);

		return "teacherLoginForm";
	}

	// url for addStudent
	@RequestMapping(value = "/teacherlogincheck", method = RequestMethod.GET)
	public String login(@Valid @RequestParam("password") String password, @RequestParam("id") int id,
			HttpServletRequest request, Model m) {

		Teacher teacherInfo = teachObj.getTeacherById(id);

		if (teacherInfo != null && password.equals(teacherInfo.getPassword()) && id == (teacherInfo.getId())) {

			request.getSession().setAttribute("user", teacherInfo.getName());

			return "welcome";

		} else {

			String msg = "login failed! Please Enter Correct Id And Password";
			m.addAttribute("message", msg);

			return "teacherLoginForm";

		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutUser(HttpServletRequest request, Model m) {
		if (request.getSession() != null) {
			request.getSession().invalidate();
		}

		return "teacherFrontPage";
     
	}
}
