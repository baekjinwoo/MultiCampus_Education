select *from tab;

select distinct job_id from employees ;

purge recyclebin; 
--휴지통 비우기

select salary as 월급, salary*12 as 연봉  from employees;

select '사번'||employee_id||'이름'||first_name||'의 월급은'|| salary||'이다' as "사원정보" from employees; 
--한줄로 표현식

select employee_id, first_name from employees order by employee_id asc;

select employee_id, first_name from employees order by employee_id desc;

 
select employee_id, first_name from employees order by first_name desc;




desc EMPLOYEES;
--sql plus에서만 사용가능 . 컬럼과 type까지도  확인

select employee_id as 사번, first_name||'   '||last_name as 성명,hire_date as 입사일, salary*12 as 연봉, commission_pct as 커미션 from employees order by salary*12 desc; 
-- 정렬하고, 문자열붙이고, as로 목차바꾸고(as는 생략가능), order by 급여 = order by 4 = order by salary = order by salary*12

select * from nls_session_parameters where parameter = 'NLS_DATE_FORMAT';
-- date의 출력형태  RR/MM/DD 
-- RR: 년도 2자리
-- 다른 함수를 사용햇을때 형태가 다르다면 다른 포멧을 써야하고, 뒤에 'NLS_DATE_FORMAT'은 대문자 필수.

select sysdate from dual;
-- 오늘의 날짜를 sql plus에서만


select salary as 월급, nvl(commission_pct,0) as 커미션, (salary+nvl(commission_pct,0)*salary) from employees; 
-- 커미션이 null이면 연산결과도 null이 된다


select salary from EMPLOYEES where salary >= 20000;
select hire_date from employees where hire_date >='05/01/01'; 
select hire_date from employees where hire_date >='05/01/01' and '07/12/31'>= hire_date; 
select employee_id from employees where employee_id =200; 
select last_name from employees where last_name='King'; 

select first_name as 이름, salary as 월급 from employees where ((salary+salary*nvl(commission_pct,0))>= 10000 ) order by salary desc, first_name asc;
--2005년 이후(포함), 작은따옴표, 연봉을 오름차순으로 정렬, 만약에 연봉이 같다면 이름을 내림차순 (a~z)

select first_name,department_id from employees where department_id in (10,50,90);

select first_name from employees where first_name like '%an%'; 

--where절
select hire_date from employees where hire_date like '07%';
-- hire date >= '07/01/01' and '07/12/31'; 07년도 입사자

select hire_date from employees where hire_date like '_%07%_';
select hire_date from employees where hire_date like '___07%';
-- 7월 입사자 ___07월 (3칸띄우고 07월하는 이유는 YY/MM/DD이기떄문에)


select first_name, commission_pct from employees where commission_pct is not null;

select commission_pct from employees order by 1 desc nulls last;



---------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------<2018/03/06 과제>----------------------------------------------------------

--1. 급여가 15000 이상인 직원들의 이름, 급여, 부서id를 조회하시오.
select first_name||'  '||last_name as 이름, salary as 급여, department_id as 부서id from employees;

--2. 직원 중에서 연봉이 170000 이상인 직원들의 이름, 연봉을 조회하시오.   연봉은 급여(salary)에 12를 곱한 값입니다.
select first_name||'  '||last_name as 이름, salary*12 as 연봉 from employees where salary*12 >=170000;

--3. 직원 중에서 부서id가 없는 직원의 이름과 급여를 조회하시오.?????????????????????????????????????????????????????????????????????????????????????????????????????
select first_name||'  '||last_name as 이름, salary as 급여 from employees where department_id =null;

--4. 2004년 이전에 입사한 직원의 이름, 급여, 입사일을 조회하시오.
select first_name||'  '||last_name as 이름, salary as 급여, hire_date as 입사일 from employees where hire_date <= '04/01/01';


-- 논리연산자 --
--1. 80, 50 번 부서에 속해있으면서 급여가 13000 이상인 직원의 이름, 급여, 부서id를 조회하시오.
select first_name||'  '||last_name as 이름, salary as 급여, department_id as 부서id from employees where department_id in(50,80) and salary >=13000;

--2. 2005년 이후에 입사한 직원들 중에서 급여가 1300 이상 20000 이하인 직원들의 이름, 급여, 부서id, 입사일을 조회하시오.
select first_name||'  '||last_name as 이름, salary as 급여, hire_date as 입사일 from employees where hire_date >='05/01/01' and salary between 1300 and 20000;


