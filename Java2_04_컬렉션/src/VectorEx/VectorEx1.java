package VectorEx;

import java.util.Vector;

public class VectorEx1 {

	public static void main(String[] args) {
		Vector<Double> v = new Vector<>(3,2);
		System.out.println("용량:"+v.capacity());
		System.out.println("크기:"+v.size());		
		
		v.add(100.3);
		v.add(new Double(3.14));
		v.add(50.4);
		v.add(75.3);
		System.out.println("용량:"+v.capacity());
		System.out.println("크기:"+v.size());		
		
		double s = 3.14;
		int index = v.indexOf(s); //해당 위치를 리턴
		if(index!=-1){
			System.out.println(s+"의 위치는"+(index+1));
		}
		else
			System.out.println(s+"는 없음");
		
		//=============================================================================
		
		double del = 3.14;
		if(v.contains(del)){ //비교함수
			v.remove(del);
		}
		System.out.println(v);
		
		//=============================================================================
		v.trimToSize(); //불필요한 용량 줄이기
		System.out.println(v.capacity()+" "+v.size());
	}
}
