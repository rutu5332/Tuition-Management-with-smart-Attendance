package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.TeacherDAO;
import model.Student;
import model.Teacher;

/**
 * Servlet implementation class ShowProfileController
 */
public class ShowProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		int tid = (Integer) session.getAttribute("tc_id");
		TeacherDAO sdao = new TeacherDAO();
		try {
			Teacher  t=  sdao.getTeacherDetails(tid);
			session.setAttribute("tp", t);
			response.sendRedirect("Teacher/myprofile.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
