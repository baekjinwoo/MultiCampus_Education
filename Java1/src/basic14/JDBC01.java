package basic14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//DB연결은 Oracle의 JDBC를 이용해서 ! 이때 sql언어를 사용한다.
public class JDBC01 {
	public static void main(String[] args) throws Exception{
	//1. 아래의 클래스이름이 없을경우 에러가 표시되도록 throws
	//db접속시도 에러시(try~catch는 내가 한다~ throws는  오류처리 니가 해라~)
		
		//1. 오라클 드라이브 로드  
		Connection con1=null; //접속객체 선언
		Class.forName("oracle.jdbc.driver.OracleDriver"); //클래스이름.스태틱메서드 (소대문자 구분 중요)
		
		//2. db 접속시도 										// 접속 ip주소 		   id   password
		con1= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr"); 

		//3. 접속확인
		System.out.println("접속했지 말입니다");

		//4. 접속종료 (접속끊기)
		//con1.close();
		//System.out.println("접속이  끝났습니다.");

		// 접속이 안 될 경우, jdk->jre->lib->ext에 ojdb6.jar 복사
		// 그래도 안 될 경우, jr->lib->ext에 ojdb6.jar 복사
		// 그래도 안 되면, 철자 틀린 것.

		//1. sql문장
		String sq12="select * from employees"+ " where department_id=? or department_id=?"; //무슨 값이 들어갈지 모르는상태, 값을 하나 넣어야함
		//PreparedStatement 생성
		PreparedStatement pst = con1.prepareStatement(sq12);//컴파일,캐쉬
		//PreparedStatement클래스		//prepareStatement메서드    
		//Statement가 아닌 PreparedStatement를 사용한 이유는 준비된상태가 아니라, 미리 준비해야하는 상태이기때문에 아래의 범위로 값을 넣어야 한다
		pst.setInt(1, 90); //Scanner로 입력하면 그때그때 값이 바뀐다.
		pst.setInt(2, 80); //두번째 물음표에는 80을 넣어라.
		ResultSet rs2=pst.executeQuery();


		//2. sql문장
		//String sq12="select * from employees"+ " where department_id=90"; //조건문 90번 부서만 나와라.
		//db접속시도할때 띄어쓰면 안됨. 그러나, 여기서는 where앞을 무조건 띄어써야함 // from employeeswhere department로 출력되니까 에러. 
		//무조건 sql문장은 문장이 바뀌었을때 한칸 띄고 작성하는 것을 습관화하지않으면 최소 3시간이상 에러잡는대 소모해야한다
		//Statement st2=con1.createStatement(); 
		//문장 문장객체= 접속객체. 문장을 하나 만들겠다는 의미 ======> 문장에 대한 객체 st2를 하나 만들겟다
		
		//ResultSet rs2= st2.executeQuery(sq12);
		//그냥 문자열로 저장되어있는 실제문장 sq12를 종이상자 ResultSet에 의해 내가 실제문장sq12를 수행한다는 executeQuery에 의해 re2에 저장된다

		while(rs2.next()){ //종이박스안에 처리할게 있어? 처리할 줄이 있어?
			int id=rs2.getInt("employee_id"); //객체.메서드 //getInt(1); //번지수가 헤깔리면 칼럼명을 다음과 같이 바로 작성해도된다.
			String fname= rs2.getString("first_name"); //getString(2); 
			int salary= rs2.getInt("salary"); // getInt(8);
			String email=rs2.getString("email"); //getString("last_name");
			String h_date=rs2.getString("hire_date"); 
			
			String hire_date=h_date.substring(0, 10); //년월일만 substring사용해서 잘라서 출력
			System.out.println(rs2.getRow()+"\t"+id+"\t"+hire_date+"\t"+fname+"\t"+salary+"\t"+email);
		}
		con1.close();
		System.out.println("접속끝");
	}
}
