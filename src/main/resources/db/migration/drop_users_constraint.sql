--liquibase formatted sql
--changeset Nedobezhkin.M.I.:drop_user_constraint
ALTER TABLE user ALTER COLUMN first_name DROP NOT NULL;
--rollback ;