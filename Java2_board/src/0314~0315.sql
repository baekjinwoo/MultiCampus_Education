/*
1. member ���̺�
id : ���ڿ� (20����Ʈ) primary key
password : ���ڿ�(10����Ʈ) not null
member_name : ���ڿ�(30����Ʈ)
email : ���ڿ�(30����Ʈ) '@' ���� 
phone : ���ڿ�(20����Ʈ)

2. board ���̺� (�̹� ���� ==> ����) 
writer member  ���̺� id �÷� ���簪 ����

		1>
		drop table board;
		create table board....

		2> alter table board modify
		(writer member  ���̺� id �÷� Ÿ�� 
		�������� member  ���̺� id �÷� ���簪 ����)  


*/


drop table board;
drop table member;
select * from member;
select * from Board;

insert into board values (2, 'ffsdf','fsddfsd','wlsdn',sysdate,1232,0);

create sequence total_seq increment by 1 start with 1; 
drop sequence total_seq;

create table member(
id varchar2(20) constraint member_id_pk primary key,
pw varchar2(10) constraint member_pw_m not null,
member_name varchar2(30),
email varchar2(30) constraint mem_email_ck check(email like '%@%'),
phone varchar2(20)
);


create table board(
num number(5) constraint board_num_pk primary key,
title varchar2(100) constraint board_title_n not null,
text varchar2(4000),
writer varchar2(20) constraint board_writer_fk references member(id),
editime date,
password number(5),
total number(10) constraint board_total_ck check (total>=0)
);
