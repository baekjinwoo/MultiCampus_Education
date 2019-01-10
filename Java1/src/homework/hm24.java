package homework;

public class hm24 {
	public static void main(String[] args) {
		/*10. 과제2 달팽이문제 =>> 실패 ==> 다시풀 것
	     1   2   3   4   5   6   7  
	     24  25  26  27  28  29  8
	     23  40  41  42  43  30  9
	     22  39  48  49  44  31  10
	     21  38  47  46  45  32  11
	     20  37  36  35  34  33  12
	     19  18  17  16  15  14  13 
	 		
	 1 2 3 4 5 6 7 / 25 26 27 28 / 41 42
	 7 8 9 10 11 12 / 29 30 31 32 / 43 44
	 18 17 16 15 14 13 / 36 35 34 33 / 46 45
	 19 20 21 22 23 24 / 37 38 39 40 / 47 48
	 동떨어진 49 -> 7x7에서 4,4 -> 0,6사이에선 3,3
	 
	 */
		int[][] dal=new int[7][7];
		int num=1;
		for(int k=0;k<dal.length;k++){ //열
			for(int j=0;j<dal.length-1;j++){//행
				for(int i=j+6;i<dal.length-1;i++)
				dal[j][k]=num;
				num++;
			}
		}
		
		
		
		for(int a=0;a<dal.length;a++){
			for(int b=0;b<dal[a].length;b++){
				System.out.print(dal[b][a] + "\t");
			}
			System.out.println();
		}
	}
}