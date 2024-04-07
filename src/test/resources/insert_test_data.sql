insert into suppliers (s_id, supplier_name, phone, email, address, city, postal_code, country)
values
    (X'e19a0275f0dc4d22bb1c79af21cb6473', 'ABC Wholesale Distributors', '+1 (212) 555-1234',
     'abc@gmail.com', '123 Main Street', 'WASHINGTON', '12345', 'USA'),
    (X'c3dbdb90d1e8495fb8bb812fffa48512', 'Johnson Enterprises Ltd.', '+33 1 23 45 67 89',
     'je@nterprises.com', '14 Rue de la Republique', 'LYON', '45678', 'FRANCE'),
    (X'0b7aa21e0f054414aa1557074e77b0ad', 'Global Importers Co.', '+49 30 123456789',
     'global@importers.com', 'Hauptstraße 65', 'BREMEN', '87654', 'GERMANY');


insert into products (p_id, product_name, description, price, available_quantity, category, is_available, supplier_id)
values
    (X'ac5c8867676f4737931f052cbb9b4a94',
     'Toy Farm Animals Set Playset Collection of Domestic Animals Pets Flask for Kids',
     'Every child has their own playtime preferences  some enjoy playing war games and building with construction sets, others play house with dolls.',
     3.45, 20, 'CONSTRUCTION_SETS', TRUE, X'e19a0275f0dc4d22bb1c79af21cb6473'),
    (X'd10bb10eae564d3a91bc1961f2a29830',
     'Barbie Cutie Series Dolls Lot Of 4 Loose Articulated Poseable Toy Dolls',
     'All Dolls are in very good condition, will come exactly as pictured no other accessories.',
     11.50, 21, 'DOLLS', TRUE, X'0b7aa21e0f054414aa1557074e77b0ad'),
    (X'3b287f306c1c4e71b7bf881e2d7b3cb4',
     '1:24 Toyota Yaris GR 2021 Alloy Car Diecasts Toy Vehicles Car Kid',
     'Scale: 1/24, material: metal, feature: diecast, package includes: 1pc Alloy Car Model',
     38.59, 43, 'TOY_VEHICLES', TRUE, X'c3dbdb90d1e8495fb8bb812fffa48512'),
    (X'9ac0037b2a2d4c269b8c15e720f0f8db',
     'CAT Little Machines 5pcs Construction Toy Vehicles Playset for Kids Ages 3',
     'Bring The Whole Construction Site To Even The Smallest Of Spaces With The Cat Little Machines 5 Pack.',
     11.20, 3, 'TOY_VEHICLES', TRUE, X'e19a0275f0dc4d22bb1c79af21cb6473');


insert into promo_codes (pc_id, promo_name, discount_amount, start_promo_date, end_promo_date, amount_of_users, unused_quantity)
values
    (X'f83d13cc42034a08a03d30a971d87e19', 'Black Friday',
     50, '2023-11-15 00:00:00', '2023-11-30 23:59:59', 30, 15),
    (X'62ae2a488c854f2eb7d891b374c94585', 'Spring Surprise',
     30, '2023-03-01 00:00:00', '2023-03-31 23:59:59', 40, 12);


insert into authorities (a_id, authority_name)
values
    (X'b30fdaec15f44df4a2d4cd4907f94a9a', 'Create customer profile'),
    (X'1a10d5483cf14c7c98235e30cf273ad4', 'Update customer profile'),
    (X'ff6b1bc11d0c4f0fb3e78be9ae76b986', 'View own orders'),
    (X'a6d7c8330fbf4bdcb07cb3bbd3d8d708', 'Place order'),
    (X'1563794ad97f4687bdc843952b6e107e', 'View customers'),
    (X'54e8699e8c944fcfa0a34ab0b2e17790', 'Process orders'),
    (X'9b3f68971e014792b56186ee800f8a0e', 'View orders'),
    (X'd354b3e7fc5a4c78bab90bf5947b2744', 'View reports'),
    (X'452c3b849eaf4e99a3d485a0eab5e6db', 'Authority management'),
    (X'e11df17df7d94729ba65c931e432b178', 'Role management'),
    (X'739a7fa5ff224f588f1dc2330bf32f89', 'User management'),
    (X'38241e7d1663458590e1d1dc6a8e3250', 'Admin access');

insert into roles (r_id, role_name)
values
    (X'e8e47c9584bb4262819f7eace92d5b7b', 'customer'),
    (X'1c7e315b38e14e899b5640c5098d3b8f', 'manager'),
    (X'ba26b7c508cb46c5bbf035203e269306', 'super manager'),
    (X'2057a26e3d3e4e8e84bcd3b9002de4f3', 'admin');


