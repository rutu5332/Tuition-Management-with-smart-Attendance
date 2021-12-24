package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AssignmentDAO;
import model.Assignment;
import model.AssignmentSubmission;

/**
 * Servlet implementation class AssignmentDetailController
 */
public class AssignmentDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		int aid = Integer.parseInt(id);
		//System.out.println(id);
		AssignmentDAO adao = new AssignmentDAO();
		try {
			Assignment ass = adao.getAssignment(aid);
			ArrayList<AssignmentSubmission> as = adao.getResponses(aid);
			HttpSession session = request.getSession();
			session.setAttribute("assign", ass);
			session.setAttribute("res", as);
			response.sendRedirect("Teacher/Assignment_Details.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
