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