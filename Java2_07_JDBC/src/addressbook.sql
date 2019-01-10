--계정바꾸기 (credu/credu)
select * from tab; --테이블 목록확인
drop table addressbook; --addressbook테이블 삭제

create table addressbook(
num number primary key,
name varchar2(10) not null,
phone varchar2(15),
addr varchar2(70));

create sequence num_seq increment by 1 start with 1 nocycle nocache;
drop sequence num_seq;  --시퀀스 삭제

insert into addressbook(num,name,phone,addr) values(num_seq.nextval,'aaa','010-111-1111','서울');
insert into addressbook(num,name,phone,addr) values(num_seq.nextval,'bbb','010-222-2222','울릉도');
insert into addressbook(num,name,phone,addr) values(num_seq.nextval,'ccc','010-333-3333','제주도');

select * from addressbook;

select * from tab;






