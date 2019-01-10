-- 1. member ���̺�
-- id : ���ڿ� (20����Ʈ) primary key
-- password : ���ڿ�(10����Ʈ) not null
-- member_name : ���ڿ�(30����Ʈ)
-- email : ���ڿ�(30����Ʈ) '@' ���� 
-- phone : ���ڿ�(20����Ʈ)

CREATE TABLE MEMBER(
	ID VARCHAR2(20) CONSTRAINT MEMBER_ID_PK PRIMARY KEY,
	PW VARCHAR2(10) CONSTRAINT MEMBER_PW_NN NOT NULL,
	MEMBER_NAME VARCHAR2(30),
	EMAIL VARCHAR2(30) CONSTRAINT MEMBER_EMAIL_CK CHECK (EMAIL LIKE '%@%'),
	PHONE VARCHAR2(20)
)

SELECT * FROM MEMBER;

-- 2. board ���̺� (�̹� ���� ==> ����) 
-- writer member  ���̺� id �÷� ���簪 ����
-- 1>
-- drop table board;
-- create table board....

CREATE TABLE BOARD(
	SEQ		NUMBER(5) CONSTRAINT BOARD_SEQ_PK PRIMARY KEY,
	TITLE	VARCHAR2(50)	CONSTRAINT BOARD_TITLE_NN NOT NULL,
	CONTENTS	VARCHAR2(4000),
	WRITER	VARCHAR2(20) CONSTRAINT BOARD_WRITER_FK REFERENCES MEMBER(ID),
	TIME	DATE,
	PW	VARCHAR2(30),
	VIEWCOUNT	NUMBER(5)	CONSTRAINT BOARD_VIEWCOUNT_CK CHECK (VIEWCOUNT >= 0)
)

SELECT * FROM BOARD;

-- 2> alter table board modify
-- (writer member  ���̺� id �÷� Ÿ�� 
-- �������� member  ���̺� id �÷� ���簪 ����)

ALTER TABLE BOARD MODIFY (WRITER VARCHAR2(20) CONSTRAINT BOARD_WRITER_FK REFERENCES MEMBER(ID));

CREATE SEQUENCE BOARD_SEQUENCE
START WITH 1
INCREMENT BY 1




DROP SEQUENCE BOARD_SEQUENCE

DROP TABLE BOARD;
DROP TABLE MEMBER;
