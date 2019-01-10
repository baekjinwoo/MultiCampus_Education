package com.user;

import java.sql.Connection;
import java.util.ArrayList;


import com.frame.Biz;
import com.vo.Item;
import com.vo.User;

public class UserBiz extends Biz<User, String> {
	UserDao dao;
	
	public UserBiz() {
		dao = new UserDao();
	}
	//정보입력------------------------------------------------------
	@Override
	public void register(User o) throws Exception {
		Connection conn = getConnection();
		try {
			// User 정보를 입력
			dao.insert(o, conn);
			// Item 정보 입력
			dao.insertItem(o.getItems(), conn);
			// User 가 보유 하고 있는 Item 정보 입력
			dao.insertUserItem(o, conn);
			conn.commit();
		}catch(Exception e) {
			conn.rollback();
			throw e;
		}finally {
			close(conn);
		}
	}
	//정보입력------------------------------------------------------
	@Override
	public void remove(String i) throws Exception {
		// TODO Auto-generated method stub
		
	}
	//정보입력------------------------------------------------------
	@Override
	public void modify(User o) throws Exception {
		// TODO Auto-generated method stub
		
	}
	//정보입력------------------------------------------------------
	@Override
	public User get(String i) throws Exception {
		// 입력 한 ID로 User정보 조회
		// 입력 한 ID로 UserItem을 조회 한다.
		// Item의 정보를 User에게 setting 한다.
		// User 정보를 리턴 한다.
		Connection conn = getConnection();
		User user = null;
		ArrayList<Item> items = null;
		try {
			user = dao.select(i, conn);
			items = dao.getItems(i, conn);
			user.setItems(items);
		}catch(Exception e) {
			throw e;
		}finally {
			close(conn);
		}
		return user;
	}
	//정보입력------------------------------------------------------
	@Override
	public ArrayList<User> get() throws Exception {
		// 모든 User 정보를 조회 한다.
		// 각각의 User의 ID를 이용하여 User Item 정보를
		// 조회 한다.
		// 각각의 User에게 Item 정보를 Setting 한다.
		// ArrayList 정보를 리턴 한다.
		Connection conn = getConnection();
		ArrayList<User> users = null;
		ArrayList<Item> items = null;
		try {
			users = dao.select(conn);
			for(User user: users) {
				items = dao.getItems(user.getId(), conn);
				user.setItems(items);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(conn);
		}
		return users;
	}

}





