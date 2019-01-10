package HomeworkEx;

import java.util.ArrayList;
import java.util.Random;

class MakeList{
	ArrayList<Integer> ss;
	
	
	
	public MakeList(){
		ss = new ArrayList<>();
	}
	
	
	
	public void makeArrayList(int size){ //size만큼 정수형 데이터를 랜덤하게 만들어서 arraylist에 넣는다
		Random r = new Random(size);
		for(int i=0;i<size;i++){
		ss.add((int)r.nextInt(9)+10);
		}
	}
	
	
	public double getAverage(){ //arraylist에 셋팅된 정수들의 평균을 리턴한다
		double m=0;
		for(Integer n:ss){
			m+=n;
		}
		return m/ss.size();
	}
	public ArrayList<Integer> getList(){ //만들어진 arraylist정보를 리턴한다
		return ss;
	}
}

public class ListTest01 {
	public static void main(String[] args) {
		MakeList m = new MakeList();
		
		String size = args[0];
		m.makeArrayList(Integer.parseInt(size));
		
		
		ArrayList list = m.getList();

		for(Object ob : list){
			System.out.print(ob+"  ");
		}
	System.out.println("\n평균: "+ m.getAverage());
	}
}
		

		
		// argument로 정수를 받는다.
		// 무작위의 번호 발생 후 저장
		// for문을 이용하여 ArrayList의 정보 출력하고 평균을 출력 한다.
		// 평균 출력
	
		
		
		//13 18 12 10 19 13 16 18 19 12
		//평균 : 15.0
	
