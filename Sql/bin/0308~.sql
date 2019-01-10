---------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------<2018/03/08 진도>----------------------------------------------------------

--select sum(first_name) from employees; 총합은 숫자만 가능하니까, first_name은 x
--select salary, sum(salary) from employees; group함수를 이용할떄, select에 다른컬럼을 끼우지말것. sum(salary)가 1개라서 salary의 107개를 같이 출력할 수 없음
select sum(salary) as 총합 from employees;
select round(avg(salary),0) as "평균" from employees;
 
--그냥 salary 107개를 조회할때랑 다르게, sum과 round의 컬럼값이 동일하게 1개이기떄문에 조회가 가능하다
select max(salary) as 최대값, min(salary) as 최소값 from employees;
select sum(salary) as 총합, round(avg(salary),0) as "평균" from employees;

-- employees 테이블에서 사원이름이 알파벳 순서로 가장 빠르게 등장하는 이름이 무엇인지 조회하시오.
-- A < a 라서, A먼저 나온다. 
-- Adam < Winston이라서, Adam먼저 나온다
select min(first_name), max(first_name) from employees;

-- 가장 빠른 입사일은(작은 값); 최근시간에서 먼
select trunc(min(hire_date)) from employees;

-- 가장 늦은 입사일은(큰 값); 최근시간에서 가까운
select trunc(max(hire_date)) from employees;

-- null값이 없는 모든 컬럼명을 넣어서, 전체 107을 조회한다. 
-- count(*)= null값을 포함한 전체를 조회
select count(employee_id) from employees;
select count(last_name) from employees;
select count(first_name) from employees;
select count(*) from employees;

--count는 자동으로 null을 제외하기때문에 where로 is not null을 작성하지 않아도 된다
select count(commission_pct) from employees ;

--Commission_pct가 null인 값만 뽑아내기위해서는 전체-35; 또는 null을 읽을 수 없기때문에 0으로 변환시켜서 조회한다
select count(nvl(commission_pct,0)) from employees where commission_pct is null;
select count(employee_id)-count(commission_pct) from employees;

--직업의 종류(개수)를 중복제거해서 조회하기 위해서 distinct와 count를 쓴다
select count(DISTINCT(job_id)) as "직업의 종류" from employees where job_id is not null;
select count(*) from jobs; --답은 같으나 문제의 의도와는 맞지않는 코드






-- when과 decode
-- 50번부서 월급20%올리고, 80번 부서 월급 15%증액, 110번 부서 월급 10% 증액, 나머지 부서 월급이고, where이나 order by는 x
select department_id as 부서번호, to_char(salary,'99,999') as 월급, decode(department_id,50,salary+(salary*1.2),80,(salary*1.15),110,(salary*1.1),salary) as "총 급여" from employees;
select department_id as 부서번호, to_char(salary,'99,999') as 월급, to_char(decode(department_id,50,salary+(salary*0.2),80,salary+(salary*0.15),110,salary+(salary*0.1),salary),'99,999') as "총 급여" from employees where department_id is not null;

--50, 60, 70 라도 1.2배일때는, >=50를 할 수 있을까? 생각하겟지만  Decode는 <, > 대소비교자 사용할 수 없다. =만 쓸 수 있다?????????????????
select department_id as 부서번호, to_char(salary,'99,999') as 월급, 
case
when department_id>=110 then (to_char((salary*1.1),'99,999'))
when department_id>=80 then (to_char((salary*1.15),'99,999')) 
when department_id>=50 then (to_char((salary*1.2),'99,999')) 
end as "총 급여" from employees where department_id is not null;


select job_id as 직종, salary as 급여, 
case 
when job_id like '%CLERK' then salary + 50000
when job_id like '%MANAGER' then salary + 30000
when job_id like '%REP' then salary + 10000
when job_id like '%PROG' then salary + 70000
end as 총급여
from employees;





