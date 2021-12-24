package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Assignment;
import model.StudyMaterial;
import util.DbConnection;

public class StudyMaterialDao {

	
		
		public List<StudyMaterial> getDetails() {
			String query="select * from study_material";
			Connection conn = null;
			PreparedStatement pr = null;
			//String query = null;
			String msg="";
			//User u1=null;
			List<StudyMaterial> list=new ArrayList(); 
			try {
			conn = DbConnection.getConnection();
			pr = conn.prepareStatement(query);
		  ResultSet rs=pr.executeQuery();
		  while(rs.next())
		  {
			  	StudyMaterial s=new StudyMaterial();
			  	
			  	s.setMaterial_id(Integer.parseInt(rs.getString("material_id")));
			  
			  	s.setMaterial_file(rs.getString("material_file"));
			  	s.setMaterial_title(rs.getString("material_title"));
			  	s.setUpload_date(rs.getDate("upload_date"));
			  	
			  	list.add(s);
		  }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;

	}
	
}
