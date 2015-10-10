INSERT INTO customer VALUES
	(1, 'John Smith', '44 Longview Drive, Mt Gravatt, QLD', '555444333');
INSERT INTO Customer VALUES
	(2, 'Jane Doe', '33 Riverside Avenue, Sunnybank, QLD', '111222333');
INSERT INTO Customer VALUES
	(3, 'Joe Bloggs', '22 Northwood Road, Annerley, QLD', '777888999');


INSERT INTO credit_card VALUES
	('324345982094', TO_DATE('01/17', 'mm/yy'), 'John Smith', 'VISA');
INSERT INTO credit_card VALUES
	('984358209821', TO_DATE('04/18', 'mm/yy'), 'Jane Doe', 'VISA');
INSERT INTO credit_card VALUES
	('457923492092', TO_DATE('05/17', 'mm/yy'), 'Ron Doe', 'MasterCard');


INSERT INTO uses_card VALUES
	(1, '324345982094', TO_DATE('01/17', 'mm/yy'));
INSERT INTO uses_card VALUES
	(2, '984358209821', TO_DATE('04/18', 'mm/yy'));
INSERT INTO uses_card VALUES
	(2, '457923492092', TO_DATE('05/17', 'mm/yy'));

INSERT INTO menu_item VALUES
	(1, 'Combination Chow Mein', 12.50);
INSERT INTO menu_item VALUES
	(2, 'Sweet and Sour Pork', 11.00);
INSERT INTO menu_item VALUES
	(3, 'Seafood Ho Fun', 14.50);
INSERT INTO menu_item VALUES
	(4, 'Shredded Duck and Preserved Veg', 12.50);
INSERT INTO menu_item VALUES
	(4, 'Hokkien Noodle', 12.50);