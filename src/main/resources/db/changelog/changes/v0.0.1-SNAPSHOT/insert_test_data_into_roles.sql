--liquibase formatted sql

--changeset liquibase:9

insert into roles (r_id, role_name)
values
    (UNHEX('e8e47c9584bb4262819f7eace92d5b7b'), 'customer'),
    (UNHEX('1c7e315b38e14e899b5640c5098d3b8f'), 'manager'),
    (UNHEX('ba26b7c508cb46c5bbf035203e269306'), 'super manager'),
    (UNHEX('2057a26e3d3e4e8e84bcd3b9002de4f3'), 'admin')
