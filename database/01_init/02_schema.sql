----------------------------
-- Create schema
----------------------------

CREATE TABLE IF NOT EXISTS public.hello
(
    id bigserial,
    message varchar(50),
    PRIMARY KEY (id)
);