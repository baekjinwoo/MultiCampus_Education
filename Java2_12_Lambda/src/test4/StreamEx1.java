package test4;

import java.util.Arrays;
import java.util.stream.Collectors;


//Stream API 종류
public class StreamEx1 {
	public static void main(String[] args) {
		Arrays.asList(1,2,3,4,5,6).stream()
			  .forEach(System.out::println); // 1 2 3 4 5 6 	

		
		Arrays.asList(1,2,3,4,5,6).stream()
			  .map(i->i*i) //1 4 9 16 25 36
			  .forEach(System.out::println); 
		
		
		Arrays.asList(1,2,3,4).stream()
			  .limit(2)	//1 2
			  .forEach(System.out::println); 
		
		
		Arrays.asList(1,2,3,4,5,6).stream()
			  .skip(2) //3 4 5 6
			  .forEach(System.out::println); 
		
		
		Arrays.asList(1,2,3,4,5,6).stream()
			  .filter(i-> i>2) //i값이 2보다 큰 값 
			  .forEach(System.out::println); //3 4 5 6
		
		
		Arrays.asList(Arrays.asList(1,2,3,4),Arrays.asList(5,6,7,8),Arrays.asList(9,10)).stream()
		  	  .flatMap(i-> i.stream()) //Stream을 쭉 연결하는 것
		  	  .forEach(System.out::println); //1 2 3 4 5 6 7 8 9 10
		
		
		System.out.println(Arrays.asList(1,2,3).stream()
			  .reduce((a,b)-> a-b) //1-2=-1-3 =-4
			  .get());
		
		
		Arrays.asList(1,2,3,4,5,6).stream()
			  .collect(Collectors.toList()) //1 2 3 4 5 6
			  .forEach(System.out::println); 
	}
}
