package model;
import java.util.Date;

public class StudyMaterial {
	private int material_id;
	private String material_title;
	private Date upload_date;
	private String material_file;
	private int material_type;
	private String class_name;
	
	public int getMaterial_id() {
		return material_id;
	}
	public void setMaterial_id(int material_id) {
		this.material_id = material_id;
	}
	public String getMaterial_title() {
		return material_title;
	}
	public void setMaterial_title(String material_title) {
		this.material_title = material_title;
	}
	public Date getUpload_date() {
		return upload_date;
	}
	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}
	public String getMaterial_file() {
		return material_file;
	}
	public void setMaterial_file(String material_file) {
		this.material_file = material_file;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public int getMaterial_type() {
		return material_type;
	}
	public void setMaterial_type(int material_type) {
		this.material_type = material_type;
	}
}
