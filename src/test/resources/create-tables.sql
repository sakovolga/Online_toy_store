CREATE TABLE IF NOT EXISTS suppliers (
    s_id          binary(16) NOT NULL,
    supplier_name varchar(128) NOT NULL,
    phone         varchar(128) NOT NULL,
    email         varchar(128) NOT NULL,
    address       varchar(128) NOT NULL,
    city          varchar(128) NOT NULL,
    postal_code   varchar(128) NOT NULL,
    country       varchar(128) NOT NULL,
    PRIMARY KEY (s_id)
);

CREATE TABLE IF NOT EXISTS products (
    p_id	binary(16),
    product_name varchar(256) NOT NULL,
    description	text NOT NULL,
    price	double NOT NULL,
    available_quantity int NOT NULL,
    category varchar(256) NOT NULL,
    is_available boolean NOT NULL,
    supplier_id	binary(16) NOT NULL,
    PRIMARY KEY (p_id),
    FOREIGN KEY (supplier_id) REFERENCES suppliers (s_id)
);

CREATE TABLE IF NOT EXISTS promo_codes (
    pc_id	binary(16) NOT NULL,
    promo_name	varchar(128) NOT NULL,
    discount_amount	double NOT NULL,
    start_promo_date	timestamp NOT NULL,
    end_promo_date	timestamp NOT NULL,
    amount_of_users	int NOT NULL,
    unused_quantity	int NOT NULL,
    PRIMARY KEY (pc_id)
);

CREATE TABLE IF NOT EXISTS authorities (
    a_id binary(16) NOT NULL,
    authority_name	varchar(128) NOT NULL,
    PRIMARY KEY (a_id)
);

CREATE TABLE IF NOT EXISTS roles (
    r_id binary(16) NOT NULL,
    role_name varchar(128) NOT NULL,
    PRIMARY KEY (r_id)
);

CREATE TABLE IF NOT EXISTS authorities_roles (
    a_id binary(16) NOT NULL,
    r_id binary(16) NOT NULL,
    PRIMARY KEY (a_id, r_id),
    FOREIGN KEY (a_id) REFERENCES authorities (a_id),
    FOREIGN KEY (r_id) REFERENCES roles (r_id)
);

CREATE TABLE IF NOT EXISTS users_info (
    ui_id	binary(16) NOT NULL,
    user_name	varchar(128) NOT NULL,
    password	varchar(128) NOT NULL,
    address	varchar(128) NOT NULL,
    city	varchar(128) NOT NULL,
    postal_code	varchar(128) NOT NULL,
    email	varchar(128) NOT NULL,
    card_number	varchar(128),
    PRIMARY KEY (ui_id)
);

CREATE TABLE IF NOT EXISTS users_info_roles (
    ui_id binary(16) NOT NULL,
    r_id binary(16) NOT NULL,
    PRIMARY KEY (ui_id, r_id),
    FOREIGN KEY (ui_id) REFERENCES users_info (ui_id),
    FOREIGN KEY (r_id) REFERENCES roles (r_id)
);

CREATE TABLE IF NOT EXISTS users (
    u_id	binary(16) NOT NULL,
    first_name	varchar(128) NOT NULL,
    last_name	varchar(128) NOT NULL,
    created_at	timestamp NOT NULL,
    country	varchar(128) NOT NULL,
    user_info	binary(16) NOT NULL,
    PRIMARY KEY (u_id),
    FOREIGN KEY (user_info) REFERENCES users_info (ui_id)
);

CREATE TABLE IF NOT EXISTS orders (
    o_id	binary(16),
    user_id	binary(16),
    order_date	timestamp NOT NULL,
    promo_code_id	binary(16),
    order_status	varchar(128) NOT NULL,
    PRIMARY KEY (o_id),
    FOREIGN KEY (user_id) REFERENCES users (u_id),
    FOREIGN KEY (promo_code_id) REFERENCES promo_codes (pc_id)
);

CREATE TABLE IF NOT EXISTS order_details (
    od_id	binary(16) NOT NULL,
    order_id	binary(16),
    product_id	binary(16),
    quantity	int NOT NULL,
    order_comment	text,
    PRIMARY KEY (od_id),
    FOREIGN KEY (order_id) REFERENCES orders (o_id),
    FOREIGN KEY (product_id) REFERENCES products (p_id)
);

CREATE TABLE IF NOT EXISTS reviews (
    rv_id	binary(16) NOT NULL,
    user_id	binary(16) NOT NULL,
    product_id	binary(16) NOT NULL,
    review_date	timestamp NOT NULL,
    review_title	varchar(256),
    content	text,
    rating	varchar(128),
    PRIMARY KEY (rv_id),
    FOREIGN KEY (user_id) REFERENCES users (u_id),
    FOREIGN KEY (product_id) REFERENCES products (p_id)
)
