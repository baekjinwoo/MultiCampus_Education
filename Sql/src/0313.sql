-- 데이터 무결성 제약조건: 부적절한 데이터 입력 방지
-- 테이블 = 현실 세계 모습 그대로를 반영 (맞지 않는 것을 제약하는 것을 의미한다)

-- 조건1, not null: 반드시 값 존재
-- 조건2, unique: 중복값 허용x 
-- 조건3, primary key: not null + unique
-- 조건4, foreign key: 다른 테이블의 컬럼값만 허용한다
-- 조건5, check: 사용자 정의, 중복x

create table c_emp
(
id number(5) constraint c_emp_id_pk primary key,
emp_name varchar2(20) constraint c_emp_name_nn not null,
indate date, 
salary number(10, 2) constraint c_emp_salary_ck check (salary >= 10000),
phone varchar2(20) constraint c_emp_phone_ck check (phone like '010%'),
d_id number(5) constraint c_emp_d_id_fk references c_dept(d_id)
);
--외래키 d_id는 중복x 범위5안에 정해진 값만 작성해서 넣을수 잇음

insert into c_emp values(100,'홍길동', sysdate, 10000, '010-652-7777',10);
insert into c_emp values(200,'심청이', sysdate, 20000, '010-555-2222',20);
insert into c_emp values(300,'심청이', sysdate, 30000, '010-555-444',30);
insert into c_emp values(400,'기며식', sysdate, 40000, '010-555-5555',40);
insert into c_emp values(500,'이자바', sysdate, 50000, '010-555-7777',50);

	commit 

create table c_dept(
	d_id number(5) constraint c_dept_d_id_pk primary key,
	d_name varchar2(20), 
	city varchar2(30) constraint c_dept_city_ck check (city like '%시')
);

drop table c_emp;
select * from tab;

insert into c_dept values (10,'총무부','서울시');
insert into c_dept values (20,'인사부','안산시');
insert into c_dept values (30,'전산부','제주시');
insert into c_dept values (40,'신사업부','광주시');
insert into c_dept values (50,'개발부','부산시');

select *from c_dept
commit 

-- c_dept 테이블 50번 부서 삭제
1> c_emp 테이블 50번 부서원 x -수행
2> c_emp 테이블 50번 부서원 다른 부서 이동/수행
3> c_emp 테이블 50번 부서원 같이 삭제
	delete c_emp where d_id=50;
	delete c_dept where d_id=50;

-- 데이터 딕셔너리
-- select CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, SEARCH_CONDITION from USER_CONSTRAINTS WHERE TABLE_NAME ='테이블명'
	
select * from dictionary
select table_name from dictionary where table_name like 'USER_CON%' ORDER BY TABLE_NAME
select CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, SEARCH_CONDITION from USER_CONSTRAINTS WHERE TABLE_NAME ='C_EMP'

employees테이블에 설정 제약조건 컬럼들 확인
select CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, SEARCH_CONDITION from USER_CONSTRAINTS WHERE TABLE_NAME ='EMPLOYEES'


===============================================================================================================
	select * from c_emp 
	drop table c_dept
	drop table c_emp
	
--C_EMP테이블에서 이름이 심씨인 사원의 모든 컬럼조회
	SELECT * FROM c_emp WHERE emp_name LIKE '심%' 
	
--C_EMP테이블에서 홍길동과 전화번호 뒤 4자리 동일한 사원의 급여를 홍길동의 급여로 변경
	update c_emp
	set salary = (select salary from c_emp where emp_name = '홍길동')
	where substr(phone,9,4)= (select substr(phone,9,4) from c_emp where emp_name = '홍길동')
  --where substr(phone,length(phone)-3,4)= (select substr(phone,length(phone)-3,4) from c_emp where emp_name = '홍길동')
	
	select * from c_emp
	
--C_EMP테이블에서 홍길동과 같은 부서원 삭제 (단, 홍길동 자신은 제외)
	delete c_emp 
	where d_id = (select d_id from c_emp where emp_name = '홍길동')
	
	rollback
	
	delete c_emp 
	where d_id = (select d_id from c_emp where emp_name = '홍길동') and emp_name != '홍길동'

