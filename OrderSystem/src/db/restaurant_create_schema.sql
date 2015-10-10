CREATE TABLE menu_item (
	id	varchar(3)	not null,	/* primary key */
	name	varchar(50)	not null,
	price	number(4,2)	not null,
	PRIMARY KEY (id)
);

CREATE SEQUENCE mitem_id_seq;

CREATE TRIGGER trg_mitem_id
	BEFORE INSERT ON menu_item
	FOR EACH ROW
BEGIN
	SELECT mitem_id_seq.NEXTVAL
	INTO :new.id
	FROM dual;
END;
/

CREATE TABLE customer (
	id		varchar(7)	not null,	/* primary key */
	name		varchar(100)	not null,
	address		varchar(200)	not null,
	phone_no	number(12)	not null,
	PRIMARY KEY (id)	
);

CREATE SEQUENCE cust_id_seq;

CREATE TRIGGER trg_cust_id
	BEFORE INSERT ON customer
	FOR EACH ROW
BEGIN
	SELECT cust_id_seq.NEXTVAL
	INTO :new.id
	FROM dual;
END;
/

CREATE TABLE credit_card (
	cr_number	varchar(19)	not null,	/* primary key */
	exp		date		not null,	/* primary key */
	cr_holder	varchar(100)	not null,
	cr_provider	varchar(50)	not null,
	PRIMARY KEY (cr_number,exp)	
);

CREATE TABLE staff (
	sid		varchar(3)	not null,	/* primary key */
	name		varchar(50)	not null,	
	password	char(8)		not null,
	PRIMARY KEY (sid)	
);

CREATE TABLE order_transaction (
	oid		varchar(4)	not null,	/* primary key */
	customer_id	varchar(7)	not null,
	delivery_type	varchar(13)	not null,
	date_ordered	timestamp	not null,
	total		number(5,2)	not null,
	CONSTRAINT	chk_delivery	CHECK (delivery_type='take-away' OR delivery_type='home delivery'), 
	PRIMARY KEY (oid)	
);

ALTER TABLE order_transaction ADD CONSTRAINT order_customer
	FOREIGN KEY (customer_id) REFERENCES customer(id);

CREATE TABLE order_item (
	mid		varchar(3)	not null,	/* primary key */
	oid		varchar(4)	not null,	/* primary key */
	quantity	number(3)	not null,
	PRIMARY KEY (mid,oid)	
);

ALTER TABLE order_item ADD CONSTRAINT order_item_mid
	FOREIGN KEY (mid) REFERENCES menu_item(id);

ALTER TABLE order_item ADD CONSTRAINT order_item_oid
	FOREIGN KEY (oid) REFERENCES order_transaction(oid);

CREATE TABLE uses_card (
	cid		varchar(7)	not null,	/* primary key */
	cr_number	varchar(19)	not null,	/* primary key */
	cr_exp		date		not null,	/* primary key */
	PRIMARY KEY (cid,cr_number,cr_exp)	
);

ALTER TABLE uses_card ADD CONSTRAINT customer_uses_card
	FOREIGN KEY (cid) REFERENCES customer(id);

ALTER TABLE uses_card ADD CONSTRAINT uses_card_number
	FOREIGN KEY (cr_number,cr_exp) REFERENCES credit_card(cr_number,exp);