--liquibase formatted sql

--changeset liquibase:6

insert into products (p_id, product_name, description, price, available_quantity, category, is_available, supplier_id)
values
    (UNHEX('ac5c8867676f4737931f052cbb9b4a94'),
     'Toy Farm Animals Set Playset Collection of Domestic Animals Pets Flask for Kids',
      'Every child has their own playtime preferences  some enjoy playing war games and building with construction sets, others play house with dolls.',
     3.45, 20, 'CONSTRUCTION_SETS', TRUE, UNHEX('e19a0275f0dc4d22bb1c79af21cb6473')),
    (UNHEX('d10bb10eae564d3a91bc1961f2a29830'),
     'Barbie Cutie Series Dolls Lot Of 4 Loose Articulated Poseable Toy Dolls',
     'All Dolls are in very good condition, will come exactly as pictured no other accessories.',
     11.50, 21, 'DOLLS', TRUE, UNHEX('0b7aa21e0f054414aa1557074e77b0ad')),
    (UNHEX('3b287f306c1c4e71b7bf881e2d7b3cb4'),
     '1:24 Toyota Yaris GR 2021 Alloy Car Diecasts Toy Vehicles Car Kid',
     'Scale: 1/24, material: metal, feature: diecast, package includes: 1pc Alloy Car Model',
      38.59, 43, 'TOY_VEHICLES', TRUE, UNHEX('c3dbdb90d1e8495fb8bb812fffa48512')),
    (UNHEX('9ac0037b2a2d4c269b8c15e720f0f8db'),
     'CAT Little Machines 5pcs Construction Toy Vehicles Playset for Kids Ages 3',
     'Bring The Whole Construction Site To Even The Smallest Of Spaces With The Cat Little Machines 5 Pack.',
      11.20, 3, 'TOY_VEHICLES', TRUE, UNHEX('e19a0275f0dc4d22bb1c79af21cb6473'))