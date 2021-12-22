package controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TeacherDAO;
import model.Teacher;

public class AddTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String name,sub,dob,email,pass;
			GeneratePassword g=new GeneratePassword();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			long ph;
			Date dOB;
			
			name=request.getParameter("name").trim();
			sub=request.getParameter("sub").trim();
			dob=request.getParameter("dob").trim();
			ph=Long.parseLong(request.getParameter("mob").trim());
			email=request.getParameter("email").trim();
			pass=g.generatePassword(8);
			dOB=format.parse(dob);
			
			Teacher t=new Teacher(name,sub,dOB,ph,email,pass);
			TeacherDAO teacherDAO = new TeacherDAO();
			
			if(teacherDAO.addTeacher(t) )
				response.sendRedirect("Admin/TeacherDetails");
			else
				System.out.println("ERROR");
			
		
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
