package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.Data;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Data dt = new Data();

		String id, psw;
		boolean flag = false;
		System.out.println("andar ");
		id = request.getParameter("email");
		psw = request.getParameter("password");

		try {
			dt.st = dt.cn.createStatement();
			
	
			
				
			HttpSession session=request.getSession();
			
			String sql_data = "select * from user_login u join teacher t on t.email=u.email;";
			dt.rs = dt.st.executeQuery(sql_data);
			
			
			while (dt.rs.next()) {
				String eid = dt.rs.getString("email");
				String psw1 = dt.rs.getString("password");
				
				
				if (eid.equals(id) && psw1.equals(psw)) {
					flag = true;
					String tid=dt.rs.getString("teacher_id");
					int tid2=Integer.parseInt(tid);
					session.setAttribute("userEmail", id);
					session.setAttribute("tc_id", tid2);
					
					if (dt.rs.getString("type").equals("0")) {
						session.setAttribute("userType", 0);
						response.sendRedirect("Admin/index.jsp");
					} else if (dt.rs.getString("type").equals("1")) {
						session.setAttribute("userType", 1);
						response.sendRedirect("Student/index.jsp");
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
