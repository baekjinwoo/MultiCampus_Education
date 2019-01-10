package test4;

interface Obj{
	public void m();
}

public class StreamEx3 {
	public static void display(){
		System.out.println("abcd");
	}

	public static void main(String[] args) {
		Obj ob=StreamEx3::display;
		ob.m();
	}
}
