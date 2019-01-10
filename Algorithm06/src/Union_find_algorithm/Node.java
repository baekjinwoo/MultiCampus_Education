package Union_find_algorithm;

public class Node {
	int parent;
	int rank;
	
	//두 개의 트리를 하나로 합치면서 root노드 : rank++
	public Node() {
	}

	public Node(int parent, int rank) {
		this.parent = parent;
		this.rank = rank;
	}
	
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Node [parent=" + parent + ", rank=" + rank + "]";
	}
}
