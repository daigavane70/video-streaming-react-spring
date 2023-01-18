CREATE SCHEMA `test` ;
create table stocks(id bigint auto_increment not null, name varchar(45), price bigint, total_shares bigint, outstanding_shares bigint, PRIMARY KEY (id));