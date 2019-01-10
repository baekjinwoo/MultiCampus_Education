package Prim;

import java.util.Comparator;

public class Edge implements Comparator<Edge>{
 int vertex, adjVertex; //시작점, 인접점
 int weight; //가중치
 Edge(){}
 Edge(int vertex, int adjVertex, int weight){
	 this.vertex = vertex;
	 this.adjVertex = adjVertex;
	 this.weight = weight;
 }
	@Override
	//정렬 compare메소드 결과 음수 0 양수에 따라 정렬
	public int compare(Edge o1, Edge o2) {
		return o1.weight - o2.weight;//-10 5 
//		if(o1.weight  > o2.weight){
//			return 1;
//		}else if(o1.weight  < o2.weight){
//			return -1;
//		}else{//같은 경우
//			return 0;
//		}
	}
 
}
//Arrays.sort(배열, 배열내부데이터타입정렬기준객체);
//Collections.sort(리스트, 배열내부데이터타입정렬기준객체);



