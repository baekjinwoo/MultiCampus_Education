package constructorEx;

public class ConstructorEx1 { // 인자가 없는 "생성자"
	public ConstructorEx1(){
		System.out.println("default constructor");
		
	}
	
	public ConstructorEx1(String s){ //인자가 있는 "생성자"
		System.out.println(s);
	}
	
	public ConstructorEx1(String s, int a){ //인자가 있는 "생성자"
		System.out.println(s+", "+a);
	}
	
	public static void main(String[] args) {
		
/*		ConstructorEx1 ob1=new ConstructorEx1();
		ConstructorEx1 ob2=new ConstructorEx1("가나다"); //객체는 다 다르게 해줘야한다. ob1 , ob2
		ConstructorEx1 ob3=new ConstructorEx1("가나다",10); */
		
		new ConstructorEx1();
		new ConstructorEx1("가나다"); //객체는 다 다르게 해줘야한다. ob1 , ob2
		new ConstructorEx1("가나다",10);
		
		
	}
}
