package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.StudyMaterialDAO;
import model.StudyMaterial;

public class ShowLectureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StudyMaterialDAO dao = new StudyMaterialDAO();
		try {
			ArrayList<StudyMaterial> list = dao.getLectures();
			HttpSession session = request.getSession();
			session.setAttribute("lec", list);
			response.sendRedirect("Teacher/Lecture_Links.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
