use mydb3;
drop table vote;
create table vote(
 id int primary key auto_increment,
 content varchar(30) not null,
 ticket int default 1
);
insert into vote(content) values('�ܲ�');
insert into vote(content) values('����');
insert into vote(content) values('��Ȩ');
insert into vote(content) values('�����');
select * from vote;




