package homework01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*[����16] HashMap�÷����� �̿��Ͽ� ���� �ڷḦ �߰��Ͻÿ�
(1)Ŭ������ : Heripoter
   -no:int
   -firstname:String
   -lastname:String
   +Heripoter(no:int,firstname:String,lastname:String)
   +toString():String

(2) ��뵥����
     key        value
    ------------------------------------- 
     101        �ظ�           ����
     102        ��              ����
     103        �츣�̿´�  �׷�����

(2)����
   1) main()�Լ����� HashMapŬ������ hm��ü��  ����� �����͸� �߰��Ѵ�
   2) ���׸����� �̿��Ѵ�

[���ȭ��]
��              �̸�
----------------------
�ظ�           ����
��              ����
�츣�̿´�  �׷�����*/

class Heripoter {
	private int no;
	private String firstname;
	private String lastname;

	public Heripoter(int no, String firstname, String lastname) {
		this.no = no;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public String toString() {
		return firstname + "  \t   " +lastname ;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}

public class munjae16 {
	public static void main(String[] args) {
		Map<Integer,Heripoter> hm = new HashMap<>();
		
		 System.out.println("�� \t �̸�");
		 
		 hm.put(101, new Heripoter(101,"�ظ�","����"));
		 hm.put(102, new Heripoter(102,"��","����"));
		 hm.put(103, new Heripoter(103,"�ظ��̿´�","�׷�����"));

		System.out.println("---------------------");
		Set<Integer> keys = hm.keySet();
		for (Integer k : keys) {
			System.out.println(hm.get(k));
		}
	}
}