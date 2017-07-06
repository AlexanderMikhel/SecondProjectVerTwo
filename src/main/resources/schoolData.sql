


insert into subject (name) values('Chemical');
insert into subject (name) values('English');

insert into subject (name) values('matan'),('russian');
insert into teacher (first_name,last_name,subject_id) values('vova','Larionov',1),('Petr','Fedorov',2);
insert into teacher (first_name,last_name,subject_id) values('Katia','Larionova',3),('Olga','Kukuruzova',4);

select * from subject
insert into class_unit (teacher_id) values (1); 
insert into class_unit (teacher_id) values (4); 
insert into class_unit (teacher_id) values (3); 
insert into class_unit (teacher_id) values (2); 

insert into student (first_name,last_name) values 
('pasha','ivanov'),('nikolia','ogurcov'),('jenia','rudenko'),('nastia','tea'),('stol','isfaneri'),('miagkiy','divan'),('kolia','petrosian'),
('stas','mikhailov'),('ysnie','dni'),('hmurie','dni'),('vika','sidorenko'),('tania','palochkina'),('svata','abramovich'),('frosia','evdokieva'),('kapitan','vorobey'),('djeck','vorobey'),
('victor','karlov'),('oleg','animeshov'),('naruto','iso'),('enot','hvostov');

select * from class_unit
insert into stud_class(id_class,id_student) values(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,2),(1,3),(1,4),(1,1);
insert into stud_class(id_class,id_student) values(2,13),(2,14),(2,15),(2,16),(2,17),(2,18),(2,19),(2,20);

insert into student (first_name,last_name) values 
('pasha','ivanov'),('nikolia','ogurcov'),('jenia','rudenko'),('nastia','tea'),('stol','isfaneri'),('miagkiy','divan'),('kolia','petrosian'),
('stas','mikhailov'),('ysnie','dni'),('hmurie','dni'),('vika','sidorenko'),('tania','palochkina'),('svata','abramovich'),('frosia','evdokieva'),('kapitan','vorobey'),('djeck','vorobey'),
('victor','karlov'),('oleg','animeshov'),('naruto','iso'),('enot','hvostov');

insert into stud_class(id_class,id_student) values(3,21),(3,22),(3,23),(3,24),(3,25),(3,26),(3,27),(3,28),(3,29),(3,30),(3,31),(3,32);
insert into stud_class(id_class,id_student) values(4,33),(4,34),(4,35),(4,36),(4,37),(4,38),(4,39),(4,40);

insert into mark (date,value,student_id,subject_id,teacher_id) VALUES 
('2016-02-01',5,7,2,3),('2015-01-09',3,3,4,3),('3098-01-01',4,4,3,4)