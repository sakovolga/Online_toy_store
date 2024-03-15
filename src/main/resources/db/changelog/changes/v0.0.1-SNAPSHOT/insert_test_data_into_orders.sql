--liquibase formatted sql

--changeset liquibase:5

insert into orders (o_id, user_id, order_date, promo_code_id, order_status)
values
    (UNHEX('b0e6d30d0e4d4694b7f33d40c788b2b1'), UNHEX('184bc3b168064924924d6a66b6bf91df'),
     '2023-11-21 13:20:49', UNHEX('f83d13cc42034a08a03d30a971d87e19'), 'DELIVERED'),
    (UNHEX('ed0285f4452440f8bcf56cb23b7f81dc'), UNHEX('1b4a432d1ec94141ace11d6ed2e3de0f'),
     '2024-03-05 07:11:49', UNHEX('62ae2a488c854f2eb7d891b374c94585'), 'DELIVERED');

insert into orders (o_id, user_id, order_date, order_status)
values
    (UNHEX('97bea1843e064f639c94ec65f00c823d'), UNHEX('a92e7e02b4804384b1db5c5f02e87c15'),
     '2024-02-02 16:10:49', 'DELIVERED'),
    (UNHEX('6b4e8a7c0f644fd8a37f5c0a072d14a2'), UNHEX('6f5dc02d82d3443db59e35c4c4597080'),
     '2024-02-10 17:11:49', 'SHIPPED'),
    (UNHEX('4eab43a7038548f3bfd34529a2bcfd51'), UNHEX('37e91890cf7143769bc98b4d94b11254'),
     '2024-02-26 07:11:49', 'PROCESSING')