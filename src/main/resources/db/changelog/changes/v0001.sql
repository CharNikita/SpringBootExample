--liquibase formatted sql

--changeset author:goncharenko

CREATE TABLE task
(
    id           SERIAL PRIMARY KEY,
    text         VARCHAR(255) NOT NULL,
    is_completed BOOL         NOT NULL DEFAULT false
);