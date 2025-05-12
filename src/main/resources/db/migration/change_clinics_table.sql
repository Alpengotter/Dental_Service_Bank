--liquibase formatted sql
--changeset Nedobezhkin.M.I.:change_clinics_names
update clinics
set name_ = 'ЗТЛ'
where name_ = 'ЛАБ оратории';

update clinics
set name_ = 'ПК + ДЕНТМАСТЕР'
where name_ = 'ДентМастер';

update user_clinic_map
set clinic_id = 6
where clinic_id = 13;

update clinics
set name_ = 'Маркса, 1'
where name_ = 'ТИТОВА';
--rollback ;

--changeset Nedobezhkin.M.I.:delete_clinics_with_users
delete from users
where id in (select user_id
             from user_clinic_map
             where clinic_id in (select id
                                 from clinics
                                 where name_ in ('Дентерпрайз', 'Институт НМСИДМ'))) ;

delete from user_clinic_map
where clinic_id in (select id
                    from clinics
                    where name_ in ('Дентерпрайз', 'Институт НМСИДМ'));

delete from clinics
where name_ in ('Дентерпрайз', 'Институт НМСИДМ');
--rollback ;

--changeset Nedobezhkin.M.I.:delete_clinics_again
delete from clinics
where name_ = 'Профессорская клиника';
--rollback ;