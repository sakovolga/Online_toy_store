--liquibase formatted sql

--changeset liquibase:10

insert into suppliers (s_id, supplier_name, phone, email, address, city, postal_code, country)
values
    (UNHEX('e19a0275f0dc4d22bb1c79af21cb6473'), 'ABC Wholesale Distributors', '+1 (212) 555-1234',
        'abc@gmail.com', '123 Main Street', 'WASHINGTON', '12345', 'USA'),
    (UNHEX('c3dbdb90d1e8495fb8bb812fffa48512'), 'Johnson Enterprises Ltd.', '+33 1 23 45 67 89',
     'je@nterprises.com', '14 Rue de la Republique', 'LYON', '45678', 'FRANCE'),
    (UNHEX('0b7aa21e0f054414aa1557074e77b0ad'), 'Global Importers Co.', '+49 30 123456789',
     'global@importers.com', 'Hauptstraße 65', 'BREMEN', '87654', 'GERMANY')