===============================================================================================================
/*
프로젝트 계정생성
create table 테이블명
(admin:system):
--
conn system/1234;
create user project identified by 1234; //아이디/비번
grant connect, resource to project;
--
conn project/project
*/
===============================================================================================================
create user
create table
create view 
create sequence

view 개념/생성/수정/삭제
create view 뷰이름 as subquery
create or replace view 뷰이름(별칭) as subquery
drop view 뷰이름

===============================================================================================================

테이블: 물리적 행과 열 구조 정의
create view 뷰 이름   --테이블의 특정 컬럼 모아놓은 가상 테이블
as
subquery;

--view 생성
create view emp55
as
select employee_id, first_name, salary, department_id 
from employees 
where department_id = 50;

--조회
select sum(salary) from employees where department_id=50
select sum(salary) from emp55;

select*from emp55

--view 수정
create or replace view emp55 as select *from  c_emp;

--view 삭제
drop view emp55

-- view 내부에서 사용시 as필수로 쓰도록 한다
create or replace view emp55 = as select *from employees where departmenet_id = 50;
1> view dml 제한적 가능
2> 뷰 포함되지 않는  컬럼이 원래 테이블 제약조건 설정을 위배되는 dml불가능
3> 부서의 최대급여 최소급여 평균급여 급여총합 부서원수 자주 조회: emp_group55 뷰 생성 sql

create or replace view emp_group50
as
select max(salary) maxsal,
min(salary) minsal,
round(avg(salary)) avgsal,
sum(salary) sumsal,
count(salary) cntsal
from employees
where department_id =50;

4> insert into emp_group50 values(1,2,3,4,5);
-- 뷰를 조회할때,  DML을 사용할 수 없다 . max, min 등....사용이 제한적

===============================================================================================================

/*
sequence 개념/생성/수정/삭제
create sequence 시퀀스이름
start with 10

시퀀스: 자동숫자생성기
rownum: select시 조회 자동 레코드 번호 생성기
시퀀스: insert시 자동숫자증가
create sequence test_sequence
start with 1 --시작값
increment by 2 --증가값
maxvalue 100 --종료값  

create sequence test_sequence
start with 1 --시작값
increment by 2 --증가값
nomax; --무한대

시퀀스 내부 2가지 값 자동존재
- nextval :초기값 10
- currval :초기값 null
*/

create sequence test_sequence;
select test_sequence.nextval from dual;

-- < c_emp테이블 id 컬럼 501~600 >
create sequence sq_id start with 501 increment by 1 maxvalue 600;
select test_sequence.currval from dual;

insert into c_emp
values(sq_id.nextval,'김대리', '2016/12/31', 20000, '010-5676-9999',50);

select *from c_emp

-- 이클립스는 자동commit이라서 rollback효과 없음 => sqlplus에서 써야한다
--commit; 
--rollback;

--<시퀀스 무한대로 변경>
alter sequence sq_id nomaxvalue;
select test_sequence.nextval from dual;

-- alter table 테이블명 modify (salary number(4,2)); => alter를 통해 salary길이값을 줄이거나, 이미 데이터가 삽입이 된 경우에는 변경할 수 없다.
-- alter table 테이블명 modify (~~~~~~~~~~~~~~~~~~); => 값의 범위를 늘리는 것은 제한이 없다.
--<시퀀스 startwith 변경>
ALTER SEQUENCE sq_id INCREMENT BY 600;
select sq_id.nextval from dual;

alter sequence sq_id increment by 1;
select sq_idnextval from dual;

--<시퀀스 제거>
drop sequence 시퀀스명;
drop sequence c_emp_id_seq;
select c_emp_id_seq from dual;


--
jdbc 프로그램
1. 키보드 입력
사원명 : xxxx
급여 : xxx
전화번호: xxx
부서 : xxxx

2. c_emp테이블에 저장 (사번, 사원명, 입사일, 급여, 전화번호, 부사코드)
사번: c_emp_id_seq값 활용
입사일: 오늘 날짜
전화번호: 010- 앞 포함
부서명을 c_dept조회하여 부서코드값

create sequence c_emp_id_seq start with 1 increment by 1 nomaxvalue;
