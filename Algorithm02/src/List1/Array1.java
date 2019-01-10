package List1;

import java.util.Scanner;

//2차원배열
public class Array1 {
	public static void main(String[] args) {
//숫자출력
/*		Scanner sc= new Scanner(System.in);
		System.out.print("출력 행과열을 입력하세요: ");
		int row= sc.nextInt();
		int col=sc.nextInt();
		int [][] data = new int[4][5]; //ex) data[0][0]=1;
		int num=0;

		for(int i=0; i<row;i++){
			for(int j=0;j<col;j++){
				num++;
				data[i][j]=num;
				//System.out.println("data["+  i  +"]["+  j  +"] = "+data[i][j]); //반복문이 돌때마다 결과값을 수시로 확인하기위한 검증코드 //검증법: 아래에 두개의 sysout를 주석한 뒤
				System.out.print(data[i][j]+"\t");
			}
			System.out.println();
		}
*/
		

		
//5*5보다 작은 2차원배열에서, 대문자알파벳출력
		Scanner sc =new Scanner(System.in);
		System.out.print("출력 행과열을 입력하시오: ");
		int row=sc.nextInt();
		int col=sc.nextInt();
		char [][] data= new char[row][col];
		//(char)65-->아스키코드로 A, (char)97->B, (char)0->48
		char num=65; //char num='A';  
		//System.out.println(num); 'A'의 아스키코드의 검증용 
		
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				data[i][j]=num;
				num++;
				System.out.print(data[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
