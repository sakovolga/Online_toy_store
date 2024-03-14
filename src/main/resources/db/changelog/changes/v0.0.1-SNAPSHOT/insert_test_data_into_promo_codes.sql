--liquibase formatted sql

--changeset liquibase:1

insert into promo_codes (pc_id, promo_name, discount_amount, start_promo_date, end_promo_date, amount_of_users, unused_quantity)
values
    ('f83d13cc-4203-4a08-a03d-30a971d87e19', 'Black Friday',
     50, '2023-11-15 00:00:00', '2023-11-30 23:59:59', 30, 15),
    ('62ae2a48-8c85-4f2e-b7d8-91b374c94585', 'Spring Surprise',
     30, '2024-03-01 00:00:00', '2023-03-31 23:59:59', 40, 12)