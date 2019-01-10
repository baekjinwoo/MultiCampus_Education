package test5;

import java.util.function.IntPredicate;
import java.util.function.Predicate;


//Predicate: 하나의 인자와 리턴값을 가진다. Function과 비슷하지만, Predicate는 매개변수가 보이지 않는다.
public class StreamEx8 {
	public static void main(String[] args) {
    
/*		IntPredicate predicateA = a -> a % 2 == 0;
		IntPredicate predicateB = b -> b % 3 == 0;
 
        boolean result;
        IntPredicate predicateAB = predicateA.and(predicateB); //and
        result = predicateAB.test(9);
        System.out.println("9는 2와 3의 배수입니까? " + result);
 
        predicateAB = predicateA.or(predicateB); //or
        result = predicateAB.test(9);
        System.out.println("9는 2또는 3의 배수입니까? " + result);
 
        predicateAB = predicateA.negate(); //negate
        result = predicateAB.test(9);
        System.out.println("9는 홀수입니까? " + result);*/

		
		
//다음 예제는 두 문자열을 비교하기 위해 Predicate의 isEqual() 정적 메소드를 사용했습니다.
/*      Predicate<String> predicate;
        
        predicate = Predicate.isEqual(null);
        System.out.println("null, null: " + predicate.test(null));
 
        predicate = Predicate.isEqual("Java");
        System.out.println("Java, null: " + predicate.test(null));
 
        predicate = Predicate.isEqual(null);
        System.out.println("null, Java: " + predicate.test("Java"));
 
        predicate = Predicate.isEqual("Java");
        System.out.println("Java, Java: " + predicate.test("Java"));*/


		
		
		
        
        
//Predicate<T>   : 인수 값을 받아  논리값으로  결과를 판정한다. test(T)
//BiPredicate<T,U>   : test(T t, U u) 	
		Predicate<String>   p= s->s.isEmpty();
		System.out.println( p.test("abc")); //비어잇냐? => f
		System.out.println( p.test("")); //비어잇t
		
		IntPredicate  a =  n ->(n%5) ==0;
		IntPredicate  b =  n ->(n%3) ==0;
		IntPredicate   r = a.and(b); //15의 배수일때만
		for(int i =1; i<=20;i++) { //20까지
			if(r.test(i)==true) //사용자선호에 따라 넣어도되고
			System.out.println( i +" : "+ r.test(i));
		}			
	}
}
