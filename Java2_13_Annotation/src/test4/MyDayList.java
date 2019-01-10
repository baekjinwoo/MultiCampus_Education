package test4;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(Days.class) //반복
@interface Day{
	String name();
}
@Retention(RetentionPolicy.RUNTIME)
@interface Days{
	Day[] value();
}




