package view;

import java.util.List;

import vo.MemberVo;

public class MemberView {
	public void insertMember(String name){
		if(name!=null){
			System.out.println(name+"님이 추가되었습니다\n");
		}
		else{
			System.out.println("점수 입력오류!!");
		}
		
	}
	public void getMember(MemberVo ob){
		if (ob != null) {
				System.out.print("이름 : " + ob.getName()+"\t");
				System.out.print("전화번호 : " + ob.getPhone()+"\t");
				System.out.println();
			} else {
			System.out.println("데이터가 없습니다\n");
		}
	}
	
	public void getMemberList(List<MemberVo> list){
		if (list != null) {
			for (MemberVo ob : list) {
				System.out.print("번호 :"+ ob.getIdx()+"\t");
				System.out.print("이름 : " + ob.getName()+"\t");
				System.out.print("전번 : " + ob.getPhone()+ "\n");
			}
			System.out.println();
		} else {
			System.out.println("데이터가 없습니다\n");
		}
	}
	
	public void deleteMember(int n){
		if(n != 0){
			System.out.println("삭제되었다");
		}else
			System.out.println("입력오류");
		
		
	}
}
