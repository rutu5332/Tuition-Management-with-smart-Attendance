package model;
import java.util.Date;

public class Announcement {
	private int announcement_id;
	private Date announcement_date; 
	private String announcement_desc; 
	private int classname ;
	
	public int getAnnouncement_id() {
		return announcement_id;
	}
	public void setAnnouncement_id(int announcement_id) {
		this.announcement_id = announcement_id;
	}
	public Date getAnnouncement_date() {
		return announcement_date;
	}
	public void setAnnouncement_date(Date announcement_date) {
		this.announcement_date = announcement_date;
	}
	public String getAnnouncement_desc() {
		return announcement_desc;
	}
	public void setAnnouncement_desc(String announcement_desc) {
		this.announcement_desc = announcement_desc;
	}
	public int getClassname() {
		return classname;
	}
	public void setClassname(int classname) {
		this.classname = classname;
	}
}
