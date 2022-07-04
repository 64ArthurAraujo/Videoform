DROP TABLE IF EXISTS grupo CASCADE;
DROP TABLE IF EXISTS usuario CASCADE;
DROP TABLE IF EXISTS categoria CASCADE;
DROP TABLE IF EXISTS usuario_categoria CASCADE;
DROP TABLE IF EXISTS video CASCADE;

CREATE TABLE grupo (
  id bigint GENERATED ALWAYS AS IDENTITY,
  name varchar(255),
  PRIMARY KEY (id)
);

CREATE TABLE usuario (
  id bigint GENERATED ALWAYS AS IDENTITY,
  username varchar(255),
  password varchar(128),
  auth_token varchar(128) UNIQUE,
  PRIMARY KEY (id)
);

CREATE TABLE categoria (
  id bigint GENERATED ALWAYS AS IDENTITY,
  name varchar(255) UNIQUE,
  id_grupo bigint,
  PRIMARY KEY (id),
  CONSTRAINT fk_id_grupo FOREIGN KEY (id_grupo) REFERENCES grupo(id) ON DELETE SET NULL
);

CREATE TABLE usuario_categoria (
  id bigint GENERATED ALWAYS AS IDENTITY,
  name_categoria varchar(255),
  token_usuario varchar(128),
  interest_rate bigint,
  PRIMARY KEY (id),
  CONSTRAINT fk_name_categoria FOREIGN KEY (name_categoria) REFERENCES categoria(name) ON DELETE SET NULL,
  CONSTRAINT fk_token_usuario FOREIGN KEY (token_usuario) REFERENCES usuario(auth_token) ON DELETE SET NULL
);


/* SPECIFIC TABLES FOR VIDEOS */
CREATE TABLE video (
  id bigint GENERATED ALWAYS AS IDENTITY,
  video_token varchar(12) UNIQUE,
  title varchar(180),
  description varchar(1024),
  owner_id bigint,
  likes bigint,
  dislikes bigint,
  vizualizations bigint,
  category_id bigint,
  PRIMARY KEY (id),
  CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES categoria(id) ON DELETE SET NULL,
  CONSTRAINT fk_owner_id FOREIGN KEY (owner_id) REFERENCES usuario(id) ON DELETE SET NULL
)





















