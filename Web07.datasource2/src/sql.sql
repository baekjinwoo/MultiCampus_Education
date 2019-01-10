select * from board;

insert into BOARD
values(3,"b","bb","boy",sysdate,3123,123);


create table board(
seq number(5),
title varchar2(100),
contents varchar2(4000),
writer varchar2(30),
time1 date,
pw number(5),
view1 number(10)
);

drop table board;

--2.다음의 데이터를 board 테이블에 저장하시오. 
--1 첫번째글제목 첫번째글내용 홍길동 현재날짜시간 1111 0

--DROP SEQUENCE id_seq
--ALTER SEQUENCE num_seq
--select * from user_sequences

insert into board(seq, title, contents, writer, time1, pw, view1)
values('1', '첫번째글제목','첫번째글내용','홍길동',sysdate,1111,0);

insert into board(seq, title, contents, writer, time1, pw, view1)
values('5', '인어 아세요? ','허준재를 좋아합니다.','심청이 ',sysdate,2222,0);

insert into board(seq, title, contents, writer, time1, pw, view1)
values('4', '공유 ','도깨비입니다','김신 ',sysdate,3333,0);

insert into board(seq, title, contents, writer, time1, pw, view1)
values('6', '보검복지부 ', '팬클럽니다','박보검',sysdate,4444,0);

