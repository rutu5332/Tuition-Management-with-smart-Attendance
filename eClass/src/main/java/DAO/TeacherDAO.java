package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Database.Data;
import model.Teacher;

public class TeacherDAO {
	private Data data;
	
	public TeacherDAO() {
		
		data = new Data();
	}
	
	public boolean addTeacher(Teacher teacher) throws SQLException{
		
		String sql = "insert into teacher values(default,?,?,?,?,?,?)";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dob = format.format(teacher.getDOB());
		String no =Long.toString(teacher.getPhone_no());
		PreparedStatement statement = data.cn.prepareStatement(sql);
		statement.setString(1,teacher.getTeacher_name());
		statement.setString(2,teacher.getSubject());
		statement.setString(3,dob);
		statement.setString(4,no);
		statement.setString(5,teacher.getEmail());
		statement.setString(6,teacher.getPassword());
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
			sql = "insert into user_login values('"+teacher.getEmail()+"' ,  '"+ teacher.getPassword() +"' , 2 )" ;
			data.st = data.cn.createStatement();
			data.st.executeUpdate(sql);
			data.st.close();
		    return true;
		}
		return false;
	}
	
	public List<Teacher> getALL() throws SQLException{
		List<Teacher> tList = new ArrayList<Teacher>();
		try {
			String sel = "select * from teacher";
			data.st = data.cn.createStatement();
			data.rs=data.st.executeQuery(sel);
			String name="",sub="",phno="",email="";
			Date dob;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			while(data.rs.next()) {
				name=data.rs.getString(2);
				sub=data.rs.getString(3);
				dob=format.parse(data.rs.getString(4));
				phno=data.rs.getString(5);
				email=data.rs.getString(6);
				Teacher t = new Teacher(name,sub,dob,Long.parseLong(phno),email);
				tList.add(t);
			}
			
			return tList;
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tList;
	}
}
