# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table guestbook (
  id                        bigint not null,
  name                      varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  content                   varchar(255),
  post_at                   timestamp,
  constraint pk_guestbook primary key (id))
;

create sequence guestbook_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists guestbook;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists guestbook_seq;

