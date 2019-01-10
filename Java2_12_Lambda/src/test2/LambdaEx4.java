package test2;

@FunctionalInterface
interface Item{
	public String getItem();
	
}

public class LambdaEx4 {
	public static void main(String[] args) {
		Item ob = () -> {return "컴퓨터";};
		System.out.println(ob.getItem());
	
		ob = () -> "프린터";
		System.out.println(ob.getItem());
	}
}
