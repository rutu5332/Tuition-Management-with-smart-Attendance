package model;

import java.util.Date;

public class Assignment {
	private int assignment_id; 
	private String assignment_title;
	private String assignment_file; 
	private String assignment_description;
	private Date upload_date;
	private Date due_date ;
	private int teacher_id ;
	private int class_name;
	
	
	
	public Assignment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Assignment(int assignment_id, String assignment_title, String assignment_file, String assignment_description,
			Date upload_date, Date due_date, int teacher_id, int class_name) {
		super();
		this.assignment_id = assignment_id;
		this.assignment_title = assignment_title;
		this.assignment_file = assignment_file;
		this.assignment_description = assignment_description;
		this.upload_date = upload_date;
		this.due_date = due_date;
		this.teacher_id = teacher_id;
		this.class_name = class_name;
	}
	public int getAssignment_id() {
		return assignment_id;
	}
	public void setAssignment_id(int assignment_id) {
		this.assignment_id = assignment_id;
	}
	public String getAssignment_title() {
		return assignment_title;
	}
	public void setAssignment_title(String assignment_title) {
		this.assignment_title = assignment_title;
	}
	public String getAssignment_file() {
		return assignment_file;
	}
	public void setAssignment_file(String assignment_file) {
		this.assignment_file = assignment_file;
	}
	public String getAssignment_description() {
		return assignment_description;
	}
	public void setAssignment_description(String assignment_description) {
		this.assignment_description = assignment_description;
	}
	public Date getUpload_date() {
		return upload_date;
	}
	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public int getClass_name() {
		return class_name;
	}
	public void setClass_name(int class_name) {
		this.class_name = class_name;
	}
	
}
