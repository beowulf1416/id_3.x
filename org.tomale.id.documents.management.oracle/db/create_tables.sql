/**
 * document management tables
 */

/* modify below line to use a different schema */
alter session set current_schema = documents;

create sequence seq_doc_id;

create table content_types (
	id int not null,
	mime varchar2(200) not null,
	primary key (id)
);

comment on column content_types.id is 'pk, content type id';
comment on column content_types.mime is 'mime type';

create table documents (
	id int not null,
	content_type_id int not null,
	path varchar2(500) not null,
	filename varchar2(100) not null,
	content blob not null,
	attribs varchar2(200),
	primary key (id),
	foreign key (content_type_id) references content_types(id)
);

create index idx_doc_path on documents(path);
create index idx_doc_fn on documents(filename);

comment on column documents.id is 'pk, document id';