package AbstractEx;

//추상메서드가 없는 추상클래스--------------------------------------------------------------------------------
abstract class AA{
	public void view1(){ } //1
	public void view2(){ } //2 {} 블럭이 있기때문에 메서드는 구현되어 있다.
}

class BB extends AA{
	@Override
	public void view1(){ } //3 재정의
	
	
}


public class AbstractEx1 {

	public static void main(String[] args) {
		//AA ob = new AA(); //객체 생성 불가능
		//ob.view1(); //1호출
		
		AA ob2 = new BB();
		ob2.view1(); //3
		ob2.view2(); //2
	}
}

/*//추상(미완성)클래스 --------------------------------------------------------------------------------------
abstract class AA{ 
	abstract public void view1(); //1
	abstract public void view2(); //2 //메서드나 클래스에 abstract가 하나라도 있으면 추상클래스이다.
}

class BB extends AA{
	@Override
	public void view1(){} //3 강제 재정의
}

public class AbstractEx1 {

	public static void main(String[] args) {
		//AA ob = new AA(); //객체생성 불가능
		//ob.view1(); //1호출 불가능
		
		AA ob2 = new BB(); //AA가 주소를기억하는 방을 만들고 자식객체를 만들 수 있다.
		ob2.view1(); //3
		ob2.view2(); //2
	}
}*/

//일반클래스-----------------------------------------------------------------------------------------------
/*class AA{
	public void view1(){ } //1
	public void view2(){ } //2 {} 블럭이 있기때문에 메서드는 구현되어 있다.
}

class BB extends AA{
	@Override
	public void view1(){ } //3 재정의
	
	
}


public class AbstractEx1 {

	public static void main(String[] args) {
		AA ob = new AA(); //객체생성
		ob.view1(); //1호출
		
		AA ob2 = new BB();
		ob2.view1(); //3
		ob2.view2(); //2
	}
}*/