-- SQL 비교연산자 --
--1. 80, 50 번 부서에 속해있으면서 급여가 13000 이상인 직원의 이름, 급여, 부서id를 조회하시오. ???????????????????????????????????????????????????????????????????????????
--select first_name||'  '||last_name as 이름, salary as 급여, department_id as 부서id from employees where department_id in(50,80) and salary >=13000;
select first_name||'  '||last_name as 이름, salary as 급여, department_id as 부서id from employees where (department_id=50 or department_id=80) and salary>=13000;

--2. 95년 이후에 입사한 직원들 중에서 급여가 1300 이상 20000 이하인 직원들의 이름, 급여, 부서id, 입사일을 조회하시오.
--select first_name||'  '||last_name as 이름, salary as 급여, department_id as 부서id, hire_date as 입사일 from employees where hire_date >='95/01/01' and salary between 1300 and 20000;
select first_name||'  '||last_name as 이름, salary as 급여, department_id as 부서id, hire_date as 입사일 from employees where hire_date >='95/01/01' and (salary >= 1300 and  salary <= 20000);

--3. 2005년도 입사한 직원의 정보만 출력하시오.
select * from employees where hire_date like '05%'

--4. 직종이 clerk 군인 직원의 이름, 급여, 직종코드를 조회하시오.(clerk 직종은 job_id에 CLERK을 포함하거나 CLERK으로 끝난다.)
select first_name||'  '||last_name as 이름, salary as 급여, job_id as 직종코드 from employees where job_id like '%CLERK%';

--5. 12월에 입사한 직원의 이름, 급여, 입사일을 조회하시오.
--select first_name||'  '||last_name as 이름, salary as 급여, hire_date as 입사일 from employees where hire_date like '_%12%_';
select first_name||'  '||last_name as 이름, salary as 급여, hire_date as 입사일 from employees where hire_date like '___12%';

--6. 이름에 le 가 들어간 직원의 이름, 급여, 입사일을 조회하시오.
select first_name||'  '||last_name as 이름, salary as 급여, hire_date as 입사일 from employees where (last_name like '%le%') or (first_name like '%le%');

--7. 이름이 m으로 끝나는 직원의 이름, 급여, 입사일을 조회하시오.
select first_name||'  '||last_name as 이름, salary as 급여, hire_date as 입사일 from employees where (last_name like '%m') or (first_name like '%m');

--8. 이름의 세번째 글자가 d인 이름, 급여, 입사일을 조회하시오.
select first_name||'  '||last_name as 이름, salary as 급여, hire_date as 입사일 from employees where (last_name like '__d%') or (first_name like '__d%');

--9. 커미션을 받는 직원의 이름, 커미션, 급여를 조회하시오.
select first_name||'  '||last_name as 이름, commission_pct as 커미션, salary as 급여 from employees where commission_pct is not null; 

--10. 커미션을 받지 않는 직원의 이름, 커미션, 급여를 조회하시오.
--null을 무시하고싶으면 nvl(commission_pct,0)을 쓰면된다
select first_name||'  '||last_name as 이름, commission_pct as 커미션, salary as 급여 from employees where commission_pct is null; 

--11. 30, 50, 80 번 부서에 속해있으면서, 급여를 5000 이상 17000 이하를 받는 직원을 조회하시오. 
--단, 커미션을 받지 않는 직원들은 검색 대상에서 제외시키며, 먼저 입사한 직원이 먼저 출력되어야 하며 입사일이 같은 경우 급여가 많은 직원이 먼저 출력되록 하시오.???????????????????????????????????????????????????
select * from employees where department_id in(30,50,80) and (salary between 5000 and 17000) and (commission_pct is not null) order by salary desc, hire_date asc ;


---------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------<2018/03/07 수업>----------------------------------------------------------

select first_name from employees;
select job_id from employees where job_id = upper('it_PROG');
select first_name, length(FIRST_NAME) from employees;
select sysdate from employees;
select sysdate from dual;
select '이자바', length('dfgg'),lengthb('dfgg') from dual;

