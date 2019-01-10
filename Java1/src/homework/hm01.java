package homework;

//Print활용
public class hm01 {
	public static void main(String[] args) {
		//1번. 지구에서 몸무게가 120kg인데 어느 별에서는 12.4%로 감소된다고 한다. 그 별에서의 몸무게는?
		int jikoomom=120;
		double byulMom = jikoomom-(jikoomom*0.124);
		System.out.println("\n\n"+"120kg이 그 별에서는"+ byulMom+ "kg이다");
		System.out.printf("120kg이 그 별에서는  %.2fkg이라는",byulMom);
		System.out.println();
				
//-----------------------------------------------------------------------------------
				
		//2번. 지구에서 몸무게가 130kg인데 어느 별에서는 12.4%로 감소된다고 한다. 그 별에서의 몸무게는?
		int jigustar = 130;
		double otherstar = jigustar- (jigustar *(12.4/100));
		double otherstar2 = jigustar +(jigustar*0.124);
		System.out.println("\n\n"+"130에서 다른별에서의 12.4% 감소된 무게"+otherstar);
		System.out.println("130에서 다른별에서의 12.4% 증가된 무게"+otherstar2);
		System.out.println();
		
//-----------------------------------------------------------------------------------
				
		// 3번. 나의 어제 몸무게가 64.3kg이다. 어제 과식을 해서 2%가 증가했다. 현재 몸무게는?
		double yes1 = 64.3;
		double pre1 = yes1+(yes1*(0.02));
		System.out.println("\n\n"+"현재몸무게는"+pre1);
			 
//-----------------------------------------------------------------------------------
				
		// 4번. 나의 어제 몸무게가 64kg이다. 어제 과식을 해서 2%가 증가했다. 현재 몸무게는?
		int yes2=64;
		double pre2= yes2+(yes2*(0.02));
		System.out.println("현재몸무게는"+pre2);	//65.28이다.
		//System.out.println("\n\n"+"현재몸무게는"+ yes_wei+(yes_wei*0.02)); 641.28로 오류
		//System.out.println("\n\n"+"현재몸무게는"+ yes_wei+(yes_wei*(2/100))); 640으로 오류
	}
}
