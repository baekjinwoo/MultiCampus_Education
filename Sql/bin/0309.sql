
create table salgrade(
grade number(2),
lowsalary number(8,2),
hisalary number(8,2)
);

insert into salgrade values(1,1000,5000);
insert into salgrade values(2,5000,10000);
insert into salgrade values(3,10001,15000);
insert into salgrade values(4,15001,20000);
insert into salgrade values(5,20001,99999);

select * from salgrade;


--겹치는 key는 없지만 join가능, salary보다 lowsalary가 작고, hisalary가 큰 값만 조회해라
--겹치는 key (중복)테이블일 경우에만 별칭을 써서 join한다
select first_name as 이름, salary as  급여, grade as 등급 from employees, salgrade where lowsalary <= salary and (salary <= hisalary); 
select first_name as 이름, salary as  급여, grade as 등급 from employees, salgrade where salary between lowsalary and hisalary; 


--106개만 보인다
select first_name, department_name from employees e, departments d where e.department_id = d.department_id;
																		
-- 한쪽 테이블은 데이터가 존재하고, 한쪽 테이블은 데이터가 존재하지 않을때 = 존재하지않는 쪽에 (+)를 하면 없는 값까지 포함해서 조회된다
--																			null(0)	 	 = 	null(x)이고,   (+)는 범위 내부 존재x 포함
--																		null도 포함되있음	 = d.department_id에는 null없어도, 보여달라
select first_name, department_name from employees e, departments d where e.department_id = d.department_id(+);


select e.first_name as 사원명, d.department_id as 부서코드, d.manager_id as 부서장사번 
from employees e, departments d 
where e.department_id = d.department_id(+);


-- manager_id 안의 null값도 포함시켜줘라는 뜻
select d.department_id as 부서코드, d.department_name as 부서명, nvl(to_char(e.first_name),'부서장없음') as 부서장이름
from employees e, departments d 
where e.employee_id(+) = d.manager_id;


--내 사번, 내이름, 사수사번, 사수이름 조회  		
--employees(내정보) : 내사번, 내이름 
--employees(사수정보): 사수사번, 사수이름
-- manager_id에는 null이 있지만, employee_id에는 null이 없기때문에 null을 받겟다는 의미로 +
select me.employee_id as "내 사번", me.first_name as "내 이름", nvl(to_char(me.manager_id),'boss') as "사수사번",  nvl(to_char(up.employee_id),'boss') as "내사번", up.first_name as "상사이름" 
from employees me, employees up 
where me.manager_id=up.employee_id(+);


--주어진 조건 만족 범위 내 조인 : inner join
--주어진 조건 만족 범위 이외 조인: outer join
-- 조건값 동일 조인 : equi
-- 조건값 동일 이외 조인 : non-equi
-- 자신 테이블 조인: self
-- equi+self+outer

--join : 2개 이상 테이블에서 칼럼들 합침.
--union: 은행 합병 (a,b회사 합병 사원 새로 구성, a회사 사원테이블 + b회사 사원테이블) 


--10장. <union : 레코드 행을 합친다 : 단, 조건으로 출력하는 컬럼개수와 값이 같아야 한다.>--
--사원테이블에서 50번 부서는 보너스10%, 80번 부서는 보너스 20%
--출력형태 : 부서코드 급여 보너스

--select department_id as 부서코드, salary as 급여, salary*1.1 as 보너스 from employees where department_id in(50,80)을 쓸수없다. 왜냐하면 보너스를 구분해서 줄수가 없음
select department_id as 부서코드, salary as 급여, salary*1.1 as 보너스 from employees where department_id =50
union
select department_id as 부서코드, salary as 급여, salary*1.2 as 보너스 from employees where department_id =80;



--11장. subquery 하위쿼리
--select (select절에 들어가는 하위쿼리....)
--from (from절에 들어가는 하위쿼리....)
--where (where절에 들어가는 하위쿼리....)

--sarah와 같은 날에 입사한 사원 이름, 입사일 조회
select first_name as 이름, department_id as 부서코드 from employees where lower(first_name)='sarah' or department_id = '50';
select first_name as 이름, to_char(hire_date,'YYYY/MM/DD') as 입사일 from employees where department_id = (select department_id from employees where lower(first_name)='sarah');

