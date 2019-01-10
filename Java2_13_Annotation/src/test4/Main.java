package test4;

public class Main {
	public static void main(String[] args) {
		// getAnnotationsByType : 어노테이션의 슈퍼 타입을 받는다
		Day[] d=MyDay.class.getAnnotationsByType(Day.class);
		for(Day mday : d){
			System.out.println(mday.name());
		}
	}
}





