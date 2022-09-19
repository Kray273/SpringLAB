drop table users purge;

CREATE table users(
	id				varchar2(20)	primary key,
	password		varchar2(20),
	name			varchar2(20),
	role			varchar2(5)
);

insert into users values('admin','admin','관리자','Admin');
insert into users values('henkoc','1234','핸콕','User');
insert into users values('1','1','eui','User');

select * from users;