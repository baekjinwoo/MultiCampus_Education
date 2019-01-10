package homework01;

/*[����9] ���� ���α׷��� �ϼ��Ͻÿ�

		(1)Ŭ���� : Entry
		   -word:String
		   +Entry()                              // "***������***"�� ����Ͻÿ�
		   +Entry(word:String)              //  Entry()ȣ�� 
		   +writeView():void                // ������

		(2)Ŭ���� : SubEntry   (Entry�� ��ӹ���)
		   -definition:String 
		   -year:int
		   +SubEntry(word:String)                                       //Entry(word)   ȣ�� 
		   +SubEntry(word:String, definition:String, year:int);  //SubEntry(word)ȣ��
		   +writeView():void                                               //����, �ñ����

		(3)main()�Լ�����
		public static void main(String[] args){
		    new SubEntry("OOP","Object Oriented Programming", 1991).writeView();
		}

		[���ȭ��]
 *****������******
		��� : OOP
		���� : Object Oriented Programming
		�ñ� : 1991��*/

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
		// ��� ���
		System.out.println("���: "+ word);
	}
}

class SubEntry extends Entry {
	private String defination;
	private int year;

	public SubEntry(String word) {
		super("oop");
	}

	public SubEntry(String word, String definition1, int year) { //String�� ���ڰ��� Ŭ������������ ��Ī�� �ٸ��� ������Ѵ�.
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
		// ����, �ñ� ���
		System.out.println("����: " +  defination + "\n�ñ�: " + year);
	}
}


public class munjae09 {
	public static void main(String[] args) {
		 SubEntry ob=new SubEntry("OOP","Object Oriented Programming", 1991);
		 ob.writeView();
		 ob.printView();
	}
}