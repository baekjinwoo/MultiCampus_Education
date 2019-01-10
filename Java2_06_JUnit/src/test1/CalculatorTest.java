package test1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CalculatorTest {
	private Calculator ob;

	
	@Before
	public void setUp(){
		ob= new Calculator();
		System.out.println("setUp");
	}
	
	@After
	public void tearDown(){
		System.out.println("tearDown()");
	}
	
	
	@Test
	public void concatenate(){
		//Calculator ob=new Calculator();
		String s=ob.concatenate("abc","가나다");
		assertEquals("abc가나다", s);
	}
	@Test
	public void add(){
		//Calculator ob=new Calculator();
		int n=ob.add(3,5);
		assertEquals(8, n);
	}
	@Test
	public void subtract(){
		//Calculator ob=new Calculator();
		int n=ob.subtract(7,5);
		assertEquals(2, n);
	}
}

// @Test가 3개니까 3번 호출한다.
// @Before에서 한번 @After에서 한번씩 3번 호출한다.


