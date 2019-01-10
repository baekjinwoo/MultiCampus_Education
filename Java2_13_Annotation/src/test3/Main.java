package test3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



public class Main {
	public static void main(String[] args) {
		Method[] m = MyMember.class.getMethods();
		
		//@isAnnotationPresent : 어노테이션이 부여됬는지를 True/False 리턴
		for(Method r:m){
			//System.out.println(r.getName());
			if(r.isAnnotationPresent(Member.class)){
				Member my=r.getAnnotation(Member.class);
				
				if(my.name().equals(args[0])){ //admin, all
					try {
						r.invoke(new MyMember(), null);  //invoke(클래스명, 매개변수)
						
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		} //end for
	}
}
