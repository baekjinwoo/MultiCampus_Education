package homework01;

import java.util.StringTokenizer;

/*[����14] ���ڿ������� "10*30*20*40*50"�� �������� StringTokenizerŬ������ 
         �̿��Ͽ� ������������Ͻÿ�
         String str="10*30*20*40*50";   Integer.parseInt()���

[���ȭ��]
10+30+20+40+50 = 150*/

public class munjae14{ 
	public static void main(String[] args)  {
		String str = "10*30*20*40*50";
		int sum = 0;
		
		StringTokenizer ob = new StringTokenizer(str,"#*");
		
		while(ob.hasMoreTokens()){
				sum+=Integer.parseInt(ob.nextToken());
		}
		System.out.println(str.replace('*','+')+"="+sum);

		
		
	}
}
