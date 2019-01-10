package basic05;

public class CommandLine {
	public static void main(String[] args) {
		/* 커맨드 라인: 그때그때 값을 너줄때 사용하는 것
		ex) 명령= 30 80인자들  
		명령인자들이 명령을 받아들일 수 있도록 무언가가 받아줘야하는대 이를 String[] args가 한다.
		따라서, main안의 인자(String[] args)<=문자열배열은 평상시에 쓸일이 없지만 명령어 뒤에 인자를 받고 싶을때
		사용하게되면 자동으로 인식된다. */

		
		
		//명령어 뒤에 붙일 인자 30에 붙은 따옴표를 제거하기 위하여 (문자->정수화)
		//Run-> Run configurations-> main->Argument(인자) ->명령어뒤에 넣고싶은 값을 넣고 Run한다.
		if(args.length!=2){
			System.out.println("정신똑바로!"); //명령어가 원하는 변수 두개만 작성하도록 알려주기위한 문구
			System.out.println("사용법: 명령  인자 인자(숫자)");
			//return; //강제종료(1)
			System.exit(1); //강제종료(2)
		}
		System.out.println(Integer.parseInt(args[0])+ Integer.parseInt(args[1]));
										//80			//30					


	}
}
