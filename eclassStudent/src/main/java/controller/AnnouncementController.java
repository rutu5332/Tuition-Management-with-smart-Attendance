package controller;

import java.io.IOException;
import java.sql.Time;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AnnouncementDao;
import dao.AttendanceDao;
import model.Announcement;
import model.Attendance;

/**
 * Servlet implementation class AnnouncementController
 */
public class AnnouncementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnouncementController() {
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
		HttpSession session=request.getSession();
		int id=(int) session.getAttribute("tc_id");
		Announcement a = new Announcement();
		Attendance att=new Attendance();
		AttendanceDao attdao=new AttendanceDao();
		AnnouncementDao dao = new AnnouncementDao();
		
		String page = " ";
			List<Announcement> list = dao.getAllAnnouncement();
			Time t;
			t=attdao.getAttendance(id);
			//System.out.println(t);
			request.setAttribute("list", list);
			request.setAttribute("time", t);
			page = "index.jsp";
		RequestDispatcher rd=request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
