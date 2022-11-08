----------------------------
-- Update schema
----------------------------

alter table franchise add column token_cheval smallint default 0, add column token_etablissement smallint default 0;


create table etablissement
(
	id bigserial,
	nom varchar(50),
	type smallint,
	franchise_id smallint,
	PRIMARY KEY (id)
);

alter table trace add column etablissement_id integer;

alter table etablissement add constraint fk_etablissement_franchise_id foreign key (franchise_id) REFERENCES franchise(id);
alter table trace add constraint fk_trace_franchise_id foreign key (franchise_id) REFERENCES franchise(id);
alter table trace add constraint fk_trace_etablissement_id foreign key (etablissement_id) REFERENCES etablissement(id);
alter table transaction add constraint fk_transaction_source_f_id foreign key (source_f_id) REFERENCES franchise(id);
alter table transaction add constraint fk_transaction_destinataire_f_id foreign key (destinataire_f_id) REFERENCES franchise(id);
