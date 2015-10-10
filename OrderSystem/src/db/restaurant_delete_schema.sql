ALTER TABLE uses_card DROP CONSTRAINT uses_card_number;
ALTER TABLE uses_card DROP CONSTRAINT customer_uses_card;
ALTER TABLE order_item DROP CONSTRAINT order_item_oid;
ALTER TABLE order_item DROP CONSTRAINT order_item_mid;
ALTER TABLE order_transaction DROP CONSTRAINT order_customer;

DROP TABLE uses_card;
DROP TABLE order_item;
DROP TABLE order_transaction;
DROP TABLE staff;
DROP TABLE credit_card;
DROP TABLE customer;
DROP TABLE menu_item;