select hire_date from employees where hire_date like'___07%';
select hire_date from employees where substr(hire_date,4,2)='07';
select hire_date from employees where instr(hire_date,'07')=4;
-- =4라는건 07이 4번째 위치해있지않니?
-- 0보다 크다는건 '07'이 hire_date에 포함되어잇지않니?
-- =0이라는건 '07'이 hire_date에 포함되어있지 않아

select salary, lpad(salary,20,'#'), rpad(salary,20,'#') from employees;
select salary, ltrim(salary,20,'#'), rtrim(salary,20,'#') from employees;

select '이자바', from employees;

select employee_id as 사번, mod(employee_id,2) as "구분 여부" from employees;

select salary from employees;
select salary as 월급, salary/20 as 일급 from employees;

select salary as 월급, trunc(salary/20,0) as 일급 from employees;
select salary as 월급, round(salary/20,0) as 일급 from employees;

select 1234.56789, round(1234.56789,0), trunc(1234.56789,0) from dual;
select 1234.56789, round(1234.56789), trunc(1234.56789) from dual;
select 1234.56789, round(1234.56789,2), trunc(1234.56789,2) from dual;



select trunc(sysdate-HIRE_DATE,0) as "입사한지 몇일" from employees;
--오늘날자  - 입사일 : 입사한지 몇일이 지낫는지
select trunc((sysdate-HIRE_DATE)/7,0) as "입사한지 몇주" from employees;
--입사한지 몇주됫는지: 고정숫자로 나누기
select trunc((sysdate-HIRE_DATE)/(30),0) as "입사한지 몇달" from employees;
select round(months_between(hire_date,sysdate),0) as "입사한지 몇달" from employees;
--입사한지 몇개월됫는지: 윤년인지 평년인지 다 조건걸어야해서 함수를 써야한다
--months_between(~,~)함수1
select trunc((sysdate-HIRE_DATE)/(365),0) as "입사한지 몇년" from employees;
--입사한지 몇년됫는지: 고정숫자로 나누기

select hire_date, hire_date+(30*5) from employees;
-- 개월을 계산할때에는 오차가 있기때문에 함수를 사용해라
select hire_date, add_months(hire_date,5) from employees;
-- 5개월을 더해라
-- add_months(~,~)함수2

select sysdate, next_day(sysdate,'수요일') from dual;
-- '수요일'을 영어로바꾸면 안된다

--< dictionay: 언어,날짜 포맷 >
select *from dba_;
select *from all_;
select *from v$;
select *from user_;
select *from nls_session_parameters;
select *from dual;
select *from tab;

select*from nls_session_parameters where parameter like 'NLS_%';
select trunc(sysdate- to_date('17/12/31'),0) as 날짜 from dual;
-- ' '안에들어있으면 문자이기때문에 날짜로 인식시키고 싶어서 to_date로 형변환
select trunc(sysdate- to_date('2017/12/31', 'YYYY/MM/DD'),0) as 날짜 from dual;
select trunc(sysdate- to_date('2017/31/12', 'YYYY/DD/MM'),0) as 날짜 from dual;
-- 기본적인 날짜포멧형식에 어긋나기때문에 실행이 불가능하다. YY/MM/DD => YYYY/MM/DD로  뒤에 날짜포멧을 다시 작성해야한다. to_date형변환을 통해서

select to_char(sysdate, 'YY/MM/DD HH:MI:SS        MON DAY')from dual;
-- sysdate를 YY/MM/DD => YY/MM/DD HH:MI:SS로 바꿀때는 to_char 문자열형변환을 한다
select to_char(sysdate, 'YY/MM/DD HH24:MI:SS      MON DAY')from dual;
-- 시간이 오전/오후로 나뉜다
--select to_char(hire_date, 'YY/MM/DD') from employees where member_id=107, hire_date like'___07%'; x
select hire_date, to_char(hire_date, 'YY/MM/DD') from employees where substr(hire_date,4,2)='07';
--select to_char(hire_date, 'YY/MM/DD') from employees where instr(hire_date,'07')='4'; x
select hire_date, to_char(hire_date, 'YY/MM/DD') from employees where to_char(hire_date,'MM')='07';
--모든사원107의 07월 입사자만 뽑아라


