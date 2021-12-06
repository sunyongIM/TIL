create table test2tbl(
	id varchar(10) primary key,
	password varchar(8) not null,
	userName varchar(20) not null
);

insert into test2tbl values("admin","1234","kim");
insert into test2tbl values("user","2354","lee");
insert into test2tbl values("tester","5214","park");

drop table test2tbl;

select * from test2tbl;