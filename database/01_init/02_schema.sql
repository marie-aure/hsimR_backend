----------------------------
-- Create schema
----------------------------

create table franchise 
(
	id bigserial,
	nom varchar(50),
	password varchar(255),
	role varchar(10),
	argent float,
	token_cheval smallint default 0,
	token_etablissement smallint default 0,
	PRIMARY KEY (id)
);

create table etablissement
(
	id bigserial,
	nom varchar(50),
	type varchar(50),
	franchise_id smallint,
	PRIMARY KEY (id)
);

create table tour
(
	id bigserial,
	annee integer,
	mois integer,
    semaine_mois integer,
	cle integer,
	actif boolean,
	PRIMARY KEY (id)
);

create table trace
(
	id bigserial,
	type varchar(50),
	description varchar(300),
    date timestamp with time zone,
	franchise_id integer,
	etablissement_id integer,
	PRIMARY KEY (id)
);

create table transaction
(
	id bigserial,
	montant float,
	libelle varchar(300),
    tour_id integer,
	source_f_id integer,
	destinataire_f_id integer,
	PRIMARY KEY (id)
);

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

alter table etablissement add constraint fk_etablissement_franchise_id foreign key (franchise_id) REFERENCES franchise(id);
alter table trace add constraint fk_trace_franchise_id foreign key (franchise_id) REFERENCES franchise(id);
alter table trace add constraint fk_trace_etablissement_id foreign key (etablissement_id) REFERENCES etablissement(id);
alter table transaction add constraint fk_transaction_source_f_id foreign key (source_f_id) REFERENCES franchise(id);
alter table transaction add constraint fk_transaction_destinataire_f_id foreign key (destinataire_f_id) REFERENCES franchise(id);
alter table employe add constraint fk_employe_etablissement_id foreign key (etablissement_id) REFERENCES etablissement(id);