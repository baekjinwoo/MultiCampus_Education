package homework05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class ListHashSet {
	public static void main(String[] args) {
		Random r = new Random();
		int size = Integer.parseInt(args[0]);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		// ArrayList�� size��ŭ�� ���� ��ŭ ������ ���ڸ� �ִ´�.
		while (list.size() < size) {
			list.add((int) (Math.random() * 10));
			System.out.println(list);
				
		}
		// ArrayList�� ������ HashSet�� �ִ´�.

		ArrayList<Integer> set = new ArrayList<>();
		Collections.sort(set); //�������� ����
		
		for(Integer ob : set){ //�ڷ��� ���� : ��ü
			System.out.print(ob);
		}
	}
}
