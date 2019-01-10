package basic04;

public class WhileEx01 {
	public static void main(String[] args) {
	/*1. 현재가 항상 true인 무한Loop는 for(;;)과 같다.
			while(true){ }*/
		
			
			
	
	//2. 자주 사용되는 switch기법: (=flag기법) 
		int bb=0; int flag=0;
		while(flag==0){
			System.out.println("무한출력");
			bb++;
			if(bb==5)
				flag=1;  //	break역할이면서 많이 사용할 수 있다.
						//break는 반복문에서 한 번밖에 사용할 수 없다.	
		}
	}
}
