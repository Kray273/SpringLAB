create table users(
 	id			varchar2(20) primary key, 
 	password	varchar2(20),
 	name		varchar2(20),
 	role 		varchar2(50)
);

insert into users values('admin','admin','관리자','Admin')
insert into users values('henkoc','1234','핸콕','User')

select * from users order by id;
