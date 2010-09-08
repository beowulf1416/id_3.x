/**
 * populate document management tables
 */


/* content types */

create seq_content_type_id;

insert into content_types (id,mime) values (seq_content_type_id.nextval(),'text/plain');
insert into content_types (id,mime) values (seq_content_type_id.nextval(),'text/csv');
insert into content_types (id,mime) values (seq_content_type_id.nextval(),'text/css');
insert into content_types (id,mime) values (seq_content_type_id.nextval(),'text/html');
insert into content_types (id,mime) values (seq_content_type_id.nextval(),'text/xml');

insert into content_types (id,mime) values (seq_content_type_id.nextval(),'image/gif');
insert into content_types (id,mime) values (seq_content_type_id.nextval(),'image/jpg');
insert into content_types (id,mime) values (seq_content_type_id.nextval(),'image/png');
insert into content_types (id,mime) values (seq_content_type_id.nextval(),'image/tiff');

insert into content_types (id,mime) values (seq_content_type_id.nextval(),'application/msword');
insert into content_types (id,mime) values (seq_content_type_id.nextval(),'application/pdf');

drop seq_content_type_id;

