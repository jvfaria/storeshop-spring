CREATE TABLE IF NOT EXISTS categories
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(256) NOT NULL
);
CREATE TABLE IF NOT EXISTS products
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(256) NOT NULL,
    description VARCHAR(256) NOT NULL ,
    stock_balance BIGINT NOT NULL,
    price DECIMAL(8,2) NOT NULL,
    category_id SERIAL NOT NULL,
    CONSTRAINT fk_category_id FOREIGN KEY (category_id)
        REFERENCES categories(id) ON DELETE SET NULL ON UPDATE SET NULL
);
CREATE TABLE IF NOT EXISTS clients
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(256) NOT NULL,
    email VARCHAR(256) NOT NULL
);
CREATE TABLE IF NOT EXISTS sales
(
    id   SERIAL PRIMARY KEY,
    date TIMESTAMP NOT NULL,
    client_id SERIAL NOT NULL,
    CONSTRAINT  fk_client_id FOREIGN KEY (client_id)
        REFERENCES clients(id) ON DELETE SET NULL ON UPDATE SET NULL

);