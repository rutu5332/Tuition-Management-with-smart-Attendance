package controllers;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import DAO.AssignmentDAO;
import DAO.StudyMaterialDAO;
import model.Assignment;
import model.StudyMaterial;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2)

public class UploadDocumentController extends HttpServlet {
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
		String file = request.getParameter("file");
		System.out.println(tid+""+title+desc+cls+file);
		int c = Integer.parseInt(cls);
		System.out.println(tid+""+title+desc+cls+file);
		
		Part part = request.getPart("file");
		
		String filename = extractFileName(part);
		String savepath = "C:\\Users\\hp\\Downloads\\eClass (2)\\eClass\\src\\main\\webapp\\Assests\\study_docs" + File.separator + filename;
		
		part.write(savepath+File.separator);
		
		try {
			
			StudyMaterial sm = new StudyMaterial();
			sm.setClass_name(cls);
			sm.setMaterial_file(filename);
			sm.setMaterial_title(title);
			sm.setMaterial_type(1);
			sm.setUpload_date(new Date());
			
			StudyMaterialDAO sdao= new StudyMaterialDAO();
			
			if (sdao.addStudyMaterial(sm,tid)) {
				response.sendRedirect("assignments");
			} else {
				System.out.println("na thayu");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