insert into authorities_roles (a_id, r_id)
values
    (X'b30fdaec15f44df4a2d4cd4907f94a9a', X'e8e47c9584bb4262819f7eace92d5b7b'),
    (X'1a10d5483cf14c7c98235e30cf273ad4', X'e8e47c9584bb4262819f7eace92d5b7b'),
    (X'ff6b1bc11d0c4f0fb3e78be9ae76b986', X'e8e47c9584bb4262819f7eace92d5b7b'),
    (X'a6d7c8330fbf4bdcb07cb3bbd3d8d708', X'e8e47c9584bb4262819f7eace92d5b7b'),
    (X'b30fdaec15f44df4a2d4cd4907f94a9a', X'1c7e315b38e14e899b5640c5098d3b8f'),
    (X'1a10d5483cf14c7c98235e30cf273ad4', X'1c7e315b38e14e899b5640c5098d3b8f'),
    (X'ff6b1bc11d0c4f0fb3e78be9ae76b986', X'1c7e315b38e14e899b5640c5098d3b8f'),
    (X'a6d7c8330fbf4bdcb07cb3bbd3d8d708', X'1c7e315b38e14e899b5640c5098d3b8f'),
    (X'1563794ad97f4687bdc843952b6e107e', X'1c7e315b38e14e899b5640c5098d3b8f'),
    (X'54e8699e8c944fcfa0a34ab0b2e17790', X'1c7e315b38e14e899b5640c5098d3b8f'),
    (X'9b3f68971e014792b56186ee800f8a0e', X'1c7e315b38e14e899b5640c5098d3b8f'),
    (X'b30fdaec15f44df4a2d4cd4907f94a9a', X'ba26b7c508cb46c5bbf035203e269306'),
    (X'1a10d5483cf14c7c98235e30cf273ad4', X'ba26b7c508cb46c5bbf035203e269306'),
    (X'ff6b1bc11d0c4f0fb3e78be9ae76b986', X'ba26b7c508cb46c5bbf035203e269306'),
    (X'a6d7c8330fbf4bdcb07cb3bbd3d8d708', X'ba26b7c508cb46c5bbf035203e269306'),
    (X'1563794ad97f4687bdc843952b6e107e', X'ba26b7c508cb46c5bbf035203e269306'),
    (X'54e8699e8c944fcfa0a34ab0b2e17790', X'ba26b7c508cb46c5bbf035203e269306'),
    (X'9b3f68971e014792b56186ee800f8a0e', X'ba26b7c508cb46c5bbf035203e269306'),
    (X'd354b3e7fc5a4c78bab90bf5947b2744', X'ba26b7c508cb46c5bbf035203e269306'),
    (X'b30fdaec15f44df4a2d4cd4907f94a9a', X'2057a26e3d3e4e8e84bcd3b9002de4f3'),
    (X'1a10d5483cf14c7c98235e30cf273ad4', X'2057a26e3d3e4e8e84bcd3b9002de4f3'),
    (X'ff6b1bc11d0c4f0fb3e78be9ae76b986', X'2057a26e3d3e4e8e84bcd3b9002de4f3'),
    (X'a6d7c8330fbf4bdcb07cb3bbd3d8d708', X'2057a26e3d3e4e8e84bcd3b9002de4f3'),
    (X'1563794ad97f4687bdc843952b6e107e', X'2057a26e3d3e4e8e84bcd3b9002de4f3'),
    (X'54e8699e8c944fcfa0a34ab0b2e17790', X'2057a26e3d3e4e8e84bcd3b9002de4f3'),
    (X'9b3f68971e014792b56186ee800f8a0e', X'2057a26e3d3e4e8e84bcd3b9002de4f3'),
    (X'd354b3e7fc5a4c78bab90bf5947b2744', X'2057a26e3d3e4e8e84bcd3b9002de4f3'),
    (X'452c3b849eaf4e99a3d485a0eab5e6db', X'2057a26e3d3e4e8e84bcd3b9002de4f3'),
    (X'e11df17df7d94729ba65c931e432b178', X'2057a26e3d3e4e8e84bcd3b9002de4f3'),
    (X'739a7fa5ff224f588f1dc2330bf32f89', X'2057a26e3d3e4e8e84bcd3b9002de4f3'),
    (X'38241e7d1663458590e1d1dc6a8e3250', X'2057a26e3d3e4e8e84bcd3b9002de4f3');

