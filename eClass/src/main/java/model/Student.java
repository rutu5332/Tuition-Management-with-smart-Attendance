package model;
import java.util.Date;

public class Student {
	private int student_id;
	private String student_name;
	private int student_class; 
	private Date dob;
	private String image;
	private long student_phoneno;
	
	public Student(String student_name, int student_class, Date dob, String image, long student_phoneno,
			String student_email, String parent_name, long parent_phoneno, String parent_email, String password) {
		super();
		this.student_name = student_name;
		this.student_class = student_class;
		this.dob = dob;
		this.image = image;
		this.student_phoneno = student_phoneno;
		this.student_email = student_email;
		this.parent_name = parent_name;
		this.parent_phoneno = parent_phoneno;
		this.parent_email = parent_email;
		this.password = password;
	}
	
	public Student(String student_name, int student_class, Date dob, String image, long student_phoneno,
			String student_email, String parent_name, long parent_phoneno, String parent_email) {
		super();
		this.student_name = student_name;
		this.student_class = student_class;
		this.dob = dob;
		this.image = image;
		this.student_phoneno = student_phoneno;
		this.student_email = student_email;
		this.parent_name = parent_name;
		this.parent_phoneno = parent_phoneno;
		this.parent_email = parent_email;
	}

	

	public Student(int student_id, String student_name, int student_class, Date dob, String image, long student_phoneno,
			String student_email, String parent_name, long parent_phoneno, String parent_email) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_class = student_class;
		this.dob = dob;
		this.image = image;
		this.student_phoneno = student_phoneno;
		this.student_email = student_email;
		this.parent_name = parent_name;
		this.parent_phoneno = parent_phoneno;
		this.parent_email = parent_email;
		
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public String getParent_name() {
		return parent_name;
	}

	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}

	public long getParent_phoneno() {
		return parent_phoneno;
	}

	public void setParent_phoneno(long parent_phoneno) {
		this.parent_phoneno = parent_phoneno;
	}

	public String getParent_email() {
		return parent_email;
	}

	public void setParent_email(String parent_email) {
		this.parent_email = parent_email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String student_email; 
	private String parent_name;
	private long parent_phoneno; 
	private String parent_email;
	private String password;
	

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public int getStudent_class() {
		return student_class;
	}

	public void setStudent_class(int student_class) {
		this.student_class = student_class;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getStudent_phoneno() {
		return student_phoneno;
	}

	public void setStudent_phoneno(long student_phoneno) {
		this.student_phoneno = student_phoneno;
	}
	
}
