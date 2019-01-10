package homework01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*[문제16] HashMap컬렉션을 이용하여 다음 자료를 추가하시오
(1)클래스명 : Heripoter
   -no:int
   -firstname:String
   -lastname:String
   +Heripoter(no:int,firstname:String,lastname:String)
   +toString():String

(2) 사용데이터
     key        value
    ------------------------------------- 
     101        해리           포터
     102        론              위즐리
     103        헤르미온느  그레인져

(2)조건
   1) main()함수에서 HashMap클래스로 hm객체를  만들어 데이터를 추가한다
   2) 제네릭스를 이용한다

[출력화면]
성              이름
----------------------
해리           포터
론              위즐리
헤르미온느  그레인져*/

class Heripoter {
	private int no;
	private String firstname;
	private String lastname;

	public Heripoter(int no, String firstname, String lastname) {
		this.no = no;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public String toString() {
		return firstname + "  \t   " +lastname ;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}

public class munjae16 {
	public static void main(String[] args) {
		Map<Integer,Heripoter> hm = new HashMap<>();
		
		 System.out.println("성 \t 이름");
		 
		 hm.put(101, new Heripoter(101,"해리","포터"));
		 hm.put(102, new Heripoter(102,"론","위즐리"));
		 hm.put(103, new Heripoter(103,"해르미온느","그레인저"));

		System.out.println("---------------------");
		Set<Integer> keys = hm.keySet();
		for (Integer k : keys) {
			System.out.println(hm.get(k));
		}
	}
}