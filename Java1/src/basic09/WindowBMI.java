package basic09;

//WindowBMI를 이용하기 (추후에, Window Builder이용할 것)

// java에서 입출력을 동시에 담당하는 도구: TextField
// java에서 출력을 담당하는 도구: Label
// java에서 버튼을 담당하는 도구: Button
// java에서 window를 표현하는 패키지: awt와 swing ==> (import java.awt.*; import java.awt.event.*;)

	import java.awt.*;
	import java.awt.event.*;

	class BMIGUI2 extends Frame implements ActionListener { // 윈도우 틀(Frame)을 만들기위해
														   // 상속받고 다중상속을 위해
	// implements로 event를									
	// 제어하는 인터페이스
	// ActionListener 받음.
	// 전부다 객체를 만드는 것 
	// 컴퓨터에서 event란, 동작하는 모든것을 말하는대 예를들면 마우스가 움직이는 것. 버튼을 누르면 뭔가가 발생하는 것

		private Button b1 = new Button("BMI계산");
		private Label la1 = new Label("당신의 키는");
		private Label la2 = new Label("당신의 몸무게는");
		private TextField tf1 = new TextField();
		private TextField tf2 = new TextField();
		private TextField tf3 = new TextField();

		public BMIGUI2(){
			this.setLayout(null);
			b1.setSize(100,70); //버튼크기
			//======================================
			b1.setForeground(new Color(0,0,255)); //red,green은 빛이없고 blue만 255 (RGB)
			b1.setForeground(new Color(255,180,100)); 
			b1.setFont(new Font("돋움",Font.BOLD,20)); //돋움,굵음,20크기
			//======================================
			b1.setLocation(200, 300); //버튼 내부위치
			this.add(b1); //버튼추가
			b1.addActionListener(this); //버튼을 이벤트로 쓸 수 있도록
			
			la1.setSize(90,30); 
			la1.setLocation(20,70); //라벨 내부위치
			this.add(la1);
			
			tf1.setSize(70,30);
			tf1.setLocation(120,70); //텍스트 내부위치
			this.add(tf1); //라벨 추가
			
			la2.setSize(90,30);
			la2.setLocation(20,100);
			this.add(la2);
			
			tf2.setSize(70,30);
			tf2.setLocation(120,100);
			this.add(tf2);
			
			tf3.setSize(400,50);
			tf3.setLocation(20,400);
			this.add(tf3);
			
			this.setSize(500, 500); //프레임 크기 (=전체크기)
			this.setVisible(true); 
	//실행하자마자 프레임(창문)을 보이게한다. false를 주면 안보이는대 나중에 나오게 하려는 의도에서 false를 쓴다.

			addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e1){
					dispose(); 
	// 개발자가 지금까지 썻던 필요없는 객체를을 직접 지우는 명령(쓰레기전담반 GC를 대신해서)  //프레임 닫을때 필요한 것
					
					System.exit(0); 
	//강제종료// c:exit() // 0이 들어가면 정상 강제종료, -1이나 1이 들어가면 비정상 강제종료(문제가 생겻을때)
	// c#: Environment.Exit()			}
				}});
		} //생성자 end
	
		@Override
		public void actionPerformed(ActionEvent e1){
			if(e1.getSource()==b1){  //버튼 b1을 누르면, b1만 이벤트를 가동시킬수 있다
				int ki=Integer.parseInt(tf1.getText());
				int mom=Integer.parseInt(tf2.getText());
				double mki=ki/100.0;
				double bmi=mom/Math.pow(mki,2);	
				
				String result;
				if(bmi>=30.0)
					result="비만";
				else if(bmi>=25.0)
					result="과체중";
				else if(bmi>18.5)
					result="보통";
				else
					result="저체중";
				tf3.setText("당신의 bmi지수는"+bmi+"이며 "+result+"이군요");
			}
		}
	}
	public class WindowBMI {
		public static void main(String[] args) {
			BMIGUI2 b = new BMIGUI2();
	}
}										
