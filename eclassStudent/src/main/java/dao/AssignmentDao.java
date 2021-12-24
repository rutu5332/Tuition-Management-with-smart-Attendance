package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Assignment;
import model.Student;
import util.DbConnection;

public class AssignmentDao {

	public List<Assignment> getDetails(int stu_id) {
		int classname=0;
		/*
		 * String
		 * query="SELECT a.assignment_id,a.assignment_title,a.upload_date,a.due_date \r\n"
		 * + "				  FROM eclass.assignment a \r\n" +
		 * "				      JOIN eclass.assignment_submission ass ON a.assignment_id=ass.assignment_id \r\n"
		 * +
		 * "				       JOIN eclass.student s ON s.student_id=ass.student_id where s.student_class=a.class"
		 * ;
		 */
		String query="select student_class from student where student_id=?";
		Connection conn = null;
		PreparedStatement pr = null;
		//String query = null;
		String msg="";
		//User u1=null;
		List<Assignment> list=new ArrayList(); 
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
	  query="select * from assignment where class=?";
	  pr = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, 
              ResultSet.CONCUR_UPDATABLE);
	  pr.setInt(1, classname);
	  rs=pr.executeQuery();
	  while(rs.next())
	  {
		  	Assignment a=new Assignment();
		  	
		  	a.setAssignment_id(Integer.parseInt(rs.getString("assignment_id")));
		  	//a.setAssignment_description(rs.getString("assignment_description"));
		  	//a.setAssignment_file(rs.getString("assignment_file"));
		  	a.setAssignment_title(rs.getString("assignment_title"));
		  	a.setDue_date(rs.getDate("due_date"));
		  	a.setUpload_date(rs.getDate("upload_date"));
		  	//a.setTeacher_id(rs.getInt("teacher_id"));
		  	list.add(a);
	  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public Assignment getAssignDetails(int id) {
		
		String query="select * from assignment where assignment_id=?";
		Connection conn = null;
		PreparedStatement pr = null;
		//String query = null;
		String msg="";
		//User u1=null;
		//List<Assignment> list=new ArrayList();
		Assignment a=null;
		
		try {
		conn = DbConnection.getConnection();
		pr = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
		 pr.setInt(1, id);
		 
		 ResultSet rs=pr.executeQuery();
		   if(rs.first())
	  {
		  a=new Assignment();
		  a.setAssignment_id(Integer.parseInt(rs.getString("assignment_id")));
		  	a.setAssignment_description(rs.getString("assignment_description"));
		  	a.setAssignment_file(rs.getString("assignment_file"));
		  	a.setAssignment_title(rs.getString("assignment_title"));
		  	a.setDue_date(rs.getDate("due_date"));
		  	//a.setUpload_date(rs.getDate("upload_date"));
		  	//a.setTeacher_id(rs.getInt("teacher_id"));
	  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return a;
	}

	public boolean uploadAssignment(String filename, int i, int j) throws ParseException {
		
		String query="INSERT INTO assignment_submission values(?,?,?,?);";
		boolean result = false;
		Connection conn = null;
		PreparedStatement pr = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date subdate= new Date();
		//Date duetime;
		String date="2022-09-08";
		subdate = format.parse(date);
		String dtime = format.format(subdate);
		String msg="";
		int rs=0;
		//int id=3;
		//id++;
		try
		  { 
			conn = DbConnection.getConnection();
			pr = conn.prepareStatement(query);
			pr.setInt(1, i); 
			pr.setInt(2, j);
			pr.setString(3,dtime);
			pr.setString(4,filename);
			
			
			
			 rs = pr.executeUpdate();
			 System.out.println("RS:"+rs);
			 if(rs>0)
			 {
				 result=true;
			 }
		  }
		catch (Exception e1) 
		{ // TODO Auto-generated
		  e1.printStackTrace(); 
		} 
		
		
		return result;
	}


}
