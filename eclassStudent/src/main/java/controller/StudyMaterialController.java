package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AssignmentDao;
import dao.StudyMaterialDao;
import model.Assignment;
import model.StudyMaterial;

/**
 * Servlet implementation class StudyMaterialController
 */
public class StudyMaterialController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudyMaterialController() {
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
		StudyMaterial s = new StudyMaterial();
		StudyMaterialDao dao = new StudyMaterialDao();
		String page = " ";
		if ("viewMaterials".equalsIgnoreCase(action)) {
			System.out.println("Hello");
			List<StudyMaterial> list = dao.getDetails();
			// list=dao.getDetails(u);
			request.setAttribute("list", list);
			page = "Materials.jsp";
			
		}
		RequestDispatcher rd=request.getRequestDispatcher(page);
		rd.forward(request, response);
		

	}

}
