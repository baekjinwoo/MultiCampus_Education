package test2;

import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) {
		MyHello ob = new MyHello();
		
		try {
			Method method = ob.getClass().getDeclaredMethod("hello2");
			System.out.println(method.getName());
			
			if(method.isAnnotationPresent(MyAnnotation.class)){
				for (int i=0; i<10; i++) {
					ob.hello();
				}
			}
			else{
				ob.hello(); //Annotation을 설정안한 상태이기때문에 hello는 한번만 호출된다
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}
