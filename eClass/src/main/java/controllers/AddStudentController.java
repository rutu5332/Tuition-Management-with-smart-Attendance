package controllers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.StudentDAO;
import model.Student;


@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
maxFileSize = 1024 * 1024 * 10 ,
maxRequestSize = 1024 * 1024 * 50 )

public class AddStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Part part = request.getPart("img1");
		String filename = extractFileName(part);
		String savepath = "C:\\Users\\hp\\git\\Tuition-Management-with-smart-Attendance\\eClass\\src\\main\\webapp\\Assests\\images" + File.separator + filename;
		String newsavepath = "C:\\Users\\hp\\git\\Tuition-Management-with-smart-Attendance\\eClass\\src\\main\\webapp\\Assests\\images" + File.separator;
		part.write(savepath + File.separator);
		
		try {
			
			String name,c,dob,email,pass,pemail,pname;
			GeneratePassword g=new GeneratePassword();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			long ph,pmob;
			Date dOB;
			
			name=request.getParameter("name").trim();
			c=request.getParameter("class").trim();
			dob=request.getParameter("dob").trim();
			ph=Long.parseLong(request.getParameter("mob").trim());
			pname=request.getParameter("pname").trim();
			email=request.getParameter("email").trim();
			pmob=Long.parseLong(request.getParameter("pmob").trim());
			pemail=request.getParameter("pemail").trim();
			pass=g.generatePassword(8);
			dOB=format.parse(dob);
			
			Student s=new Student(name,Integer.parseInt(c),dOB,filename,ph,email,pname,pmob,pemail,pass);
			StudentDAO sDAO = new StudentDAO();
			
			if(sDAO.addStudent(s) ) {
				
				filename = Integer.toString(s.getStudent_id()) + ".jpg";
				newsavepath += filename;
				File old =new File(savepath);
				File newF=new File(newsavepath);
				old.renameTo(newF);
				sDAO.updateImage(s,filename);
				response.sendRedirect("StudentListController");
			}
			else
				System.out.println("ERROR");
			
		
		}
		catch(Exception e){
			System.out.println(e);
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
