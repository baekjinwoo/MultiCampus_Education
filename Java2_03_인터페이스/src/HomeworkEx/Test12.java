package HomeworkEx;

/*[문제12]
(1)클래스명:ScoreTable
  - name:String    ==> 이름
  - sol:int            ==> 맞은수
  - s: static int     ==> 배점(20)
  - score:int         ==> 점수=맞은수*배점
  +ScoreTable()
  +ScoreTable(name:String,sol:int)  
  +calcScore():void          ==>계산
  +display():void             ==> 출력  

(3) main()함수에서 
    public static void main(String[] args){
           ScoreTable  s1 = new ScoreTable("민들래",5);
           ScoreTable  s2 = new ScoreTable("진달래",3);
           ScoreTable  s3 = new ScoreTable("개나리",0);
           //나머지를 완성하시오
    }
[출력화면]
   이름      점수      
  ---------------------
   민들래    100
   진달래     60
   개나리      0
*/

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
		//계산
	}
	public void display(){
		System.out.print(name+"\t");
		calcScore();		
		//출력
	}
}

public class Test12 {
	public static void main(String[] args) {
		 ScoreTable  s1 = new ScoreTable("민들래",5);
         ScoreTable  s2 = new ScoreTable("진달래",3);
         ScoreTable  s3 = new ScoreTable("개나리",0);
         
         System.out.println("이름\t 점수");
         s1.display();
         s2.display();
         s3.display();
	}
}
