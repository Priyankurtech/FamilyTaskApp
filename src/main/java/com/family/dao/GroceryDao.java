package com.family.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.family.dto.AddTaskEvent;
import com.family.dto.Grocery;
import com.family.dto.TaskEventShow;

public class GroceryDao {
	public Connection connect_to_database() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/family_task", "postgres",
				"abcde");
		if (connection == null) {
			System.out.println("not connected");
		} else {
			System.out.println("connected");
		}
		return connection;
	}


	public void addGrocery(Grocery grocery) throws ClassNotFoundException, SQLException {

		String groceryname = grocery.getGroceryName();
		String quantity=grocery.getQuantity();
		Connection con = connect_to_database();
		Statement statement = con.createStatement();
		String query = String.format(
				"insert into grocery_list(item_name,quantity,status) values('%s','%s','%s');",
				groceryname, quantity, "not done");
		statement.executeUpdate(query);
	}
	public List getAllGrocery()throws ClassNotFoundException, SQLException {
        List<Grocery> gro=new ArrayList<Grocery>();
		
		String query = "select * from grocery_list";
		Connection con = connect_to_database();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			int gid=resultSet.getInt("item_id");
			String gname = resultSet.getString("item_name");
			String gquantity = resultSet.getString("quantity");
			String status = resultSet.getString("status");
			
			Grocery grocery=new Grocery();
			
			grocery.setGroceryid(gid);
			grocery.setGroceryName(gname);
			grocery.setQuantity(gquantity);
			grocery.setStatus(status);
			gro.add(grocery);
		}
		return gro;
		
		
	}
}
