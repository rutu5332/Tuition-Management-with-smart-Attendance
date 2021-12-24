package util;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	public class DbConnection 
	{
		public static Connection getConnection() throws Exception
		{
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			String url = "jdbc:mysql://localhost:3306/eclass?characterEncoding=latin1";
			String user = "root";
			String pass = "root";
			Connection conn = null;
			conn = DriverManager.getConnection(url, user, pass);
			return conn;
		}
		public static void closeConnection(Connection conn, PreparedStatement pr) throws SQLException 
		{
			if(conn != null) 
				conn.close();
			if(pr != null) 
				pr.close();
		}
	}


