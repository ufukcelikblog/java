CREATE TABLE URUN (
    ID INTEGER NOT NULL PRIMARY KEY GENERATED 
        ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    AD VARCHAR(150),
    TANIM VARCHAR(250),
    RESIMAD VARCHAR(250),
    RESIM BLOB
)