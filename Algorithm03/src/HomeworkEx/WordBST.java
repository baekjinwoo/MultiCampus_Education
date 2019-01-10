package HomeworkEx;

import binarySearchTree.Node;

//WordBST클래스 생성: 
//void insert메소드(String word, String meaning) : 
//1.word, meaning을 가지는 WordNode 객체 생성
//2.WordNode의 word 변수를 기준으로 사전식 나열되도록처리

//String find메소드(String word) : 
//1.현재 WordBST 의 ROOT부터 시작하여
//각 노드들의 word와  입력된 word 비교
//2.일치하는 것 찾으면 그 노드의 mean 리턴
//3.일치하는 것 찾지 못하면 "미등록단어" 리턴
public class WordBST {
	WordNode root;
	
	public WordBST(){};
	public WordNode getRoot() {
		return root;
	}
	public void setRoot(WordNode root) {
		this.root = root;
	}
	public WordBST(WordNode root){
		this.root = root;
	}
	
	
	public void insert(String word, String meaning){
		WordNode newNode = new WordNode(word,meaning);
		if(root == null){
			root = newNode;
			return;
		}
		WordNode current  = root;
		WordNode parent = null;
		while(true){
			parent = current;
			if(current.getWord().compareToIgnoreCase(word) < 0){
				current = current.getLeft();
				if(current == null){ //왼쪽자식 없다면
					parent.setLeft(newNode);
					return;
				}
			}
			else {
				current = current.getRight();
				if(current == null){
					parent.setRight(newNode);
					return;
				}
			}
		}
		
	}
	public String find(String word){
		//System.out.println(word); 테스트용
		
		WordNode current = root;
		while(current != null){
			if(current.getWord().equals(word)){ // 여기서 ==표시를 하면 안된다. 그럼 Scanner로 받은 word가 안읽혀짐
				return current.getMeaning();
			}else if(current.getWord().compareToIgnoreCase(word) <0){
				current = current.getLeft();
			}else {
				current = current.getRight();
			}
		}
		return null;

	}
	
}
