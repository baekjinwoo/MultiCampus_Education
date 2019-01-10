package com.example.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTemplate {

	public static Connection getConnection() { //Connection을 main실행과 동시에 실행시키려고 static으로 작성. static이 작성되면 클래스로 호출가능
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", "credu", "credu");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static boolean isConnection(Connection conn) {
		boolean valid = true;
		try {
			if (conn == null || conn.isClosed())
				valid = false;
		} catch (SQLException e) {
			valid = false;
			e.printStackTrace();
		}
		return valid;
	}

	public static void commit(Connection conn) {
		if (isConnection(conn)) { //접속되어있으면
			try {
				conn.commit(); //commit해라
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void rollback(Connection conn) {
		if (isConnection(conn)) { //접속되어있으면
			try {
				conn.rollback(); //rollback해라
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Connection객체 닫기
	public static void close(Connection conn) {
		if (isConnection(conn)) { //연결되어있다면
			try {
				conn.close(); //닫기
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Statement or PreparedStatement객체 닫기
	public static void close(Statement stmt) {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ResultSet 객체 닫기
	public static void close(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
