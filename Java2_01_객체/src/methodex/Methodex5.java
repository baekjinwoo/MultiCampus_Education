package methodex;

//Call by Reference : 주소값을 전달하는 방식
public class Methodex5 {

	public static String view1(String s) {
		return s;
	}

	public static void view2(String s) {
		System.out.println(s);
	}

	public static void view3(int[] a){
		for(int i:a){
		System.out.println(i);
		}
		
		/*for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}*/
		
	}
	
	public static void main(String[] args) {
		String str = "Happy";
		System.out.println(view1(str)); // 출력(1)

		view2(str); // 출력(2)

		int[] num = { 10, 20, 30, 40, 50 };
		view3(num); // 출력(3)
	}
}
