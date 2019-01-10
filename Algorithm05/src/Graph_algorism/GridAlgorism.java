package Graph_algorism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//Grid알고리즘 : 탐욕알고리즘이다. ==> 최소신장트리로 관련
//종료시간이 더 빠르면 더 많은 회의를 할 수 있따
public class GridAlgorism {
	public static void main(String[] args) {
		int [][] rooms = { {1,1,10}, {2,5,6}, {3,13,15}, {4,14,17}, {5,8,14}, {6,3,12} }; 
		
							//클래스명을 넣지않고 쓰는이유는 일회성이기때문에, 클래스를 만들어서 사용할떄는 재사용성이라는 큰 장점. 따라서 위와같은 것을 무명클래스
							//rooms가 2차원배열인데, 하나하나씩 꺼내면 1차원배열이니까 int[]
		Arrays.sort(rooms, new Comparator<int[]>(){
			public int compare(int[] o1, int[] o2) { 
				return o1[2]-o2[2]; 
				} 
			}
		);			
		
		for(int i=0; i<rooms.length; i++){
			System.out.println(rooms[i][0]+":"+rooms[i][1]+":"+rooms[i][2]);
			}
		
		//ArrayList에 결과를 저장한다
		ArrayList<int[]> list = new ArrayList();
		list.add(rooms[0]); //종료시간이 가장 빠른 회의를 저장한다
		
		for(int i=1; i<rooms.length; i++){
			//if(list.get(i-1)[2] <= rooms[i][1]){ 이전거와 비교
			if(list.get(list.size()-1)[2] <= rooms[i][1]){ //전체크기와 비교
				list.add(rooms[i]);
					}
				}
		
		
		for(int[] m : list){
					System.out.println(m[0] + "번 회의");
				}
			}//main
		}







/*class Meeting{
	int id;
	int starttime;
	int endtime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStarttime() {
		return starttime;
	}
	public void setStarttime(int starttime) {
		this.starttime = starttime;
	}
	public int getEndtime() {
		return endtime;
	}
	public void setEndtime(int endtime) {
		this.endtime = endtime;
	}
	public Meeting(int id, int starttime, int endtime) {
		this.id = id;
		this.starttime = starttime;
		this.endtime = endtime;
	}
	@Override
	public String toString() {
		return "id=" + id + ", starttime=" + starttime + ", endtime=" + endtime;
	}
} */



//public class MeetingRoomTest /*implements Comparator<Meeting>*/ {
//	public static void main(String[] args) {
// 	Meeting []mt = { new Meeting(1,1,10), new Meeting(2,5,6), new Meeting(3,13,15), new Meeting(4,14,17), new Meeting(5,8,14),
// 	new Meeting(6,3,12) };				
//			
//		int temp=0;
//		
//		Arrays.sort(mt,new MeetingRoomTest());
//		for(Meeting stu : mt){
//			System.out.println(stu);
//		}
//		
//		for(int i=0; i<mt.length; i++){
//			for(int j=i+1; j<mt.length; j++){
//
//				if(mt[i].getStarttime()<mt[j].getStarttime()){
//						temp= mt[i].getStarttime();
//					//	mt[i].getStarttime()=mt[j].getStarttime();
//					//	mt[j].getStarttime()=temp;
//					}
//				}
//			}
//	}
//	public int compare(Meeting o1, Meeting o2) {
//		return o1.getEndtime()-o2.getEndtime();
//	}
//}
