package family;

class  MainEx
{
	public static void main(String[] args) 
	{
		Family f = new Family("강호동");
		System.out.println(f.toString());
	
		}
	}



/*class  MainEx
{
	public static void main(String[] args) 
	{
		Family[] ob = new Family[]{
				new Father("홍길동"), //Family로 시작해서 자식클래스 형변환.
				new Mother("김순희"),
				new Son("홍돌이")
		};
		
				
		for(Family m:ob){ //Family로 주소값을 받는 형변환. //ob라는 방을 만들어서 그 방은 각각 3개의 방을 가지는대 각각 방마다 주소값을 기억하게된다.
			System.out.println(m.toString()); //업캐스팅: 서브클래스가 슈퍼클래스 타입으로 변환되는 것을 뜻함
		}
	}*/
		/*Father ft=new Father("홍길동");
		Mother mt=new Mother("김순희");
		Son so=new Son("홍돌이");
		
		System.out.println(ft);                //or   ft.toString()
		System.out.println(mt);
		System.out.println(so);
*/

/* 이름 : 홍길동                  <--- Family의 toString()에서 작성
 *  아빠는 나가서 일을 한다    <--  Job인터페이스를 상속받아서  
 *                                           Father의  work()에서 작성 
 *                                       
 *  이름 : 김순희
 *  엄마는 집안일을 한다
 * 
 *  이름 : 홍돌이
 *  아들은 공부를 한다 
 */