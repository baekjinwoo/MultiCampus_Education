select it.id as id, it.name as name, it.price  as price 
from t_user us ,t_item it,t_useritem ui 
where us.id = ui.userid 
and   ui.itemid = it.id 
and   us.id = 'id04';

insert into t_useritem values (?,?);
insert into t_user values (?,?,?);
select * from t_user where id = ?;
select * from t_user;
-- -------------------------------------------------------
create table t_item(
id number,
name varchar2(10),
price number);

create table t_user(
id varchar2(10),
pwd varchar2(10),
name varchar2(10));

drop table T_ITEM;
drop table T_user; --테이블제거
drop table t_useritem;
delete from T_USER; --내용제거


insert into t_user values('id01','pwd01','강호동');
insert into t_user values('id02','pwd02','이만기');
insert into t_user values('id03','pwd03','이순신');

create table t_useritem(
userid varchar2(10),
itemid varchar2(10));

select * from tab;
select * from t_user;
select * from t_item;
select * from t_useritem;

delete from t_user where id='id04';
delete from t_useritem where userid='id04';



