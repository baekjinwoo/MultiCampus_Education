package test2;

interface Ver{

	public String call(String name);
}


public class LambdaEx5 {
	public static void main(String[] args) {
		
		Ver m1 = (name)-> { return "java:" + name;};
	
		System.out.println(m1.call("ver 8.0"));
	}
}
