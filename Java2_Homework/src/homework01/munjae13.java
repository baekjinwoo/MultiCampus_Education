package homework01;

/*[����13] ���ڿ������� "IT ELITE" �� �������� StringŬ������ �޼��带 �̿��Ͽ�
         ������ ���� ����Ͻÿ�

-���-

L   T
it elite
IT
ELITE
iT ELiTE*/

public class munjae13 {
	public static void main(String[] args) {
		String str = "IT ELITE";
		System.out.println(str.charAt(4)+"\t"+str.charAt(6));
		
		String str1 = str.toLowerCase(); //�빮�� ->�ҹ���
		System.out.println(str1);
		
		String str2 = str.substring(0,2);
		System.out.println(str2);
		
		String str3 = str.substring(3,8);
		System.out.println(str3);
		
		
		
		char c1 = str.charAt(0); //indexOf, contains //Concat(����)
		char c2 = str.charAt(5);
		c2= c1 = 'i';
		String str4 = str.substring(1,2);
		String str5 = str.substring(3,5);
		String str6 = str.substring(6,8);
		
		System.out.println(c1+str4+"  "+str5+c2+str6);
	}
}