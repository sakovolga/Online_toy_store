--liquibase formatted sql

--changeset liquibase:1

insert into users_info (ui_id, user_name, password, address, city, postal_code, email, card_number)
values
    ('f8d79884-76d3-43d4-8f2b-880ff944e45b', 'ivan_ivanov', 'ubwuyt!529', 'Musterstrabe 123',
     'DREZDEN', '32415', 'ivanov@gmail.com', '1234 5678 9012 3452'),
    ('ef6de8c0-1d72-41cf-ae4a-7498632c6929', 'petr_petrov', 'ybvmkgf&54091',
     '17 Rue de la Republique', 'PARIS', '76539', 'petrov@gmail.com', '4556 1148 0236 8949'),
    ('146c6e2e-9790-4a1f-9a67-f50fdcc61dd5', 'anna_belova', '6dj4kz3!jevh', '123 Main Street',
     'WASHINGTON', '52746', 'belova@gmail.com', '5238 7520 6917 0361'),
    ('08ae72f7-4d3b-4fb1-bb0b-1aaae6b4a8ed', 'svetlana_bolshova', '614274&gfdvbnh', '456 Oak Avenue',
     'DETROIT', '73098', 'bolshova@gmail.com', '3790 4606 1852 935'),
    ('8da9be61-81c6-499d-8a0f-87416e3e5414', 'jurii_ostapov', '74567ygfds!', '789 Elm Street',
    'CHICAGO', '65473', 'ostapov@gmail.com', '6011 3530 9423 7768'),
    ('a056a97b-0863-4310-8e25-70f46aa7aee7', 'grigorii_chernookov', '4321566&yfcvbhhgfc', 'Hauptstrabe 34',
    'BREMEN', '65437', 'chern@gmail.com', '4916 8497 2085 6137'),
    ('c9fb87a6-b0ff-457b-a646-6b4a2a107396', 'julija_klimenko', '765000!fdbvytr', 'Rosenweg 7',
     'DREZDEN', '32546', 'klim@gmail.com', '3463 8895 2271 479'),
    ('1fcff618-5405-44a2-b79d-d5ac86a4779e', 'tatiana_kurilenko', '65487698*gfdsa', '25 Rue de la Republique',
     'LYON', '63579', 'kurila@gmail.com', '3749 6097 8113 254')