# challenge_sofka
# code for database
CREATE DATABASE sofka;

CREATE TABLE public.ganador
(
    nombre character varying(20) COLLATE pg_catalog."default",
    posicion integer,
    numerovictorias integer
)

TABLESPACE pg_default;

