--liquibase formatted sql

--changeset liquibase:1

insert into users (u_id, first_name, last_name, created_at, country, user_info)
values
    ('b3cf89da-79d2-42f8-8f4d-fcb22aa43f96', 'Ivan', 'Ivanov', '2024-01-13 13:13:00',
     'GERMANY', 'f8d79884-76d3-43d4-8f2b-880ff944e45b'),
    ('fd26dcd5-2ba4-4ac2-8ad9-83750a560746', 'Petr', 'Petrov', '2024-01-01 09:10:00',
     'FRANCE', 'ef6de8c0-1d72-41cf-ae4a-7498632c6929'),
    ('56b45130-bdd2-4c7f-bd9b-68e08dd481fb', 'Anna', 'Belova', '2024-01-02 09:10:00',
     'USA', '146c6e2e-9790-4a1f-9a67-f50fdcc61dd5'),
    ('184bc3b1-6806-4924-924d-6a66b6bf91df', 'Svetlana', 'Bolshova', '2024-01-03 19:15:43',
     'USA', '08ae72f7-4d3b-4fb1-bb0b-1aaae6b4a8ed'),
    ('a92e7e02-b480-4384-b1db-5c5f02e87c15', 'Jurii', 'Ostapov', '2024-01-04 10:15:43',
     'USA', '8da9be61-81c6-499d-8a0f-87416e3e5414'),
    ('6f5dc02d-82d3-443d-b59e-35c4c4597080', 'Grigorii', 'Chernookov', '2024-01-05 11:19:49',
     'GERMANY', 'a056a97b-0863-4310-8e25-70f46aa7aee7'),
    ('1b4a432d-1ec9-4141-ace1-1d6ed2e3de0f', 'Julija', 'Klimenko', '2024-01-07 12:20:49',
     'GERMANY', 'c9fb87a6-b0ff-457b-a646-6b4a2a107396'),
    ('37e91890-cf71-4376-9bc9-8b4d94b11254', 'Tatiana', 'Kurilenko', '2024-01-08 13:20:49',
     'FRANCE', '1fcff618-5405-44a2-b79d-d5ac86a4779e')