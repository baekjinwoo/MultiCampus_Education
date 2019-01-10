package Inheritance;

class Branch {
	public Branch(){
		this("가나다");
		System.out.println("Branch default constructor");
	}
	
	public Branch(String st){
		System.out.println(st+" Branch constructor");
	}
}


class Leaf extends Branch {
	public Leaf(String str,int in){
		super();
		System.out.println(str+" "+in+" Leaf constructor");
	}
}

public class InheritanceEx3 {

	public static void main(String[] args) {
		new Leaf("가나다",10);
		
		
	}
}

/*class Branch {
	public Branch(){
		System.out.println("Branch default constructor");
	}
	
	public Branch(String str){
		this(); //2
		System.out.println(str+"Branch constructor");
	}
}


class Leaf extends Branch {
	public Leaf(){
		super("가나다"); //1
		System.out.println("Leaf default constructor");
	}
}

public class InheritanceEx3 {

	public static void main(String[] args) {
		new Leaf();
		
		
	}
}*/
