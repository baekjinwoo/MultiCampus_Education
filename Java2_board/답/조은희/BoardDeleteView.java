package view;

import java.util.Scanner;

import vo.BoardVo;

public class BoardDeleteView {
	
	public BoardVo input(){
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("������ �Խù� ��ȣ : ");		int num=sc.nextInt();
		sc.nextLine();
		System.out.print("��ȣ �Է� : ");			String pw=sc.nextLine();
		
		BoardVo vo=new BoardVo(num,pw);
		
		return vo;
	}	
}
