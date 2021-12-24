package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuizDao;
import model.Quiz;

/**
 * Servlet implementation class QuizController
 */
public class QuizController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizController() {
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
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		Quiz q = new Quiz();
		QuizDao dao = new QuizDao();
		String msg = " ";
		String page = " ";
		if ("viewQuiz".equalsIgnoreCase(action)) {
			System.out.println("Hello");
			HttpSession session=request.getSession();
			int stu_id=(int)session.getAttribute("tc_id");
			
			List<Quiz> list = dao.getDetails(stu_id);
			// list=dao.getDetails(u);
			request.setAttribute("list", list);
			page = "Quizes.jsp";
			
		}
		else if("quizDetails".equalsIgnoreCase(action)) {
			int id=Integer.parseInt(request.getParameter("id"));
			q=dao.getQuizDetails(id);
			request.setAttribute("quiz", q);
			page = "Quiz_Details.jsp";
			
		}
		else if("submitQuiz".equalsIgnoreCase(action))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			HttpSession session=request.getSession();
			int stu_id=(int)session.getAttribute("tc_id");
			
			dao.submitQuiz(id,stu_id,1);
			page="QuizController?action=viewQuiz";
			
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(page);
		rd.forward(request, response);

	}

}
