--liquibase formatted sql

--changeset liquibase:7

insert into promo_codes (pc_id, promo_name, discount_amount, start_promo_date, end_promo_date, amount_of_users, unused_quantity)
values
    (UNHEX('f83d13cc42034a08a03d30a971d87e19'), 'Black Friday',
     50, '2023-11-15 00:00:00', '2023-11-30 23:59:59', 30, 15),
    (UNHEX('62ae2a488c854f2eb7d891b374c94585'), 'Spring Surprise',
     30, '2023-03-01 00:00:00', '2023-03-31 23:59:59', 40, 12)