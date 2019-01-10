package ExceptionEx;

//사용자정의 예외처리
class MyException extends Exception{
public void ExceptionEx4(){
		
	}
}
public class ExceptionEx4{
	public static void main(String[] args) throws MyException {
		int age = Integer.parseInt(args[0]);
		if(age<15)
			throw new MyException();
		else
			System.out.println("즐거운 시간 되세요");
	}
}
