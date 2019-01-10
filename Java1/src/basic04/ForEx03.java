package basic04;

//별짓기
public class ForEx03 {
	public static void main(String[] args) {
		/* 9. *** 
		 *    *** 
		 *    *** 모양을 만드시오. */
				for(int i=1; i<=3; i++){
					for(int j=1;j<=3;j++){
						System.out.print("*");
					}
					System.out.println();
				}
				System.out.println();
				
		/*10. *
		      **
		      ***
		      ****
		      ***** 모양을 만드시오.*/
				for(int i=1;i<6;i++){
					for(int j=1;j<=i;j++){
						System.out.print("*");		
					}
					System.out.println();
				}
				System.out.println();
				

		/* 11. *****
		       ****
		       ***
		       **
		       *  모양을 만드시오.*/
				for(int i=1;i<=5;i++){
					for(int j=5;j>=i;j--){
						System.out.print("*");
					}
					System.out.println();
				}
		/*12. *****
		       ****
		        ***
		         **
		          * 모양을 만드시오.*/
				for(int i=1;i<=5;i++){
					for(int j=0;j<i;j++){
						System.out.print(" ");
					}
					for(int k=i;k<=5;k++){
						System.out.print("*");
				}
				System.out.println();
				}
		
	}
}
