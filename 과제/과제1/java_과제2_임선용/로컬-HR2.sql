CREATE TABLE bookDTO(
    isbn NUMBER(5) primary key,
    title VARCHAR2(50) NOT NULL,
    author VARCHAR2(250) NOT NULL,
    publisher VARCHAR2(50) NOT NULL,
    price NUMBER(6) NOT NULL,
    desc_ VARCHAR2(200) NULL,
    publish_date VARCHAR2(10) NULL
);

