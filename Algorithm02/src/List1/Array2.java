package List1;

import java.util.Scanner;

//2차원배열_지그재그
public class Array2 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.print("값을 입력하세요: ");
		int a= sc.nextInt();
		int b= sc.nextInt();
		int [][]data = new int[a][b];
		int num=0;
		
		for(int i=0; i<a; i++){
			if(i%2==1){
				num = (i + 1) * b+1;
			}
			else{
				num = i*b;
			}
			for(int j=0; j<b;j++){
				if(i%2==1){
					num--;
				}
				else{
					num++;
				}
				data[i][j]=num;
				System.out.print(data[i][j]+"\t");
			}
			System.out.println();
		}
		
		
		
//		Scanner sc = new Scanner(System.in);
//		int a=sc.nextInt();
//		int b=sc.nextInt();
//		int sw=0;
//		int num=0;
//		
//		int [][]data=new int[a][b];
//		
//		for(int i=0;i<a;i++){
//			for(int j=0;j<b;j++){
//				if(sw==0){
//					num++;
//				}
//				else{
//					num--;
//				}
//			
//				data[i][j]=num;
//				System.out.print(data[i][j]+"\t");
//			}
//			System.out.println();
//		}
	}
}