package Graph_data_structure;

//그래프 만드는 방법(1)_ 인접행렬: 
//이차원배열: 각 인덱스= 정점(vertex)[0][1]
//			각 값= 간선(edge)존재 1/0

//4개의 정점 인접행렬 (p.370)

public class Graph1 {
	public static void main(String[] args) {
		//int [][] graph = new int[4][4];
		int [][] graph = {{0,1,1,0}, {1,0,1,1}, {1,1,0,1}, {0,1,1,0}};
		
//x점 => y점 경로: 있음
		//0 - 1 : 있음
		//0 - 2 : 있음
		int cnt=0;
		for(int i=0; i<graph.length; i++){
			for(int j=0; j<graph[i].length;j++){ //우선, 전체출력
				if(graph[i][j]==1){ //0일때는 출력x
					cnt++;
				System.out.println("graph["+i+"]["+j+"]="+ graph[i][j]); //그래프의 연결상태확인: 1이있으면 선이 연결되있는것으로 확인.
				}
			}
			System.out.println(cnt/2); //모든 edge 수 출력
		}
	}
}
