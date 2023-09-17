--liquibase formatted sql

--changeset  sleepwalker:create_customers_table
CREATE TABLE IF NOT EXISTS CUSTOMERS
(
    ID                  BIGINT UNIQUE PRIMARY KEY NOT NULL,
    RANSOM_AMOUNT       BIGINT                    NOT NULL
);
