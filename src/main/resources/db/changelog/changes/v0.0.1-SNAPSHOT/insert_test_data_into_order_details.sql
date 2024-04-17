--liquibase formatted sql

--changeset liquibase:4

insert into order_details (od_id, order_id, product_id, quantity, order_comment)
values
    (UNHEX('081ab92d687e4e24bc4dbd41f631dc21'), UNHEX('97bea1843e064f639c94ec65f00c823d'),
    UNHEX('3b287f306c1c4e71b7bf881e2d7b3cb4'), 1, 'Prefer red color'),
    (UNHEX('081ab92d687e4e24bc4dbd41f631dc22'), UNHEX('ed0285f4452440f8bcf56cb23b7f81dc'),
    UNHEX('d10bb10eae564d3a91bc1961f2a29830'), 2, 'I want first Barbie with pink hear and second in violet dress');

insert into order_details (od_id, order_id, product_id, quantity)
values
    (UNHEX('df3535a575a74a6498793e575194f4a0'), UNHEX('b0e6d30d0e4d4694b7f33d40c788b2b1'),
    UNHEX('ac5c8867676f4737931f052cbb9b4a94'), 1),
    (UNHEX('25f00b1a33574dcbb01f0717db69b1fc'), UNHEX('6b4e8a7c0f644fd8a37f5c0a072d14a2'),
    UNHEX('9ac0037b2a2d4c269b8c15e720f0f8db'), 1),
    (UNHEX('3f348f098910445e810d05fd8dd1a96d'), UNHEX('4eab43a7038548f3bfd34529a2bcfd51'),
    UNHEX('3b287f306c1c4e71b7bf881e2d7b3cb4'), 1),
    (UNHEX('e41825613eb14f08b29bd816b8c394bb'), UNHEX('4eab43a7038548f3bfd34529a2bcfd51'),
    UNHEX('9ac0037b2a2d4c269b8c15e720f0f8db'), 1),

    (UNHEX('e41825613eb14f08b29bd816b8c12345'), UNHEX('ed0285f4452440f8bcf56cb23b712345'),
     UNHEX('9ac0037b2a2d4c269b8c15e720f0f8db'), 2),
    (UNHEX('e41825613eb14f08b29bd816b8c12346'), UNHEX('ed0285f4452440f8bcf56cb23b712346'),
     UNHEX('9ac0037b2a2d4c269b8c15e720f0f8db'), 1),
    (UNHEX('e41825613eb14f08b29bd816b8c12347'), UNHEX('ed0285f4452440f8bcf56cb23b712347'),
     UNHEX('9ac0037b2a2d4c269b8c15e720f0f8db'), 4),
    (UNHEX('e41825613eb14f08b29bd816b8c12348'), UNHEX('ed0285f4452440f8bcf56cb23b712348'),
     UNHEX('9ac0037b2a2d4c269b8c15e720f0f8db'), 1),
    (UNHEX('e41825613eb14f08b29bd816b8c12349'), UNHEX('ed0285f4452440f8bcf56cb23b712348'),
     UNHEX('d10bb10eae564d3a91bc1961f2a29830'), 1),
    (UNHEX('e41825613eb14f08b29bd816b8c12340'), UNHEX('ed0285f4452440f8bcf56cb23b712347'),
     UNHEX('3b287f306c1c4e71b7bf881e2d7b3cb4'), 3)