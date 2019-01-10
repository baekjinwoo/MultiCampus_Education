package com.user.test;

import java.util.ArrayList;

import org.junit.Test;

import com.frame.Biz;
import com.user.UserBiz;
import com.vo.Item;
import com.vo.User;

public class UserBizTest {
	@Test
	public final void testRegisterUser() {
		Biz<User, String> biz = new UserBiz();
		ArrayList<Item> list = new ArrayList<>();
//		list.add(new Item(100, "칼", 1500));
//		list.add(new Item(200, "총", 2000));
//		User user = new User("id01", "pwd01", "강호동");
		
		list.add(new Item(300, "창", 1700));
		User user = new User("id03", "pwd03", "이순신");
		user.setItems(list);
		try{
			biz.register(user);
			System.out.println("입력성공");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
