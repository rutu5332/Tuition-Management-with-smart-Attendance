/*package controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DAO.TeacherDAO;
import model.Teacher;

public class AdminRouteController {
	@RequestMapping({ "/Admin/"})
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Admin/index.jsp");
		return mv;
	}
	
	@RequestMapping("/TeachersDetails")
	public ModelAndView teacherDeatails() {
		ModelAndView mv = new ModelAndView();
		TeacherDAO t = new TeacherDAO();
		try {
			List<Teacher> list = t.getALL();
			mv.setViewName("Admin/Teachers.jsp");
			mv.addObject("result" , list);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return mv;
	}
}
*/