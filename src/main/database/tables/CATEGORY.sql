-- Table: zfgbb.category

-- DROP TABLE IF EXISTS zfgbb.category;

CREATE TABLE IF NOT EXISTS zfgbb.category
(
    category_id integer NOT NULL DEFAULT nextval('zfgbb.forum_forum_id_seq'::regclass),
    category_name character varying(32) COLLATE pg_catalog."default" NOT NULL,
    descriptipn character varying(64) COLLATE pg_catalog."default",
    created_ts timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    updated_ts timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT forum_pkey PRIMARY KEY (category_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS zfgbb.category
    OWNER to zfgcdev;