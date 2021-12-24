package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Quiz;
import model.Student;
import util.DbConnection;


/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Data dt = new Data();

		String id, psw;
		boolean flag = false;
		System.out.println("andar ");
		id = request.getParameter("email");
		psw = request.getParameter("password");

		try {
			String sql_data = "select * from user_login u join student s on s.student_email=u.email;";
			Connection conn = null;
			PreparedStatement pr = null;
			
			 
			
			conn = DbConnection.getConnection();
			pr = conn.prepareStatement(sql_data,ResultSet.TYPE_SCROLL_SENSITIVE, 
	                ResultSet.CONCUR_UPDATABLE);
		  ResultSet rs=pr.executeQuery();
		 HttpSession session=request.getSession(true);
			while (rs.next()) {
				String eid = rs.getString("email");
				String psw1 =rs.getString("password");
				
				
				if (eid.equals(id) && psw1.equals(psw)) {
					flag = true;
					String tid=rs.getString("student_id");
					int tid2=Integer.parseInt(tid);
					session.setAttribute("userEmail", id);
					session.setAttribute("tc_id", tid2);
					
					if (rs.getString("type").equals("0")) {
						session.setAttribute("userType", 0);
						response.sendRedirect("Admin/index.jsp");
					} else if (rs.getString("type").equals("1")) {
						session.setAttribute("userType", 1);
						response.sendRedirect("AnnouncementController");
					} else {
						session.setAttribute("userType", 2);
						response.sendRedirect("Teacher/index.jsp");
					}
				}
			}
			if (flag != true) {
				String msg = "Invalid Username Or Password";
				response.sendRedirect("login.jsp?msg=" + msg);

			}

		}

		catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
}



