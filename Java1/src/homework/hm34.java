package homework;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//http://kissiloan.tistory.com/entry/디지털-시계-만들기?category=224150
class DCGUI extends Frame implements ActionListener { 

	private Button b1 = new Button("시작");
	private TextField tf1 = new TextField();
	private TextField tf2 = new TextField();
	private TextField tf3 = new TextField();

	public DCGUI(){
		this.setLayout(null);
		b1.setSize(100,70); //버튼크기
		//======================================
		b1.setForeground(new Color(0,100,50)); //red,green은 빛이없고 blue만 255 (RGB)
			b1.setBackground(Color.lightGray);
		b1.setFont(new Font("돋움",Font.BOLD,20)); //돋움,굵음,20크기
		//======================================
		b1.setLocation(200, 300); //버튼 내부위치
		this.add(b1); //버튼추가
		b1.addActionListener(this); //버튼을 이벤트로 쓸 수 있도록
	
		tf1.setSize(70,50);
		tf1.setFont(new Font("돋움",Font.BOLD,20));
		tf1.setLocation(120,200); //텍스트 내부위치
		this.add(tf1); //라벨 추가
		
		tf2.setSize(70,50);
		tf2.setBackground(Color.CYAN);
		tf2.setFont(new Font("돋움",Font.BOLD,20));
		tf2.setLocation(220,200);
		this.add(tf2);
		
		tf3.setSize(70,50);
		tf3.setForeground(new Color(0,0,255));
		tf3.setBackground(Color.green);;
		tf3.setFont(new Font("돋움",Font.BOLD,20));
		tf3.setLocation(320,200);
		this.add(tf3);
		
		this.setSize(500, 500); //프레임 크기 (=전체크기)
		this.setVisible(true); 

		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e1){
				dispose(); 
				System.exit(0); 
			}});
	}

	@Override
	public void actionPerformed(ActionEvent e1) {
		Timer t=new Timer(); //Timer클래스: 바로 실제 타이머의 기능을 수행하는 클래스
		TimerTask t2 = new TimerTask(){ //TimerTask클래스: Timer클래스가 수행되야할 내용을 작성하는 클래스
		
			public void run() { //작성될 내용은 TimerTask클래스의 run메소드에 오버라이드(매서드 재정의)를 통하여 작성되도록 되어있습니다.
				Date d3=new Date();
				SimpleDateFormat sdf1=new SimpleDateFormat("hh"+"시");
				SimpleDateFormat sdf2=new SimpleDateFormat("mm"+"분");
				SimpleDateFormat sdf3=new SimpleDateFormat("ss"+"초");
				
				tf1.setText((sdf1.format(d3)));
				tf2.setText((sdf2.format(d3)));
				tf3.setText((sdf3.format(d3)));
				
				
			}
		};
		t.schedule(t2,0,1000); //객체,(최초시작 딜레이), 반복주기

		
		
		
		
	} 
	
/*	@Override
	public void actionPerformed(ActionEvent e1){
		if(e1.getSource()==b1){  
			int hour;
			int min;
			int sec;
			
			tf1.setText(hour = rightNow.get(Calendar.HOUR));
			tf2.setText(min = rightNow.get(Calendar.MINUTE));
			tf3.setText(sec = rightNow.get(Calendar.SECOND));
			
		}
	
	}*/
}
public class hm34 {

	public static void main(String[] args) {
		DCGUI D1=new DCGUI();

	}
}



/////////////////////////////////////////////////////////////////////////////////////////////
/* 또 다른 풀이1
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class ClockGUI extends Frame implements ActionListener {
		private Button b1 = new Button("시작 버튼");
		private Label la1 = new Label("시");
		private Label la2 = new Label("분");
		private Label la3 = new Label("초");
		private TextField tf1 = new TextField();
		private TextField tf2 = new TextField();
		private TextField tf3 = new TextField();
		
		public ClockGUI() {
			this.setLayout(null);
			b1.setForeground(new Color(0,0,255));
			b1.setBackground(new Color(255,180,100));
			b1.setFont(new Font("돋움",Font.BOLD,20));
			///button
			b1.setSize(200, 70);
			b1.setLocation(150, 300);
			this.add(b1);
			b1.addActionListener(this);
			///label
			la1.setSize(50, 40);
			la1.setLocation(130,100);
			this.add(la1);
			
			la2.setSize(50,40);
			la2.setLocation(250, 100);
			this.add(la2);
			
			la3.setSize(50, 40);
			la3.setLocation(370,100);
			this.add(la3);
			//Text-box
			tf1.setSize(60, 30);
			tf1.setLocation(80, 100);
			this.add(tf1);
			
			tf2.setSize(60, 30);
			tf2.setLocation(200,100);
			this.add(tf2);
			
			tf3.setSize(60,30);
			tf3.setLocation(320,100);
			this.add(tf3);
			
			this.setSize(500, 500);
			this.setVisible(true);
			
			addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e1){
					dispose();
					System.exit(0);//Coercion exit
				}
			});
		}
		

		@Override
		public void actionPerformed(ActionEvent e1) {
			// TODO Auto-generated method stub
			Timer t1 = new Timer();
			TimerTask m_t = new TimerTask(){
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					int hh=0, mm=0, ss=0;
					Date d1 = new Date();
					hh = d1.getHours();
					mm = d1.getMinutes();
					ss = d1.getSeconds();
					
					tf1.setText(""+hh);
					tf2.setText(""+mm);
					tf3.setText(""+ss);
				}
				
			};
			t1.schedule(m_t,0,1000);
		}
}
public class Clock1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClockGUI b = new ClockGUI();
	}
}
*/


/* 또 다른 풀이 2
 *  public void actionPerformed(ActionEvent e1){//
    	if(e1.getSource() == b1){ //버튼이 눌러졌으면(이벤트) 
    		b1.setEnabled(false);//////////
    	Timer t1=new Timer();
    	t1.scheduleAtFixedRate(new TimerTask(){
            public void run(){
          		Date d1=new Date();
          		tf1.setText(String.valueOf(d1.getHours()));
         		tf3.setText(String.valueOf(d1.getMinutes()));
         		tf5.setText(String.valueOf(d1.getSeconds()));
            }      		
    	}, 1000, 1000);//1초후에 1초간격으로 
      }
    } 
  */
