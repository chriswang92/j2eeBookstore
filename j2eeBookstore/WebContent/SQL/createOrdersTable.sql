use example;  
create table Orders(  
id int primary key auto_increment, 
username varchar(100) NOT NULL,
clientName varchar(200) NOT NULL,  
address varchar(200) NOT NULL,
totalprice double NOT NULL,
books varchar(500) NOT NULL,
display int NOT NULL DEFAULT 1
);  