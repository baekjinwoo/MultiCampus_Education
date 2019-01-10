package test2;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnimalTest {
	@Test
	public void test1(){
		String ob1="강아지";
		String ob2="고양이";
		
		Animal m=new Animal(ob1);
		assertEquals(m.getAnimal(), ob2);
		
		// 강아지랑 고양이랑 같은가? 같으면 t 다르면 false
	}
}
