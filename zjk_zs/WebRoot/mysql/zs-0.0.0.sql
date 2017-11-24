CREATE TABLE `admin` (
	id int PRIMARY KEY auto_increment,
	number VARCHAR(255),
	`password` VARCHAR(255),
	isdelete int DEFAULT 0,
	`status` int DEFAULT 0,
	createment bigint,
	createadminid int,
	updatetime bigint,
	updateadminid int
);
CREATE TABLE `enterprise` (
	id int PRIMARY KEY auto_increment,
	information text,
	qrcode VARCHAR(255),
	isconnect int DEFAULT 0,
	`status` int DEFAULT 0,
	isdelete int DEFAULT 0,
	number VARCHAR(255),
	`password` VARCHAR(255),
	createtime bigint,
	createadminid int,
	updatetime bigint,
	updateadminid int,
	`name` VARCHAR(255),
	phonenumber VARCHAR(255),
	address VARCHAR(255),
	company VARCHAR(255),
	`code` VARCHAR(255),
	role int
);
CREATE TABLE `employee`(
	id int PRIMARY KEY auto_increment,
	`name` VARCHAR(255),
	isdelete int DEFAULT 0,
	enterpriseid int,
	sex int,
	jobnumber VARCHAR(255),
	phonenumber VARCHAR(255),
	`status` int DEFAULT 0,
	number VARCHAR (255),
	`password` VARCHAR(255),
	createtime bigint,
	createenterpriseid int,
	updatetime bigint,
	updateenterpriseid int
);
CREATE TABLE `product`(
	id int PRIMARY KEY auto_increment,
	status int DEFAULT 0,
	isapply int,
	information text,
	ispackage int DEFAULT 0,
	isdelete int DEFAULT 0,
	rank int,
	`name` VARCHAR(255),
	version varchar (255),
	description text
);
CREATE TABLE `productproperty`(
	id int PRIMARY KEY auto_increment,
	`name` VARCHAR(255),
	`valre` VARCHAR(255),
	productid int,
	description text
);
CREATE TABLE `qrcode`(
	id int PRIMARY KEY auto_increment,
	qrcode VARCHAR(255),
	productid int,
	issell int DEFAULT 0,
	isevaluate int DEFAULT 0,
	evaluate1 VARCHAR(255),
	evaluate2 VARCHAR(255),
	evaluate3 VARCHAR(255),
	evaluate4 VARCHAR(255),
	phonenumber VARCHAR(255),
	selltime bigint,
	employeeid int,
	sellplace VARCHAR(255),
	appnumber VARCHAR(255),
	scannumber int,
	sonid int,
	parentid int,
	hasson int,
	hasparent int,
	soncount int
);
CREATE TABLE `qrcodeproperty`(
	id int PRIMARY KEY auto_increment,
	`name` VARCHAR(255),
	`value` VARCHAR(255),
	qrcodeid int,
	description text
);
CREATE TABLE `circulate`(
	id int PRIMARY KEY auto_increment,
	isdelete int DEFAULT 0,
	qrcodeid int,
	deliveremployeeid int,
	receiveemployeeid int,
	receiveenterpriseid int,
	isreceive int DEFAULT 0,
	delivertime bigint,
	receivetime bigint,
	deliverplace VARCHAR(255),
	receiveplace VARCHAR(255),
	sonid int,
	parentid int,
	hasson int,
	hasparent int
);
CREATE TABLE `waybill`(
	id int PRIMARY KEY auto_increment,
	qrcode VARCHAR(255),
	number VARCHAR(255),
	circulateid int
);
CREATE TABLE `logininformation`(
	id int PRIMARY KEY auto_increment,
	ip VARCHAR(255),
	time bigint,
	count int
);