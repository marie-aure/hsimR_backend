----------------------------
-- Update schema
----------------------------

alter table franchise add column token_cheval smallint default 0, add column token_etablissement smallint default 0;