create table IMAGENES(
	ID bigint not null AUTO_INCREMENT,
	NOMBRE varchar(150) not null,
	TIPO_CONTENIDO varchar(25),
	CONTENIDO  MEDIUMBLOB not null,
	PRIMARY KEY(ID)
);

create table USUARIOS(
	ID bigint not null AUTO_INCREMENT,
	NOMBRE varchar(100) not null,
	APELLIDO varchar(100) not null,
	MAIL varchar(50),
	TELEFONO varchar(25),
	PRIMARY KEY(ID)
);

create table MASCOTAS(
	ID bigint not null AUTO_INCREMENT,
	NOMBRE varchar(100) not null,
	ESPECIE varchar(100) not null,
	GENERO varchar(20),
	COLOR varchar(50),
	RAZA varchar(50),
	CASTRADO boolean,
	PRIMARY KEY(ID)
);

create table PUBLICACIONES(
	ID bigint not null AUTO_INCREMENT,
	FECHA timestamp not null,
	TEXTO_ADICIONAL varchar(255),
	UBICACION varchar(255),
	ESTADO varchar(20) not null,
	IMAGEN_ID bigint,
	USUARIO_ID bigint not null,
	MASCOTA_ID bigint not null,
	PRIMARY KEY(ID)

);

alter table PUBLICACIONES add constraint PUB$IMG foreign key (IMAGEN_ID) references IMAGENES(ID);
alter table PUBLICACIONES add constraint PUB$USU foreign key (USUARIO_ID) references USUARIOS(ID);
alter table PUBLICACIONES add constraint PUB$MAS foreign key (MASCOTA_ID) references MASCOTA(ID);