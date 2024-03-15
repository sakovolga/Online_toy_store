--liquibase formatted sql

--changeset liquibase:2

insert into authorities (a_id, authority_name)
values
    (UNHEX('b30fdaec15f44df4a2d4cd4907f94a9a'), 'Create customer profile'),
    (UNHEX('1a10d5483cf14c7c98235e30cf273ad4'), 'Update customer profile'),
    (UNHEX('ff6b1bc11d0c4f0fb3e78be9ae76b986'), 'View own orders'),
    (UNHEX('a6d7c8330fbf4bdcb07cb3bbd3d8d708'), 'Place order'),
    (UNHEX('1563794ad97f4687bdc843952b6e107e'), 'View customers'),
    (UNHEX('54e8699e8c944fcfa0a34ab0b2e17790'), 'Process orders'),
    (UNHEX('9b3f68971e014792b56186ee800f8a0e'), 'View orders'),
    (UNHEX('d354b3e7fc5a4c78bab90bf5947b2744'), 'View reports'),
    (UNHEX('452c3b849eaf4e99a3d485a0eab5e6db'), 'Authority management'),
    (UNHEX('e11df17df7d94729ba65c931e432b178'), 'Role management'),
    (UNHEX('739a7fa5ff224f588f1dc2330bf32f89'), 'User management'),
    (UNHEX('38241e7d1663458590e1d1dc6a8e3250'), 'Admin access')











