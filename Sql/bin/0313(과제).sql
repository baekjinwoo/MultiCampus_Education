drop table board;
--외래키는 pk로 되있는 것에 한해서 가능하다. pk가 아니면 여기저기서 많이 사용되기때문에 fk로 쓸수 없다. 따라서 name을 ㅅ쓰지말고 id를 fk로 쓴다

--1.
create table board(
num number(5) constraint board_num_pk primary key,
title varchar2(100) constraint board_title_n not null,
text varchar2(4000),
id number(5) constraint board_id_fk references c_emp(id),
editime date,
password number(5),
total number(10) constraint board_total_ck check (total>=0)
);

--2. 
select * from tab;
drop table c_emp;
drop table c_dept;
drop table board;

insert into board
values(1,'첫번째글제목','첫번째글내용',300,sysdate,1111,0);

--3
create sequence num_seq2 increment by 1 start with 2; 
drop sequence num_seq2

insert into board
values(num_seq2.nextval, '인어 아세요? ','허준재를 좋아합니다.',200,sysdate,2222,0);

insert into board
values(num_seq2.nextval, '공유 ','도깨비입니다',100,sysdate,3333,0);

insert into board
values(num_seq2.nextval, '보검복지부 ', '팬클럽니다',500,sysdate,4444,0);

insert into board
values(num_seq2.nextval, '태후', '송혜교가 상대역입니다',400,sysdate,5555,0);

--4
commit

--5 계시물이 조회할떄에는 조회수가 1 증가되어야합니다. 게시물 조회한다고 가정하고 1번 글의 조회수를 1 증가시키는 sql을 작성하시오
update board
set total = total+1
where num like '1'

--6 1번 게시물 제목, 내용을 '수정 제목' , '수정 내용'으로  변경하고 작성시간을 변경하는 시간으로 재저장하시오
update board
set title='수정제목', text='수정내용', editime =sysdate
where num = 1;

select *from board

--7 지금까지의 dml 트랜잭션을 완료하시오
commit

--8 게시물의 암호가 4444인 글을 삭제하시오
delete board
where password = 4444


--9 8번에서 삭제된 글을 복구하시오
rollback

--10 태후라는 제목의 글을 작성한 작성자를 '유시진'으로 수정하시오
update board 
set id = '100'
where title = '태후';


select * from board;


/* view(1) Locations, Countries, Regions 테이블의 정보를 자주 이용해야 하며 이에 대해 하나의 단일 테이블인 것처럼 이용할 수 있도록 하기위해 다음과 같이 출력할 수 있는 
'LOCATIONS_NOT_AMERICAS'라는 이름의 View를 생성하기로 하였다. 단 REGION_NAME이 Americas가 아닌 것으로 것으로 것으로 한정한다 한정한다 한정한다 한정한다 . */
	create view LOCATIONS_NOT_AMERICAS
	as
	select location_id, street_address, postal_code, city, country_name, region_name
	from locations l, countries c, regions r
	where l.country_id=c.country_id and c.region_id=r.region_id and REGION_NAME != 'Americas';

	select * from LOCATIONS_NOT_AMERICAS;

/* view(2) 기존 EMPLOYEES 테이블에 있는 레코드들 중, Marking 부서에 근무하는 직원 레코드를 이용하여 EMPLOYEES_MARKETING 테이블을 만들기 위한 DDL을 작성하십시오 
 * 단, EMPLOYEES_MARKETING 테이블의 키는 없어도 관계없습니다*/
	create or REPLACE VIEW EMPLOYEES_MARKETING
	as
	select employee_id, first_name, last_name, email, phone_number, hire_date,job_id,salary, commission_pct,d.manager_id,d.department_id
	from employees e, departments d
	where e.department_id=d.department_id and lower(department_name)='marketing'

	select * from EMPLOYEES_MARKETING;


/* view(3) 인사관리를 위하여 현재 직원정보에 대한 백업테이블을 생성하여 보관하기로 합니다. 새로 생성하는 백업테이블명은 "EMPLOYEES_BACKUP*이며 기존테이블(EMPLOYEES)의 Index,
 Constraint는 필요로 하지 않습니다. 단 급여(Salary)가 5000을 초과하는 직원만 백업테이블 내에 존재해야 합니다. 위 설명에 해당하는 테이블을 생성하기 위한 스크립트를 작성하시오. 
 새로 생성한 테이블의 데이터 조회결과는 아래와 같습니다  */
	create or REPLACE VIEW EMPLOYEES_BACKUP
	as
	select employee_id, first_name, last_name, email, phone_number, hire_date,job_id,salary, commission_pct,d.manager_id,d.department_id
	from employees e, departments d
	where e.department_id=d.department_id and salary>=5000

	select * from EMPLOYEES_BACKUP;


/* view(4) 사원이 한 명 이상인 부서들에 대해 부서 번호, 부서 이름, 사원 수, 최고 급여, 최저 급여, 평균 급여, 급여 총액을 빈번하게 조회하여야 할 필요가 있어, VIEW를 생성하여 사용하고자 합니다 
 *  생성된 DB Object(View)의 전체 레코드에 대한 조회 결과가 아래와 같이 출력되도록 "DEPT_SAL_INFO"라는 VIEW를 생성하는 스크립트를 작성하십시오. 단, 평균 급여의 소수점이하는 절사합니다
 *  (출력: DEPT_ID | DEPT_NAME | NUM_EMP | MAX_SAL | MIN_SAL | AVG_SAL | SUM_SAL */
	create or REPLACE VIEW DEPT_SAL_INFO
	as
	select d.department_id 부서번호, department_name 부서명, count(employee_id) 사원수, max(salary) 최고급여, min(salary) 최저급여, round(avg(salary)) 평균급여, sum(salary) 급여총액	
	from employees e, departments d
	where e.department_id = d.department_id
	group by d.department_id, department_name
	order by d.department_id
	
	또는
	
	create or REPLACE VIEW DEPT_SAL_INFO
	as
	select e.department_id 부서번호, department_name 부서명, count(employee_id) 사원수, max(salary) 최고급여, min(salary) 최저급여, round(avg(salary)) 평균급여, sum(salary) 급여총액	
	from employees e, departments d
	where e.department_id = d.department_id
	group by e.department_id, department_name
	order by e.department_id


	select * from DEPT_SAL_INFO;
	
	drop view DEPT_SAL_INFO


/* view(5) EMPLOYEES 테이블에서 last_name 이 'Markle' 라는 사람의 job_id 와 동일한 job_id 를 가지는 사원에 대하여 
 * first_name, last_name, job_id, salary 를 조회하는 뷰를 생성하시오.
 * */

	create or REPLACE VIEW FINAL_TEST
	as
	select first_name, last_name, job_id, salary
	from employees 
	where job_id = (select job_id from employees where last_name like ('%Markle%'));

	select * from FINAL_TEST;

