BEGIN

CREATE TABLE t_user (
    id VARCHAR(255) PRIMARY KEY NOT NULL,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(25) NOT NULL, 
)

CREATE TABLE t_account (
    id VARCHAR(255) PRIMARY KEY NOT NULL,
    phone_number VARCHAR(12),
    rank VARCHAR(255) NOT NULL,
    address_id VARCHAR(255) NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES t_user(id) 
)

CREATE TABLE t_role (
    id VARCHAR(255) PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES t_user(id) 
)

CREATE TABLE t_address (
    id VARCHAR(255) PRIMARY KEY NOT NULL,
    country VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    street VARCHAR(150),
    postal_code NUMERIC NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES t_user(id)  
)

END