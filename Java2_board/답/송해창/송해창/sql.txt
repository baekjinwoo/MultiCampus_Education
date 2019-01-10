1. member 테이블
id : 문자열 (20바이트) primary key
password : 문자열(10바이트) not null
member_name : 문자열(30바이트)
email : 문자열(30바이트) '@' 포함 
phone : 문자열(20바이트)

create table member(
id varchar2(20) constraint member_id_pk primary key,
password varchar2(10) constraint member_pw_nn not null,
member_name varchar2(30),
email varchar2(30) constraint member_email_ck check (email like '%@%'),
phone varchar2(20));

create table board(
numberr number(5) constraint b_numberr_pk primary key,
title varchar2(100) constraint b_title_nn not null,
story varchar2(4000),
writer varchar2(20) constraint b_writer_fk references member(id),
timee date,
pass number(5),
vieww number(10) constraint b_view_ck check(vieww >= 0));

insert into board values(1, '첫번째글제목','몰라','이자바', sysdate, 1111, 0);



create sequence board_sequence start with 1 increment by 1 maxvalue 100;

select * from board;
select * from member;