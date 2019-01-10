package solution;

/* [문제14]
성적처리프로그램을 작성하시오

==================================================
번호    이름      국어    영어    수학    총점    평균    학점    재수강    순위
----------------------------------------------------------------------------------
   1      진달래     90       95       100
   2      개나리     75       55        65
   3      민들래     100     100       100
----------------------------------------------------------------------------------

처리조건
조건1) 변수
     String []name ={"진달래","개나리","민들래"};
     int [][]score = {{90,95,100,0},{75,55,65,0},{100,100,100,0}};
     double []avg = {0.0, 0.0, 0.0};
     char []grade = new char[3];
     String []pass = new String[3];
     int []rank ={1,1,1};

조건2) 총점 = 국어 + 영어 + 수학
       평균 = 총점/3;
       학점 = 90이상 'A' / 80이상 'B' / 70이상 'C' / 60이상 'D' / 나머지는 'F'
               (if ~ else if문 이용)
       재수강 = 60이상이면 "pass"  60미만이면 "fail"
               (if~else문)
       순위구하기    

 */
public class ExamTest14 {
	public static void main(String[] args) {
		String[] name = { "진달래", "개나리", "민들래" };
		int[][] score = { { 90, 95, 100, 0 }, { 75, 55, 65, 0 }, { 100, 100, 100, 0 } };
		double[] avg = { 0.0, 0.0, 0.0 };
		char[] grade = new char[3];
		String[] pass = new String[3];
		int[] rank = { 1, 1, 1};
		
		int sum[]=new int[3];
		for(int i=0;i<score.length;i++){
			for(int j=0;j<score[i].length-1;j++){
				sum[i]+=score[i][j];
			}
		}
		char c=' ';
		String s=null;
		double max;
		int tmp = 0;
		for(int i=0;i<score.length;i++){
			for(int j=0; j<score[i].length-1;j++){
				score[i][3]=sum[i];
				avg[i]=sum[i]/3;
				if(avg[i]>=90){
					c='A';
				}
				else if(avg[i]>=80){
					c='B';
				}
				else if(avg[i]>=70){
					c='C';
				}
				else if(avg[i]>=60){
					c='D';
				}
				else{
					c='F';
				}
				grade[i]=c;
				
				if(avg[i]>=60){
					s="pass";
				}
				else{
					s="fail";
				}
				pass[i]=s;
				
				if(sum[i]<sum[j]){ //1,2,3기준데이터를 하나씩 잡고 1~3까지 비교해서 기준이 작으면 rank[i]++등수 내리기
					rank[i]++;
				}
			}
		}
//		if(grade[i]=='A'){
//			rank[i]=1;
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t학점\t재수강\t순위");
		System.out.println("----------------------------------------------------------------------------------");
		for(int i=0;i<score.length;i++){
				System.out.println(i+1+"\t"+name[i]+"\t"+score[i][0]+"\t"+score[i][1]+"\t"+score[i][2]+"\t"+sum[i]+"\t"+avg[i]+"\t"+grade[i]+"\t"+pass[i]+"\t"+rank[i]);
		}
		System.out.println("----------------------------------------------------------------------------------");
	}
}
