CREATE DATABASE internet_shop
    WITH OWNER = postgres
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

\c internet_shop;

CREATE TABLE IF NOT EXISTS public.customers (
                                                id SERIAL PRIMARY KEY,
                                                first_name VARCHAR(50) NOT NULL,
                                                last_name VARCHAR(50) NOT NULL,
                                                patronymic VARCHAR(50),
                                                address VARCHAR(250) NOT NULL,
                                                phone_number VARCHAR(11) NOT NULL,
                                                email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS public.products (
                                               id SERIAL PRIMARY KEY,
                                               title VARCHAR(100) NOT NULL UNIQUE,
                                               price INT NOT NULL,
                                               weight INT NOT NULL,
                                               size VARCHAR(50) NOT NULL,
                                               description VARCHAR(250) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.login_info (
                                                 customer_id INT PRIMARY KEY,
                                                 username VARCHAR(50) NOT NULL UNIQUE,
                                                 password VARCHAR(50) NOT NULL,
                                                 role VARCHAR(50) NOT NULL,
                                                 FOREIGN KEY (customer_id) REFERENCES public.customers (id)
);

CREATE TABLE IF NOT EXISTS public.carts (
                                            customer_id INT NOT NULL,
                                            product_id INT NOT NULL,
                                            quantity INT NOT NULL,
                                            PRIMARY KEY (customer_id, product_id),
                                            FOREIGN KEY (customer_id) REFERENCES public.customers (id),
                                            FOREIGN KEY (product_id) REFERENCES public.products (id)
);

CREATE TABLE IF NOT EXISTS public.orders (
                                             id SERIAL PRIMARY KEY,
                                             customer_id INT NOT NULL,
                                             registration_date DATE NOT NULL,
                                             shipping_cost INT NOT NULL,
                                             order_cost INT NOT NULL,
                                             payment_method VARCHAR(50) NOT NULL,
                                             status VARCHAR(50) NOT NULL,
                                             FOREIGN KEY (customer_id) REFERENCES public.customers (id)
);

CREATE TABLE IF NOT EXISTS public.order_products (
                                                     order_id INT NOT NULL,
                                                     product_id INT NOT NULL,
                                                     quantity INT NOT NULL,
                                                     PRIMARY KEY (order_id, product_id),
                                                     FOREIGN KEY (order_id) REFERENCES public.orders (id),
                                                     FOREIGN KEY (product_id) REFERENCES public.products (id)
);