select salary, to_char(salary, '099,999.99') from employees;
-- salary는 숫자인데 문자로 바꿔주기위해서 to_char를 쓴다
-- 9는 한자리를 뜻하고, .99는 소수아래 2자리를 의미한다
select 200000-100000,to_char(200000-100000, '999,999') from dual;
select to_char(to_number('200,000','999,999')-to_number('100,000','999,999'), '999,999') from dual;
-- ,가 있으면 문자이다. 200,000-100,000하기위해서는 문자를 숫자로 우선 바꿔줘야한다.


select employee_id as "내 사번", nvl(to_char(manager_id),'사장님') as"사수 사원" from employees where manager_id is null; 
-- 사번이 없는 100번은 아마도 사장이라는 것을 알 수 있다.
-- 사번이 없는 사원만 출력하라는 조건을 실행한 문장
-- manager_id는 숫자타입인데, null자리에 문자열=사장님을 넣기위해서 to_char로 변환해주고, '사장님'을 작성한다

select first_name as "사원 이름", nvl(to_char(department_id),'부서 배치 이전') as "부서 코드" from employees where department_id is null;
-- 날짜포맷 구분자로는: 한글X

select to_char(sysdate,'yyyy"년도"mm"월"dd"일"') from dual;
select to_char(sysdate,'fmyyyy"년도"mm"월"dd"일"') from dual;
--포멧팅을 만들었지만 03월로 보지않고 3월로 보기위해 mm이 아닌 m이여야한다. 따라서 fm을 붙이면 불필요한 것을 지우고 실행시켜준다는 것을 사용한다 
-- sysdate => 문자로 바꾸는게 to_char
-- 형변환 http://nown2210.tistory.com/92


---------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------<2018/03/07 과제>----------------------------------------------------------

--employees테이블
--1. 이름이 'adam' 인 직원의 급여와 입사일을 조회하시오.
	select salary as 급여, (to_char(hire_date,'YYYY/MM/DD'))as 입사일 from employees where first_name like '%Adam%';
	
--2. 나라 명이 'united states of america' 인 나라의 국가 코드를 조회하시오.
	select COUNTRY_ID as 국가코드 from COUNTRIES where lower(country_name) ='united states of america';
	
--3. 'Adam의 입사일은 95/11/2 이고, 급여는 7,000 원입니다.' 이런 식으로 직원정보를 조회하시오.
	select first_name||'의 입사일은 '||hire_date||'이고, 급여는 '||to_char(salary,'9,999')||'원입니다.' from employees where first_name like '%Adam%';
	
-- 4. 이름이 5글자 이하인 직원들의 이름, 급여, 입사일을 조회하시오. (이름길이<6)이라면
	select first_name as 이름, salary as 급여, hire_date as 입사일 from employees where length(first_name)<6;

-- 5. 06년도에 입사한 직원의 이름, 입사일을 조회하시오. (06~~~~~~~인 것, __를 붙일 필요없는건 년도는 제일 처음이니까)
	select first_name as 이름, (to_char(hire_date,'YY/MM/DD')) as 입사일 from employees where hire_date like ('06%');
	select first_name as 이름, (to_char(hire_date,'YY/MM/DD')) as 입사일 from employees where substr(hire_date,1,2)='06';
	select first_name as 이름, (to_char(hire_date,'YY/MM/DD')) as 입사일 from employees where instr(hire_date,'06')=1;
	select first_name as 이름, (to_char(hire_date,'YY/MM/DD')) as 입사일 from employees where to_char(hire_date,'YY')=06;
	
-- 6. 10년 이상 장기 근속한 직원들의 이름, 입사일, 급여, 근무년차를 조회하시오.
	select first_name as 이름, (to_char(hire_date,'YY/MM/DD')) as 입사일, salary as 급여, trunc((sysdate-hire_date)/365,0) as 근속년수 from employees;

-- 7. employees 테이블에서 직종이(job_id) 'st_clerk'인 사원 중에서 급여가 1500 이상인 사원의first_name, job_id, salary  조회
	select first_name as 이름, job_id as "직종 코드", to_char(salary,'9,999') as 월급 from employees where job_id like('%ST_CLERK%') and salary>=1500;
	select job_id from employees;
	
-- 8. 급여가 20000 이상인 직종(job_id)의job_id, salary 조회 (단, salary는 10자리로 출력하되 공백은 '0'으로 표시)
	select job_id as "직종 코드", to_char(rpad(salary,10,0),'9,999,999,999') as 월급 from employees where salary>=20000;
	
	
	
	
