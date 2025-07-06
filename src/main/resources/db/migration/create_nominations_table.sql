--liquibase formatted sql
--changeset Nedobezhkin.M.I.:create_nominations_table
create table if not exists nominations
(
    id int primary key generated ALWAYS AS IDENTITY,
    title_ varchar(500),
    value_ bigint default 0,
    type_ varchar(100),
    is_active boolean default true,
    created_by varchar(100) default 'system',
    updated_by varchar(100),
    created_at timestamp default now(),
    updated_at timestamp default now()
    );
--rollback drop table nominations;