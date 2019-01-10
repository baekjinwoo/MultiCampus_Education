package solution;

/*[문제9]실행시 숫자 3개(a,b,c,d,e)을 args로 입력받아서 순서대로 출력하시오


[결과 화면]
java  ExamTest08   25  78  36 

5 25  36  78 90
*/

//selection sort 또는 bubble sort
public class ExamTest09 {
	public static void main(String[] args) {

		int[] bae = new int[5];
		int temp;
		for (int i = 0; i <bae.length; i++) {
			bae[i]=Integer.parseInt(args[i]);
		}

		for (int i = 0; i < bae.length; i++) {
			for (int j = i; j < bae.length-1-i; j++) { //j=i로 selection sort한 이유는, 내림차순한 값을 오른쪽으로 몰아넣으니까
				if (bae[i] > bae[j]) { //내림차순
				temp=bae[i];
				bae[i]=bae[j];
				bae[j]=temp;
				}
			}
			System.out.print(bae[i]+" ");
		}

	}
}
