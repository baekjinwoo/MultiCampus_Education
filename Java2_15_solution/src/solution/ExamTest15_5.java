package solution;

//세 개의 주사위를 던졌을 때, 눈의 곱이 3의 배수인 값을 출력하는 프로그램을 작성하시오

public class ExamTest15_5 {
	public static void main(String[] args) {

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 6; k++) {
					if (((i * j * k) % 3 == 0)&& (i!=0 && j!=0 && k!=0)) { //조건(1): 세 개의 변수의 곱이 3의배수
						System.out.println(i+"*"+j+"*"+k+"="+(i*j*k));	   //조건(2): 세 개의 변수는 0이 아니다
					} // if-end
				} // for-end
			} // for-end
		} // for-end
	}
}
