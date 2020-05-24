DROP TABLE IF EXISTS user;
CREATE TABLE user
(
  id BIGINT IDENTITY PRIMARY KEY,
  first_name VARCHAR(32) COMMENT 'first name',
  last_name VARCHAR(32) COMMENT 'last name',
  area_code VARCHAR(8)  COMMENT 'area code',
  phone_number VARCHAR(16)  COMMENT 'phone number',
  username VARCHAR(128)  COMMENT 'username',
  password VARCHAR(128)  COMMENT 'password',
  create_time TIMESTAMP
);

DROP TABLE IF EXISTS car_model;
CREATE TABLE car_model
(
  id INT IDENTITY PRIMARY KEY,
  name VARCHAR(30) NOT NULL COMMENT 'model name',
  create_time TIMESTAMP
);

DROP TABLE IF EXISTS car;
CREATE TABLE car
(
  id INT IDENTITY PRIMARY KEY ,
  license_number VARCHAR(30) NOT NULL COMMENT 'car name',
  model_id INT NOT NULL COMMENT 'model id',
  status TINYINT DEFAULT 0 COMMENT 'rental status',
  deleted BOOLEAN  DEFAULT 0 COMMENT 'car health scraped',
  create_time TIMESTAMP
);

DROP TABLE IF EXISTS car_storage;
CREATE TABLE car_storage
(
  id INT IDENTITY PRIMARY KEY,
  model_id INT NOT NULL COMMENT 'model id',
  model_name VARCHAR(30) NOT NULL COMMENT 'model name',
  in_stock_quantity INT NOT NULL COMMENT 'in stock quantity',
  create_time TIMESTAMP
);

DROP TABLE IF EXISTS rental_record;
CREATE TABLE rental_record
(
  id BIGINT IDENTITY PRIMARY KEY,
  user_id BIGINT NOT NULL COMMENT 'user id',
  licence_number VARCHAR(30)  COMMENT 'car id',
  model_id INT NOT NULL COMMENT 'car model id',
  term_start_time TIMESTAMP,
  term_end_time TIMESTAMP,
  create_time TIMESTAMP
);