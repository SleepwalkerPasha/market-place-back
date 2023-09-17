--liquibase formatted sql

--changeset  sleepwalker:create_sellers_table
CREATE TABLE IF NOT EXISTS SELLERS
(
    ID                BIGINT UNIQUE PRIMARY KEY NOT NULL,
    SALES_AMOUNT      BIGINT                    NOT NULL
);
