----------------------------
-- Create schema
----------------------------

CREATE TABLE IF NOT EXISTS public.hello
(
    id bigserial,
    message varchar(50),
    PRIMARY KEY (id)
);

create table franchise (
	id bigserial,
	nom varchar(50),
	password varchar(255),
	role varchar(10),
	PRIMARY KEY (id)
);