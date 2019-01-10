package ObjectEx;


import static java.lang.System.out; //static을 처리했을때는 이와같이 해도 괜찮다.
public class ObjectEx{
	String str = "test";

	public void view(){
		out.println(str);
	}
	
	public static void main(String[] args) {
		new ObjectEx().view();
	}
}



/*public class ObjectEx{
	String str = "test";

	public void view(){
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		new ObjectEx().view();
	}
}
*/



/*import java.lang.String;
import java.lang.System;

public class ObjectEx extends Object {
	String str = "test";
	public ObjectEx(){
		super();
	}
	
	public void view(){
		System.out.println(str.toString());
	}
	
	public static void main(String[] args) {
		ObjectEx ob = new ObjectEx();
		ob.view();
	}
}
*/