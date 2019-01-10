package tv1;

//결합도가 높다 (<= 나쁜 거다 <= 유지보수할 떄 이것도 고치고 저것도 고쳐야 하기때문에, 따라서  응집도가 높고 결합도가 낮아야 좋은 코드)

// $ javac TvUser.java --> TvUser.class
// $ java TvUser 10 20 30 aaa //뒤에 문자는 메인의 args로 들어간다. 
// 외부에서 들어오는 값은 int가 아니고 문자열로 들어온다. 그 이유는
// 전화번호 010-111-1111하면 빼기는 빼기로 인식한다.
// 비슷한 예로 주민등록번호가 있다.
// 따라서 있는 그대로 출력하기 위해서 문자열로 출력한다
public class TvUser {
	public static void main(String[] args) {
		String com=args[0]; // run as -> run configuration -> variable -> ${string_prompt}
		
		if(com.equals("LG"))    // com=="LG" 같은 개념
		{
			LgTv tv=new LgTv();
			tv.powerOn();
			tv.powerOff();
			tv.volumeUp();
			tv.volumeDown();
		}else if(com.equals("SAMSUNG")){  // 값비교  com=="SAMSUNG" 같은 개념 ,, ==가 주소값비교
			SamsungTv tv=new SamsungTv();
			tv.turnOn();
			tv.turnOff();
			tv.soundUp();
			tv.soundDown();
		}else{
			System.out.println("error");
		}

	}
}
