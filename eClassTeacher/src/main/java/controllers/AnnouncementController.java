package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import DAO.AnnouncementDAO;
import model.Announcement;


public class AnnouncementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
 
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String desc = request.getParameter("announcement");
		//System.out.println(desc);
		HttpSession session = request.getSession();
		
		int tid = (Integer) session.getAttribute("tc_id"); 
		Announcement announcement = new Announcement();
		Date date = new Date();
		announcement.setAnnouncement_date(date);
		announcement.setAnnouncement_desc(desc);
		AnnouncementDAO announcementDAO = new AnnouncementDAO();
		try {
			if(announcementDAO.MakeAnnouncement(announcement,tid))
			{
				System.out.println("success");
				response.sendRedirect("Teacher/index.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
