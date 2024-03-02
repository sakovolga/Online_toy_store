# Online shop Project [Backend]

 There is a prototype of the BackEnd Online Shop's Core Services data.
 
 Data consist of products, orders, order_details, customers, reviews, suppliers, promocodes.
 ___
 
## Database structure

### Table products ( Online store products )

| Column name        | Type         | Description                                   |
|--------------------|--------------|-----------------------------------------------|
| p_id               | binary16     | id key of row - unique, not null, primary key |
| name               | varchar(256) | Product name                                  |
| description        | text         | Product description                           |
| price              | double       | Price                                         |
| available_quantity | int          | Available quantity                            |
| category           | varchar(256) | Category                                      |
| is_available       | boolean      | Product availability for sale                 |
| supplier_id        | binary16     | Supplier                                      |
| date_of_delivery   | timestamp    | Date of delivery of goods to the store        |


### Table orders ( Сompleted orders )

| Column name  | Type         | Description                                   |
|--------------|--------------|-----------------------------------------------|
| o_id         | binary16     | id key of row - unique, not null, primary key |
| customer_id  | binary16     | The customer who placed the order             |
| order_date   | timestamp    | Order date                                    |
| promocode_id | binary16     | Promo code applied                            |
| order_status | varchar(128) | Order status                                  |



### Table order_details ( Individual items in the order )

| Column name   | Type     | Description                                   |
|---------------|----------|-----------------------------------------------|
| od_id         | binary16 | id key of row - unique, not null, primary key |
| order_id      | binary16 | Order containing this item                    |
| product_id    | binary16 | Product id                                    |
| quantity      | int      | Number of product units in the order          |
| order_comment | text     | Comment about the product                     |



### Table customers ( Online store customers )

| Column name | Type         | Description                                   |
|-------------|--------------|-----------------------------------------------|
| c_id        | binary16     | id key of row - unique, not null, primary key |
| first_name  | varchar(128) | Customer's first name                         |
| last_name   | varchar(128) | Customer's last name                          |
| address     | varchar(128) | Customer's address                            |
| city        | varchar(128) | Customer's city                               |
| postalCode  | varchar(128) | Customer's postalCode                         |
| country     | varchar(128) | Customer's country                            |
| card_number | varchar(128) | Customer's cardNumber                         |



### Table reviews ( User reviews for products )

| Column name  | Type         | Description                                   |
|--------------|--------------|-----------------------------------------------|
| r_id         | binary16     | id key of row - unique, not null, primary key |
| customer_id  | binary16     | Customer who left a review                    |
| product_id   | binary16     | Reviewed product                              |
| review_date  | timestamp    | Review date                                   |
| review_title | varchar(256) | Review title                                  |
| content      | text         | Review content                                |
| rating       | varchar(128) | Product rating                                |
| card_number  | varchar(128) | Customer's cardNumber                         |



### Table suppliers ( Product suppliers )

| Column name  | Type         | Description                                   |
|--------------|--------------|-----------------------------------------------|
| s_id         | binary16     | id key of row - unique, not null, primary key |
| name         | varchar(128) | Supplier's name                               |
| contact_name | varchar(128) | Supplier's contact person                     |
| phone        | varchar(128) | Supplier's phone                              |
| address      | varchar(128) | Supplier's address                            |
| city         | varchar(128) | Supplier's city                               |
| postal_code  | varchar(128) | Supplier's postal code                        |
| country      | varchar(128) | Supplier's country                            |



### Table promocodes ( Promo codes for discounts )

| Column name      | Type         | Description                                                        |
|------------------|--------------|--------------------------------------------------------------------|
| pc_id            | binary16     | id key of row - unique, not null, primary key                      |
| promo_name       | varchar(128) | Promo code name                                                    |
| discount_amount  | double       | Discount amount                                                    |
| start_promo_date | timestamp    | Promotion start date                                               |
| end_promo_date   | timestamp    | Promotion end date                                                 |
| amount_of_users  | int          | Maximum number of customers who can take advantage of the discount |
| unused_quantity  | int          | Number of promo code units available for use                       |




