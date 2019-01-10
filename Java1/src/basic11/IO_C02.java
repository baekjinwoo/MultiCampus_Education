package basic11;

import java.io.*; 

//throws와 Import선언은 필수이다.
//text Writer :key 입력->파일로
//open :Scanner기능	

public class IO_C02 {
	public static void main(String[] args) throws IOException {
		
		//문자기반일 경우
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); //키보드로 만든 입력문
		
		//파일저장을  위해
		FileWriter fw=new FileWriter("C:\\Users\\student\\workspace\\aa.txt",true); //소스안이 아니라 소스밖(프로젝트폴더안)에 aa.txt를 넣어야 계속 작성가능하다
		BufferedWriter bw=new BufferedWriter(fw); //도우미1
		PrintWriter pw = //출력도우미 2 (PrintWriter를 쓰면 줄바꿈도 가능하다)
		new PrintWriter(bw,true); //true는 append기능인대, 쓰려고 파일을 열때 내용이 지워지지않고 연결해서 쓰기위해
		
		System.out.println("저장할데이터를 입력해주세요 (입력끝은 ctrl+z)"); //Ctrl+z는 파일의 끝
		String s=null;
		while((s=br.readLine())!=null){
			//br: 키보드에서
			pw.println(s); //pw에 출력 + 줄바꿈때문에 커서가 아래를 
			
			System.out.println("나 파일 출력중........");////////
			System.out.println(s); ////화면출력
			
			//pw: 파일에다 출력// 화면출력 없음
		}
		br.close();pw.close();bw.close();fw.close();
	}

}
