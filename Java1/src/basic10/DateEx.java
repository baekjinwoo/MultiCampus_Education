package basic10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//import java.util.*;를 써야 Calendar와 Date를 쓸 수 있다
public class DateEx {
	public static void main(String[] args) {
	//1. Date클래스를 이용 	
	//먼저 오늘날짜 구하기
		Date d1=new Date();
		int year = d1.getYear()+1900; //기본값이 118이니까 +1900
		int mon=d1.getMonth()+1; //객체.메소드로 월뽑는것  //0부터 시작하도록 되어있어서 +1
		int day=d1.getDate();
		System.out.println("오늘날짜:"+year+"년"+mon+"월"+day+"일");
		
	//만난지 100일 구하기 (문법상 오늘부터 100일까지 새려면 99일더하면된다. 1은 오늘이 포함되니까)
		d1.setDate(d1.getDate()+100-1); 
		int year1 = d1.getYear()+1900; 
		int mon1=d1.getMonth()+1; 
		int day1=d1.getDate();
		System.out.println("만난지 100일은 :"+year1+"년"+mon1+"월"+day1+"일");
				
	//살아온 날: 오늘날자-생일
		Date b1=new Date(1992-1900,12-1,29); //92y11m23d경우(생일) //-1900 //-1
		Date d2=new Date();
				
	//밀리세컨드
		long cha=d2.getTime()-b1.getTime();
	
	//오늘까지의 밀리세컨드를 구하기위해
	//생일까지의
	//초로 바꾸려면 1000/ 시간으로 바꾸려면 3600/ 날자로 바꾸려면 24  
		long nal=cha /1000/60/60/24;
		System.out.println(nal+"일");
				
			
	//2. 캘린더 클래스를 이용	
	//캘린더를 이용한 현재시간 출력
		Calendar cal1=Calendar.getInstance(); //객체안만들고 실행하는것
		int year2=cal1.get(Calendar.YEAR);
		int mon2=cal1.get(Calendar.MONTH)+1;
		int day2=cal1.get(Calendar.DAY_OF_MONTH);
		int hour2=cal1.get(Calendar.HOUR);
		int min2=cal1.get(Calendar.MINUTE);
		int sec2=cal1.get(Calendar.SECOND);
						
		System.out.println("현재시간");
		System.out.println(year2+"년"+mon2+"월"+day2+"일");
		System.out.println(hour2+"시"+min2+"분"+sec2+"초");
				
	//캘린더를 이용한 생일 출력
		Calendar birth=Calendar.getInstance();
		birth.set(1992, Calendar.JANUARY,29,0,0,0);
				
	// Calendar형 객체를 Date형으로 바꿀때 getTime()쓰고/ 밀리세컨드로 /
		Date today=cal1.getTime();
		Date saengil=birth.getTime();
		long cha2=today.getTime()-saengil.getTime();
		
		long nal2= cha2/1000/3600/24;
		System.out.println("살아온 날은"+nal2+"일");
				
	//3. SimpleDateFormat을 이용한 현재시간출력	
		Date d3=new Date();
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy년MM월dd일E요일 HH:mm:ss"); //대소문자 필히 지킬것 //HH는 24h
		System.out.println(sdf1.format(d3));
			
		Date d4=new Date();
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy년MM월dd일E요일 hh:mm:ss a");  //a 오전 오후
		System.out.println(sdf1.format(d3));
					
	}
}