insert into users_info (ui_id, user_name, password, address, city, postal_code, email, card_number)
values
    (X'f8d7988476d343d48f2b880ff944e45b', 'ivan_ivanov', 'ubwuyt!529', 'Musterstrabe 123',
     'DREZDEN', '32415', 'ivanov@gmail.com', '1234 5678 9012 3452'),
    (X'ef6de8c01d7241cfae4a7498632c6929', 'petr_petrov', 'ybvmkgf&54091',
     '17 Rue de la Republique', 'PARIS', '76539', 'petrov@gmail.com', '4556 1148 0236 8949'),
    (X'146c6e2e97904a1f9a67f50fdcc61dd5', 'anna_belova', '6dj4kz3!jevh', '123 Main Street',
     'WASHINGTON', '52746', 'belova@gmail.com', '5238 7520 6917 0361'),
    (X'08ae72f74d3b4fb1bb0b1aaae6b4a8ed', 'svetlana_bolshova', '614274&gfdvbnh', '456 Oak Avenue',
     'DETROIT', '73098', 'bolshova@gmail.com', '3790 4606 1852 935'),
    (X'8da9be6181c6499d8a0f87416e3e5414', 'jurii_ostapov', '74567ygfds!', '789 Elm Street',
     'CHICAGO', '65473', 'ostapov@gmail.com', '6011 3530 9423 7768'),
    (X'a056a97b086343108e2570f46aa7aee7', 'grigorii_chernookov', '4321566&yfcvbhhgfc', 'Hauptstrabe 34',
     'BREMEN', '65437', 'chern@gmail.com', '4916 8497 2085 6137'),
    (X'c9fb87a6b0ff457ba6466b4a2a107396', 'julija_klimenko', '765000!fdbvytr', 'Rosenweg 7',
     'DREZDEN', '32546', 'klim@gmail.com', '3463 8895 2271 479'),
    (X'1fcff618540544a2b79dd5ac86a4779e', 'tatiana_kurilenko', '65487698*gfdsa', '25 Rue de la Republique',
     'LYON', '63579', 'kurila@gmail.com', '3749 6097 8113 254');


insert into users_info_roles (ui_id, r_id)
values
    (X'f8d7988476d343d48f2b880ff944e45b', X'2057a26e3d3e4e8e84bcd3b9002de4f3'),
    (X'f8d7988476d343d48f2b880ff944e45b', X'ba26b7c508cb46c5bbf035203e269306'),
    (X'f8d7988476d343d48f2b880ff944e45b', X'1c7e315b38e14e899b5640c5098d3b8f'),
    (X'f8d7988476d343d48f2b880ff944e45b', X'e8e47c9584bb4262819f7eace92d5b7b'),
    (X'ef6de8c01d7241cfae4a7498632c6929', X'ba26b7c508cb46c5bbf035203e269306'),
    (X'ef6de8c01d7241cfae4a7498632c6929', X'1c7e315b38e14e899b5640c5098d3b8f'),
    (X'ef6de8c01d7241cfae4a7498632c6929', X'e8e47c9584bb4262819f7eace92d5b7b'),
    (X'146c6e2e97904a1f9a67f50fdcc61dd5', X'1c7e315b38e14e899b5640c5098d3b8f'),
    (X'146c6e2e97904a1f9a67f50fdcc61dd5', X'e8e47c9584bb4262819f7eace92d5b7b'),
    (X'08ae72f74d3b4fb1bb0b1aaae6b4a8ed', X'e8e47c9584bb4262819f7eace92d5b7b'),
    (X'8da9be6181c6499d8a0f87416e3e5414', X'e8e47c9584bb4262819f7eace92d5b7b'),
    (X'a056a97b086343108e2570f46aa7aee7', X'e8e47c9584bb4262819f7eace92d5b7b'),
    (X'c9fb87a6b0ff457ba6466b4a2a107396', X'e8e47c9584bb4262819f7eace92d5b7b'),
    (X'1fcff618540544a2b79dd5ac86a4779e', X'e8e47c9584bb4262819f7eace92d5b7b');


insert into users (u_id, first_name, last_name, created_at, country, user_info)
values
    (X'b3cf89da79d242f88f4dfcb22aa43f96', 'Ivan', 'Ivanov', '2024-01-13 13:13:00',
     'GERMANY', X'f8d7988476d343d48f2b880ff944e45b'),
    (X'fd26dcd52ba44ac28ad983750a560746', 'Petr', 'Petrov', '2024-01-01 09:10:00',
     'FRANCE', X'ef6de8c01d7241cfae4a7498632c6929'),
    (X'56b45130bdd24c7fbd9b68e08dd481fb', 'Anna', 'Belova', '2024-01-02 09:10:00',
     'USA', X'146c6e2e97904a1f9a67f50fdcc61dd5'),
    (X'184bc3b168064924924d6a66b6bf91df', 'Svetlana', 'Bolshova', '2024-01-03 19:15:43',
     'USA', X'08ae72f74d3b4fb1bb0b1aaae6b4a8ed'),
    (X'a92e7e02b4804384b1db5c5f02e87c15', 'Jurii', 'Ostapov', '2024-01-04 10:15:43',
     'USA', X'8da9be6181c6499d8a0f87416e3e5414'),
    (X'6f5dc02d82d3443db59e35c4c4597080', 'Grigorii', 'Chernookov', '2024-01-05 11:19:49',
     'GERMANY', X'a056a97b086343108e2570f46aa7aee7'),
    (X'1b4a432d1ec94141ace11d6ed2e3de0f', 'Julija', 'Klimenko', '2024-01-07 12:20:49',
     'GERMANY', X'c9fb87a6b0ff457ba6466b4a2a107396'),
    (X'37e91890cf7143769bc98b4d94b11254', 'Tatiana', 'Kurilenko', '2024-01-08 13:20:49',
     'FRANCE', X'1fcff618540544a2b79dd5ac86a4779e');


