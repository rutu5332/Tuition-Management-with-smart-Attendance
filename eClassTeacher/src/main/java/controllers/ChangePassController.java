package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.TeacherDAO;

/**
 * Servlet implementation class ChangePassController
 */
public class ChangePassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangePassController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession s = request.getSession();
		int tid = (Integer) s.getAttribute("tc_id");
		String new_pass = request.getParameter("password");
		TeacherDAO tdao = new TeacherDAO();
		try {
			if(tdao.changePass(tid, new_pass)) {
				response.sendRedirect("Teacher/myprofile.jsp");
			}
			else {
				response.sendRedirect("showProfile");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