--sarah와 같은 연도에 입사한 사원 이름, 입사년도 조회, 다만 sarah는 빼고 조회해라
select first_name as 이름 from employees where hire_date = (select hire_date from employees where lower(first_name)='sarah');
select first_name as 이름, to_char(hire_date,'YYYY/MM/DD') as "변경된 입사일" from employees where substr(hire_date,1,2) = (select substr(hire_date,1,2) from employees where lower(first_name)='sarah') and lower(first_name) <> 'sarah';

-- 한 번 select안되면 subquery해라
--전사원의 평균급여 이상의 급여를 받는 이름과 급여 조회
select first_name as 이름, salary, round(salary) 
from employees 
where salary >=(select round(avg(salary)) from employees);
select first_name as 이름, salary, (select round(avg(salary)) from employees) from employees where salary>= (select round(avg(salary)) from employees);

--sarah와 같은 직종에 종사하는 사원의 부서명
select first_name as 이름, job_title as 직종명 
from employees e, jobs j 
where e.job_id=j.job_id 
and
e.job_id= (select job_id from employees where lower(first_name)='sarah');

--manager 관련 직종 가운데 급여를 5000이상 받는 사원이름 직종이름 급여 조회를 출력하시오
-- 1. join으로 푸시오
select first_name as 이름, job_title as 직종, salary as 급여 
from employees e, jobs j 
where e.job_id = j.job_id 
and lower(j.job_id) like 'man%' and e.salary>=5000;

select first_name as 이름, job_title as 직종, salary as 급여 
from employees e, jobs j 
where e.job_id = j.job_id 
and lower(j.job_title) like '%manager' and e.salary>=5000;

select job_id, job_title from jobs;
--2.sub으로만 푸시오 ; 
			--manager관련 직종 사원정보 조회 => 
			select job_title as 직종명, job_id as 직종코드 from jobs where job_id like 'man%';
				--급여를 5000이상 받는 사원정보 조회
				select salary as 급여, job_id from employees where salary >= 5000;
					--최종 합치기 :from절안에 맨위의 절을 작성할 것이다
					select first_name, job_title, salary
					from 
					(select job_title, job_id from jobs where job_id like '%MAN') A,
					(select first_name, salary, job_id from employees where salary >= 5000) B
					where A.job_id=B.job_id;

-- employees 입사일 가장 빠른 사원부터
-- 1페이지: 10명 출력/
-- 2페이지: 그다음 10명 출력
		select first_name, hire_date from employees order by hire_date desc;
		-- 한번에 조회할 수 없다면 sub query를 이용하라
		select rownum, first_name, hire_date from employees order by hire_date;
			--1절+2절 ===> 두 절을 하위커리로 합치시오
			--페이징처리 sql:오라클은 rownum 함수 제
			
			select rownum, first_name, hire_date  
			from (select first_name, hire_date from employees order by hire_date)
			where rownum>=1 and rownum <=20;
			

			select r_id, first_name, hire_date
			from (select rownum r_id, first_name, hire_date  
			from (select first_name, hire_date from employees order by hire_date))  --정렬을 하기 위한 서브커리
			where r_id>=11 and r_id <=20;
			-- rownum: select시 임시 레코드 번호 생성인데, 첫번째 레코드가(1번)이 조회가 된 상태에서 진행된다. // 시작값인 1을 제외하고는 연산계산을 할 수 없다. // >, >= 연산자 인식못함(1 제외)  //rownum은 자기보다 작거나 같다는 연산자는 인식한다.
			--키보드입력 : 1--> 1,10
			--         2--> 11,20
			
			
--william과 같은 부서에 근무하는 사원의 이름과 부서코드 조회
-- 사라일때는, 사라가 한명이라서 비교연산자 =였는데 william일때는 2명이기때문에 in으로 쓴다		
select first_name, department_id from employees where lower(first_name)='william';

--50과 80 인 사람.
-- sub query 앞으로 서브커리를 사용할때, (1)단일행 subquery: =연산자   (2) 다중행 subquery: in연산자 ///// =any 연산자
-- 							   (1)단일행 >, >= , <, <=   (2) 다중행 in, =any, =all
select first_name, department_id from employees where department_id all 
(select department_id from employees where lower(first_name) = 'william');	

