# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table contactos (
  id                        bigint auto_increment not null,
  nombre                    varchar(255),
  telefono                  varchar(255),
  correo_electronico        varchar(255),
  usuarios_id               bigint,
  constraint pk_contactos primary key (id))
;

create table preguntas (
  id                        bigint auto_increment not null,
  pregunta                  varchar(255),
  constraint pk_preguntas primary key (id))
;

create table usuarios (
  id                        bigint auto_increment not null,
  nombre                    varchar(255),
  genero                    varchar(255),
  fecha_nacimiento          datetime,
  username                  varchar(255),
  password                  varchar(255),
  preguntas_id              bigint,
  respuesta                 varchar(255),
  constraint pk_usuarios primary key (id))
;

alter table contactos add constraint fk_contactos_usuarios_1 foreign key (usuarios_id) references usuarios (id) on delete restrict on update restrict;
create index ix_contactos_usuarios_1 on contactos (usuarios_id);
alter table usuarios add constraint fk_usuarios_preguntas_2 foreign key (preguntas_id) references preguntas (id) on delete restrict on update restrict;
create index ix_usuarios_preguntas_2 on usuarios (preguntas_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table contactos;

drop table preguntas;

drop table usuarios;

SET FOREIGN_KEY_CHECKS=1;

