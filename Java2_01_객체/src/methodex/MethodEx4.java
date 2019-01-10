package methodex;
//중첩함수 응용 (함수안에 또 다른 함수가 들어있는 것)
public class MethodEx4 {

		public static int total(int a,int b,int c){
			return a+b+c;
		}
		
		public static double avg(int tot){
			return (double)tot/3;
		}
		
		public static char grade(double aver){
		/*	if(aver>= 80)
				return "A학점";
						
			else
				return "B학점";*/
			
			
			switch((int)aver/10){
			case 10:
			case 9:
			case 8: return 'A'; 
			case 7: return 'B'; 
			case 6: return 'C'; 
			default: return 'F';
			}
		}

		public static String result(char av){ 
			if(av=='F')
				return "불합격";
			else 
				return "합격";
		}
		
	public static void main(String[] args) {
		/*
		 * 학점 : switch()를 이용하여 결과 구하기 90이상 'A' 80이상 'B' 70이상 'C' 60이상 'D' 나머지
		 * 'F' 결과 : if ~ else를 이용하여 'F'학점인 경우 "불합격" 나머지는 "합격"을 리턴
		 * 
		 * [출력화면] 총점 : 253점 평균 : 84.33 학점 : B 결과 : 합격
		 */
		
		
		int k=95, e=85, m=73;
		System.out.println("총점:"+total(k,e,m)+"점");
		System.out.printf("평균:%.2f\n", avg(total(k,e,m)));  // avg(253)이니까 total은 변수 하나를 받는다.
														     // %.2f니까 메서드에서 double로 받는다.
		
		System.out.println("학점:"+grade(avg(total(k,e,m))));
		System.out.println("결과:"+result(grade(avg(total(k,e,m)))));

	}

}
