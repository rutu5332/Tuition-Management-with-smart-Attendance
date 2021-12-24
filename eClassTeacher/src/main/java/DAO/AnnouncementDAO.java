package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import Database.Data;
import model.Announcement;

public class AnnouncementDAO {

	Data data;
	
	public AnnouncementDAO() {
		super();
		// TODO Auto-generated constructor stub
		
		data = new Data();
	}

	public boolean MakeAnnouncement(Announcement announcement,int tid) throws SQLException
	{
		String sql = "INSERT INTO announcement VALUES(default,?,?,?,?)";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd") ;
		String stime = format.format(announcement.getAnnouncement_date());
		PreparedStatement statement = data.cn.prepareStatement(sql);
		statement.setString(1, stime);
		statement.setString(2, announcement.getAnnouncement_desc());
		statement.setInt(3, tid);
		statement.setString(4, "11");
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    return true;
		}
		return false;
	}
}
