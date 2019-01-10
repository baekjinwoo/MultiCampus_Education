package Graph_data_structure;

import java.util.ArrayList;

//그래프 만드는 방법(2)_ 인접리스트: 
//ArrayList안에 ArrayList:
// 정점들 리스트
// 각 정점 - 인접 정점리스트 (p.371)

public class Graph2 {
	public static void main(String[] args) {
//순서1.
//ArrayList<하나하나의 정점은 ArrayList를 또 가지고 있어야한다> graph = new ArrayList<>(전체구성하는 정점수); //ArrayList로 구성된 graph 
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		
//오류.
/*	    graph.add(0점 ArrayList<Integer>);
		graph.add(1점 ArrayList<Integer>);
		graph.add(2점 ArrayList<Integer>);
		graph.add(3점 ArrayList<Integer>);
  
  	 위와 같은 점들의 값을 만들기 위해 0~4번점의 ArrayList를 반복문을 통해서 4개 만들 수 없다.  
 	왜냐하면 연결점이 반복된 규칙이 아니기때문에 직접 구현해야한다.	*/	
		
		
//순서2.
		//0번점
		ArrayList adjList1 = new ArrayList<Integer>(); 
			adjList1.add(1);
			adjList1.add(2);
			graph.add(adjList1);
		//1번점
		ArrayList adjList2 = new ArrayList<Integer>(); 
			adjList2.add(0);
			adjList2.add(3);
			graph.add(adjList2);
		//2번점
		ArrayList adjList3 = new ArrayList<Integer>(); 
			adjList3.add(0);
			adjList3.add(1);
			adjList3.add(3);
			graph.add(adjList3);
		
		//3번점
		ArrayList adjList4 = new ArrayList<Integer>(); 
			adjList4.add(1);
			adjList4.add(2);
			graph.add(adjList4);

			
//순서3.
		for(int i=0; i<graph.size(); i++){
			for(int j=0; j<graph.get(i).size(); j++)
				System.out.println(i+ " 정점: "+graph.get(i).get(j)); //i점 옆에있는 정점들을 출력하기 위한 코드
		}
		
	}
}

//-------------------------------------------------------------------------------------------------------

//방법(3)_ 인접리스트: 
//ArrayList안에 배열:  (chap5 => Graph_Search => DFSMain 참고)
//정점들 리스트
