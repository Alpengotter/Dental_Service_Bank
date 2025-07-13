--liquibase formatted sql
--changeset Nedobezhkin.M.I.:change_history_table_add_activities
alter table history
add column activities_id int references activities(id);
--rollback ;

