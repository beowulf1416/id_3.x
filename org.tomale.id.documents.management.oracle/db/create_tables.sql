/**
 * document management tables
 */

delimiter //

create sequence seq_doc_id;

create table content_types (
	id int not null comment 'content type id',
	mime varchar2(200) not null
)
default character set utf8;
//

create table documents (
	id int not null comment 'pk, doc id',
	content_type_id int not null,
	path varchar2(500) not null,
	filename varchar2(100) not null,
	content blob not null,
	attribs varchar2(200),
	primary key (id),
	foreign key (content_type_id) references content_types(id) on delete restrict,
	index (path),
	index (filename)
)
default character set utf8;
//

delimiter ;