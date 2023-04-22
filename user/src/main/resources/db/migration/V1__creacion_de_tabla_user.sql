create table usuario (
                         usuario_id  SERIAL primary key,
                         nombre		varchar(100) not null,
                         apellido	varchar(100) not null,
                         user_name	varchar(100) not null,
                         password	varchar(200) not null,
                         telefono	varchar(20) not null,
                         email		varchar(200) not null
);