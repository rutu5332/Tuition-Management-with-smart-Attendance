package model;
import java.util.Date;

public class Quiz {
	private int quiz_id;
    private String quiz_title;
    private String quiz_desc;
    private String quiz_file;
    private Date upload_date;
    private Date due_date;
    private int classname;
    
	public int getQuiz_id() {
		return quiz_id;
	}
	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}
	public String getQuiz_title() {
		return quiz_title;
	}
	public void setQuiz_title(String quiz_title) {
		this.quiz_title = quiz_title;
	}
	public String getQuiz_desc() {
		return quiz_desc;
	}
	public void setQuiz_desc(String quiz_desc) {
		this.quiz_desc = quiz_desc;
	}
	public String getQuiz_file() {
		return quiz_file;
	}
	public void setQuiz_file(String quiz_file) {
		this.quiz_file = quiz_file;
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
	public int getClassname() {
		return classname;
	}
	public void setClassname(int classname) {
		this.classname = classname;
	}
}
