package ExceptionEx;

// $ java ExceptionEx1 2==> 2
// $ java ExceptionEx1 0==> 0으로 나눌 수 없음
// $ java ExceptionEx1 a==> 숫자로 바꿀수 없음



//unchecked exception
//예외처리는 문제를 해결하지못하고 버려버리는 것을 말한다.


public class ExceptionEx1 {
	public static void main(String[] args) {
		int val = 5;
		
		/*try{
			int n = Integer.parseInt(args[0]);
			System.out.println(val/n);
		}
		catch(Exception e){
			System.out.println("정상적으로 들어온 값 외에는 다 오류처리됩니다.");
		}*/
		
		
		try{
		int n = Integer.parseInt(args[0]);
		System.out.println(val/n);
		//system.exit(0);는 끌수 있으나, return;은 끌 수 없다. finally이 실행된다.
		}
		catch(ArithmeticException e){
			System.out.println("0으로 나눌수 없음");
		}
		catch(NumberFormatException e){
			System.out.println("숫자로 바꿀 수 없음");
		}
		catch(ArrayIndexOutOfBoundsException e){
		System.out.println("입력값이 없음");
		}
		finally{
			System.out.println("무조건 실행");
		}
		
		
		
	}
}
