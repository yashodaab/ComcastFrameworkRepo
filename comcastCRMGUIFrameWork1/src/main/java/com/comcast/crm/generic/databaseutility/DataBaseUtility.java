package com.comcast.crm.generic.databaseutility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	
	Connection con;
	public void getConnection(String url, String username, String password)
	{
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username, password);
			}
		catch(Exception e) {
			
		}
	}
	
	public void closeDBConnection()
	{
		try {
			con.close();
		}
		catch(Exception e) {
			
		}
	}
	
	public ResultSet executeSelectQuery(String query)
	{
		ResultSet result = null ;
		try {
			Statement stat = con.createStatement();
			result = stat.executeQuery(query);
		}
		catch(Exception e) {
			
		}
		return result;
	}
	
	public Object executeNonSelectQuery(String query)
	{
		Object result = null;
		try {
			Statement stat = con.createStatement();
			result = stat.executeQuery(query);
		}
		catch(Exception e) {
			
		}
		return result;
	}
	
	public void getDBConnection()
	{
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jsbc:mysql://localhost:3036/projects", "root", "root");
			}
		catch(Exception e) {
			
		}
	}

}