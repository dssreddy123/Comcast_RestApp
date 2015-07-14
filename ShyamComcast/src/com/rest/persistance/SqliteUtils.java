package com.rest.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.rest.vo.User;

final public class SqliteUtils {
	static private SqliteUtils sqliteUtils = null;
	private Connection conn = null;

	public Connection getConn() {
		return this.conn;
	}

	private SqliteUtils() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:users.db");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveUser(User user) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = getConn();
			stmt = conn.createStatement();
			// INSERT INTO USERS (USERNAME,EMAILADDRESS,DATE) VALUES ("Dabeeth",
			// "dabeeth@gmail.com", "Date");
			String sql = "INSERT INTO USERS (USERNAME,EMAILADDRESS,DATE) "
					+ "VALUES (\"" + user.getUsername() + "\",\""
					+ user.getEmailAddress() + "\",\""
					+ user.getDateRegistered() + "\")";
			if (stmt == null)
				System.out.println("statement is null");
			else
				System.out.println("statement is not null");
			System.out.println(sql);
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static SqliteUtils getInstance() {
		if (sqliteUtils == null)
			sqliteUtils = new SqliteUtils();
		return sqliteUtils;
	}
}
