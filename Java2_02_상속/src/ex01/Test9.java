package ex01;
/*[문제9] 다음 프로그램을 완성하시오

(1)클래스 : Entry
   -word:String
   +Entry()                              // "***약어사전***"을 출력하시오
   +Entry(word:String)              //  Entry()호출 
   +writeView():void                // 약어출력

(2)클래스 : SubEntry   (Entry를 상속받음)
   -definition:String 
   -year:int
   +SubEntry(word:String)                                //Entry(word)   호출 
   +SubEntry(word:String, definition:String, year:int);  //SubEntry(word)호출
   +printView():void                                     //원어, 시기출력

(3)main()함수에서
public static void main(String[] args){
    SubEntry ob=new SubEntry("OOP","Object Oriented Programming", 1991);
    ob.writeView();
    ob.printView();
}

[출력화면]
*****약어사전******
약어 : OOP
원어 : Object Oriented Programming
시기 : 1991년
*/

class Entry {
	private String word;

	public Entry() {
		
	}
	public Entry(String word) {
		this.word = word;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public void writeView() {
		// 약어 출력
		System.out.println("약어: "+ word);
	}
}

class SubEntry extends Entry {
	private String defination;
	private int year;

	public SubEntry(String word) {
		super("oop");
	}

	public SubEntry(String word, String definition1, int year) { //String은 인자값과 클래스변수값의 명칭을 다르게 해줘야한다.
		this("oop");
		this.defination = definition1;
		this.year = year;
	}

	public String getDefination() {
		return defination;
	}

	public void setDefination(String defination1) {
		this.defination = defination1;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void printView() {
		// 원어, 시기 출력
		System.out.println("원어: " +  defination + "\n시기: " + year);
	}
}


public class Test9 {
	public static void main(String[] args) {
		 SubEntry ob=new SubEntry("OOP","Object Oriented Programming", 1991);
		 ob.writeView();
		 ob.printView();
	}
}
