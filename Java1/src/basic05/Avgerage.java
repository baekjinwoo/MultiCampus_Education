package basic05;

//총점과 평균을 구하는 프로그램을 작성하시오
public class Avgerage {
	public static void main(String[] args) {
	//자바, sql, jsp점수가 있다. int javajum=30; sqljum=100; int jspjum=89;
		int javajum=30;
		int sqljum=100;
		int jspjum=89;
		int sumjum=javajum+sqljum+jspjum;
		double averjum=sumjum/3.0;
		
		System.out.printf("총점은 %d이고, 평균은%.2f이다",sumjum,averjum);
	}
}
