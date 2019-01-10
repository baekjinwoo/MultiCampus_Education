package basic11;

//2. throws (1)
public class Exception02 {
	public static void main(String[] args) {
		try{
			kaja();
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("던진것 받아 여기서 예외 처리");
		}
	}
	static void kaja()
			throws ArrayIndexOutOfBoundsException{
			String[] aa=new String[10];
			aa[100]="야 100번쨰다";		
	}
}