-- 9장 group화; group by + 컬럼이란, 중복을 제거하고, 그룹별로 나눈다는 것을 의미한다. 구분짓는다. 분류한다 ( group함수 sum, avg 등의 사용에서는 왠만하면 , 한 개만 조회할 수 있도록 선언할 수 있는데(왜냐하면 제각각 개수가 다르기때문에), groub by+컬럼에서는 그 컬럼과 같이 2개의 절을 출력할 수 있다.)
-- 작성순서 : select from where (group by) order by
-- 실행순서 : from 테이블조회 -> where 개수 줄어듬 -> group by 그룹화 -> select 컬럼명,함수 -> order by
select count(employee_id) from employees; -- 총사원수
select count(*) as 사원수 from employees where department_id =80; --80번 부서의 사원 수 
select department_id as 부서코드, count(employee_id) as 사원수 from employees group by department_id; --group by + 컬럼명 

--50번 부서만 조회
select department_id, salary from employees where department_id = 50; 
-- 월별 정렬  : group by로 묶고 앞에 같은 걸 한번 조회하면서 +1로 하나더 가능(salary)하고, asc로 위에서부터 내림차순
select substr(hire_date,4,2)||'월' as 입사월, to_char(sum(salary),'999,999')||'원' as 급여총합 from employees group by substr(hire_date,4,2) order by substr(hire_date,4,2);
-- 급여별 정렬
select to_char(hire_date,'MM')||'월' as 입사월, to_char(sum(salary),'999,999')||'원' as 급여총합 from employees group by to_char(hire_date,'MM' ) order by sum(salary) desc;






--<작성순서>--				--<실행순서>--
-- select				-- from
-- from					-- where
-- where				-- group by
-- group by				-- having
-- having				-- select
-- order by				-- order by

-- where절: group함수를 제외한 조건문 // 급여가 10000 이상인 경우만,  출력형태: 부서 총합
-- where조건절에 맞는 정보를 우선적으로 들고와서 group by로 그룹화한다 (where절은 그룹함수 sum, avg, count, max, min을 쓸 수 없다)
select department_id as 부서, to_char(sum(salary),'999,999')||'원' as 총합 from employees where salary>=10000 group by department_id;

-- having절: group함수 조건문   // 부서 급여총합이 50000이상일때,   출력형태: 부서 총합
-- group by화 한 상태에서 having조건절에 맞는 정보를 들고옵니다. (이때 having 조건절에 이용할 컬럼은 select뒤에 반드시 명시 되어져야 합니다)
select department_id as 부서, to_char(sum(salary),'999,999')||'원' as 급여총합 from employees group by department_id having sum(salary)>=50000;

-- 직종별 급여 평균을 조회, 해당 직종 종사자가 5명 미만인 경우는 제외하고 조회한다
select job_id as 직종, avg(salary) as 급여평균, count(job_id) as 종사자  from employees group by job_id having count(job_id)>=5; 

-- 부서별 			최소급여와 최대급여를 구하되 최소급여와 최대급여가 같은 부서는 제외하고 조회  
-- group by     min    max            		having
select department_id as 부서, to_char(min(salary),'999,999')||'원' as 최소급여, to_char(max(salary),'999,999')||'원' as 최대급여 from employees group by department_id having min(salary) != max(salary);
select department_id as 부서, to_char(min(salary),'999,999')||'원' as 최소급여, to_char(max(salary),'999,999')||'원' as 최대급여 from employees group by department_id having min(salary) <> max(salary);

--추가 조건으로 commission_pct를 받는 사람만
select department_id as 부서, to_char(min(salary),'999,999')||'원' as 최소급여, to_char(max(salary),'999,999')||'원' as 최대급여 from employees where commission_pct is not null group by department_id having min(salary) <> max(salary);









-- 10장.테이블 JOIN  ==> rdb 정규화 : 레코드 컬럼을 합친다.
-- join: 2개 이상의 테이블을 합쳐서 조회하도록 하는 키워드
select department_id from employees;
select first_name as 사원명, employees.department_id as e부서코드, department_id.department_id as d부서코드, department_name as 부서명 from employees, departments where employees.department_id = department_id.department_id;
select first_name as 사원명, department_name as 부서명 from employees e, departments  d where d.department_id = e.department_id;
--select first_name as 사원명, department_name as 부서명 from employees e, departments  d where d.department_id = e.department_id and nvl(e.department_id,0)is not null;


