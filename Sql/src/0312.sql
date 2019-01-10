
create table 테이블명(
컬럼1 타입(길이:byte),
컬럼2 타입(길이:byte),
......

);
이름: 30문자 제한
타입: 오라클 // NUMBER							,VARCHAR2, 				,DATE
	 자바 // re.getInt()/ rs.getDouble()		,rs.getString()			,rs.getDate()=rs.getString()

	 number: 최대 38자리
	 varchar2: 최대 4000바이트(한글 1300자정도)
	 
	 
-- emp테이블
-- 사번: id, 5자리 정수
-- 이름: name, 20바이트 문자열
-- 입사일: date
-- 급여: 소수점 2자리, 정수 6자리 실수

select * from emp;
select * from tab;
	 
create table EMP(
id number(5),
name varchar2(20), 
indate Date,
salary number(8,2)
);

select *from tab where lower(tname)='emp';



---- DDL (1)create  (2)alter  (3) drop----
---- DDL: 대상테이블
------------------------------------------

-- alter table 테이블명  modify() --수정내용 정의
-- < 급여 정수8, 소수2자리로 자리수 수정 >
alter table EMP modify(
salary number(10,2)
)

-- alter table 테이블명  add() --없던 컬럼 새롭게 하나 추가
-- < phone 문자열(30) 칼럼추가 >
alter table EMP add(PHONE varchar2(30));


-- alter table 테이블명  drop() --컬럼 삭제 
alter table EMP drop (PHONE);
alter table EMP drop column PHONE;


-- alter table 테이블명 rename column 기존테이블명 to 새로운이름(새로운테이블명)
-- <name-> emp_name 수정>
alter table emp rename column name to emp_name

-- drop table 테이블명; 테이블 삭제 
-- 테이블 + 칼럼구조 삭제
-- 데이터삭제 + 칼럼구조 삭제 X
drop table EMP;
select table EMP;


-- subquery -> create table(select)
1. 레코드 x(테이블 구조복사) // 레코드 O(데이터 복사)
create table emp50 as
select * from employees where department_id = 50;

2.
select *from emp50;

3.
desc emp50;


---- DML: (1)insert (2)delete (3)update
---- DML: 대상레코드
------------------------------------------
--insert into 테이블명(컬럼1, 컬럼2...)
--value(값1, 값2...)
   ※ 문자열/날짜는 '  '붙이고
   ※ 정수/실수는 안붙인다

--()를 생략해도 create순서대로 작성된다
insert into EMP(ID, EMP_NAME, INDATE, SALARY)
values(100, '박보검', '18/03/12', 400000);
insert into EMP(ID, EMP_NAME, INDATE, SALARY)
values(101, '박보영', sysdate, 600000);
insert into EMP  
values(102, '이보영', sysdate-1, 900000);
insert into EMP					       
values(103, null, sysdate-1, 400000);  
insert into EMP(id,indate,salary)		
values(104, sysdate-1, 400000);  

insert into emp (select employee_id, first_name, hire_date, salary from employees where lower(first_name) =lower('Steven'));

-- update 테이블명 set 칼럼명 = 수정값 [where 수정조건식];
emp_name 컬럼 null 인 사원의 이름 이자바 수정

update 테이블명
set 컬럼명 = 수정값[컬럼명2=수정값2,....]
[where 수정조건식]

update emp
set emp_name='이자바'
where emp_name is null;

-- delete 테이블명 where 삭제할 조건식;
-- truncate: 모든 데이터만 삭제  	+테이블구조 유지 (복구x)
-- delete: 조건에 맞는 데이터만 삭제	+테이블구조 유지 (복구O)

delete emp where emp_name = initcap('steven'); 
select * from EMP;


Rollback complete.
-- dml: 실행후에 복구 기회 x, 실행 동시에 db반영  ==> (dml수행 후 sql plus 정상종료: 자동 commit)
-- ddl: insert/update/delete: 복구기회o (db반영 x 기회o) ==> insert + rollback=> 삽입(임시 메모리 저장)+ 취소
													-- insert + commit => 삽입+db반영
-- transaction control language)
-- 트랜잭션 : 2개 이상의 여러 복합 작업 단위 (2개 sql(dml))
-- tcl: commit// rollback(삭제를 취소한다) 
--  	(저장)	 (취소)


계좌이체
A계좌 , B계좌 100원 이체
1. a계쫘 100출금 - 은행 전산망 문제로 중단
2. b계좌 100입금

