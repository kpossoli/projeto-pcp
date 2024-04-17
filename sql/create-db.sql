CREATE TABLE aluno (
	id bigserial NOT NULL,
	data_nascimento date,
	nome varchar(255),
	version int8,
	id_usuario int8,
	id_turma int8,
	CONSTRAINT pk_aluno PRIMARY KEY (id)
);

CREATE TABLE curso (
	id bigserial NOT NULL,
	nome varchar(255),
	version int8,
	CONSTRAINT pk_curso PRIMARY KEY (id)
);

CREATE TABLE docente (
	id bigserial NOT NULL,
	data_entrada date,
	nome varchar(255),
	version int8,
	id_usuario int8,
	CONSTRAINT pk_docente PRIMARY KEY (id)
);

CREATE TABLE materia (
	id bigserial NOT NULL,
	nome varchar(255),
	version int8,
	id_curso int8,
	CONSTRAINT pk_materia PRIMARY KEY (id)
);

CREATE TABLE notas (
	id bigserial NOT NULL,
	data date,
	valor numeric(19, 2),
	version int8,
	id_aluno int8,
	id_docente int8,
	id_materia int8,
	CONSTRAINT pk_notas PRIMARY KEY (id)
);

CREATE TABLE papel (
	id bigserial NOT NULL,
	nome varchar(255),
	version int8,
	CONSTRAINT pk_papel PRIMARY KEY (id)
);

CREATE TABLE turma (
	id bigserial NOT NULL,
	nome varchar(255),
	version int8,
	id_docente int8,
	id_curso int8,
	CONSTRAINT pk_turma PRIMARY KEY (id)
);

CREATE TABLE usuario (
	id bigserial NOT NULL,
	login varchar(255),
	nome varchar(255),
	senha varchar(255),
	version int8,
	id_papel int8,
	CONSTRAINT pk_usuario PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS aluno
	add CONSTRAINT fk_aluno_usuario
	FOREIGN KEY (id_usuario)
	REFERENCES usuario;

CREATE INDEX idx_aluno_id_usuario ON aluno (id_usuario);

ALTER TABLE IF EXISTS aluno
	add CONSTRAINT fk_aluno_turma
	FOREIGN KEY (id_turma)
	REFERENCES turma;

CREATE INDEX idx_aluno_id_turma ON aluno (id_turma);

ALTER TABLE IF EXISTS docente
	add CONSTRAINT fk_docente_usuario
	FOREIGN KEY (id_usuario)
	REFERENCES usuario;

CREATE INDEX idx_docente_id_usuario ON docente (id_usuario);

ALTER TABLE IF EXISTS materia
	add CONSTRAINT fk_materia_curso
	FOREIGN KEY (id_curso)
	REFERENCES curso;

CREATE INDEX idx_materia_id_curso ON materia (id_curso);

ALTER TABLE IF EXISTS notas
	add CONSTRAINT fk_notas_aluno
	FOREIGN KEY (id_aluno)
	REFERENCES aluno;

CREATE INDEX idx_notas_id_aluno ON notas (id_aluno);

ALTER TABLE IF EXISTS notas
	add CONSTRAINT fk_notas_docente
	FOREIGN KEY (id_docente)
	REFERENCES docente;

CREATE INDEX idx_notas_id_docente ON notas (id_docente);

ALTER TABLE IF EXISTS notas
	add CONSTRAINT fk_notas_materia
	FOREIGN KEY (id_materia)
	REFERENCES materia;

CREATE INDEX idx_notas_id_materia ON notas (id_materia);

ALTER TABLE IF EXISTS turma
	add CONSTRAINT fk_turma_docente
	FOREIGN KEY (id_docente)
	REFERENCES docente;

CREATE INDEX idx_turma_id_docente ON turma (id_docente);

ALTER TABLE IF EXISTS turma
	add CONSTRAINT fk_turma_curso
	FOREIGN KEY (id_curso)
	REFERENCES curso;

CREATE INDEX idx_turma_id_curso ON turma (id_curso);

ALTER TABLE IF EXISTS usuario
	add CONSTRAINT fk_usuario_papel
	FOREIGN KEY (id_papel)
	REFERENCES papel;

CREATE INDEX idx_usuario_id_papel ON usuario (id_papel);