-- 출력: first_name 사원이름(컬럼)과, city 도시(컬럼)두 개를 출력하시오  < employees <--> locations > 
select first_name as 사원명, city as 도시명 
from employees e, locations l, departments d 
where (e.department_id = d.department_id) and (d.location_id = l.location_id);

-- 출력: first_name 사원이름(컬럼)과, region_id 나라(컬럼)두 개를 출력하시오 < employees <--> countries >
select first_name as 사원명, country_name as 나라명 
from employees e, locations l, departments d, countries c
where (e.department_id = d.department_id) and (d.location_id = l.location_id) and (c.country_id = l.country_id);

-- 영국지역만 출력해라. 이름, 국가명 출력
select first_name as 사원명, country_name as 나라명 
from employees e, locations l, departments d, countries c
where (e.department_id = d.department_id) and (d.location_id = l.location_id) and (c.country_id = l.country_id) and lower(country_name)='united kingdom';


---------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------<2018/03/08 과제>----------------------------------------------------------
--1. 사원의 이름과 상사의 사번을 조회하되 아래와 같이 컬럼명을 지정하고 상사가 없는 사원은 상사의 사번에 '사장' 이라고 출력하시오. 출력형태: 사원의 이름   상사의 사번
select first_name as "사원의 이름", nvl(to_char(manager_id),'사장') as "상사의 사번" from employees;

--2. 아래와 같은 조건으로 직급을 조회하시오.입사년도가 2007년~2008년인 사원은 사원 , 입사년도가 2005년~2006년인 사원은 대리,  입사년도가 2003년~2004년인 사원은 과장,  나머지는 임원  
-- to_char로  hire_date를  문자로 받앗으니까 연산자에서 2007숫자를 ''로 문자화시킨다.
-- 그리고 then뒤에는 그냥 ''값을 넣어준다

--between a and b는 숫자의 범위일 뿐, 문자의 범위를 할 수는 없는 것 같다
select first_name as 이름, 
case 
when to_char(hire_date,'YYYY') between '2007' and '2008' then '사원'
when to_char(hire_date,'YYYY') between '2005' and '2006' then '대리'
when to_char(hire_date,'YYYY') between '2003' and '2004' then '과장'
else '임원' end as "직책"
from employees;

select first_name as 이름, case 
when to_char(hire_date, 'YY') = '07' or to_char(hire_date, 'YY') = '08' then '사원'
when to_char(hire_date, 'YY') = '05' or to_char(hire_date, 'YY') = '06' then '대리'
when to_char(hire_date, 'YY') = '03' or to_char(hire_date, 'YY') = '04' then '과장'
else '임원' 
end as "직책"
from employees;


select first_name as 이름, 
case 
when to_char(hire_date,'YYYY') like '%2007%' or to_char(hire_date,'YYYY') like '%2008%' then '사원'
when to_char(hire_date,'YYYY') like '%2005%' or to_char(hire_date,'YYYY') like '%2006%' then '대리'
when to_char(hire_date,'YYYY') like '%2003%' or to_char(hire_date,'YYYY') like '%2004%' then '과장'
else '임원' 
end as 직책
from employees;


select first_name as 이름, 
case 
when substr(hire_date,1,2) = '07' or substr(hire_date,1,2) = '08' then '사원' 
when substr(hire_date,1,2) = '05' or substr(hire_date,1,2) = '06' then '대리'
when substr(hire_date,1,2) = '03' or substr(hire_date,1,2) = '04' then '과장'
else '임원' end as 직책
from employees;


--3. DEPARTMENTS 테이블에서 DEPARTMENT_ID, MANAGER_ID를 조회하되 매니저 없는 부서는 MANAGER_ID를 'NONE'로 표현하여 조회
select department_id as 부서,
case
when manager_id is null then nvl(to_char(manager_id),'NONE')
when manager_id is not null then (to_char(manager_id)) 
end as "상사의 사번" from departments;

--4. EMPLOYEES 테이블에서 전체 사원의 FIRST_NAME, JOB_ID, 총근무주수를 조회.
--(단, 근무주수 많은 직원부터 조회하고 같은 근무주수가 있으면 FIRST_NAME 오름차순으로 조회)  ====> order by를 근무주수로 작성하고, first_name으로 작성하면 된다
select first_name as 이름,  job_id as 사번, trunc((sysdate-hire_date)/7,0)||'일' as 총근무주수 from employees where sysdate-hire_date>0 order by hire_date, first_name;

