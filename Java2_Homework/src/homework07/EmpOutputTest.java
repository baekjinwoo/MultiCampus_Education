package homework07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/* BufferedReader(new InputStreamReader(System.in)      //표준입력
 * 
 * BufferedWriter(new FileWriter(new File("파일명")))   //파일출력 
 */

/*[문제3-1] 데이타를 입력받아 파일에 기록하시오

1) 값을 입력받아 파일로 출력하는 프로그램
파일명 : EmpOutputTest.java
처리조건 : 데이타들 사이에 \t를 추가하여 저장하시오
           ex) name+"\t"+dept+"\t"+salary+"\n"


입력을 종료하시려면 ctrl+z를 하시오
이름을 입력하시오 : 강호동
부서를 입력하시오 : 개발부
급여를 입력하시오 : 1500000
계속 입력하려면 Enter키를 누르시오

이름을 입력하시오 : 이순신
부서를 입력하시오 : 영업부
급여를 입력하시오 : 2500000
계속 입력하려면 Enter키를 누르시오
ctrl+z

emp.txt파일이 저장 되었습니다
--------------------------------------------------------
emp.txt파일
강호동    개발부    1500000
이순신    영업부    2500000*/

public class EmpOutputTest {
	public static void main(String[] args) throws IOException {
		/*출력 스트림(파일)*/
		File file=new File("src/homework07/emp.txt");
		//FileWriter fw=new FileWriter(file);           //==> 실행할때마다 emp.txt파일이 새로 만들어짐
		FileWriter fw=new FileWriter(file,true);        //==> 실행하면 기존파일에 새로운 데이타 추가 
		BufferedWriter bw=new BufferedWriter(fw);
		
		/*입력 스트림(키보드)*/
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		
		String name, dept;
		int salary;
		
		System.out.println("입력을 종료하려면 CTRL+Z를 하시오\n");
		try{
			do{
				System.out.print("이름을 입력하시오:"); name=br.readLine();
				System.out.print("부서를 입력하시오:"); dept=br.readLine();
				System.out.print("급여를 입력하시오:"); salary=Integer.parseInt(br.readLine());
				
				bw.write(name+"\t"+dept+"\t"+salary+"\n");
				System.out.println("계속 입력하려면 Enter키를 누르시오");
				System.in.read();   // \n을 처리
			}while(System.in.read() != -1);   
			System.out.println("emp.txt파일로 저장 되었습니다");
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				br.close();
				isr.close();
				bw.close();
				fw.close();
			}catch(IOException e){}
		}
	}
}




















