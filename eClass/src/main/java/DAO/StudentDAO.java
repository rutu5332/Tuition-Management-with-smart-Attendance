package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Database.Data;
import model.Student;


public class StudentDAO {
private Data data;
	
	public StudentDAO() {
		
		data = new Data();
	}
	
public boolean addStudent(Student student) throws SQLException{
		
		String sql = "insert into student values(default,?,?,?,?,?,?,?,?,?,?)";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dob = format.format(student.getDob());
		String no =Long.toString(student.getStudent_phoneno());
		PreparedStatement statement = data.cn.prepareStatement(sql);
		statement.setString(1,student.getStudent_name());
		statement.setString(2,Integer.toString(student.getStudent_class()) );
		statement.setString(3,dob);
		statement.setString(4,student.getImage());
		statement.setString(5,no);
		statement.setString(6,student.getStudent_email());
		statement.setString(7,student.getParent_name());
		statement.setString(8,Long.toString(student.getParent_phoneno()));
		statement.setString(9,student.getParent_email());
		statement.setString(10,student.getPassword());
		
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
			sql = "insert into user_login values('"+student.getStudent_email()+"' ,  '"+ student.getPassword() +"' , 1 )" ;
			data.st = data.cn.createStatement();
			data.st.executeUpdate(sql);
			data.st.close();
			sql="select * from student";
			data.st = data.cn.createStatement();
			data.rs=data.st.executeQuery(sql);
			int i=0;
			while(data.rs.next()) {
				i= Integer.parseInt(data.rs.getString(1));
			}
			student.setStudent_id(i);
		    return true;
		}
		return false;
	}

	public List<Student> getALL() throws SQLException{
		List<Student> tList = new ArrayList<Student>();
		try {
			String sel = "select * from student";
			data.st = data.cn.createStatement();
			data.rs=data.st.executeQuery(sel);
			String name="",c="",phno="",email="",image="",pname="",pmob="",pemail="";
			Date dob;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			while(data.rs.next()) {
				name=data.rs.getString(2);
				c=data.rs.getString(3);
				dob=format.parse(data.rs.getString(4));
				image=data.rs.getString(5);
				phno=data.rs.getString(6);
				email=data.rs.getString(7);
				pname=data.rs.getString(8);
				pmob=data.rs.getString(9);
				pemail=data.rs.getString(10);
				Student s = new Student(name,Integer.parseInt(c),dob,image,Long.parseLong(phno),email,pname,Long.parseLong(pmob),pemail);
				tList.add(s);
			}
			
			return tList;
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tList;
	}

	public void updateImage(Student stu, String filename) {
		String s="update student set image='"+filename+"' where student_id=" + stu.getStudent_id() ;
		try {
			data.st = data.cn.createStatement();
			data.st.executeUpdate(s);
			stu.setImage(filename);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
