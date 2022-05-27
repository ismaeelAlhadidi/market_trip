package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.util.List;
import java.util.ArrayList;

public class DBConnection {
	
	private String driver = "com.mysql.jdbc.Driver";
	private String server = "jdbc:mysql://localhost:3325";
	private String databaseName = "market_trip";
	private String username = "root";
	private String password = "";
	
	private Connection connection;
	
	public DBConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName(driver);
		connection = DriverManager.getConnection(server + "/" + databaseName, username, password);
	}
	
	
	public int executeUpdate(String sql) throws SQLException {
		
		Statement statement = connection.createStatement();
		
		return statement.executeUpdate(sql);
	}
	
	public ResultSet executeQuery(String query) throws SQLException {
		
		Statement statement = connection.createStatement();
		
		return statement.executeQuery(query);
	}
	
	public void close() {
		try {
			connection.close();
		} catch(SQLException e) { }
	}
}
