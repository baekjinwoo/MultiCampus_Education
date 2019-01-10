package basic05;

public class RefactorandGenerator {
	public static void main(String[] args) {
		//1. 원하는 메소드영역을 드래그해서-> refactor-> extract method/rename 
		//2. 그 외에도 source-> generator		
			  kajayukci();
			  kajayukci();
			  kajayukci();		
		}
		public static void kajayukci() {
			System.out.print("메소드를 꿀잼으로 만들자");
			System.out.print("메소드는 아니면 핵노잼?");
	}
}
