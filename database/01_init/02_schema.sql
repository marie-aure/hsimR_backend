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

