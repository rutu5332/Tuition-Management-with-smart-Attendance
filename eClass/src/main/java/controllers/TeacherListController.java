package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import DAO.TeacherDAO;
import model.Teacher;

/**
 * Servlet implementation class TeacherListController
 */
public class TeacherListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherDAO t = new TeacherDAO();
		try {
			
			List<Teacher> list = t.getALL();
			HttpSession session = request.getSession();
			session.setAttribute("result", list);
			response.sendRedirect("Admin/Teachers.jsp");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
