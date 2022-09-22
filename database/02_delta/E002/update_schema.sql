----------------------------
-- Update schema
----------------------------

alter table franchise add column argent float;

drop table hello;

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