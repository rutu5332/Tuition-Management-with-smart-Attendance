package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Announcement;
import util.DbConnection;

public class AnnouncementDao {

	public List<Announcement> getAllAnnouncement() {
		String query="SELECT * from announcement";
		Connection conn = null;
		PreparedStatement pr = null;
		List<Announcement> list=new ArrayList(); 
		try {
		conn = DbConnection.getConnection();
		pr = conn.prepareStatement(query);
	  ResultSet rs=pr.executeQuery();
	  while(rs.next())
	  {
		  	Announcement a=new Announcement();
		  	
		  	a.setAnnouncement_id(Integer.parseInt(rs.getString("announcement_id")));
		  	a.setAnnouncement_date(rs.getDate("announcement_date"));
		  	a.setAnnouncement_desc(rs.getString("announcement_desc"));
		  	a.setClassname(Integer.parseInt(rs.getString("class")));
		  	//a.setTeacher_id(rs.getInt("teacher_id"));
		  	list.add(a);
	  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
