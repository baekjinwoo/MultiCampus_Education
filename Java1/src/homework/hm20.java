package homework;

public class hm20 {
	public static void main(String[] args) {
		/*정수배열에 반드시 숫자순서대로 숫자를 모두 넣은 후 입력이 끝나면 열부터 변하면서 배열 모양 그대로 출력하는 프로그램을 작성하시오
		 * 		 ex) 1  2  4   7  11
		 *  		 3  5  8  12  16
		 *   		 6  9  13 17  20
		 *   		10  14 18 21  23
		 *   		15  19 22 24  25
		 * */
		int[][] arr = new int[5][5];
		int a = 1;
		for (int k = 0; k < arr.length; k++) {//0~4묶음 //열
			for (int i = 0, j = k; i <= k; i++, j--) { //행
				arr[i][j] = a;
				a++;
			}
		}

		for (int k = 1; k < arr.length; k++) {
			for (int i = k, j = arr.length-1; i < arr.length; i++, j--) {
				arr[i][j] = a;
				a++;
			}
		}

		for (int i = 0; i < arr.length; i++) { // 행 //k2.length 층의 개수
			for (int j = 0; j < arr[i].length; j++) { // 열 k2[i].length 열의 
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}  
	}
}