select first_name, department_id from employees where department_id = any 
(select department_id from employees where lower(first_name) = 'william');	

-- 하위커리에 department_id 말고 다른게 들어가면 안된다
select first_name, department_id from employees where department_id in 
(select department_id from employees where lower(first_name) = 'william');	


--william보다 급여를 많이 받는 사원의 이름, 급여 조회 (같거나 큰이 아니고, 그냥 큰 이기때문에 =대신 any로)   ==> 동명이인이라면 1사람의 william과 조건만족
-- 사라일때는 1명밖에 없기때문에 >만 쓰면되는데, william일때는 2명이기때문에 > any를 써야한다
-- >any는 두 건중에 한 건만 만족하면 되기때문에 record수가 많다
select first_name, salary from employees where salary > any
(select salary from employees where lower(first_name) = 'william');

--  >all는 두 건을 다 만족해야되기때문에 >any보다 record수가 적다
select first_name, salary from employees where salary > all
(select salary from employees where lower(first_name) = 'william');


---------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------<2018/03/09 과제>----------------------------------------------------------

--1. 80번 부서의 평균급여보다 많은 급여를 받는 직원의 이름, 부서id, 급여를 조회하시오.
	select department_id from employees where department_id ='80';

	select first_name 이름, department_id 부서id, round(salary) 급여 from employees
	where salary > (select round(avg(salary)) from employees where department_id ='80');

--2. 'South San Francisco'에 근무하는 직원의 최소급여보다 급여를 많이 받으면서 ////////////50 번부서의 평균급여보다 많은 급여를 받는 직원의 이름, 급여, 부서명, 부서id를 조회하시오.
	select e.first_name 이름, round(salary) 급여, d.department_name 부서명, d.department_id 부서id from employees e, departments d
	where e.department_id=d.department_id and salary > (select round(avg(salary)) from employees where department_id =50)
	union
	select e.first_name 이름, round(salary) 급여, d.department_name 부서명, d.department_id 부서id from employees e, departments d	
	where e.department_id=d.department_id and salary > (select round(min(salary)) from employees e, departments d where d.department_id = e.department_id and lower(department_name) ='south san francisco');
	
--3. 각 직급별(job_title) 인원수를 조회하되 사용되지 않은 직급이 있다면 해당 직급도 출력결과에 포함시키시오. 그리고 직급별 인원수가 3명 이상인 직급만 출력결과에 포함시키시오. (각 =group by)
	select count(job_title) "직급별 인원수" from employees e, jobs j where j.job_id = e.job_id group by job_title having count(job_title)>=3;
	
--4. 각 부서별 최대급여를 받는 직원의 이름, 부서명, 급여를 조회하시오. (각 = group by)
	SELECT FIRST_NAME 이름, DEPARTMENT_NAME 부서명, E.SALARY 급여
		FROM EMPLOYEES E, (SELECT D.DEPARTMENT_ID, DEPARTMENT_NAME, MAX(SALARY) "SALARY" FROM EMPLOYEES E, DEPARTMENTS D
		WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID GROUP BY D.DEPARTMENT_ID, DEPARTMENT_NAME) MD
	WHERE E.DEPARTMENT_ID = MD.DEPARTMENT_ID AND MD.SALARY = E.SALARY;

--5. 직원의 이름, 부서id, 급여를 조회하시오. 그리고 직원이 속한 해당 부서의 최소급여를 마지막에 포함시켜 출력 하시오.
	SELECT FIRST_NAME 이름, DEPARTMENT_NAME 부서명, E.SALARY 급여
		FROM EMPLOYEES E, (SELECT D.DEPARTMENT_ID, DEPARTMENT_NAME, MAX(SALARY) "SALARY" FROM EMPLOYEES E, DEPARTMENTS D
		WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID GROUP BY D.DEPARTMENT_ID, DEPARTMENT_NAME) MD
	WHERE E.DEPARTMENT_ID = MD.DEPARTMENT_ID AND MD.SALARY = E.SALARY;

	
