package model;

import java.util.Date;

public class AssignmentSubmission {

	private int student_id;
	private int id;
	private Date sub_date;
	private String file;
	public AssignmentSubmission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssignmentSubmission(int student_id, int id, Date sub_date, String file) {
		super();
		this.student_id = student_id;
		this.id = id;
		this.sub_date = sub_date;
		this.file = file;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getSub_date() {
		return sub_date;
	}
	public void setSub_date(Date sub_date) {
		this.sub_date = sub_date;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
	
	
}
