package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.frame.Dao;
import com.frame.Sql;
import com.vo.Item;
import com.vo.User;

public class UserDao extends Dao<User, String> {
	public ArrayList<Item> getItems(String i,Connection conn)  
			throws Exception{
		ArrayList<Item> items = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectuseritem);
			pstmt.setString(1, i);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Item item = null;
				int id = rset.getInt("ID");
				String name = rset.getString("NAME");
				int price = rset.getInt("PRICE");
				item = new Item(id, name, price);
				items.add(item);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(rset);
			close(pstmt);
		}
		return items;
	}
	//User 추가-----------------------------------------------------
	@Override
	public void insert(User o, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertUser);
			pstmt.setString(1, o.getId());
			pstmt.setString(2, o.getPwd());
			pstmt.setString(3, o.getName());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}		
	}
	//Item 추가-----------------------------------------------------
	public void insertItem(ArrayList<Item> o, Connection conn) throws Exception{
	//	ArrayList<Item> items = o.getItems();
	//	String id = o.getId();
		PreparedStatement pstmt = null;
		try {
			for(Item item : o) { //반복문을 돌리는 이유는 아이템을 여러개 가져올 수 있기 떄문에
				pstmt = conn.prepareStatement(Sql.insertItem);
				pstmt.setInt(1, item.getId());
				pstmt.setString(2, item.getName());
				pstmt.setInt(3, item.getPrice());
				pstmt.executeUpdate();
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}
	}
	//UserItem 추가-----------------------------------------------------
	public void insertUserItem(User o, Connection conn) throws Exception{
		ArrayList<Item> items = o.getItems();
		String id = o.getId();
		PreparedStatement pstmt = null;
		try {
			for(Item item : items) {
				pstmt = conn.prepareStatement(Sql.insertUserItem);
				pstmt.setString(1, id);
				pstmt.setInt(2, item.getId());
				pstmt.executeUpdate();
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}
	}
	//-----------------------------------------------------------------
	@Override
	public void delete(String i, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User o, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User select(String i, Connection conn) throws Exception {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectUser);
			pstmt.setString(1, i);
			rset = pstmt.executeQuery();
			rset.next();
			String id = rset.getString("ID");
			String pwd = rset.getString("PWD");
			String name = rset.getString("NAME");
			user = new User(id, pwd, name);
		}catch(Exception e) {
			throw e;
		}finally {
			close(rset);
			close(pstmt);
		}	
		return user;
	}

	@Override
	public ArrayList<User> select(Connection conn) throws Exception {
		ArrayList<User> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectUserAll);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				User user = null;
				String id = rset.getString("ID");
				String pwd = rset.getString("PWD");
				String name = rset.getString("NAME");
				user = new User(id, pwd, name);
				list.add(user);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(rset);
			close(pstmt);
		}	
		return list;
	}
}





