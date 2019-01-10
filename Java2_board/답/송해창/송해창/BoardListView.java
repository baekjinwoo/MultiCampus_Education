package view;

import java.util.Scanner;

public class BoardListView {

	public String input(){
		
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("1. 페이지조회");
		System.out.println("2. 조건조회");
		System.out.print("번호입력 : ");
		
		int search = sc1.nextInt();
		String result = ""; 
		if(search ==1){
			System.out.print("페이지 번호 입력: ");
			result = sc1.next(); //1+100 
		}else if(search==2){
			System.out.print("검색어 입력 : ");
			result = sc1.next();
		}
		
		
		
		return result;
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
		
	/*
				while (vo.next()) {
					int numberr = vo.getInt("numberr");
					String title = rsf.getString("title");
					String story = rsf.getString("story");
					String writer = rsf.getString("writer");
					String time = rsf.getString("time");
					int pass = rsf.getInt("pass");
					int vieww = rsf.getInt("vieww");

					System.out.println(rsf.getRow() + "\t" + numberr + "\t" + title + "\t" + story + "\t" + writer + "\t" + time + "\t" + pass + "\t" + vieww);
					}
				stf.close();
				System.out.println();
				System.out.println("이상 보드테이블 정보입니다.");
				break; // case2 end	
				
				
			}
			
			if(menu1 == 2){
				
			Connection con = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");	
			
			String sqlview2 = "select * from board where title, story, writer like '%?%'";
			
			
			PreparedStatement pstview2 = con.prepareStatement(sqlview2);
			
			System.out.println("\n 변경할 내용을 치셈.");
			
			String abcd = sc1.nextLine();
			pstview2.setString(1, abcd);
						
			ResultSet rs = pstview2.executeQuery();
			
			con.close();
			break; // case2-4 end
			
		
			}
			
		}
	
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return null;
		
	}
	
}
		
	*/