package homework01;

/*[����12]
(1)Ŭ������:ScoreTable
  - name:String    ==> �̸�
  - sol:int            ==> ������
  - s: static int     ==> ����(20)
  - score:int         ==> ����=������*����
  +ScoreTable()
  +ScoreTable(name:String,sol:int)  
  +calcScore():void          ==>���
  +display():void             ==> ���  

(3) main()�Լ����� 
    public static void main(String[] args){
           ScoreTable  s1 = new ScoreTable("�ε鷡",5);
           ScoreTable  s2 = new ScoreTable("���޷�",3);
           ScoreTable  s3 = new ScoreTable("������",0);
           //�������� �ϼ��Ͻÿ�
    }
[���ȭ��]
   �̸�      ����      
  ---------------------
   �ε鷡    100
   ���޷�     60
   ������      0*/

class ScoreTable{
	private String name;
	private int sol;
	private static int s = 20;
	private int score;
	
	public ScoreTable(){
	}
	public ScoreTable(String name, int sol){
		this.name=name;
		this.sol=sol;
	}
	public void calcScore(){
		score = sol * s;
		System.out.println(score);
		//���
	}
	public void display(){
		System.out.print(name+"\t");
		calcScore();		
		//���
	}
}

public class munjae12 {
	public static void main(String[] args) {
		 ScoreTable  s1 = new ScoreTable("�ε鷡",5);
         ScoreTable  s2 = new ScoreTable("���޷�",3);
         ScoreTable  s3 = new ScoreTable("������",0);
         
         System.out.println("�̸�\t ����");
         s1.display();
         s2.display();
         s3.display();
	}
}