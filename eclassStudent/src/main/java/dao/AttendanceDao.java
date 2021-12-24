package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

import util.DbConnection;

public class AttendanceDao {

	public Time getAttendance(int id) {
		String query="select intime from attendance where student_id=?";
		Connection conn = null;
		PreparedStatement pr = null;
		Time t1 = null;
		
		try {
		conn = DbConnection.getConnection();
		pr = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
		 pr.setInt(1, id);
		 
		 ResultSet rs=pr.executeQuery();
		 if(rs.first())
		  {
			 t1=rs.getTime("intime");
		  }
		
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return t1;
	}
}
