----------------------------
-- Update schema
----------------------------

create table employe
(
	id bigserial,
	nom vharchar(20),
	prenom varchar(20),
	genre varchar(8),
	age integer,
	role varchar(10),
	salaire float,	
	etablissement_id integer,
	PRIMARY KEY (id)
);

alter table employe add constraint fk_employe_etablissement_id foreign key (etablissement_id) REFERENCES etablissement(id);


create table competence
(
	id bigserial,
	libelle varchar(20),
	type varchar(10),
	PRIMARY KEY (id)
);


create table competence_par_role
(
	id bigserial,
	role varchar(10),
	niveau_moy float,
	competence_id integer,
	PRIMARY KEY (id)
);

alter table competence_par_role add constraint fk_competence_par_role_competence_id foreign key (competence_id) REFERENCES competence(id);