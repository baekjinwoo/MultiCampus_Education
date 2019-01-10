package homework01;

/*[문제18] 다음 프로그램을 작성하시오
(1) 프로젝트명 : MemberTest
(2)테이블명: memberphone
   컬럼명 :    idx   숫자, 기본키
                  name  가변형(10),널값허용안함
                  phone 가변형(15)
   시퀀스 : mp_idx (1부터 1씩증가)
   입력자료 :  강호동  010-123-4567
                   이만기  011-789-4561

create table memberphone(
idx number primary key,
name varchar2(10) not null,
phone varchar2(15));

create sequence mp_idx increment by 1 start with 1 nocycle nocache;

insert into memberphone(idx,name,phone) values(mp_idx.nextval,'강호동','010-123-4567');
insert into memberphone(idx,name,phone) values(mp_idx.nextval,'이만기','011-789-4561');
====================================
(3)구조
   src
      common
          JdbcTemplate.java
      view
          MemberMain.java   <---main()메서드
          MemberView.java 
      vo
          MemberVo.java
      dao
           MemberDAO.java
      biz
           MemberBiz.java    
      table_schema
           member.sql 

(4)조건
     1) MemberMain은 입력코드를 완성한다
     2) MemberVo 
            -idx:int    -name:String    -phone:String
            +MemberVo()
            +MemberVo(idx:int,name:String,phone:String)
            +getter & setter
      3) MemberBiz : Connection/close처리를 한다
               getMemberList():void     
               getMember(name:String):void            
               insertMember(ob:MemberVo):void                
               deleteMember(name:String):void 
      4) MemberDAO : Statement/ResultSet/close처리를 한다
               getMemberList(conn:Connection):ArrayList<MemberVo>      ==> 전체보기
               getMember(conn:Connection,name:String):MemberVo            ==> 찾기
               insertMember(conn:Connection,ob:MemberVo):int                ==> 추가
               deleteMember(conn:Connection,name:String):int                    ==> 삭제 
      5) MemberView는 출력 코드를 완성한다.

[입.출력화면]
1.추가  2.삭제  3.전체보기  4.찾기  5.종료
선택(1~5) : 1

이름: 강호동 
전화: 010-123-4567
추가되었습니다

1.추가  2.삭제  3.전체보기  4.찾기  5.종료
선택(1~5) : 3
강호동  010-123-4567
이만기  011-789-4561

1.추가  2.삭제  3.전체보기  4.찾기  5.종료
선택(1~5) : 4
찾는사람 : 강호동
강호동  010-123-4567

1.추가  2.삭제  3.전체보기  4.찾기  5.종료
선택(1~5) : 2
삭제할사람 : 강호동
삭제되었습니다
*/