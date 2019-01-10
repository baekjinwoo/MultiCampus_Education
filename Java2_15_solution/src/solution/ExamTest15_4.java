package solution;

//Math.random()를 이용해서 1부터 6사이의 임의의 int 형 정수를 출력 하는 프로그램을 작성하시오

public class ExamTest15_4 {
	public static void main(String[] args) {

		int r= (int)((Math.random()*6)+1); //1~6은 6-1 
		System.out.println(r);
	}
}
