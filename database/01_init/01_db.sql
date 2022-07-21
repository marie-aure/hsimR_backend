----------------------------
-- Create local database
----------------------------

CREATE DATABASE db_sandbox
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = 30;