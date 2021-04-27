#datos productos

INSERT INTO Product (id,code,description,name,photo,price,quantity,shippingCost) VALUES(1,'33256','talla 36','Zapatos formales para dama','https://firebasestorage.googleapis.com/v0/b/ingreso-egreso-app-461cd.appspot.com/o/zapatp1.gif?alt=media&token=805d5a18-9e41-497d-a132-4c3f5afdbaeb',60000.0,20.0,10000.0);
INSERT INTO Product (id,code,description,name,photo,price,quantity,shippingCost) VALUES(2,'33257','talla 40','Zapatos formales para dama','https://firebasestorage.googleapis.com/v0/b/ingreso-egreso-app-461cd.appspot.com/o/zapato2.gif?alt=media&token=c8aa5ea0-d2ba-4884-8acb-79d86968f126',50000.0,20.0,15000.0);
INSERT INTO Product	(id,code,description,name,photo,price,quantity,shippingCost) VALUES(3,'33258','talla 35','Zapatos formales para dama','https://firebasestorage.googleapis.com/v0/b/ingreso-egreso-app-461cd.appspot.com/o/zapato3.gif?alt=media&token=df4d1ecf-d812-4c51-aac9-cdb8a45aa52d',40000.0,20.0,20000.0);


#datos usuario para pruebas
# username = usuario
# password = 1234
INSERT INTO Account (username,email,fullname,password) VALUES ('usuario','prueba@prueba.com','usuario prueba','$2a$10$kX8SB17vwiNeZXdfrYQSauStkWMf0iLZYPmEfS6GtS5rlGkb/5vte');