--liquibase formatted sql
--changeset Nedobezhkin.M.I.:drop_user_constraint
ALTER TABLE users ALTER COLUMN first_name DROP NOT NULL;
--rollback ;