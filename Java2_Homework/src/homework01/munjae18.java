package homework01;

/*[����18] ���� ���α׷��� �ۼ��Ͻÿ�
(1) ������Ʈ�� : MemberTest
(2)���̺��: memberphone
   �÷��� :    idx   ����, �⺻Ű
                  name  ������(10),�ΰ�������
                  phone ������(15)
   ������ : mp_idx (1���� 1������)
   �Է��ڷ� :  ��ȣ��  010-123-4567
                   �̸���  011-789-4561

create table memberphone(
idx number primary key,
name varchar2(10) not null,
phone varchar2(15));

create sequence mp_idx increment by 1 start with 1 nocycle nocache;

insert into memberphone(idx,name,phone) values(mp_idx.nextval,'��ȣ��','010-123-4567');
insert into memberphone(idx,name,phone) values(mp_idx.nextval,'�̸���','011-789-4561');
====================================
(3)����
   src
      common
          JdbcTemplate.java
      view
          MemberMain.java   <---main()�޼���
          MemberView.java 
      vo
          MemberVo.java
      dao
           MemberDAO.java
      biz
           MemberBiz.java    
      table_schema
           member.sql 

(4)����
     1) MemberMain�� �Է��ڵ带 �ϼ��Ѵ�
     2) MemberVo 
            -idx:int    -name:String    -phone:String
            +MemberVo()
            +MemberVo(idx:int,name:String,phone:String)
            +getter & setter
      3) MemberBiz : Connection/closeó���� �Ѵ�
               getMemberList():void     
               getMember(name:String):void            
               insertMember(ob:MemberVo):void                
               deleteMember(name:String):void 
      4) MemberDAO : Statement/ResultSet/closeó���� �Ѵ�
               getMemberList(conn:Connection):ArrayList<MemberVo>      ==> ��ü����
               getMember(conn:Connection,name:String):MemberVo            ==> ã��
               insertMember(conn:Connection,ob:MemberVo):int                ==> �߰�
               deleteMember(conn:Connection,name:String):int                    ==> ���� 
      5) MemberView�� ��� �ڵ带 �ϼ��Ѵ�.

[��.���ȭ��]
1.�߰�  2.����  3.��ü����  4.ã��  5.����
����(1~5) : 1

�̸�: ��ȣ�� 
��ȭ: 010-123-4567
�߰��Ǿ����ϴ�

1.�߰�  2.����  3.��ü����  4.ã��  5.����
����(1~5) : 3
��ȣ��  010-123-4567
�̸���  011-789-4561

1.�߰�  2.����  3.��ü����  4.ã��  5.����
����(1~5) : 4
ã�»�� : ��ȣ��
��ȣ��  010-123-4567

1.�߰�  2.����  3.��ü����  4.ã��  5.����
����(1~5) : 2
�����һ�� : ��ȣ��
�����Ǿ����ϴ�
*/