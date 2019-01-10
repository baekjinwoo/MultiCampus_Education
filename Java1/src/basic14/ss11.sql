select *from tab;
drop table TELTABLE5;

create table TELTABLE5(
id2 number(5),
name2 varchar2(20),
tel2 varchar2(20),
d2 date
);


insert into TELTABLE5
values (1,'hong','010-7777-8888','20160210');

insert into TELTABLE5
values(5,'hong','010-3333-5555','20160207');

insert into TELTABLE5
values(10,'momo','010-1878-4184','20160202');


select *from TELTABLE5;

select id2,name2 from TELTABLE5;
select *from TELTABLE5;

select * from teltable5 
where name2='hong';

select * from teltable5;


update teltable5
set name2='kim'
where name2='hong'; 

select * from teltable5;

---------------------------------------------------------------------------------------------------


create table sawon1(
id4 number(10),
name4 varchar2(30),
sal4 number(20),
d4 date
);

insert into sawon1
values(1,'bae','10000','20160220');

insert into sawon1
values(2,'cae','20000','20160220');

insert into sawon1
values(3,'hae','22000','20160220');

insert into sawon1
values(4,'qae','23000','20160220');

insert into sawon1
values(5,'eae','24000','20160220');

insert into sawon1
values(6,'dae','30000','20160220');
select name4 from sawon1;

select *from sawon1;

update sawon1
set sal4=sal4*1.1;

drop table sawon;

---------------------------------------------------------------------------------------------------

select *from employees;
select *from departments; 
select *from locations;




