--liquibase formatted sql

--changeset  sleepwalker:create_products_info_table
CREATE TABLE IF NOT EXISTS PRODUCTS_INFO
(
    PRODUCT_ID       BIGINT       NOT NULL,
    INFO_FIELD_NAME  varchar(255) not null,
    INFO_FIELD_VALUE varchar(255) not null,
    constraint pk_products_info primary key (PRODUCT_ID, INFO_FIELD_NAME, INFO_FIELD_VALUE)
);
