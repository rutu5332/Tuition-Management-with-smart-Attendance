package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.QuizDAO;
import model.Quiz;

public class ShowQuizController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		QuizDAO qdao = new QuizDAO();
		
		try {
			ArrayList<Quiz> list = qdao.getDetails();
			HttpSession session = request.getSession();
			session.setAttribute("quizlist",list);
			response.sendRedirect("Teacher/Quizes.jsp");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}


}
