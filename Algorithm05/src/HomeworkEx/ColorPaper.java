package HomeworkEx;

import java.util.ArrayList;
import java.util.Scanner;

import Graph_Search.DFS;
import Graph_Search.Edge;

/*첫째 줄에 색종이의 수가 주어진다. 이어 둘째 줄부터 한 줄에 하나씩 색종이를 붙인 위치가 주어진다.
		색종이를 붙인 위치는 두 개의 자연수로 주어지는데 첫 번째 자연수는 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리이고, 두 번째 자연수는 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리이다.
		색종이의 수는 100 이하이며, 색종이가 도화지 밖으로 나가는 경우는 없다.
		출력형식
		첫째 줄에 색종이가 붙은 검은 영역의 넓이를 출력한다.
		입력예
		3 
		3 7 
		15 7 
		5 2	출력예
		260*/

public class ColorPaper {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("입력시작");
		int cntPaper = sc.nextInt();
		int[][] matrix = new int[100][100];
		//자동 저장 값 : 0
		
		int result = 0;
		//둘레
		for(int i = 1; i <=cntPaper; i++ ){
			int left = sc.nextInt();
			int top = sc.nextInt();
			for(int j = left ; j < left+10;j++ ){ //3+10
				for(int k = top; k< top+10; k++){
					matrix[j][k] = 1;
				}
			}
		}
		
		for(int i = 1; i <matrix.length-1; i++){
			for(int j = 1; j < matrix.length-1; j++){
				if(matrix[i][j] == 1){
					if(matrix[i-1][j] == 0){//왼쪽세로선
						result++;
					}
					if(matrix[i+1][j] == 0){//오른쪽세로선
						result++;
					}
					if(matrix[i][j-1] == 0){//아래가로선
						result++;
					}
					if(matrix[i][j+1] == 0){//위가로선
						result++;
					}
				}
			}
		}
		
		
		//면적
	/*	for(int i = 1; i <=cntPaper; i++ ){
			int left = sc.nextInt();
			int top = sc.nextInt();
			for(int j = left ; j < left+10;j++ ){ //3+10
				for(int k = top; k< top+10; k++){
					if(matrix[j][k] == 0){
						matrix[j][k] = 1;
						result ++;
					}
				}
			}
		}*/
		
		//확인용
		System.out.println(result);//260
//		for(int i = 0; i <matrix.length; i++){
//			for(int j = 0; j < matrix.length; j++){
//				if(matrix[i][j] == 1){
//				System.out.println
//				("m[" + i +"][" +j + "]="
//				+ matrix[i][j]);
//				}
//			}
//		}
			
	}
	}
