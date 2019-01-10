package homework01;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*[문제17] Hashtable 컬렉션을 이용하여 다음 프로그램을 작성하시오

(1)클래스명 : PhoneBook
- phoneNumber : String
- address : String
+ PhoneBook(phoneNumber:String,address:String)
+ toString():String      ==> 연락처와 주소의 출력문자열을 리턴한다

(2)사용데이터
    key             value
    ----------------------------------
    홍길동         123-4567   서울
    이몽룡         345-3345   대구
    임꺽정         123-7890   부산

(2)조건
    1) main()메서드에서 Hashtable클래스로 ob객체를 만들어 데이터를 추가한다
    2) 제네릭스를 이용한다

[출력화면]
찾는 이름: 임꺽정
Phone: 123-7890
Address: 부산

찾는 이름 : 방자
그런사람 없음
*/

class PhoneBook{
	private String phoneNumber;
	private String address;
	public PhoneBook(String phoneNumber, String address){
		this.phoneNumber=phoneNumber;
		this.address=address;
	}
	public String toString(){
		//연락처와 주소의 출력문자열을 리턴
		return phoneNumber + "\n"+ address;
	}
}

public class munjae17 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String,PhoneBook> ob = new Hashtable<>();
		ob.put("홍길동", new PhoneBook("123-4567","서울"));
		ob.put("이몽룡", new PhoneBook("345-3345","대구"));
		ob.put("임꺽정", new PhoneBook("123-7890","부산"));
		
		System.out.println("찾는 이름은: ");
		String name = sc.next();
		
		Set<String> key =ob.keySet();
		if(key.contains(name))
			System.out.println(ob.get(name));
		else
			System.out.println("찾는 이름이 없습니다.");
	}
}
