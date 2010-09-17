/**
 * customers
 */

alter session set current_schema = customers;

create table customer_states (
	id int not null,
	description varchar2(100) not null,
	primary key (id),
	unique (description)
);

create table customers (
	id int not null,
	account_id varchar2(20) not null,
	status_id int not null,
	primary key (id),
	unique (account_id),
	foreign key status_id references customer_states(id)
);