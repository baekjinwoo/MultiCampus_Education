package basic04;

import java.util.Arrays;

public class SortEx01 {

	public static void main(String[] args) {
		/*1. for문을 이용한 오름차순과 내림차순
		http://startdash.tistory.com/entry/%EB%B0%B0%EC%97%B4%EC%9D%98-%EB%82%B4%EC%9A%A9%EC%9D%84-%EC%98%A4%EB%A6%84%EC%B0%A8%EC%88%9C%EC%9C%BC%EB%A1%9C-%EC%A0%95%EB%A0%AC
		http://blog.naver.com/PostView.nhn?blogId=jin93hj&logNo=220578168789&parentCategoryNo=&categoryNo=&viewDate=&isShowPopularPosts=false&from=postView		*/
		int str[]={3, 50, 31, 55, 69, 72, 61};
		int temp;
				
		for(int k=0;k<str.length;k++){
			for(int j=k+1;j<str.length;j++){
				if(str[k]>str[j]){ //str[k]크면 내림차순
					temp=str[k]; //str[k]부터 지그재그 대입
					str[k]=str[j];
					str[j]=temp;
				}
		}
		System.out.println(str[k]); //str[k]만 출력가능
}
		for(int k=0;k<str.length;k++){
			for(int j=k+1;j<str.length;j++){
				if(str[k]<str[j]){ //str[k]작으면 오름차순
					temp=str[k]; //str[k]부터 지그재그 대입
					str[k]=str[j];
					str[j]=temp;					
			}
		}
		System.out.println(str[k]);
}//for_end		
		
		
		//2. 배열을 이용한 오름차순
		int str0[]={1, 11, 22, 33, 5, 17};
		Arrays.sort(str0);
		for(int k2=0;k2<6;k2++){ //k2<7아니다.
			System.out.println(str0[k2]); 
			//System.out.println(str0);만 넣으면 주소값이 나온다
			//System.out.println(str0[0]); 0번지값이 출력되니까 1이 나온다.
			//따라서, for문을 돌려야지 낱개로 안나오고 전체가 출력된다. 
		}//for_end
	}
}
