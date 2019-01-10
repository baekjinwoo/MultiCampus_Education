package com.frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/*ex1)class Biz<T>{
 * 
 *   Biz<String> ob1=new Biz<String>();
 *   Biz<Integer> ob1=new Biz<Integer>();
 *   Biz<String> ob1=new Biz<String>();
 *
 * }
 * 
 * 
 *ex2)abstract class Biz<X,Y>{
 *   public abstract void register(X x);
 *   public abstract void remove(Y y);
 * }

 * class UserBiz extends Biz<User,String>{
 *   public void register(User user){

 * }
 *   public void remove(String s){
 
 * }
 * 
 * <관계형 데이터베이스>
 * ex3) 테이블명: t_user
 * id   pwd   name
  (p.k)
 * ----------------
 * id01 pwd01 강호동
 * id02 pwd02 이만기
 * id03 pwd03 이순신

 * 테이블명: t_item
 * id   name   price
  (p.k)
 * -----------------
 * 100    칼	 1500
 * 200   총	 2000
 * 300   창   1700
 * ----------------
 *
 * 
 
 * 테이블명: t_useritem
 * userid     itemid
 * id01			100
 * id01			200
 * id02			200
 * id03			100
 * id03			200
 * id03			300
 * -----------------
 * */


public abstract class Biz<O,I> {
	
	protected Dao<O,I> dao;
	
	public Biz(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found...");
		}
	}
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "credu";
		String password = "credu";
		try {
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void close(Connection conn) {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
			
			}
	}
	public abstract void register(O o) throws Exception;
	public abstract void remove(I i) throws Exception;
	public abstract void modify(O o) throws Exception;
	public abstract O get(I i) throws Exception;
	public abstract ArrayList<O> get() throws Exception;
}
