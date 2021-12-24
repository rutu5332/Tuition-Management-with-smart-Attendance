package controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.AssignmentDao;

import model.Assignment;


/**
 * Servlet implementation class AssignmentController
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2)
public class AssignmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int id=3; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignmentController() {
        super();
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		Assignment a = new Assignment();
		AssignmentDao dao = new AssignmentDao();
		String msg = " ";
		String page = " ";
		if ("viewAssignment".equalsIgnoreCase(action)) {
			System.out.println("Hello");
			HttpSession session=request.getSession();
			int stu_id=(int)session.getAttribute("tc_id");
			
			List<Assignment> list = dao.getDetails(stu_id);
			// list=dao.getDetails(u);
			request.setAttribute("list", list);
			page = "Assignments.jsp";
			
		}
		else if("assignDetails".equalsIgnoreCase(action)) {
			
			int id=Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			
			a=dao.getAssignDetails(id);
			System.out.println(a.getAssignment_id());
			request.setAttribute("ass", a);
			page = "Assignment_Details.jsp";
			
		}
		
		else if("submitAssignment".equalsIgnoreCase(action))
		{
			response.setContentType("text/html;charset=UTF-8");
			//System.out.println("");
			//PrintWriter out = response.getWriter();
			//System.out.println(request.getParameter("title"));
			HttpSession session = request.getSession();
			int sid = (Integer) session.getAttribute("tc_id");
			//int sid=1;
			String file = request.getParameter("file");
			int ass_id=Integer.parseInt(request.getParameter("id"));
			//System.out.println(tid+""+title+desc+cls+date+file);
			//int c = Integer.parseInt(cls);
			//System.out.println(tid+""+title+desc+cls+date+file);
			
			Part part = request.getPart("file");
			
			String filename = extractFileName(part);
			String savepath = "C:\\Users\\hp\\Downloads\\eclass\\src\\main\\webapp\\Assests\\Stu_assignments" + File.separator + filename;
			
			part.write(savepath+File.separator);
			
			try {
				if (dao.uploadAssignment(filename,ass_id,sid)) {
					
					page="AssignmentController?action=viewAssignment";
				} else {
					System.out.println("na thayu");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		RequestDispatcher rd=request.getRequestDispatcher(page);
		rd.forward(request, response);
		
	}

	private String extractFileName(Part part) throws IOException, NullPointerException {
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
