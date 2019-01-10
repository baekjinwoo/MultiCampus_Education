package homework;

import java.util.Random;

public class hm11 {
	public static void main(String[] args) {
	// 문제. 로또를 랜덤으로 나오게 한 후 오름차순으로 소트하여 출력하시오. (단, 소트 부분은 메소드 2형식을 사용한다)
		Random rd = new Random(); // 랜덤생성
		int[] lo = new int[6]; // 6 배열생성
		for (int i = 0; i < lo.length; i++) { // 랜덤값을 배열에 넣고 Sort하는 순서로 우선 랜덤값을
			lo[i] = rd.nextInt(45) + 1;
		}
		Psort(lo); // 보내기

		for (int i = 0; i < lo.length; i++) { // 출력하기
			System.out.print(lo[i] + "\t");
		}
	}

	public static void Psort(int[] lo) {
		int imsi;
	
		for (int i = 0; i < 6; i++) { // 0~5 //비교하기
			for (int j = i + 1; j < 6; j++) {
				if (lo[i] < lo[j]) { // 오름차순
					imsi = lo[i];
					lo[i] = lo[j];
					lo[j] = imsi;
				}
			}
		}
	}
}
