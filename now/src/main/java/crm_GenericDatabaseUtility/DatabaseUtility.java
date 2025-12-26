package crm_GenericDatabaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection con;
	public void getDatabaseconnection(String url, String username, String password) {
		try {
			Driver d= new Driver();
			DriverManager.registerDriver(d);
			con=DriverManager.getConnection(url,username,password);
		}
		catch (Exception e) {
		}
	}
	public void closeDbConnection() {
		try {
			con.close();
		} catch (Exception e) {
		}
	}
	public ResultSet ExecuteSelectQuery(String query) {
		ResultSet result=null;
		try {
			Statement stat = con.createStatement();
			 result = stat.executeQuery(query);
		} catch (Exception e) {
		}
		return result;
	}
	public int ExecuteNonSelectQuery(String query) {
		int result=0;
		try {
			Statement stat = con.createStatement();
			 result = stat.executeUpdate(query);
		} catch (Exception e) {
		}
		return result;
	}
	public void getDatabaseconnection() {
		try {
			Driver d= new Driver();
			DriverManager.registerDriver(d);
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Myown","root","root");
		}
		catch (Exception e) {
		}
	}
	
}