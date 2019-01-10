package IOEX;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//public class DataStreamTest {
//	public static void main(String[] args) {
//
//		try{
//			FileOutputStream file = new FileOutputStream("src/IOEX/result.txt");
//			DataOutputStream out = new DataOutputStream(file);
//			
//			out.writeUTF("가나다");
//			out.writeInt(100);
//			out.writeDouble(100.45);
//			
//			out.writeUTF("XYZ");
//			out.writeInt(200);
//			out.writeDouble(200.45);
//			
//			out.close();
//			file.close();
//			System.out.println("저장됨");
//			
//		}catch(FileNotFoundException e){
//				e.printStackTrace();
//		}catch(IOException e){
//			e.printStackTrace();	
//		}
//	}
//}


public class DataStreamTest {
	public static void main(String[] args) {

		try{
			FileInputStream file = new FileInputStream("src/IOEX/result.txt");
			DataInputStream in = new DataInputStream(file);
			
			System.out.println(in.readUTF());
			System.out.println(in.readInt());
			System.out.println(in.readDouble());
			
			System.out.println(in.readUTF());
			System.out.println(in.readInt());
			System.out.println(in.readDouble());
			
			in.close();
			file.close();
			
		}catch(FileNotFoundException e){
				e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();	
		}
	}
}
