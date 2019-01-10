package test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Comparator을 이용하는 방법-2
public class ComparatorEx4 {
	//중첩클래스(inner class)
	public static Comparator<Soccer> myComparator
	                        = new Comparator<Soccer>(){
		@Override
		public int compare(Soccer o1, Soccer o2) {
			if(o1.getAge() == o2.getAge()){
				return o1.getPosition().compareTo(o2.getPosition());
			}
			return o2.getAge() - o1.getAge();
		}
	};
	
	public static void main(String[] args) {
		ArrayList<Soccer> playerList= new ArrayList<Soccer>();
		Soccer player1=new Soccer("메시","공격수",20);
		Soccer player2=new Soccer("호날두","공격수",23);
		Soccer player3=new Soccer("박지성","미드필더",25);
		Soccer player4=new Soccer("오스카","미드필더",23);
		Soccer player5=new Soccer("기안","공격수",22);
		
		playerList.add(player1);
		playerList.add(player2);
		playerList.add(player3);
		playerList.add(player4);
		playerList.add(player5);
		
		//나이(내림차순) / 포지션(오름차순)
		Collections.sort(playerList ,myComparator); 
		
		for(Soccer ob :  playerList){
			System.out.println(ob.getName()+"  " 
		                            + ob.getPosition() +"  " 
					                + ob.getAge());
		}
	}
}
