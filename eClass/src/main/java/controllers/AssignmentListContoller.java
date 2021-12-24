package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AttendanceDAO;
import model.Attendance;
import model.Student;


public class AssignmentListContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AttendanceDAO aDAO = new AttendanceDAO();
		try {
			HashMap<Student,Attendance> list = aDAO.getTodayAttendance();
			HttpSession session = request.getSession(false);
			session.setAttribute("result", list);
			response.sendRedirect("Admin/Attendance.jsp");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
