--liquibase formatted sql

--changeset  sleepwalker:create_products_info_table
CREATE TABLE IF NOT EXISTS PRODUCTS_INFO
(
    PRODUCT_ID       BIGINT UNIQUE PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    INFO_FIELD_NAME  varchar(255)                                               not null,
    INFO_FIELD_VALUE varchar(255)                                               not null
);
