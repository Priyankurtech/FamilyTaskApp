package com.family.controller;

import java.sql.SQLException;

import com.family.dao.TaskDao;


public class Testing {
   public static void main(String[] args) throws ClassNotFoundException, SQLException {
	TaskDao dao=new TaskDao();
	
	dao.create_table(dao.connect_to_database(), "familyevent");
  }
}
