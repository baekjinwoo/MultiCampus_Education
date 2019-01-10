
create table member(
id varchar2(20) constraint m_id_pk primary key, 
password varchar2(10) constraint m_pwd_nn not null,
member_name varchar2(30),
email varchar2(30) constraint m_em_ck check (email like '%@%'),
phone varchar2(20)
)

create table board(
title varchar2(100) constraint board_title_nn not null,
contents varchar2(4000),
writer varchar2(20) constraint board_writer_fk references member(id),
writedate date,
password number(5),
pageview number(10) constraint board_pageview_ck check(pageview >= 0)
)

create sequence board_pageview
start with 1
increment by 1
nomaxvalue;

