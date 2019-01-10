package test3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	private Account account;
	
	@Test
	public void testAccount() throws Exception{
		if(account==null){
			throw new Exception("계좌 생성 실패");
		}
		System.out.println("testAccount()");
	}
	@Before
	public void setUP(){
		account=new Account(100000);
		System.out.println("setUP()");
	}
	@Test
	public void testGetBalance() throws Exception{
		Assert.assertEquals(100000, account.getBalance());
		
		account=new Account(50000);
		Assert.assertEquals(50000, account.getBalance());
		
		account=new Account(0);
		Assert.assertEquals(0, account.getBalance());
	
	}
	
	@Test	
	public void testDeposit() throws Exception{
		account.deposit(3000);
		assertEquals(103000,account.getBalance());
		}
	
	@Test
	public void testWithdraw() throws Exception{
		account.withdraw(20000);
		Assert.assertEquals(80000, account.getBalance());
	}
	
	
}




