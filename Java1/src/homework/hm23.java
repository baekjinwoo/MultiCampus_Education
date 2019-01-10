package homework;

import java.util.Scanner;

public class hm23 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] word = { 's', 'a', 'k', 'w', 'a' };
		char[] Emptyword = { '-', '-', '-', '-', '-' };
		// System.out.print("-----");
		int count = 1;
		int same=0;
		String Eword;
		System.out.println("-----");
		while (count <= 10) {
			System.out.print(count+"번째 : ");
			Eword = sc.nextLine();
			char c = Eword.charAt(0);
			
			for (int i = 0; i < 5; i++) {
				if (c == word[i]) {
					Emptyword[i] = c;// System.out.println(Emptyword[i]);
				}
				System.out.print(Emptyword[i]);
			
			}
			
			
			for(int i=0; i<5; i++){
				if(c== word[i]){
					same++;
				}
				if(same == 5){
					count = 10;
				}
			}
			
			
			System.out.println();
			count++;
		}
	}
}

/*
 * 또 다른 풀이방법.
 * String [] moonja = {"s","a","k","w","a"};
	String [] jool = {"_","_","_","_","_"};
	
	String ip;	         
	int cnt,sw=0;
	       for(int j=0; j<5;j++) //처음 줄 출력
	           System.out.print(jool[j]);
	       System.out.println();
	     
	       Scanner scan1=new Scanner(System.in);
	       for(int i=1;i<=10;i++){
	    	 cnt=0;  
	   	     System.out.println("예상글자입력:"); 
	         ip=scan1.next(); //////// 	 
	      
	         for(int j=0; j<5;j++){
	        	   if(ip.equals(moonja[j]))//////////
	        		       jool[j]=moonja[j];
	         } 	   
	         for(int j=0; j<5;j++)
	              System.out.print(jool[j]);//줄출력	
	         System.out.println("\t"+i+"번시도");
	        
	         for(int j=0; j<5;j++){
	        	   if(jool[j].equals(moonja[j]))
	        	   {
	        		        cnt++;
	        	       //System.out.println(cnt);
	        	   }
	         }	   
	        if(cnt == 5){
	              System.out.println("굳-드에요");
	              sw=1;
	        	  break;	   
	         }
	      }
	         if(sw==0)
	              System.out.print("다음기회에");
		}
	}
 */