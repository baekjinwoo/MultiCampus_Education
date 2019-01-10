package Homework;

import java.util.Scanner;

//1. 입력된 숫자의 행과 열을 가진 이차원 배열을 이용하여 출력된 형태를 만드시오.
public class HomeworkEx1 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int a=sc.nextInt();
		int num=0;
		
		int [][] data= new int[a][a];
		for (int i = 0; i < a; i++) {
			if(i%2==1){
				num = i+1;
			}
			else{
				num = i+1;
			}
			
			for (int j = 0; j < a; j++) {
			data[i][j]=num;
			System.out.print(data[i][j]+"\t");

			if(i%2==1){
				num=num+4;
			}
			else{
				num=num+4;
				}
			}
		System.out.println();
		}//for-end
	}//for-end
}