--5.employees 테이블에서 사번이 홀수인 사원의 사번, 급여, 입사일자 조회 (급여 : $ 세자리마다 콤마, 입사일자 : '04-7-16 : 5:34:35')
select manager_id as "사원의 사번", to_char(salary,'999,999') as 급여, to_char(hire_date,'YY-MM-DD : HH:MI:SS') as 입사일자 from employees;

--6. departments 테이블에서 location_id는 해당 부서의 도시코드이다. 도시코드에 따른 도시를 출력하고자 한다. 도시 출력의 조건은 다음과 같다.
select distinct(l.location_id) as 도시코드, l.city as 도시명 
from locations l, departments d
where l.location_id = d.location_id;

location_id : 
1700 : 서울
2400 : 부산
2500 : 광주
2700 : 제주
나머지 : 대전

출력은 다음과 같다
도시코드     도시명
1700          서울
......

--7. 각 부서별 최대급여와 최소급여를 조회하시오. 단, 최대급여와 최소급여가 같은 부서는 직원이 한명일 가능성이 높기때문에 조회결과에서 제외시킨다.
select department_id as 부서코드, max(salary) as 최대급여, min(salary) as 최소급여 from EMPLOYEES group by department_id having max(salary)!=min(salary);

--8. 각 부서별 인원수를 조회하되 인원수가 5명 이상인 부서만 출력되도록 하시오.
select department_id as "부서", count(employee_id) as "부서별 인원" from employees group by department_id  having count(employee_id)>=5;

--9. 부서가 50, 80, 110 번인 직원들 중에서 급여를 5000 이상 24000 이하를 받는  직원들을 대상으로 부서별 평균 급여를 조회하시오. \
-- (단, 평균급여가 8000 이상인 부서만 출력되어야 하며, 출력결과를 평균급여가 높은  부서가 먼저 출력되도록 해야 한다.
select department_id as 부서, trunc(avg(salary),0)||'원' as 평균급여 from employees where department_id in(50,80,110) and salary between 5000 and 24000 group by department_id;

--10. 80번 부서에서 가장 최근에 입사한 사원의 입사일과 입사한지 가장 오래된 사원의 입사일을 출력하도록 조회하시오.
select department_id as 부서, max(trunc(sysdate-hire_date,0))||'일' as "오래된 입사일", min(trunc(sysdate-hire_date,0))||'일' as "최근 입사일"  from employees where department_id = 80 group by department_id;

--11. 50번 부서를 제외한 부서에 소속된 사원 중 커미션을 받는 사원의 수를 조회하시오.
select department_id as 부서, count(*) as "사원의 수" from employees where department_id !=50 and (commission_pct is not null) group by department_id;

--12.직원들의 이름과 직급명(job_title)을 조회하시오.(join)
select first_name as 이름, job_title as 직급명 from employees e, jobs j where e.job_id = j.job_id;

--13.부서이름과 부서가 속한 도시명(city)을 조회하시오.(join)
select job_id as 부서이름, city as 도시명 from employees e, departments d, locations l where e.department_id = d.department_id and l.location_id = d.location_id;

--14. 'IT' 관련 직종의 직원들의 이름, 직종명과 근무국가명을 조회하시오.  ('IT'관련직종은 직종코드에 'IT'를 포함한 것으로 간주한다)
select first_name as "직원의 이름", department_name as 직종명, city as 근무국가명 from employees e, departments d, locations l where e.department_id = d.department_id and l.location_id = d.location_id and lower(job_id) like('%it%');

--15. 직책(job_title)이 'manager' 인 사람의 이름, 직책, 부서명을 조회하시오.
select first_name as 이름, job_title as 직책, department_name as 부서명 
from employees e, departments d, jobs j 
where e.department_id = d.department_id and j.job_id = e.job_id and lower(job_title) like '%manager%';

--16. 직원들의 이름, 입사일, 부서명을 조회하시오.
select first_name as 이름, to_char(hire_date,'YY/MM/DD') as 입사일, department_id as 부서명 from employees;



