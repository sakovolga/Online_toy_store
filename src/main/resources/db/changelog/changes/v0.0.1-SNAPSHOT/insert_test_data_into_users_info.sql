--liquibase formatted sql

--changeset liquibase:12 pass ivan_ivanov -> 529

insert into users_info (ui_id, user_name, password, address, city, postal_code, email, card_number)
values
    (UNHEX('f8d7988476d343d48f2b880ff944e45b'), 'ivan_ivanov', '$2y$10$6gGADQGhYJ9beDIv3o9KC.JjnxvLo.17WtSky/izehC0RmA3kSv6K', 'Musterstrabe 123',
     'DRESDEN', '32415', 'ivanov@gmail.com', '1234 5678 9012 3452'),
    (UNHEX('ef6de8c01d7241cfae4a7498632c6929'), 'petr_petrov', 'ybvmkgf&54091',
     '17 Rue de la Republique', 'PARIS', '76539', 'petrov@gmail.com', '4556 1148 0236 8949'),
    (UNHEX('146c6e2e97904a1f9a67f50fdcc61dd5'), 'anna_belova', '6dj4kz3!jevh', '123 Main Street',
     'WASHINGTON', '52746', 'belova@gmail.com', '5238 7520 6917 0361'),
    (UNHEX('08ae72f74d3b4fb1bb0b1aaae6b4a8ed'), 'svetlana_bolshova', '614274&gfdvbnh', '456 Oak Avenue',
     'DETROIT', '73098', 'bolshova@gmail.com', '3790 4606 1852 935'),
    (UNHEX('8da9be6181c6499d8a0f87416e3e5414'), 'jurii_ostapov', '74567ygfds!', '789 Elm Street',
    'CHICAGO', '65473', 'ostapov@gmail.com', '6011 3530 9423 7768'),
    (UNHEX('a056a97b086343108e2570f46aa7aee7'), 'grigorii_chernookov', '4321566&yfcvbhhgfc', 'Hauptstrabe 34',
    'BREMEN', '65437', 'chern@gmail.com', '4916 8497 2085 6137'),
    (UNHEX('c9fb87a6b0ff457ba6466b4a2a107396'), 'julija_klimenko', '765000!fdbvytr', 'Rosenweg 7',
     'DRESDEN', '32546', 'klim@gmail.com', '3463 8895 2271 479'),
    (UNHEX('1fcff618540544a2b79dd5ac86a4779e'), 'tatiana_kurilenko', '65487698*gfdsa', '25 Rue de la Republique',
     'LYON', '63579', 'kurila@gmail.com', '3749 6097 8113 254')