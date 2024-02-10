DROP TABLE IF EXISTS credit_request_entity;
CREATE TABLE credit_request_entity
(
    id       CHAR(36) PRIMARY KEY,
    bank_id  VARCHAR(255) UNIQUE NOT NULL,
    status   VARCHAR(255)        NOT NULL DEFAULT 'APPROVED'
    created TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

DROP TABLE IF EXISTS order_entity;
CREATE TABLE order_entity
(
    id                 CHAR(36) PRIMARY KEY,
    credit_id          CHAR(36)           NOT NULL,
    payment_id         VARCHAR(19) UNIQUE NOT NULL,
    created TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id)
);
DROP TABLE IF EXISTS payment_entity;
CREATE TABLE payment_entity
(
    id              CHAR(36) PRIMARY KEY,
    amount          CHAR(36)   NOT NULL,
    transaction_id  VARCHAR(6) NOT NULL,
    status          VARCHAR(255)        NOT NULL DEFAULT 'APPROVED'
    created TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

