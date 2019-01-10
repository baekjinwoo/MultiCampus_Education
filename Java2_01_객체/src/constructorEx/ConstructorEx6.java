package constructorEx;


public class ConstructorEx6 {

	public static void main(String[] args) {
		Student st = new Student();
		//setter로 값대입후 toString()으로 출력
		
		st.setName("홍길동");
		st.setEng(95);
		st.setKor(88);
		st.setMat(95);
		System.out.println(st.toString());
		
		
	    //인자 4개를 받는 생성자를 통해 객체를 생성한후 민들래,90,75,88를 
	    //대입한후 getter를 이용하여 출력
		
		Student ss=new Student("민들레", 90,75,88);
		System.out.println("\n이름: "+ ss.getName());
		System.out.println("국어: "+ ss.getKor());
		System.out.println("영어: "+ ss.getMat());
		System.out.println("총점: "+ ss.getTotal());
		System.out.println("평균: "+ ss.getAvg());
		System.out.println("학점: "+ ss.getGrade());

		
		
		/*System.out.println(ss.getName()+"의 점수는 "+ss.getTotal()+"이며, 평균은 "+ss.getAvg()+"이고, 학점은 "+ss.getGrade()+"입니다");
		
		System.out.println();
		
		System.out.println(ss.toString());
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/*
		new Student("홍길동",75,88,95);

		System.out.println(ss.getName()+"의 점수는 "+ss.getTotal()+"이며, 평균은 "+ss.getAvg()+"이고, 학점은 "+ss.getGrade()+"입니다");
		
		System.out.println();
		
		System.out.println(ss.toString());
*/		
		
	}
}
/*
[출력]
홍길동의 점수는 258 이며, 평균은 86.00이고 학점은 B입니다

이름:민들래
국어:90
수학:75
영어:88
총점:253
평균:84.33
학점:B
*/
