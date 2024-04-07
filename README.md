# Online toy store Project [Backend]

 There is a prototype of the BackEnd Online Shop's Core Services data.
 
 Data consist of products, orders, order_details, users, users_info, roles, authorities, reviews, suppliers, promocodes.
 ___
 
## Database structure

### Table products ( Online store products )

| Column name        | Type         | Description                                   |
|--------------------|--------------|-----------------------------------------------|
| p_id               | binary(16)   | id key of row - unique, not null, primary key |
| product_name       | varchar(256) | Product name                                  |
| description        | text         | Product description                           |
| price              | decimal      | Price                                         |
| available_quantity | int          | Available quantity                            |
| category           | varchar(256) | Category                                      |
| is_available       | boolean      | Product availability for sale                 |
| supplier_id        | binary(16)   | Supplier                                      |


### Table orders ( Completed orders )

| Column name   | Type         | Description                                   |
|---------------|--------------|-----------------------------------------------|
| o_id          | binary(16)   | id key of row - unique, not null, primary key |
| user_id       | binary(16)   | The user who placed the order                 |
| order_date    | timestamp    | Order date                                    |
| promo_code_id | binary(16)   | Promo code applied                            |
| order_status  | varchar(128) | Order status                                  |



### Table order_details ( Individual items in the order )

| Column name   | Type       | Description                                   |
|---------------|------------|-----------------------------------------------|
| od_id         | binary(16) | id key of row - unique, not null, primary key |
| order_id      | binary(16) | Order containing this item                    |
| product_id    | binary(16) | Product id                                    |
| quantity      | int        | Number of product units in the order          |
| order_comment | text       | Comment about the product                     |



### Table users ( Users registered in the system )

| Column name | Type         | Description                                   |
|-------------|--------------|-----------------------------------------------|
| u_id        | binary(16)   | id key of row - unique, not null, primary key |
| first_name  | varchar(128) | User's first name                             |
| last_name   | varchar(128) | User's  last name                             |
| created_at  | timestamp    | Registration date                             |
| country     | varchar(128) | User's country                                |
| user_info   | binary(16)   | Personal data of user                         |



### Table users_info ( Personal data of users )

| Column name | Type         | Description                                   |
|-------------|--------------|-----------------------------------------------|
| ui_id       | binary(16)   | id key of row - unique, not null, primary key |
| user_name   | varchar(128) | User's unique name                            |
| password    | varchar(128) | Password                                      |
| address     | varchar(128) | User's address                                |
| city        | varchar(128) | User's city                                   |
| postal_code | varchar(128) | User's postalCode                             |
| email       | varchar(128) | User's email                                  |
| card_number | varchar(128) | User's cardNumber                             |



### Table roles ( User roles in the system )

| Column name | Type         | Description                                   |
|-------------|--------------|-----------------------------------------------|
| r_id        | binary(16)   | id key of row - unique, not null, primary key |
| role_name   | varchar(128) | Role in the system                            |



### Table authorities ( User rights in the system )

| Column name    | Type         | Description                                   |
|----------------|--------------|-----------------------------------------------|
| a_id           | binary(16)   | id key of row - unique, not null, primary key |
| authority_name | varchar(128) | Right in the system                           |



### Table reviews ( User reviews for products )

| Column name  | Type         | Description                                   |
|--------------|--------------|-----------------------------------------------|
| rv_id        | binary(16)   | id key of row - unique, not null, primary key |
| user_id      | binary(16)   | User who left a review                        |
| product_id   | binary(16)   | Reviewed product                              |
| review_date  | timestamp    | Review date                                   |
| review_title | varchar(256) | Review title                                  |
| content      | text         | Review content                                |
| rating       | varchar(128) | Product rating                                |



### Table suppliers ( Product suppliers )

| Column name   | Type         | Description                                   |
|---------------|--------------|-----------------------------------------------|
| s_id          | binary(16)   | id key of row - unique, not null, primary key |
| supplier_name | varchar(128) | Supplier's name                               |
| phone         | varchar(128) | Supplier's phone                              |
| email         | varchar(128) | Supplier's email                              |
| address       | varchar(128) | Supplier's address                            |
| city          | varchar(128) | Supplier's city                               |
| postal_code   | varchar(128) | Supplier's postal code                        |
| country       | varchar(128) | Supplier's country                            |



### Table promo_codes ( Promo codes for discounts )

| Column name      | Type         | Description                                                        |
|------------------|--------------|--------------------------------------------------------------------|
| pc_id            | binary(16)   | id key of row - unique, not null, primary key                      |
| promo_name       | varchar(128) | Promo code name                                                    |
| discount_amount  | double       | Discount amount                                                    |
| start_promo_date | timestamp    | Promotion start date                                               |
| end_promo_date   | timestamp    | Promotion end date                                                 |
| amount_of_users  | int          | Maximum number of customers who can take advantage of the discount |
| unused_quantity  | int          | Number of promo code units available for use                       |




