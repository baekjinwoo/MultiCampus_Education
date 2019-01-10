package test3;

public class MyMember {
	@Member(name="admin")
	public void view1(){
		System.out.println("관리자");
	}
	@Member(name="all")
	public void view2(){
		System.out.println("일반사용자");
	}
}
