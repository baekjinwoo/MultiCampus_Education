package HomeworkEx;


//WordNode 클래스 생성:
//String word, meaning, WordNode left, right 변수 4개 포함
//getter / setter 생성

public class WordNode {
	String word;
	String meaning;
	WordNode left;
	WordNode right;
	
	public WordNode(){}
	public WordNode(String word, String meaning){
		this.word = word;
		this.meaning = meaning;
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	public WordNode getLeft() {
		return left;
	}
	public void setLeft(WordNode left) {
		this.left = left;
	}
	public WordNode getRight() {
		return right;
	}
	public void setRight(WordNode right) {
		this.right = right;
	}
	
}
