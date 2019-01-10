package homework;

public class hm35 {
	public static void main(String[] args) {
		String s1="PH00-00003";
		String s2="RH-00007";
		String s3="ORT01-0005";
		
		ban1(s1);
		ban1(s2);
		ban1(s3);
	}	
	
	public static void ban1(String ss){
		String dap=ban2(ss);
		System.out.println(dap);
	}
	
	public static String ban2(String ss){
		char c=(char)(ss.charAt(ss.length()-1)+1);
		String st= ss.substring(0,ss.length()-1);
		String result= st+c;
			
		return result;
		
	}
}

/* 또 다른 풀이 1
 * Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<3; i++){
			String str = sc.nextLine();
			String[] arr = new String[str.length()];
			arr[i] = str;
			
			print(function(arr[i]));
		}
		
	}
	
	static char[] function(String arr){
		char[] ch = null;
		ch = arr.toCharArray();
		int a = ch.length-1;
		ch[a] +=1;
		return ch;
	}
	
	static void print(char [] ch){
		for(int i=0; i<ch.length; i++){
			System.out.print(ch[i]);
		}System.out.println();		
	}

}
 */

/* 또 다른 풀이 2
 * String str1= id.substring(id.length()-1,id.length());//7
 * int v1=Integer.parseInt(str1);
 * String str2=Integer.toString(v1+1);//7+1=>"8"
 * String str3=id.substring(0,id.length()-1); //USER-0000
 * return str3+str2; //"USER-0000" + "8"
 *   }
 * }		
 */
