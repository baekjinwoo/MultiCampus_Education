package test2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) //JVM이 실행할때 감지할 수 있도록 RUNTIME을 설정해 놓은 것
public @interface MyAnnotation {
	
}
