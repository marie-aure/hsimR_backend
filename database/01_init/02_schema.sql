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
	type smallint,
	description varchar(300),
    date timestamp with time zone,
	franchise_id integer,
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