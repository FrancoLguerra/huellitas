CREATE TABLE ROLES (
    ID INT NOT NULL,
    NOMBRE VARCHAR(50) NOT NULL UNIQUE,
    PRIMARY KEY (ID)
);

CREATE TABLE ROLES_USUARIOS (
    ROL_ID int NOT NULL,
    USUARIO_ID  bigint NOT NULL,

    PRIMARY KEY (USUARIO_ID, ROL_ID)

);

alter table ROLES_USUARIO add constraint RUSR$ROL foreign key (ROL_ID) references ROLES(ID);
alter table ROLES_USUARIO add constraint RUSR$USR foreign key (USUARIO_ID) references USUARIOS(ID);