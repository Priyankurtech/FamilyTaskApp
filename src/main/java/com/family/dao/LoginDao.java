package com.family.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	
	String url="jdbc:postgresql://localhost:5432/family_task";
	String uname = "postgres";
	String pwd ="abcde";
	String sql="SELECT * FROM family_members WHERE user_name=? and password=?";

	public boolean validate(String username,String password) {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();	}
		try {
			Connection con = DriverManager.getConnection(url,uname,pwd);
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultset = statement.executeQuery();
			if(resultset.next() == true) {
				return true;
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
		
		
		
		return false;
	}

}