insert into orders (o_id, user_id, order_date, promo_code_id, order_status)
values
    (X'b0e6d30d0e4d4694b7f33d40c788b2b1', X'184bc3b168064924924d6a66b6bf91df',
     '2023-11-21 13:20:49', X'f83d13cc42034a08a03d30a971d87e19', 'DELIVERED'),
    (X'ed0285f4452440f8bcf56cb23b7f81dc', X'1b4a432d1ec94141ace11d6ed2e3de0f',
     '2024-03-05 07:11:49', X'62ae2a488c854f2eb7d891b374c94585', 'DELIVERED');

insert into orders (o_id, user_id, order_date, order_status)
values
    (X'97bea1843e064f639c94ec65f00c823d', X'a92e7e02b4804384b1db5c5f02e87c15',
     '2024-02-02 16:10:49', 'DELIVERED'),
    (X'6b4e8a7c0f644fd8a37f5c0a072d14a2', X'6f5dc02d82d3443db59e35c4c4597080',
     '2024-02-10 17:11:49', 'SHIPPED'),
    (X'4eab43a7038548f3bfd34529a2bcfd51', X'37e91890cf7143769bc98b4d94b11254',
     '2024-02-26 07:11:49', 'PROCESSING');

insert into order_details (od_id, order_id, product_id, quantity, order_comment)
values
    (X'081ab92d687e4e24bc4dbd41f631dc21', X'97bea1843e064f639c94ec65f00c823d',
     X'3b287f306c1c4e71b7bf881e2d7b3cb4', 1, 'Prefer red color'),
    (X'081ab92d687e4e24bc4dbd41f631dc22', X'ed0285f4452440f8bcf56cb23b7f81dc',
     X'd10bb10eae564d3a91bc1961f2a29830', 2, 'I want first Barbie with pink hear and second in violet dress');

insert into order_details (od_id, order_id, product_id, quantity)
values
    (X'df3535a575a74a6498793e575194f4a0', X'b0e6d30d0e4d4694b7f33d40c788b2b1',
     X'ac5c8867676f4737931f052cbb9b4a94', 1),
    (X'25f00b1a33574dcbb01f0717db69b1fc', X'6b4e8a7c0f644fd8a37f5c0a072d14a2',
     X'9ac0037b2a2d4c269b8c15e720f0f8db', 1),
    (X'3f348f098910445e810d05fd8dd1a96d', X'4eab43a7038548f3bfd34529a2bcfd51',
     X'3b287f306c1c4e71b7bf881e2d7b3cb4', 1),
    (X'e41825613eb14f08b29bd816b8c394bb', X'4eab43a7038548f3bfd34529a2bcfd51',
     X'9ac0037b2a2d4c269b8c15e720f0f8db', 1);


insert into reviews (rv_id, user_id, product_id, review_date, review_title, content, rating)
values
    (X'a1d891b2d78d4bb5907becf6437e40af', X'184bc3b168064924924d6a66b6bf91df',
     X'ac5c8867676f4737931f052cbb9b4a94', '2023-11-25 17:11:49',
     'Good choice for a child',
     'The child plays with pleasure, the toy is safe, I recommend it as a gift', 'EXCELLENT'),
    (X'dd25f121d1674b968d0912528c53a50f', X'a92e7e02b4804384b1db5c5f02e87c15',
     X'3b287f306c1c4e71b7bf881e2d7b3cb4', '2024-02-05 13:11:34',
     'I was not happy with the purchase',
     'The wheels of the car immediately broke off, the build quality leaves much to be desired', 'UNSATISFACTORY'),
    (X'725d8b16b473481684cb13e90d7c4e65', X'6f5dc02d82d3443db59e35c4c4597080',
     X'9ac0037b2a2d4c269b8c15e720f0f8db', '2024-02-15 13:11:34',
     'My son is very happy with the purchase',
     'The boy does not let go of the car. The build quality and design of the toy are excellent. I will order a similar one for my younger child', 'EXCELLENT');






















