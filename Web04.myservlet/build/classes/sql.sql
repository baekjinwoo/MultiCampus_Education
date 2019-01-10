select * from member;

--제약조건 찾는 코드
select constraint_name, constraint_type, search_condition 
from user_constraints
where table_name like 'ME%';