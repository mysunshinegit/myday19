use mydb3;
drop table content;
create table content(
 id int primary key auto_increment,
 age int,
 description varchar(50) not null,
 vid int,
 constraint vid_FK foreign key(vid) references vote(id) 
);
insert into content(age,description,vid) values(55,'κ�����¼�',1);
insert into content(age,description,vid) values(50,'������¼�',2);
insert into content(age,description,vid) values(52,'������¼�',3);
insert into content(age,description,vid) values(48,'������',4);
select * from content;





