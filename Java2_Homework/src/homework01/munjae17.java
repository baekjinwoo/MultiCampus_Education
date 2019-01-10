package homework01;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*[����17] Hashtable �÷����� �̿��Ͽ� ���� ���α׷��� �ۼ��Ͻÿ�

(1)Ŭ������ : PhoneBook
- phoneNumber : String
- address : String
+ PhoneBook(phoneNumber:String,address:String)
+ toString():String      ==> ����ó�� �ּ��� ��¹��ڿ��� �����Ѵ�

(2)��뵥����
    key             value
    ----------------------------------
    ȫ�浿         123-4567   ����
    �̸���         345-3345   �뱸
    �Ӳ���         123-7890   �λ�

(2)����
    1) main()�޼��忡�� HashtableŬ������ ob��ü�� ����� �����͸� �߰��Ѵ�
    2) ���׸����� �̿��Ѵ�

[���ȭ��]
ã�� �̸�: �Ӳ���
Phone: 123-7890
Address: �λ�

ã�� �̸� : ����
�׷���� ����
*/

class PhoneBook{
	private String phoneNumber;
	private String address;
	public PhoneBook(String phoneNumber, String address){
		this.phoneNumber=phoneNumber;
		this.address=address;
	}
	public String toString(){
		//����ó�� �ּ��� ��¹��ڿ��� ����
		return phoneNumber + "\n"+ address;
	}
}

public class munjae17 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String,PhoneBook> ob = new Hashtable<>();
		ob.put("ȫ�浿", new PhoneBook("123-4567","����"));
		ob.put("�̸���", new PhoneBook("345-3345","�뱸"));
		ob.put("�Ӳ���", new PhoneBook("123-7890","�λ�"));
		
		System.out.println("ã�� �̸���: ");
		String name = sc.next();
		
		Set<String> key =ob.keySet();
		if(key.contains(name))
			System.out.println(ob.get(name));
		else
			System.out.println("ã�� �̸��� �����ϴ�.");
	}
}
