package com.family.service;

import java.sql.SQLException;

import com.family.dao.TaskDao;

public class CreateTable {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		TaskDao dao = new TaskDao();
		dao.create_table(dao.connect_to_database(), "grocery_list");
	}
}
