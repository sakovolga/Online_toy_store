--liquibase formatted sql

--changeset liquibase:11

insert into users (u_id, first_name, last_name, created_at, country, user_info)
values
    (UNHEX('b3cf89da79d242f88f4dfcb22aa43f96'), 'Ivan', 'Ivanov', '2024-01-13 13:13:00',
     'GERMANY', UNHEX('f8d7988476d343d48f2b880ff944e45b')),
    (UNHEX('fd26dcd52ba44ac28ad983750a560746'), 'Petr', 'Petrov', '2024-01-01 09:10:00',
     'FRANCE', UNHEX('ef6de8c01d7241cfae4a7498632c6929')),
    (UNHEX('56b45130bdd24c7fbd9b68e08dd481fb'), 'Anna', 'Belova', '2024-01-02 09:10:00',
     'USA', UNHEX('146c6e2e97904a1f9a67f50fdcc61dd5')),
    (UNHEX('184bc3b168064924924d6a66b6bf91df'), 'Svetlana', 'Bolshova', '2024-01-03 19:15:43',
     'GERMANY', UNHEX('08ae72f74d3b4fb1bb0b1aaae6b4a8ed')),
    (UNHEX('a92e7e02b4804384b1db5c5f02e87c15'), 'Jurii', 'Ostapov', '2024-01-04 10:15:43',
     'USA', UNHEX('8da9be6181c6499d8a0f87416e3e5414')),
    (UNHEX('6f5dc02d82d3443db59e35c4c4597080'), 'Grigorii', 'Chernookov', '2024-01-05 11:19:49',
     'GERMANY', UNHEX('a056a97b086343108e2570f46aa7aee7')),
    (UNHEX('1b4a432d1ec94141ace11d6ed2e3de0f'), 'Julija', 'Klimenko', '2024-01-07 12:20:49',
     'GERMANY', UNHEX('c9fb87a6b0ff457ba6466b4a2a107396')),
    (UNHEX('37e91890cf7143769bc98b4d94b11254'), 'Tatiana', 'Kurilenko', '2024-01-08 13:20:49',
     'GERMANY', UNHEX('1fcff618540544a2b79dd5ac86a4779e'))