package com.user.test;

import org.junit.Test;

import com.user.UserBiz;
import com.vo.User;

public class UserSelectBizTest {
	@Test
	public final void testGetString(){
		UserBiz biz = new UserBiz();
		User user =null;
		try{
			user=biz.get("id03");
				System.out.println(user);
				System.out.println(user.getItems()); //getId()가 아니고 Items
			
		}catch(Exception e){
		e.printStackTrace();
		}
	}
}
	
//	@Test
//	public final void testGetString(){
//		UserBiz biz = new UserBiz();
//		ArrayList<User> users =null;
//		try{
//			users=biz.get();
//			for(User user:users){
//				//System.out.println(user);
//				//System.out.println(user.getItems()); //getId()가 아니고 Items
//				System.out.println(user.getId());
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	
	