create table 계좌(
계좌번호 varchar2(10),
잔액 number(10,2)
);

1. a계좌출금
update 계좌
set잔액 = 잔액-100
where 계좌번호='a';

2. b계좌입금
update 계좌
set잔액= 잔액+100
where 계좌번호='b';
==all or nothing
 commit / rollback
 
 
따라서 dml+ commit/rollback;
-- 이클립스에서 insert하고나서 commit을 안하면 데이터가 안보일 수 밖에ㅐ 없다. commit이나 rollback을 함으로써 Lock을 풀 수 있다.


-- 오늘 배운 것
-- ddl/ dml/ tcl
-- creat/ alter/ drop/ insert/ update/ delete




---------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------<2018/03/12 과제>----------------------------------------------------------

--1. board  테이블을 정의하시오.
--번호 정수 5자리
--제목 문자열 100바이트
--내용 문자열 4000바이트
--작성자 문자열 30바이트
--작성시간 날짜시간
--글암호  정수 5자리
--조회수  정수 10자리
create table board(
num number(5),
title varchar2(100),
text varchar2(4000),
editer varchar2(30),
edtime date,
key number(5),
total number(10)
);

--2.다음의 데이터를 board 테이블에 저장하시오. 
--1 첫번째글제목 첫번째글내용 홍길동 현재날짜시간 1111 0

--DROP SEQUENCE id_seq
--ALTER SEQUENCE num_seq
--select * from user_sequences

CREATE SEQUENCE num_seq INCREMENT BY 1 START WITH 1;
insert into board(num, title, text, editer, edtime, key, total)
values(num_seq.nextval, '첫번째글제목','첫번째글내용','홍길동',sysdate,1111,0);

select * from board;
select * from tab;
drop table board;

--3.  다음 데이터 4개를 저장하시오.
--힌트 : select max(seq) from board

--1>이전 게시물의 번호+1
--인어 아세요? 
--허준재를 좋아합니다.
--심청이 
--현재날짜시간 
--2222
--0

--2>이전 게시물의 번호+1
--공유 
--도깨비입니다
--김신 
--현재날짜시간 
--3333
--0

--3>이전 게시물의 번호+1
--보검복지부 
--팬클럽니다
--박보검
--현재날짜시간 
--4444
--0

insert into board(num, title, text, editer, edtime, key, total)
values(num_seq.nextval, '인어 아세요? ','허준재를 좋아합니다.','심청이 ',sysdate,2222,0);

insert into board(num, title, text, editer, edtime, key, total)
values(num_seq.nextval, '공유 ','도깨비입니다','김신 ',sysdate,3333,0);

insert into board(num, title, text, editer, edtime, key, total)
values(num_seq.nextval, '보검복지부 ', '팬클럽니다','박보검',sysdate,4444,0);

select * from board;
--4. 이전 board 테이블의 모든 내용을 db 에 영구저장되도록 처리하시오. (commit은 영구저장, rollback은 취소)
commit


--5. DEPT 테이블을 정의하시오.
--부서코드 d_id 5자리 정수
--부서명 d_name 30바이트 문자열
--도시명 city 20바이트 문자열

CREATE TABLE DEPT(
d_id number(5),
d_name varchar2(30),
city varchar2(20)
);

--6. 부서명 컬럼의 길이를 50으로 변경하시오.

alter table DEPT modify(
d_name varchar2(50)
);

--7. 다음과 같은 데이터를 DEPT 테이블에 저장하고
--COMMIT 하시오.
--10 인사부 서울시
--20 자금부 서울시
--30 교육부 대전시
--40 IT사업부 광주시
--50 총무부 대전시
--60 신사업부 대전시
--70 금융사업부 광주시 null
--80 제품개발부 부산시 null

CREATE SEQUENCE id_seq INCREMENT BY 10 START WITH 10;
insert into DEPT
values(10,'인사부','서울시');
insert into DEPT
values(20,'자금부','서울시');
insert into DEPT
values(30,'교육부','대전시');
insert into DEPT
values(40,'IT사업부','광주시');
insert into DEPT
values(50,'총무부','대전시');
insert into DEPT
values(60,'신사업부','대전시');
insert into DEPT(d_id, d_name)
values(70,'금융사업부');
insert into DEPT(d_id, d_name)
values(80,'제품개발시');

select * from dept
drop table dept

--8. 사업부서들을 청주시 지역으로 이동하시오.
update DEPT
set city = '청주시'
where d_name like('%사업부%');



select *from DEPT;


