package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.QuizDAO;
import DAO.StudyMaterialDAO;
import model.Quiz;
import model.StudyMaterial;

/**
 * Servlet implementation class UploadQuizController
 */
public class UploadQuizController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession s = request.getSession();
		int id = (Integer) s.getAttribute("tc_id");
		//int id = Integer.parseInt(tid);
		String desc = request.getParameter("desc");
		String title = request.getParameter("title");
		String url = request.getParameter("url");
		String date = request.getParameter("date");
		String cls = request.getParameter("class");
		int c = Integer.parseInt(cls);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date uploaddate= new Date();
		Date duetime;
		try {
			duetime = format.parse(date);
			Quiz quiz = new Quiz();
			quiz.setClassname(c);
			quiz.setDue_date(duetime);
			quiz.setQuiz_desc(desc);
			quiz.setQuiz_file(url);
			quiz.setQuiz_title(title);
			quiz.setUpload_date(uploaddate);
			
			QuizDAO qdao = new QuizDAO();
			try {
				if(qdao.addQuiz(quiz, id)) {
					
					response.sendRedirect("quizzes");
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		catch(Exception e)
		{
			
		}
		
		
		StudyMaterialDAO sdao = new StudyMaterialDAO();
		
		
	}

}
