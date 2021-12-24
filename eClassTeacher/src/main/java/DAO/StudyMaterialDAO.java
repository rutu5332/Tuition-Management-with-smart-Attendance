package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Database.Data;
import model.Assignment;
import model.StudyMaterial;

public class StudyMaterialDAO {
	
private Data data;
	
	public StudyMaterialDAO() {
		super();
		// TODO Auto-generated constructor stub
		
		data = new Data();
	}

	public boolean addStudyMaterial(StudyMaterial sm, int tid) throws SQLException {
	
		String sql = "INSERT INTO study_material VALUES(default,?,?,?,?,?,?)";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String utime = format.format(sm.getUpload_date());
		PreparedStatement statement = data.cn.prepareStatement(sql);
	
		statement.setString(1, sm.getMaterial_title());
		statement.setString(2, utime);
		statement.setString(3, sm.getMaterial_file());
		statement.setInt(4, tid);
		statement.setString(5, sm.getClass_name());
		statement.setInt(6, sm.getMaterial_type());
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    return true;
		}
		return false;

	}

	public ArrayList<StudyMaterial> getLectures() throws SQLException {

		ArrayList<StudyMaterial> lists = new ArrayList<StudyMaterial>();
		String sql = "SELECT * FROM study_material where material_type=0;";
		Statement statement = data.cn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		int cnt=0;
		
		while (result.next()) {
			
			StudyMaterial s = new StudyMaterial();
			s.setMaterial_file(result.getString("material_file"));
			s.setMaterial_title(result.getString("material_title"));
			lists.add(s);
		}
		return lists;
	}
	

}
