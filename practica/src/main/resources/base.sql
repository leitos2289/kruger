-- Database: krugerBD

-- DROP DATABASE IF EXISTS "krugerBD";

CREATE DATABASE "krugerBD"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Ecuador.1252'
    LC_CTYPE = 'Spanish_Ecuador.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Table: public.empleado

-- DROP TABLE IF EXISTS public.empleado;

CREATE TABLE IF NOT EXISTS public.empleado
(
    cempleado integer NOT NULL,
    direccion character varying(255) COLLATE pg_catalog."default",
    apellido character varying(255) COLLATE pg_catalog."default" NOT NULL,
    cedula character varying(10) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default",
    fechanacimiento date,
    movil character varying(255) COLLATE pg_catalog."default",
    nombre character varying(255) COLLATE pg_catalog."default" NOT NULL,
    vacunado boolean,
    CONSTRAINT empleado_pkey PRIMARY KEY (cempleado),
    CONSTRAINT uknihg474u49g6e8aolp4lwrj6e UNIQUE (email)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.empleado
    OWNER to postgres;

-- Table: public.roles

-- DROP TABLE IF EXISTS public.roles;

CREATE TABLE IF NOT EXISTS public.roles
(
    id bigint NOT NULL DEFAULT nextval('roles_id_seq'::regclass),
    nombre character varying(60) COLLATE pg_catalog."default",
    CONSTRAINT roles_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.roles
    OWNER to postgres;

-- Table: public.usuarios

-- DROP TABLE IF EXISTS public.usuarios;

CREATE TABLE IF NOT EXISTS public.usuarios
(
    id bigint NOT NULL DEFAULT nextval('usuarios_id_seq'::regclass),
    email character varying(255) COLLATE pg_catalog."default",
    nombre character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default",
    username character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT usuarios_pkey PRIMARY KEY (id),
    CONSTRAINT ukkfsp0s1tflm1cwlj8idhqsad0 UNIQUE (email),
    CONSTRAINT ukm2dvbwfge291euvmk6vkkocao UNIQUE (username)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.usuarios
    OWNER to postgres;

-- Table: public.usuarios_roles

-- DROP TABLE IF EXISTS public.usuarios_roles;

CREATE TABLE IF NOT EXISTS public.usuarios_roles
(
    usuario_id bigint NOT NULL,
    rol_id bigint NOT NULL,
    CONSTRAINT usuarios_roles_pkey PRIMARY KEY (usuario_id, rol_id),
    CONSTRAINT fk5338ehgluufgc8bpj08nrq970 FOREIGN KEY (rol_id)
    REFERENCES public.roles (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkqcxu02bqipxpr7cjyj9dmhwec FOREIGN KEY (usuario_id)
    REFERENCES public.usuarios (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.usuarios_roles
    OWNER to postgres;

-- Table: public.vacuna

-- DROP TABLE IF EXISTS public.vacuna;

CREATE TABLE IF NOT EXISTS public.vacuna
(
    cvacuna integer NOT NULL,
    nombre character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT vacuna_pkey PRIMARY KEY (cvacuna)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.vacuna
    OWNER to postgres;

-- Table: public.vacunacion

-- DROP TABLE IF EXISTS public.vacunacion;

CREATE TABLE IF NOT EXISTS public.vacunacion
(
    codigo integer NOT NULL,
    dosis integer,
    fechavacunacion date,
    cempleado integer NOT NULL,
    cvacuna integer NOT NULL,
    CONSTRAINT vacunacion_pkey PRIMARY KEY (codigo),
    CONSTRAINT ukrg430jxp25o6747avchbumiya UNIQUE (dosis),
    CONSTRAINT fkffkftuu6aa0rql6v0pehjsdf7 FOREIGN KEY (cvacuna)
    REFERENCES public.vacuna (cvacuna) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkowiyala80v85fodrrsflk7pbx FOREIGN KEY (cempleado)
    REFERENCES public.empleado (cempleado) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.vacunacion
    OWNER to postgres;

