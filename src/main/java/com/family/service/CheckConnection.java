package com.family.service;

import java.sql.SQLException;

import com.family.dao.TaskDao;

public class CheckConnection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		TaskDao dao = new TaskDao();
		dao.connect_to_database();
	}
}
