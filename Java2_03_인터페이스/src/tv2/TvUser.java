package tv2;

//다형성을 이용해서 결합도를 낮춘다
public class TvUser {
	public static void main(String[] args) {
		String com=args[0];
		Tv tv=null;
		
		if(com.equals("LG")){
			tv=new LgTv();
		}else if(com.equals("SAMSUNG")){
			tv=new SamsungTv();
		}else{
			System.out.println("error");
		}		
		
		// 나중에 고쳐달라하면 아래코드만 바꾸면 된다. TvUser1보다 TvUser코드가 더 좋은 코드.
		// 아래의 코드를 Spring을 작성해서 끊고 연결하고를 만들 수 있다
		tv.powerOn();
		tv.powerOff();
		tv.soundUp();
		tv.soundDown();
		
		
	}
}
