--liquibase formatted sql

--changeset liquibase:1

insert into orders (o_id, user_id, order_date, promo_code_id, order_status)
values
    ('b0e6d30d-0e4d-4694-b7f3-3d40c788b2b1', '184bc3b1-6806-4924-924d-6a66b6bf91df',
     '2023-11-21 13:20:49', 'f83d13cc-4203-4a08-a03d-30a971d87e19', 'DELIVERED'),
    ('ed0285f4-4524-40f8-bcf5-6cb23b7f81dc', '1b4a432d-1ec9-4141-ace1-1d6ed2e3de0f',
     '2024-03-05 07:11:49', '62ae2a48-8c85-4f2e-b7d8-91b374c94585', 'DELIVERED');

insert into orders (o_id, user_id, order_date, order_status)
values
    ('97bea184-3e06-4f63-9c94-ec65f00c823d', 'a92e7e02-b480-4384-b1db-5c5f02e87c15',
     '2024-02-02 16:10:49', 'DELIVERED'),
    ('6b4e8a7c-0f64-4fd8-a37f-5c0a072d14a2', '6f5dc02d-82d3-443d-b59e-35c4c4597080',
     '2024-02-10 17:11:49', 'SHIPPED'),
    ('4eab43a7-0385-48f3-bfd3-4529a2bcfd51', '37e91890-cf71-4376-9bc9-8b4d94b11254',
     '2024-02-26 07:11:49', 'PROCESSING')