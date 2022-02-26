-- Table: zfgbb.board

-- DROP TABLE IF EXISTS zfgbb.board;

CREATE TABLE IF NOT EXISTS zfgbb.board
(
    board_id integer NOT NULL DEFAULT nextval('zfgbb.board_board_id_seq'::regclass),
    board_name character varying(32) COLLATE pg_catalog."default" NOT NULL,
    description character varying(64) COLLATE pg_catalog."default",
    parent_id integer,
    created_ts timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    updated_ts timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    category_id integer NOT NULL,
    CONSTRAINT board_pkey PRIMARY KEY (board_id),
    CONSTRAINT fk_board_category_id FOREIGN KEY (category_id)
        REFERENCES zfgbb.category (category_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_board_parent_id FOREIGN KEY (parent_id)
        REFERENCES zfgbb.board (board_id) MATCH FULL
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS zfgbb.board
    OWNER to zfgcadmin;
-- Index: fki_fk_board_parent_id

-- DROP INDEX IF EXISTS zfgbb.fki_fk_board_parent_id;

CREATE INDEX IF NOT EXISTS fki_fk_board_parent_id
    ON zfgbb.board USING btree
    (parent_id ASC NULLS LAST)
    TABLESPACE pg_default;