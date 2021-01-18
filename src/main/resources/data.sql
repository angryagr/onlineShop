INSERT INTO users (id, first_name, last_name, email, password, phone) VALUES (5, 'User1', 'Green', 'user1@mail.com', '$2a$10$CJgEoobU2gm0euD4ygru4ukBf9g8fYnPrMvYk.q0GMfOcIDtUhEwC','+380500320123');
INSERT INTO users (id, first_name, last_name, email, password, phone) VALUES (6, 'User2', 'White', 'user2@mail.com', '$2a$10$yYQaJrHzjOgD5wWCyelp0e1Yv1KEKeqUlYfLZQ1OQvyUrnEcX/rOy','+380500320124');
INSERT INTO users (id, first_name, last_name, email, password, phone) VALUES (4, 'User3', 'Brown', 'user3@mail.com', '$2a$10$CdEJ2PKXgUCIwU4pDQWICuiPjxb1lysoX7jrN.Y4MTMoY9pjfPALO','+380500320122');

INSERT INTO bills (id, issue_date, due_date, end_sum) VALUES (1, '2020-09-16', '2020-09-20', 489.2);
INSERT INTO bills (id, issue_date, due_date, end_sum) VALUES (2, '2020-09-16', '2020-09-20', 444.4);
INSERT INTO bills (id, issue_date, due_date, end_sum) VALUES (3, '2020-09-16', '2020-09-20', 498.2);
INSERT INTO bills (id, issue_date, due_date, end_sum) VALUES (4, '2020-09-16', '2020-09-20', 599.4);

INSERT INTO orders (id, order_date, end_sum, order_status, bill_id) VALUES (6, '2020-09-16', 489.22, 'NEW', 1);
INSERT INTO orders (id, order_date, end_sum, order_status, bill_id) VALUES (5, '2020-09-16', 789.22, 'PROCESSING', 2);
INSERT INTO orders (id, order_date, end_sum, order_status, bill_id) VALUES (7, '2020-09-16', 485.22, 'SHIPPING', 3);
INSERT INTO orders (id, order_date, end_sum, order_status, bill_id) VALUES (8, '2020-09-17', 487.22, 'DELIVERED', 4);

INSERT INTO products (id, name, price, quantity, description, order_id) VALUES (5, 'Product1', 32.45, 1,'Description1', 6);
INSERT INTO products (id, name, price, quantity, description, order_id) VALUES (6, 'Product2', 123.55, 2, 'Description2', 5);
INSERT INTO products (id, name, price, quantity, description, order_id) VALUES (7, 'Product3', 34.56, 4, 'Description3', 7);
INSERT INTO products (id, name, price, quantity, description, order_id) VALUES (8, 'Product4', 234.45, 7, 'Description4', 8);

INSERT INTO addresses (id, street, street_number, zip_code, city, country, phone, user_id) VALUES (7, 'Street1', '1a', 12345, 'City1', 'Country1', '+1234567891', 5);
INSERT INTO addresses (id, street, street_number, zip_code, city, country, phone, user_id) VALUES (4, 'Street2', '2a', 12345, 'City2', 'Country2', '+9876543211', 6);
INSERT INTO addresses (id, street, street_number, zip_code, city, country, phone, user_id) VALUES (10, 'Street3', '3a', 12345, 'City3', 'Country3', '+4567891231', 4);

INSERT INTO user_address (user_id, address_id) VALUES (5, 7);
INSERT INTO user_address (user_id, address_id) VALUES (4, 7);
INSERT INTO user_address (user_id, address_id) VALUES (6, 4);
INSERT INTO user_address (user_id, address_id) VALUES (5, 4);
INSERT INTO user_address (user_id, address_id) VALUES (4, 10);
INSERT INTO user_address (user_id, address_id) VALUES (4, 4);

