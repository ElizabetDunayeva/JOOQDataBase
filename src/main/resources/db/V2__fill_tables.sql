INSERT INTO Organizations(Name,INN,Account)VALUES('Organization1',4270,12);

INSERT INTO Organizations(Name,INN,Account)VALUES('Organization2',4230,13);

INSERT INTO Organizations(Name,INN,Account)VALUES('Organization3',4210,14);

INSERT INTO Organizations(Name,INN,Account)VALUES('Organization4',4250,200);

INSERT INTO Organizations(Name,INN,Account)VALUES('Organization5',4280,120);

INSERT INTO Organizations(Name,INN,Account)VALUES('Organization6',4239,121);

INSERT INTO Organizations(Name,INN,Account)VALUES('Organization7',4232,132);

INSERT INTO Organizations(Name,INN,Account)VALUES('Organization8',42160,143);

INSERT INTO Organizations(Name,INN,Account)VALUES('Organization9',4259,2004);

INSERT INTO Organizations(Name,INN,Account)VALUES('Organization10',4281,1208);

INSERT INTO Nomenclatures(Name, Cod_ID)VALUES('Product1',1);

INSERT INTO Nomenclatures(Name, Cod_ID)VALUES('Product2',2);

INSERT INTO Nomenclatures(Name, Cod_ID)VALUES('Product3',3);

INSERT INTO Nomenclatures(Name, Cod_ID)VALUES('Product4',4);

INSERT INTO Nomenclatures(Name, Cod_ID)VALUES('Product5',5);

INSERT INTO Invoices(Number, Date_of,Organization_ID)VALUES(1,'2019-12-04',4210);
INSERT INTO Invoices(Number, Date_of,Organization_ID)VALUES(2,'2019-10-04',4250);
INSERT INTO Invoices(Number, Date_of,Organization_ID)VALUES(3,'2019-09-04',4239);
INSERT INTO Invoices(Number, Date_of,Organization_ID)VALUES(4,'2019-08-04',4210);
INSERT INTO Invoices(Number, Date_of,Organization_ID)VALUES(5,'2019-12-20',4270);
INSERT INTO Invoices(Number, Date_of,Organization_ID)VALUES(6,'2019-07-04',4281);

INSERT INTO Positions(Price,Nomenclature_ID,Amount,Number_Invoice)VALUES (20,1,15,1);
INSERT INTO Positions(Price,Nomenclature_ID,Amount,Number_Invoice)VALUES (45,4,16,1);
INSERT INTO Positions(Price,Nomenclature_ID,Amount,Number_Invoice)VALUES (35,3,15,2);
INSERT INTO Positions(Price,Nomenclature_ID,Amount,Number_Invoice)VALUES (30,2,14,2);
INSERT INTO Positions(Price,Nomenclature_ID,Amount,Number_Invoice)VALUES (55,5,11,2);
INSERT INTO Positions(Price,Nomenclature_ID,Amount,Number_Invoice)VALUES (20,1,15,3);
INSERT INTO Positions(Price,Nomenclature_ID,Amount,Number_Invoice)VALUES (30,2,15,3);
INSERT INTO Positions(Price,Nomenclature_ID,Amount,Number_Invoice)VALUES (20,1,12,4);
INSERT INTO Positions(Price,Nomenclature_ID,Amount,Number_Invoice)VALUES (35,3,9,4);
INSERT INTO Positions(Price,Nomenclature_ID,Amount,Number_Invoice)VALUES (20,1,15,5);


