package test3;

import java.util.ArrayList;
import java.util.Collections;

// Comparable을 이용하는 방법
public class ComparatorEx2 {
	public static void main(String[] args) {
		ArrayList<Soccer> playerList= new ArrayList<Soccer>();
		Soccer player1=new Soccer("메시","공격수",20);
		Soccer player2=new Soccer("호날두","공격수",19);
		Soccer player3=new Soccer("박지성","미드필더",25);
		Soccer player4=new Soccer("오스카","미드필더",23);
		Soccer player5=new Soccer("기안","공격수",22);
		
		playerList.add(player1);
		playerList.add(player2);
		playerList.add(player3);
		playerList.add(player4);
		playerList.add(player5);
		
//		Collections.sort(playerList);   
		for(Soccer ob :  playerList){
			System.out.println(ob.getName()+"  " 
		                            + ob.getPosition() +"  " 
					                + ob.getAge());
		}
	}
}



