--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: tbl_documentos; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE tbl_documentos (
    id bigint NOT NULL,
    autor character varying(48) NOT NULL,
    data_documento date NOT NULL,
    data_inclusao timestamp without time zone NOT NULL,
    destinatario character varying(48) NOT NULL,
    local character varying(48) NOT NULL,
    resumo character varying(2048) NOT NULL,
    tipo_id character varying(5),
    cod_id character varying(7),
    tipo_origem character varying(7),
    cod_origem character varying(7),
    titulo_origem character varying(255),
    palavra_chave_1 character varying(32),
    palavra_chave_2 character varying(32),
    palavra_chave_3 character varying(32),
    tipo_documento character varying(20) NOT NULL,
    email_uploader character varying(255)
);


--
-- Name: tbl_id_num_documento; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE tbl_id_num_documento (
    id bigint NOT NULL,
    cod_id character varying(7),
    tipo_id character varying(5)
);


--
-- Name: tbl_origem; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE tbl_origem (
    id bigint NOT NULL,
    cod_origem character varying(7) NOT NULL,
    tipo_origem character varying(7) NOT NULL,
    titulo character varying(255) NOT NULL
);


--
-- Name: tbl_palavra_chave; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE tbl_palavra_chave (
    id bigint NOT NULL,
    aprovada boolean NOT NULL,
    palavra character varying(32) NOT NULL
);


--
-- Name: tbl_profile; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE tbl_profile (
    id bigint NOT NULL,
    edit boolean NOT NULL,
    profile character varying(255) NOT NULL,
    read boolean NOT NULL,
    write boolean NOT NULL
);


--
-- Name: tbl_tipo_documento; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE tbl_tipo_documento (
    id bigint NOT NULL,
    tipo_documento character varying(20) NOT NULL
);


--
-- Name: tbl_user; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE tbl_user (
    id bigint NOT NULL,
    data_inclusao timestamp without time zone,
    endereco character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    profile bigint NOT NULL
);


--
-- Name: tbl_documentos_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY tbl_documentos
    ADD CONSTRAINT tbl_documentos_pkey PRIMARY KEY (id);


--
-- Name: tbl_id_num_documento_cod_id_key; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY tbl_id_num_documento
    ADD CONSTRAINT tbl_id_num_documento_cod_id_key UNIQUE (cod_id);


--
-- Name: tbl_id_num_documento_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY tbl_id_num_documento
    ADD CONSTRAINT tbl_id_num_documento_pkey PRIMARY KEY (id);


--
-- Name: tbl_id_num_documento_tipo_id_cod_id_key; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY tbl_id_num_documento
    ADD CONSTRAINT tbl_id_num_documento_tipo_id_cod_id_key UNIQUE (tipo_id, cod_id);


--
-- Name: tbl_origem_cod_origem_tipo_origem_key; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY tbl_origem
    ADD CONSTRAINT tbl_origem_cod_origem_tipo_origem_key UNIQUE (cod_origem, tipo_origem);


--
-- Name: tbl_origem_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY tbl_origem
    ADD CONSTRAINT tbl_origem_pkey PRIMARY KEY (id);


--
-- Name: tbl_origem_tipo_origem_cod_origem_titulo_key; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY tbl_origem
    ADD CONSTRAINT tbl_origem_tipo_origem_cod_origem_titulo_key UNIQUE (tipo_origem, cod_origem, titulo);


--
-- Name: tbl_palavra_chave_palavra_key; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY tbl_palavra_chave
    ADD CONSTRAINT tbl_palavra_chave_palavra_key UNIQUE (palavra);


--
-- Name: tbl_palavra_chave_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY tbl_palavra_chave
    ADD CONSTRAINT tbl_palavra_chave_pkey PRIMARY KEY (id);


--
-- Name: tbl_profile_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY tbl_profile
    ADD CONSTRAINT tbl_profile_pkey PRIMARY KEY (id);


--
-- Name: tbl_profile_profile_key; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY tbl_profile
    ADD CONSTRAINT tbl_profile_profile_key UNIQUE (profile);


--
-- Name: tbl_tipo_documento_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY tbl_tipo_documento
    ADD CONSTRAINT tbl_tipo_documento_pkey PRIMARY KEY (id);


--
-- Name: tbl_tipo_documento_tipo_documento_key; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY tbl_tipo_documento
    ADD CONSTRAINT tbl_tipo_documento_tipo_documento_key UNIQUE (tipo_documento);


--
-- Name: tbl_user_endereco_key; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY tbl_user
    ADD CONSTRAINT tbl_user_endereco_key UNIQUE (endereco);


--
-- Name: tbl_user_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY tbl_user
    ADD CONSTRAINT tbl_user_pkey PRIMARY KEY (id);


--
-- Name: fkf5e4f76014731555; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tbl_documentos
    ADD CONSTRAINT fkf5e4f76014731555 FOREIGN KEY (tipo_documento) REFERENCES tbl_tipo_documento(tipo_documento);


--
-- Name: fkf5e4f7604762c345; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tbl_documentos
    ADD CONSTRAINT fkf5e4f7604762c345 FOREIGN KEY (tipo_id, cod_id) REFERENCES tbl_id_num_documento(tipo_id, cod_id);


--
-- Name: fkf5e4f7607c438efd; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tbl_documentos
    ADD CONSTRAINT fkf5e4f7607c438efd FOREIGN KEY (palavra_chave_1) REFERENCES tbl_palavra_chave(palavra);


--
-- Name: fkf5e4f7607c438efe; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tbl_documentos
    ADD CONSTRAINT fkf5e4f7607c438efe FOREIGN KEY (palavra_chave_2) REFERENCES tbl_palavra_chave(palavra);


--
-- Name: fkf5e4f7607c438eff; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tbl_documentos
    ADD CONSTRAINT fkf5e4f7607c438eff FOREIGN KEY (palavra_chave_3) REFERENCES tbl_palavra_chave(palavra);


--
-- Name: fkf5e4f760892355f0; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tbl_documentos
    ADD CONSTRAINT fkf5e4f760892355f0 FOREIGN KEY (email_uploader) REFERENCES tbl_user(endereco);


--
-- Name: fkf5e4f760b0810f70; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tbl_documentos
    ADD CONSTRAINT fkf5e4f760b0810f70 FOREIGN KEY (tipo_origem, cod_origem, titulo_origem) REFERENCES tbl_origem(tipo_origem, cod_origem, titulo);


--
-- Name: fkfe80bac82b6785e; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tbl_user
    ADD CONSTRAINT fkfe80bac82b6785e FOREIGN KEY (profile) REFERENCES tbl_profile(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: -
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

