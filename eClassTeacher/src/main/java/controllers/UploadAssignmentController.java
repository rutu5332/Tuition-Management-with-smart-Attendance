package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;

import DAO.AssignmentDAO;
import model.Assignment;

import java.io.File;
import javax.servlet.annotation.MultipartConfig;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2)

public class UploadAssignmentController extends HttpServlet {
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Assignment_files
		
		response.setContentType("text/html;charset=UTF-8");
		//PrintWriter out = response.getWriter();
		System.out.println(request.getParameter("title"));
		HttpSession session = request.getSession();
		int tid = (Integer) session.getAttribute("tc_id");
		String title = request.getParameter("title");
		String desc = request.getParameter("desc");
		String cls = request.getParameter("class");
		String date = request.getParameter("date");
		String file = request.getParameter("file");
		System.out.println(tid+""+title+desc+cls+date+file);
		int c = Integer.parseInt(cls);
		System.out.println(tid+""+title+desc+cls+date+file);
		
		Part part = request.getPart("file");
		
		String filename = extractFileName(part);
		String savepath = "C:\\Users\\hp\\Downloads\\eClass (2)\\eClass\\src\\main\\webapp\\Assests\\Assignment_files" + File.separator + filename;
		
		part.write(savepath+File.separator);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date uploaddate= new Date();
		Date duetime;
		try {
			duetime = format.parse(date);
			Assignment assignment = new Assignment(0,title,filename,desc,uploaddate,duetime,tid,c);
			AssignmentDAO assignmentDAO = new AssignmentDAO();
			
			if (assignmentDAO.uploadAssignment(assignment)) {
				response.sendRedirect("Teacher/Assignments.jsp");
			} else {
				System.out.println("na thayu");
			}
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	private String extractFileName(Part part) throws IOException, NullPointerException
	{
		try 
		{
			String contentDisp = part.getHeader("content-disposition");
			String[] items = contentDisp.split(";");
			for (String s : items)
			{
				if (s.trim().startsWith("filename")) 
				{
					//System.out.println("file :: " + s.substring(s.indexOf("=") + 2, s.length() - 1));  // output :: file :: logo.png
					return s.substring(s.indexOf("=") + 2, s.length() - 1);
				}
			}
			return "";
		} catch (Exception e)
		{
			System.out.println(e);
		}
		return "";

		
	}

}
