package DAO;

import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import Database.Data;
import model.Attendance;
import model.Student;

public class AttendanceDAO {
	private Data dt;
	
	public AttendanceDAO() {
		dt=new Data();
	}
	
	public HashMap<Student,Attendance> getTodayAttendance() throws ParseException {
		HashMap<Student,Attendance> att= new HashMap<Student,Attendance>();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = fmt.format(new Date());
		String sel = "select * from attendace inner join student on attendance.student_id=student"
				+ ".student_id where attendace_date";
		
		String name="",phno="",email="",image="",pname="",pmob="",pemail="";
		Time intime;
		Date dob;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
		int c,sid;
		try {
			dt.st = dt.cn.createStatement();
			dt.rs = dt.st.executeQuery(sel);
			Date attdate= new Date();
			while (dt.rs.next()) {
				if (strDate.equals(dt.rs.getString("attendance_date"))) {
						intime=(Time) dateFormat.parse(dt.rs.getString("intime"));
						c=Integer.parseInt(dt.rs.getString("student_class"));
						name=dt.rs.getString("student_name");
						dob=format.parse(dt.rs.getString("dob"));
						image=dt.rs.getString("image");
						phno=dt.rs.getString("student_phoneno");
						email=dt.rs.getString("student_email");
						pname=dt.rs.getString("parent_name");
						pmob=dt.rs.getString("parent_phoneno");
						pemail=dt.rs.getString("parent_email");
						sid = Integer.parseInt(dt.rs.getString("student_id"));
						Student s = new Student(sid,name,c,dob,image,Long.parseLong(phno),email,pname,Long.parseLong(pmob),pemail);
						Attendance a = new Attendance( attdate, intime);
						att.put(s,a);
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return att;
	}
}
