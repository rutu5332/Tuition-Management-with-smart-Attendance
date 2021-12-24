package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.StudyMaterialDAO;
import model.StudyMaterial;

/**
 * Servlet implementation class UploadLectureController
 */
public class UploadLectureController extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession s = request.getSession();
		int id =  (Integer) s.getAttribute("tc_id");
		//int id = Integer.parseInt(tid);
		String desc = request.getParameter("desc");
		String title = request.getParameter("title");
		String url = request.getParameter("url");
		String cls = request.getParameter("class");
		
		StudyMaterial sm = new StudyMaterial();
		sm.setMaterial_type(0);
		sm.setMaterial_title(title);
		sm.setClass_name(cls);
		sm.setUpload_date(new Date());
		sm.setMaterial_file(url);
		
		StudyMaterialDAO sdao = new StudyMaterialDAO();
		try {
			if(sdao.addStudyMaterial(sm, id)) {
				
				response.sendRedirect("Teacher/UploadLecture.jsp");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
