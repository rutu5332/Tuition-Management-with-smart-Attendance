package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Student;
import util.DbConnection;

public class StudentDao {
	String query="select * from student where student_id=?";
	public Student getStudentDetails(int id) {
		Connection conn = null;
		PreparedStatement pr = null;
		//String query = null;
		String msg="";
		//User u1=null;
		//List<Assignment> list=new ArrayList();
		Student s=null;
		
		try {
		conn = DbConnection.getConnection();
		pr = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
		 pr.setInt(1, id);
		 
		 ResultSet rs=pr.executeQuery();
		   if(rs.first())
	  {
		  s=new Student();
		  s.setStudent_id(Integer.parseInt(rs.getString("student_id")));
		  	s.setStudent_name(rs.getString("student_name"));
		  	s.setStudent_email(rs.getString("student_email"));
		  	s.setStudent_class(Integer.parseInt(rs.getString("student_class")));
		  	s.setStudent_phoneno(rs.getLong("student_phoneno"));
		  	s.setParent_name(rs.getString("parent_name"));
		  	s.setParent_email(rs.getString("parent_email"));
		  	s.setParent_phoneno(rs.getLong("parent_phoneno"));
		  	s.setImage(rs.getString("image"));
		  	//a.setUpload_date(rs.getDate("upload_date"));
		  	//a.setTeacher_id(rs.getInt("teacher_id"));
	  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return s;
	
	}


	}

