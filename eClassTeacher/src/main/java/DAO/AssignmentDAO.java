package DAO;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Database.Data;
import model.Assignment;
import model.AssignmentSubmission;

public class AssignmentDAO {

	
	private Data data;
	
	public AssignmentDAO() {
		super();
		// TODO Auto-generated constructor stub
		
		data = new Data();
	}
	
	public boolean uploadAssignment(Assignment assignment) throws SQLException
	{
		String sql = "INSERT INTO assignment VALUES(default,?,?,?,?,?,?,?)";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String utime = format.format(assignment.getUpload_date());
		String dtime = format.format(assignment.getDue_date());
		PreparedStatement statement = data.cn.prepareStatement(sql);
	
		statement.setString(1, assignment.getAssignment_title());
		statement.setString(2, assignment.getAssignment_file());
		statement.setString(3, assignment.getAssignment_description());
		statement.setString(4, utime);
		statement.setString(5, dtime);
		statement.setInt(6, assignment.getTeacher_id());
		statement.setInt(7, assignment.getClass_name());
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    return true;
		}
		return false;
		
	}

	public ArrayList<Assignment> getDetails() throws SQLException, ParseException {
		
		ArrayList<Assignment> lists = new ArrayList<Assignment>();
		String sql = "SELECT * FROM assignment";
		Statement statement = data.cn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		int cnt=0;
		
		while (result.next()) {
			Assignment assignment = new Assignment();
			assignment.setAssignment_id(result.getInt("assignment_id"));
			assignment.setAssignment_title(result.getString("assignment_title"));
			assignment.setAssignment_description(result.getString("assignment_description"));
			assignment.setAssignment_file(result.getString("assignment_file"));
			assignment.setClass_name(result.getInt("class"));
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			assignment.setUpload_date(format.parse(result.getString("upload_date")));
			assignment.setDue_date(format.parse(result.getString("due_date")));
			lists.add(assignment);
			
		}
		
		return lists;
		
	}

	public Assignment getAssignment(int aid) throws SQLException, ParseException {
		
		String sql = "SELECT * FROM assignment where assignment_id like "+aid+";";
		Statement statement = data.cn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		result.next();
		Assignment ass =new Assignment();
		ass.setAssignment_title(result.getString("assignment_title"));
		ass.setAssignment_description(result.getString("assignment_description"));
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		ass.setUpload_date(format.parse(result.getString("upload_date")));
		ass.setDue_date(format.parse(result.getString("due_date")));
		return ass;
	}
	
	public ArrayList<AssignmentSubmission> getResponses(int aid) throws ParseException, SQLException
	{
		ArrayList<AssignmentSubmission>list = new ArrayList<AssignmentSubmission>();
		String sql = "SELECT * FROM assignment_submission where assignment_id="+aid+";";
		Statement statement = data.cn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		int cnt=0;
		
		while (result.next()) {
			
			AssignmentSubmission as = new AssignmentSubmission();
			as.setId(Integer.parseInt(result.getString("id")));
			as.setStudent_id(Integer.parseInt(result.getString("student_id")));
			as.setFile(result.getString("submission_file"));
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			as.setSub_date(format.parse(result.getString("submission_date")));
			list.add(as);
			
		}
		return list;
	}
}