--6. 월별 입사자 수를 조회하되, 입사자 수가 5명 이상인 월만 출력하시오. (월별 => group by)
	select substr(hire_date,4,2), count(employee_id) 입사자수 from employees group by substr(hire_date,4,2) having count(employee_id)>=5;
	select to_char(hire_date,'MM'), count(employee_id) 입사자수 from employees group by to_char(hire_date,'MM') having count(employee_id)>=5;
	
	
--7. 년도별 입사자 수를 조회하시오. (단, 입사자수가 많은 년도부터 출력되도록 합니다.)
	select to_char(hire_date,'YY')||'년' as 입사년도, count(to_char(hire_date,'YY'))||'명' as 입사자 from employees group by to_char(hire_date,'YY') order by 2 desc

	
--8. 'Southlake'에서 근무하는 직원의 이름, 급여, 직책(job_title)을 조회하시오.
	select first_name, salary, job_title from employees e, jobs j, departments d, locations l 
	where e.job_id = j.job_id and d.department_id = e.department_id and l.location_id = d.location_id and city = 'Southlake';
	
--9. 국가별 근무 인원수를 조회하시오. 단, 인원수가 3명 이상인 국가정보만 출력되어야함.
	select country_name,count(country_name) from employees e, locations l, departments d, countries c
	where e.department_id=d.department_id and l.location_id=d.location_id and l.country_id = c.country_id group by country_name having count(country_name)>=3
	
--10. 직원의 이름, 급여, 직원의 관리자 이름을 조회하시오. 단, 관리자가 없는 직원은    '<관리자 없음>'이 출력되도록 해야 한다. 관리자=사수=상사
	select e.first_name, e.salary, nvl(d.first_name,'<관리자없음>') 
	from employees e, employees d 
	where d.manager_id = e.employee_id(+)

--11. 직원의 이름, 부서명, 근무년수를 조회하되, 20년 이상 장기 근속자만 출력되록한다.
	select first_name 이름, department_name 부서명, trunc((sysdate-hire_date)/365,0) 근무년수 
	from employees e, departments d 
	where trunc((sysdate-hire_date)/365,0) >=20

--12. 각 부서 이름별로 최대급여와 최소급여를 조회하시오. 단, 최대/최소급여가 동일한    부서는 출력결과에서 제외시킨다.
	select department_id "각 부서", max(salary) 최대급여, min(salary) 최소급여 from employees group by department_id having max(salary)!=min(salary)

--13. 자신이 속한 부서의 평균급여보다 많은 급여를 받는 직원정보만 조회하시오. (단, 출력결과에 자신이 속한 부서의 평균 급여정보도 출력되어야한다.) 
	select first_name 이름, salary 급여, avgsal "부서별 평균급여"
	from employees e, (select department_id, trunc(avg(salary),0) avgsal from employees group by department_id) d
	where e.department_id = d.department_id and e.salary> avgsal
	
	
--16. 자신의 관리자보다 많은 급여를 받는 직원의 이름과 급여를 조회하시오.
	select e.first_name, e.salary from employees e, employees m where e.employee_id = m.manager_id and e.salary > m.salary
	
--17. 입사년도가 가장 빠른 상위 5명 직원의 직원의 이름 , 입사년도를 입사년도를 조회하시오. //서브쿼리
	select first_name, hire_date from (select first_name, hire_date from employees order by hire_date desc) where rownum <=5

--18. 커미션을 커미션을 가장 많이 받는 4-6번째 직원의 직원의 이름 , 커미션 정보를 조회하시오. //서브쿼리 //commission_pct의 null을 제거해준다. // rownum은 기준보다 작다는O, 기준보다크다는X
	select first_name, commission_pct from (select first_name, commission_pct from employees order by commission_pct desc) where rownum<=6 and commission_pct is not null

--19. 가장 많은 사원이 사원이 속한 직종 3개를 조회하시오. //서브쿼리
	select job_title, "mem2"
	from (select job_title, count(job_title) as "mem2" from jobs j, employees e where j.job_id = e.job_id group by job_title order by count(job_title) desc)
	where rownum <=3
	
--20. jdbc 프로그램 (키보드는 페이지값을 입력받는다)
-- 키보드  1 입력 : 
-- employees 테이블 입사일이 가장 빠른 1-5 출력
-- 키보드  2 입력 :
-- employees 테이블 입사일이 가장 빠른 6-10 출력
-- sql/파라미터전달