--liquibase formatted sql
--changeset Nedobezhkin.M.I.:change_nominations_table
alter table nominations rename to activities;
--rollback alter table activities rename to nominations;