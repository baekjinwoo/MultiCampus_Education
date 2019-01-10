package Object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectMain {
	public static void main(String[] args) {

/*		User u1 = new User("민들래", 20, 89.5);
		User u2 = new User("들국화", 22, 95.5);

		// 직렬화
		try {
			// 객체생성
			ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("storage/user.txt"));
			//내보내는 거니까 OutputStream이고, fileOutputStream으로 txt파일 생성.
			
			ob.writeObject(u1);
			ob.writeObject(u2);
			ob.close();
			System.out.println("객체를 저장했습니다");
			

			} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		

		
		

		// 역직렬화
		try {
			// 객체생성
			ObjectInputStream ob = new ObjectInputStream(new FileInputStream("storage/user.txt"));

			User u1 = (User)ob.readObject();
			User u2 = (User)ob.readObject();
			
			u1.disp();
			u2.disp();
			ob.close();
			
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
