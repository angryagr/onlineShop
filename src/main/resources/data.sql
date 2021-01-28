INSERT INTO users (id, first_name, last_name, email, password, phone) VALUES (5, 'User1', 'Green', 'user1@mail.com', '$2a$10$CJgEoobU2gm0euD4ygru4ukBf9g8fYnPrMvYk.q0GMfOcIDtUhEwC','+380500320123');
INSERT INTO users (id, first_name, last_name, email, password, phone) VALUES (6, 'User2', 'White', 'user2@mail.com', '$2a$10$yYQaJrHzjOgD5wWCyelp0e1Yv1KEKeqUlYfLZQ1OQvyUrnEcX/rOy','+380500320124');
INSERT INTO users (id, first_name, last_name, email, password, phone) VALUES (4, 'User3', 'Brown', 'user3@mail.com', '$2a$10$CdEJ2PKXgUCIwU4pDQWICuiPjxb1lysoX7jrN.Y4MTMoY9pjfPALO','+380500320122');

INSERT INTO orders (id, order_date, end_sum, order_status) VALUES (6, '2020-09-16', 489.22, 'NEW');
INSERT INTO orders (id, order_date, end_sum, order_status) VALUES (5, '2020-09-16', 789.22, 'PROCESSING');
INSERT INTO orders (id, order_date, end_sum, order_status) VALUES (7, '2020-09-16', 485.22, 'SHIPPING');
INSERT INTO orders (id, order_date, end_sum, order_status) VALUES (8, '2020-09-17', 487.22, 'DELIVERED');

INSERT INTO products (id, name, price, description) VALUES (5, 'Product1', 32.45,'Description1');
INSERT INTO products (id, name, price, description) VALUES (6, 'Product2', 123.55, 'Description2');
INSERT INTO products (id, name, price, description) VALUES (7, 'Product3', 34.56, 'Description3');
INSERT INTO products (id, name, price, description) VALUES (8, 'Product4', 234.45, 'Description4');

INSERT INTO addresses (id, street, street_number, zip_code, city, country, phone, user_id) VALUES (7, 'Street1', '1a', 12345, 'City1', 'Country1', '+1234567891', 5);
INSERT INTO addresses (id, street, street_number, zip_code, city, country, phone, user_id) VALUES (4, 'Street2', '2a', 12345, 'City2', 'Country2', '+9876543211', 6);
INSERT INTO addresses (id, street, street_number, zip_code, city, country, phone, user_id) VALUES (10, 'Street3', '3a', 12345, 'City3', 'Country3', '+4567891231', 4);

INSERT INTO user_address (user_id, address_id) VALUES (5, 7);
INSERT INTO user_address (user_id, address_id) VALUES (4, 7);
INSERT INTO user_address (user_id, address_id) VALUES (6, 4);
INSERT INTO user_address (user_id, address_id) VALUES (5, 4);
INSERT INTO user_address (user_id, address_id) VALUES (4, 10);
INSERT INTO user_address (user_id, address_id) VALUES (4, 4);

