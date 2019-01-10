package IOEX;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamTest {
	public static void main(String[] args) throws IOException {

		OutputStreamWriter out = new OutputStreamWriter(System.out); //system.in표준입력 system.out표준출력 (키보드로 입력받고 모니터로 출력받고)
		BufferedWriter bw = new BufferedWriter(out);
		
		bw.write("java IO test...");
		bw.flush();	//버퍼키우기
		
		bw.close();
		out.close();
	}
}
