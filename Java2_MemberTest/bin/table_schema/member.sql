--(2)테이블명: memberphone
--   컬럼명 :    idx   숫자, 기본키
--                 name  가변형(10),널값허용안함
--                  phone 가변형(15)
--   시퀀스 : mp_idx (1부터 1씩증가)
--   입력자료 :  강호동  010-123-4567
--                   이만기  011-789-4561


create table memberphone(
idx number primary key,
name varchar2(10) not null,
phone varchar2(15));

create sequence mp_idx increment by 1 start with 1 nocycle nocache;
--create sequence N_SQL increment by 1 start with 1 nocycle nocache;


insert into memberphone(idx,name,phone) values(mp_idx.nextval,'강호동','010-123-4567');
insert into memberphone(idx,name,phone) values(mp_idx.nextval,'이만기','011-789-4561');

drop table memberphone;
DROP SEQUENCE mp_idx;
 SELECT * FROM USER_SEQUENCES

select *from memberphone;
select *from tab;