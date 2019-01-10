package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class DBConnect {
	private Logger logger = Logger.getLogger(getClass());
	Connection conn=null;


	public DBConnect(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //1. 드라이버로드
			conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","credu","credu");
			System.out.println("OK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//--------------------------------------------------------------------------------------------
	public void dbClose(){
		try{
			if(conn!=null)conn.close(); //커넥션객체 끊기.
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//--------------------------------------------------------------------------------------------
	public void addressList(){
		PreparedStatement pstmt=null;
		ResultSet rs=null;         // 4. 결과값 반환
		
		try{
			String sql="SELECT * FROM ADDRESSBOOK ORDER BY NUM DESC";
			pstmt=conn.prepareStatement(sql); //pstmt는 connection객체와 연결하기위한 //preparedstatment에 sql문을 담아서 오라클에 보낸다
			rs = pstmt.executeQuery(); //가져올 값을 resultset으로 사용한다.
			logger.info("select 쿼리"+sql);
			
			while(rs.next())
			{                    // rs.getInt("컬럼명")   or  rs.getInt(순번)   
				System.out.print(rs.getInt("NUM") + "\t");         //or    rs.getInt(1)
				System.out.print(rs.getString("NAME") + "\t");     //or    rs.getString(2)
				System.out.print(rs.getString("PHONE") + "\t");
				System.out.println(rs.getString("ADDR"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();       //5. 연결객체 해제
				if(pstmt != null) pstmt.close();
			}catch(SQLException e){}
		}
	}
	//---------------------------------------------------------------------------------------------------
/*	public void addressInsert(String name, String phone, String addr) {
		PreparedStatement pstmt = null; //3. SQL문 실행을 위한 객체하나 생성 //데이터를 실을 상자를 생성
		try{
			String sql="INSERT INTO ADDRESSBOOK(NUM,NAME,PHONE,ADDR) VALUES(NUM_SEQ.NEXTVAL,?,?,?)";
			pstmt=conn.prepareStatement(sql); //conn과 pstmt를 연결하는 문장.
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, addr);
			int n=pstmt.executeUpdate(); //실려진 데이터를 DB로 날려보낸다.
			if(n>0){
				conn.commit(); //실행 성공시 commit한다; commit이란 임시기억장소에 저장되어있는 것을 다시 DB에 넣어라.
				System.out.println("1개 추가됨");
			}
			
		} catch(SQLException e){
			try{
				conn.rollback(); //실행 실패시 rollback한다
			} catch(SQLException e1){ }
		} finally{ 
			try{
				if(pstmt !=null) pstmt.close(); //5. 연결객체 해제
 			} catch(SQLException e){
				
			}
			
		}*/
	
	public void addressInsert(String name, String phone, String addr) {
		Statement pstmt = null; //3. SQL문 실행을 위한 객체하나 생성 //데이터를 실을 상자를 생성
		try{
			String sql = "INSERT INTO ADDRESSBOOK(NUM,NAME,PHONE,ADDR) VALUES(NUM_SEQ.NEXTVAL,'" + name + "','" + phone + "','" + addr + "')";
			//System.out.println("쿼리: " + sql); //제대로 String sql을 짯는지 확인차
			pstmt = conn.createStatement();
			int n = pstmt.executeUpdate(sql);
			logger.info("insert 쿼리"+sql);

			
			if (n > 0) {
				conn.commit(); // 실행 성공시 commit한다; commit이란 임시기억장소에 저장되어있는 것을 다시
								// DB에 넣어라.
				System.out.println("1개 추가됨");
			}

		} catch (SQLException e) {
			try {
				conn.rollback(); // 실행 실패시 rollback한다
			} catch (SQLException e1) {
			}
		} finally {
			try {
				if (pstmt != null)
					pstmt.close(); // 5. 연결객체 해제
			} catch (SQLException e) {

			}

		}
	}

	//---------------------------------------------------------------------------------------------------
	public void addressUpdate(int num, String phone, String addr) {
		PreparedStatement pstmt = null; //3. SQL문 실행을 위한 객체하나 생성 //데이터를 실을 상자를 생성
		try{
			String sql="UPDATE ADDRESSBOOK SET PHONE=?, ADDR=? WHERE NUM=?";
			pstmt=conn.prepareStatement(sql); //conn과 pstmt를 연결하는 문장.
			pstmt.setString(1, phone);
			pstmt.setString(2, addr);
			pstmt.setInt(3, num);
			int n=pstmt.executeUpdate(); //실려진 데이터를 DB로 날려보낸다.
			logger.info("update 쿼리"+sql);

			if(n>0){
				conn.commit(); //실행 성공시 commit한다; commit이란 임시기억장소에 저장되어있는 것을 다시 DB에 넣어라.
				System.out.println("1개 수정됨");
			}
			
		} catch(SQLException e){
			try{
				conn.rollback(); //실행 실패시 rollback한다
			} catch(SQLException e1){ }
		} finally{ 
			try{
				if(pstmt !=null) pstmt.close(); 
 			} catch(SQLException e){
				
			}
		}
		
	}
	//---------------------------------------------------------------------------------------------------
	public void addressDelete(int num) {
		PreparedStatement pstmt = null; //3. SQL문 실행을 위한 객체하나 생성 //데이터를 실을 상자를 생성
		try{
			String sql="DELETE FROM ADDRESSBOOK WHERE NUM=?";
			pstmt=conn.prepareStatement(sql); //conn과 pstmt를 연결하는 문장.
			pstmt.setInt(1, num);
			int n=pstmt.executeUpdate(); //실려진 데이터를 DB로 날려보낸다.
			logger.info("delete 쿼리"+sql);

			if(n>0){
				conn.commit(); //실행 성공시 commit한다; commit이란 임시기억장소에 저장되어있는 것을 다시 DB에 넣어라.
				System.out.println("1개 삭제됨");
			}
			
		} catch(SQLException e){
			try{
				conn.rollback(); //실행 실패시 rollback한다
			} catch(SQLException e1){ }
		} finally{ 
			try{
				if(pstmt !=null) pstmt.close(); 
 			} catch(SQLException e){
				
			}
		}
	}
}
