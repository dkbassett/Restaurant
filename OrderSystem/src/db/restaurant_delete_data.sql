DELETE FROM menu_item;
DELETE FROM customer;
DELETE FROM credit_card;
DELETE FROM staff;

ALTER TABLE order_transaction DROP CONSTRAINT order_customer;
ALTER TABLE order_item DROP CONSTRAINT order_item_oid;
ALTER TABLE order_item DROP CONSTRAINT order_item_mid;
ALTER TABLE uses_card DROP CONSTRAINT uses_card_number;
ALTER TABLE uses_card DROP CONSTRAINT customer_uses_card;

DELETE FROM order_transaction;
DELETE FROM order_item;
DELETE FROM uses_card;

DELETE FROM mitem_id_seq;
DELETE FROM cust_id_seq;

ALTER TABLE order_transaction ADD CONSTRAINT order_customer
	FOREIGN KEY (customer_id) REFERENCES customer(id);

ALTER TABLE order_item ADD CONSTRAINT order_item_mid
	FOREIGN KEY (mid) REFERENCES menu_item(id);

ALTER TABLE order_item ADD CONSTRAINT order_item_oid
	FOREIGN KEY (oid) REFERENCES order_transaction(oid);

ALTER TABLE uses_card ADD CONSTRAINT customer_uses_card
	FOREIGN KEY (cid) REFERENCES customer(id);

ALTER TABLE uses_card ADD CONSTRAINT uses_card_number
	FOREIGN KEY (cr_number,cr_exp) REFERENCES credit_card(cr_number,exp);