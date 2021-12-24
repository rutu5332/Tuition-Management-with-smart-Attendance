package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Database.Data;
import model.Student;
import model.Teacher;

public class TeacherDAO {

	
	private Data data;
	public TeacherDAO() {
		super();
		// TODO Auto-generated constructor stub
		
		data = new Data();
	}
	
	public Teacher getTeacherDetails(int id) throws SQLException, ParseException {
		
		String query="select * from teacher where teacher_id="+id;
		Statement statement = data.cn.createStatement();
		ResultSet rs = statement.executeQuery(query);
		rs.next();
		
			Teacher t = new Teacher();
			t.setEmail(rs.getString("email"));
			t.setPassword(rs.getString("password"));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			t.setDOB(format.parse(rs.getString("DOB")));
			t.setPhone_no(rs.getLong("phone_no"));
			t.setSubject(rs.getString("subject"));
			t.setTeacher_name(rs.getString("teacher_name"));
			
		return t;
	}
	public boolean changePass(int tid,String new_pass) throws SQLException
	{
		String sql = "UPDATE teacher SET password=? where teacher_id="+tid+";";
		PreparedStatement statement = data.cn.prepareStatement(sql);
		statement.setString(1, new_pass);
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
			return true;	
		}
		return false;
	}
}
