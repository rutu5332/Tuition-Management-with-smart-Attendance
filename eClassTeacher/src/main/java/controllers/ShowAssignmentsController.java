package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import DAO.AssignmentDAO;
import model.Assignment;

/**
 * Servlet implementation class ShowAssignmentsController
 */
public class ShowAssignmentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAssignmentsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			System.out.print("in");
			AssignmentDAO assignmentDAO = new AssignmentDAO();
			
			try {
				ArrayList<Assignment> list = assignmentDAO.getDetails();
				HttpSession session = request.getSession();
				session.setAttribute("result", list);
				//RequestDispatcher rd = request.getRequestDispatcher("Teacher/Assignments.jsp");
				//rd.forward(request, response);
				response.sendRedirect("Teacher/Assignments.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//response.sendRedirect("Teacher/Assignments.jsp");
			
	}

}
