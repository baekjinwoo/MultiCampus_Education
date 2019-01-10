package homework01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*[����15] HashMap�÷����� �̿��Ͽ� ���� �ڷḦ �߰��Ͻÿ�

(1)��뵥����
    key          value
  -----------------------
   ��������   15000
   �鼳����   10000
   ������      18000

(2) ���� 
     1) main()�޼��忡��  MapŬ������ ��ü ht�� ����� HashMap���� �ν��Ͻ��Ҵ��Ұ�
     2) ���׸����� �̿��Ͽ� �����͸� �߰��Ұ�
     3) �Ʒ� ȭ��ó�� ����ϵ�, å������ ���ڸ������޸���� ȭ����� "��"�� ǥ���Ұ�
       
[���ȭ��]
���������� å����=15,000��
�������� å����=18,000��*/

public class munjae15 {
	public static void main(String[] args) {
		
		Map<String, Integer> ht = new HashMap<>();
		
		ht.put("��������", 15000);
		ht.put("�鼳����", 10000);
		ht.put("������", 18000);
		
		System.out.println("key\t value");
		
		Set <String> key = ht.keySet();
		for(String k:key){
			String st = ht.get(k).toString();
			int n = st.length()-3;
			System.out.println(k+"     "+st.substring(0,n)+","+st.substring(n)+"��");
		}
	}
}
