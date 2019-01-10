package view;

import java.util.Scanner;

import vo.BoardVo;

public class BoardDeleteView {
	
	public BoardVo input(){
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("삭제할 게시물 번호 : ");		int num=sc.nextInt();
		sc.nextLine();
		System.out.print("암호 입력 : ");			String pw=sc.nextLine();
		
		BoardVo vo=new BoardVo(num,pw);
		
		return vo;
	}	
}
