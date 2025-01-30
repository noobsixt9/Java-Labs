create database JavaDB;

create table employee (
	empID int primary key identity,
	empName varchar(50),
	empAge int, 
	empAddress varchar(50),
	empPosition varchar(20)
);

