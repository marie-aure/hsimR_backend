----------------------------
-- Create schema
----------------------------

create table hello
(
    id bigserial,
    message varchar(50),
    PRIMARY KEY (id)
);

create table franchise 
(
	id bigserial,
	nom varchar(50),
	password varchar(255),
	role varchar(10),
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

