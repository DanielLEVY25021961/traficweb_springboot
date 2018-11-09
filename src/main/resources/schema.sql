-- Table: public.profils

DROP Table IF EXISTS public.profils;

CREATE TABLE public.profils
(
    id_profil bigint NOT NULL DEFAULT nextval('profils_id_profil_seq'::regclass),
    portee character varying(255) COLLATE pg_catalog."default" NOT NULL,
    profil character varying(255) COLLATE pg_catalog."default" NOT NULL,
    restriction character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT profils_pkey PRIMARY KEY (id_profil),
    CONSTRAINT unicite_profil_portee UNIQUE (profil, portee)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.profils
    OWNER to postgres;