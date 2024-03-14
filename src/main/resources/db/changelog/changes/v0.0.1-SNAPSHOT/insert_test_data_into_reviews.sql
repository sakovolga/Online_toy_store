--liquibase formatted sql

--changeset liquibase:1

insert into reviews (rv_id, user_id, product_id, review_date, review_title, content, rating)
values
    ('a1d891b2-d78d-4bb5-907b-ecf6437e40af', '184bc3b1-6806-4924-924d-6a66b6bf91df',
     'ac5c8867-676f-4737-931f-052cbb9b4a94', '2023-11-25 17:11:49',
     'Good choice for a child',
     'The child plays with pleasure, the toy is safe, I recommend it as a gift', 5),
    ('dd25f121-d167-4b96-8d09-12528c53a50f', 'a92e7e02-b480-4384-b1db-5c5f02e87c15',
     '3b287f30-6c1c-4e71-b7bf-881e2d7b3cb4', '2024-02-05 13:11:34',
     'I was not happy with the purchase',
     'The wheels of the car immediately broke off, the build quality leaves much to be desired', 2),
    ('725d8b16-b473-4816-84cb-13e90d7c4e65', '6f5dc02d-82d3-443d-b59e-35c4c4597080',
     '9ac0037b-2a2d-4c26-9b8c-15e720f0f8db', '2024-02-15 13:11:34',
     'My son is very happy with the purchase',
     'The boy does not let go of the car. The build quality and design of the toy are excellent. I will order a similar one for my younger child', 5)