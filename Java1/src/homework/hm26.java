package homework;

//3x3 마방진을 만드시오
public class hm26 {
	public static void main(String[] args) {
		int[][] a1=new int [3][3];
		int k=1;
		a1[0][1]=k;
		
		for(int i=2, j=2; k<9;i--,j++){
			k++;
			if(k%3==1){
				i+=2;
				j--;
			}
			
			if(i==-1){
				i=2;
			}
			
			if(j==3){
				j=0;
			}
			
			a1[i][j]=k;
		}

		for(int i=0;i<a1.length;i++){
			for(int j=0;j<a1[i].length;j++){
				System.out.print(a1[i][j]+" ");
			}
			System.out.println();
		}
	}
}

/* 또 다른 풀이방법
 * int[][] a1 = new int[7][7];
		int n = 1;
		int m = 7;
		int l = 0;
		int i,j,k;
		

		for (i = a1.length; i > 1; i -= 2) {
			for (j = 0; j < i; j++) {
				a1[l][l + j] = n;
				n++;
			}

			for (k = 1; k < i; k++) {
				a1[l+k][a1.length - l - 1] = n;
				n++;
			}

			for (j = 1; j <i; j++) {
				a1[l+k-1][a1.length-l-j-1] = n;
				n++;
			}
			for(j=1; j<i-1;j++) {
				a1[a1.length-l-j-1][l]=n;
				n++;
			}
			l++;
		}

		for (i = 0; i < a1.length; i++) {
			for (j = 0; j < a1[0].length; j++) {
				System.out.print(a1[i][j] + "\t");
			}
			System.out.println();
		}
*/
