package solution;

/* 
[문제2]성적처리프로그램
        중간고사,기말고사,레포트,출석점수를 Args로 입력받아서 계산하시오
        
조건1) (중간+기말)/2   ---> 60%
          과제                          ---> 20%
          출석                           ---> 20%
     
조건2)90이상 'A'학점     (3)A,B학점  ---->"excellent"
     80이상 'B'학점        C,D학점  ---->"good"
     70이상 'C'학점        F학점    ---->"poor"
     60이상 'D'학점        
           나머지 'F'학점
     (if~else if문이용)

$ java ExamTest02  90 89 99 100  

[결과 화면]
중간고사 : 90
기말고사 : 89
과제점수 : 99
출석점수: 100

성적=93.20      <---소수이하 2째자리까지
학점=A              
평가=excellent
*/
public class ExamTest02 {
	public static void main(String[] args){
		
		int jun = Integer.parseInt(args[0]); //중간
		int gi = Integer.parseInt(args[1]); //기말
		int re = Integer.parseInt(args[2]); //레포트
		int cul = Integer.parseInt(args[3]); //출석
		
		double score = (double) (((jun+gi)/2)*0.6 + (re*0.2) + (cul*0.2));
			
		System.out.println("중간고사: "+jun);
		System.out.println("기말고사: "+gi);
		System.out.println("과제점수: "+re);
		System.out.println("출석점수: "+cul);
		System.out.printf("성적점수: %.2f",score);
		
		char grade=' ';
		if(score>=90){	grade='A';}
		else if(score>=80){ grade='B'; }
		else if(score>=70){ grade='C'; }
		else if(score>=60){ grade='D'; }
		else  grade='E';
		System.out.println("\n학점="+grade);
		
		String result =null;
		switch((int)score/10){
		case 10:
		case 9:  
		case 8:	result = "excellent"; break;
		case 7:
		case 6: result = "good"; break;
		default : result = "poor"; break;
		}
		System.out.println("평가="+result);
 	}
}
