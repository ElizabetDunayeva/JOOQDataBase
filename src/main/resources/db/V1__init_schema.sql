CREATE TABLE public.Invoices (
                                 Number BIGINT NOT NULL ,
                                 Date_of DATE NOT NULL,
                                 Organization_ID BIGINT NOT NULL ,
                                 CONSTRAINT Invoice_pk PRIMARY KEY (Number)
);

CREATE TABLE public.Organizations (
                                 Name VARCHAR  NOT NULL ,
                                 INN BIGINT NOT NULL,
                                 Account BIGINT NOT NULL ,
                                 CONSTRAINT Organizations_pk PRIMARY KEY (INN)
);

CREATE TABLE public.Nomenclatures (
                                 Name VARCHAR NOT NULL ,
                                 Cod_ID BIGINT NOT NULL ,
                                 CONSTRAINT Nomenclatures_pk PRIMARY KEY (Cod_ID)

);

CREATE TABLE public.Positions (
                                 Price BIGINT NOT NULL ,
                                 Nomenclature_ID BIGINT NOT NULL,
                                 Amount BIGINT NOT NULL,
                                 Number_Invoice BIGINT NOT NULL,
                                 CONSTRAINT Positions_pk PRIMARY KEY (Nomenclature_ID,Number_Invoice),
                                 CONSTRAINT Nomenclature_fk FOREIGN KEY(Nomenclature_ID)
                                     REFERENCES public.Nomenclatures(Cod_ID)
                                     ON DELETE NO ACTION
                                     ON UPDATE NO ACTION,
                                 CONSTRAINT Invoice_fk FOREIGN KEY(Number_Invoice)
                                     REFERENCES public.Invoices(Number)
                                     ON DELETE NO ACTION
                                     ON UPDATE NO ACTION
);