INSERT INTO car_model (id, name) VALUES
  (1,'Toyota Camry'),(2,'BMW 650');

INSERT INTO car_storage(id, model_id, model_name, in_stock_quantity, create_time)
VALUES  (1,1,'Toyota Camry',2,CURRENT_TIMESTAMP());
INSERT INTO car_storage(id, model_id, model_name, in_stock_quantity, create_time)
VALUES  (2,2,'BMW 650',2,parsedatetime('2020-05-24 15:18:13', 'yyyy-MM-dd hh:mm:ss'));


INSERT INTO car(id, license_number, model_id, status, deleted, create_time)
VALUES (1,'粤B1111',1,0,false,CURRENT_TIMESTAMP());
INSERT INTO car(id, license_number, model_id, status, deleted, create_time)
VALUES (2,'粤B2222',1,0,false,CURRENT_TIMESTAMP());
INSERT INTO car(id, license_number, model_id, status, deleted, create_time)
VALUES (3,'粤B3333',2,0,false,CURRENT_TIMESTAMP());
INSERT INTO car(id, license_number, model_id, status, deleted, create_time)
VALUES (4,'粤B4444',2,0,false,CURRENT_TIMESTAMP());