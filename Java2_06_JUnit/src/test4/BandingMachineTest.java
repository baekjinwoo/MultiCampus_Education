package test4;

//JUnit : 단위테스트. 연결되어있지않기때문에 이렇게 해야한다.
// 여럿이서 프로젝트를 만들때 각자 main없이 Test를 해보고 이상없으면 BandingMachine.java를 전달하면 됨.

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*   @Before   : BadingMachine객체생성
 *   @After     : 잔돈표시
 *   @Test     :  testInsertCoin  <-- 500,100,100주입한후
 *                                              현재 금액확인    
 *   @Test    : testNegativeCoin  <--  -100주입                                          
 */
public class BandingMachineTest {
	private BandingMachine ob;
	
	@Before
	public void setUp(){
		ob=new BandingMachine();
		System.out.println("1");
	}
	@After
	public void tearDown(){
		System.out.println("100");
		//Assert.assertEquals(700, ob.getCurrent());
	}
	
	
	@Test
	public void testInsertCoin(){
		ob.insertCoin(500);
		ob.insertCoin(100);
		ob.insertCoin(100);
		
		Assert.assertEquals(700, ob.getCurrent());
		System.out.println("2");
	}
	@Test(expected=RuntimeException.class) 
	public void testNegativeCoin(){
		ob.insertCoin(-100);
		System.out.println("3");
	}
}
