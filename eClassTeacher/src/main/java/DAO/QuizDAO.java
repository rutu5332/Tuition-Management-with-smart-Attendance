package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Database.Data;
import model.Assignment;
import model.Quiz;

public class QuizDAO {

	private Data data;
	public QuizDAO() {
		super();
		// TODO Auto-generated constructor stub
		
		data = new Data();
	}
	public boolean addQuiz(Quiz quiz, int id) throws SQLException {
		
		String sql = "INSERT INTO quiz VALUES(default,?,?,?,?,?,?,?)";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String utime = format.format(quiz.getUpload_date());
		String dtime = format.format(quiz.getDue_date());
		PreparedStatement statement = data.cn.prepareStatement(sql);
	
		statement.setString(1, quiz.getQuiz_title());
		statement.setString(2, quiz.getQuiz_desc());
		statement.setString(3, quiz.getQuiz_file());
		statement.setString(4, utime);
		statement.setString(5, dtime);
		statement.setInt(6, id);
		statement.setInt(7, quiz.getClassname());
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    return true;
		}
		return false;
	}
	public ArrayList<Quiz> getDetails() throws ParseException, SQLException {
		
		ArrayList<Quiz>list = new ArrayList<Quiz>();
		String sql = "SELECT * FROM quiz";
		Statement statement = data.cn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		int cnt=0;
		
		while (result.next()) {
			
			Quiz quiz = new Quiz();
			quiz.setQuiz_id(result.getInt("quiz_id"));
			quiz.setQuiz_desc(result.getString("quiz_desc"));
			quiz.setQuiz_file(result.getString("quiz_file"));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			quiz.setUpload_date(format.parse(result.getString("upload_date")));
			quiz.setDue_date(format.parse(result.getString("due_date")));
			quiz.setClassname(Integer.parseInt(result.getString("class")));
			quiz.setQuiz_title(result.getString("quiz_title"));
			
			list.add(quiz);
		}
		
		return list;
	}
	
	
	
}
