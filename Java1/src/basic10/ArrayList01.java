package basic10;

//1. 컬렉션과 제네릭스와 toString()를 사용하시오. (컬렉션은 List, Map, Set이라는 interface가 있습니다.)
import java.util.ArrayList;

class Screen{
	private String sname;
	
	public Screen(String sname){
		this.sname=sname;
	}
	public String getSname(){
		return sname;
	}
	public void setSname(String sname){ //getter , setter
		this.sname=sname;
	}
	
	public String toString(){
		return "("+this.sname+")";
	}
}


public class ArrayList01 {
	public static void main(String[] args) {
	ArrayList<Screen> scr1= new ArrayList<Screen>(); //이 배열에 들어갈 수 있는건 스크린 객체만 들어갈 수 있다.

	//영화제목넣기
	scr1.add(new Screen("코코")); // new -> 생성자 -> 코코가 sname대입
	scr1.add(new Screen("에로우시즌5")); //만들때마다 들어가고 늘어나는 Collection가변배열 
	scr1.get(0).getSname(); //코코배열만 꺼내라
	
	//반복문으로 꺼내라
	for(int i=0; i<scr1.size();i++){
		System.out.println(scr1.get(i).toString());
		}	
	
	}
}
