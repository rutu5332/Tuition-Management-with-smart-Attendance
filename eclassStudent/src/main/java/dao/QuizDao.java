package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Assignment;
import model.Quiz;
import model.Student;
import util.DbConnection;

public class QuizDao {

	public List<Quiz> getDetails(int stu_id) {
		int classname=0;
		String query="select student_class from student where student_id=?";
		Connection conn = null;
		PreparedStatement pr = null;
		//String query = null;
		String msg="";
		//User u1=null;
		List<Quiz> list=new ArrayList(); 
		try {
		conn = DbConnection.getConnection();
		pr = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
		pr.setInt(1, stu_id);
	  ResultSet rs=pr.executeQuery();
	  if(rs.first())
	  {
		  Student s=new Student();
		  s.setStudent_class(Integer.parseInt(rs.getString("student_class")));
		  classname=s.getStudent_class();
	  }
	  query="select * from quiz where class=?";
	  pr = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, 
              ResultSet.CONCUR_UPDATABLE);
	  pr.setInt(1, classname);
	  rs=pr.executeQuery();
	  while(rs.next())
	  {
		  	Quiz q=new Quiz();
		  	
		  	q.setQuiz_id(Integer.parseInt(rs.getString("quiz_id")));
		  	//a.setAssignment_description(rs.getString("assignment_description"));
		  	//a.setAssignment_file(rs.getString("assignment_file"));
		  	q.setQuiz_title(rs.getString("quiz_title"));
		  	q.setDue_date(rs.getDate("due_date"));
		  	q.setUpload_date(rs.getDate("upload_date"));
		  	//a.setTeacher_id(rs.getInt("teacher_id"));
		  	list.add(q);
	  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Quiz getQuizDetails(int id) {
		String query="select * from quiz where quiz_id=?";
		Connection conn = null;
		PreparedStatement pr = null;
		//String query = null;
		
		//User u1=null;
		//List<Assignment> list=new ArrayList();
		Quiz q=null;
		
		try {
		conn = DbConnection.getConnection();
		pr = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
		 pr.setInt(1, id);
		 
		 ResultSet rs=pr.executeQuery();
		   if(rs.first())
	  {
		  q=new Quiz();
		  q.setQuiz_id(Integer.parseInt(rs.getString("quiz_id")));
		  	q.setQuiz_desc(rs.getString("quiz_desc"));
		  	q.setQuiz_file(rs.getString("quiz_file"));
		  	q.setQuiz_title(rs.getString("quiz_title"));
		  	q.setDue_date(rs.getDate("due_date"));
		  		  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return q;
	}

	public void submitQuiz(int id, int stu_id, int status) {
		// TODO Auto-generated method stub
		String query="INSERT into quiz_submission values(?,?,?)";
		Connection conn = null;
		PreparedStatement pr = null;
		//String query = null;
		
		//User u1=null;
		//List<Assignment> list=new ArrayList();
		Quiz q=null;
		
		try {
		conn = DbConnection.getConnection();
		pr = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
		 pr.setInt(1, id);
		 pr.setInt(2, stu_id);
		 pr.setInt(3,status);
		 int rs=pr.executeUpdate();
		   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
