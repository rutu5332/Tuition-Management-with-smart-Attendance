package DAO;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import Database.Data;
import model.Attendance;


public class AssignmentDAO {
	private Data dt;
	public AssignmentDAO() {
		dt = new Data();
	}

	public List<Attendance> getTodayAssignment() {
		List<Attendance> assi= new ArrayList<Attendance>();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = fmt.format(new Date());
		String sel = "select * from attendace inner join student on attendance.student_id=student"
				+ ".student_id where attendace_date";
		try {
			dt.st = dt.cn.createStatement();
			dt.rs = dt.st.executeQuery(sel);
			while (dt.rs.next()) {
				if (strDate.equals(dt.rs.getString("attendance_date"))) {
						Attendance a=new Attendance();
						
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return assi;
	}

}
