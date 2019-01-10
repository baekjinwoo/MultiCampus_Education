package Override;

//부모가 자식이름으로 호출된다.
// 부모와 자식의 동일한 이름의 메서드가 있을때 호출하면 자식이 호출된다
// 만약 자식메서드가 없는대 호출된다면 부모가 출력된다.
class Test1 {
	public void view1() { System.out.println("view1 method"); }
	public void view3() { System.out.println("view3 method"); }

}

class Test2 extends Test1 {
	@Override //view1은 오버라이드된 함수이다. 
	public void view1() { System.out.println("view11 method"); }
	public void view2() { System.out.println("view22 method"); }
}

public class OverrideEx1 {

	public static void main(String[] args) {
/*
 Test2 ob = new Test2();  //Test2 ob=new Test2():에서는 왠만하면 오류가 나지 않는다.
 ob.view1();  //view 11이 나온다
 ob.view2(); //view22 나온다
 ob.view3(); //view 3이 나온다
*/

 Test1 ob=new Test2();  
 ob.view1(); //view 11
 //ob.view2(); //error   //Test1 ob=new Test2();이기 떄문에 ob는 Test1부터 주소를 찾아간다. 그리고 Test1에 view1이 있으면 Test2에있는 view2를 찾아간다. 
 ob.view3(); //view 3	 //하지만 Test1에 view2가 없으니까 찾아갈 수 없다. 이러한 원리는 자식은 extends로 부모를 알 수 있지만 부모는 자식을 알기위해 거꾸로 오버라이드인 메서드를 통해 찾아갈 수 있다.

//new Test2(); 라고 쓰는 이유는 주소를 저장하는 변수(객체)ob가 필요하지 않고 생성자만 호출할때 쓴다
		


 /*Test2 ob = new Test1(); // Test2 ob = new Test1()은 불가능하다.
 ob.view1();  //view 11이 나온다
 ob.view2(); //view22 나온다
 ob.view3(); //view 3이 나온다
*/
		
		
	}
}
