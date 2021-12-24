package model;
import java.sql.Time;
import java.util.Date;

public class Attendance {
	private int attendance_id;
	private Date attendance_date;
	private Time intime;
	public int getAttendance_id() {
		return attendance_id;
	}
	public void setAttendance_id(int attendance_id) {
		this.attendance_id = attendance_id;
	}
	public Date getAttendance_date() {
		return attendance_date;
	}
	public void setAttendance_date(Date attendance_date) {
		this.attendance_date = attendance_date;
	}
	public Time getIntime() {
		return intime;
	}
	public void setIntime(Time intime) {
		this.intime = intime;
	}
}
