--liquibase formatted sql

--changeset liquibase:8

insert into reviews (rv_id, user_id, product_id, review_date, review_title, content, rating)
values
    (UNHEX('a1d891b2d78d4bb5907becf6437e40af'), UNHEX('184bc3b168064924924d6a66b6bf91df'),
    UNHEX('ac5c8867676f4737931f052cbb9b4a94'), '2023-11-25 17:11:49',
     'Good choice for a child',
     'The child plays with pleasure, the toy is safe, I recommend it as a gift', 5),
    (UNHEX('dd25f121d1674b968d0912528c53a50f'), UNHEX('a92e7e02b4804384b1db5c5f02e87c15'),
    UNHEX('3b287f306c1c4e71b7bf881e2d7b3cb4'), '2024-02-05 13:11:34',
     'I was not happy with the purchase',
     'The wheels of the car immediately broke off, the build quality leaves much to be desired', 2),
    (UNHEX('725d8b16b473481684cb13e90d7c4e65'), UNHEX('6f5dc02d82d3443db59e35c4c4597080'),
    UNHEX('9ac0037b2a2d4c269b8c15e720f0f8db'), '2024-02-15 13:11:34',
     'My son is very happy with the purchase',
     'The boy does not let go of the car. The build quality and design of the toy are excellent. I will order a similar one for my younger child', 5)