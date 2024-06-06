CREATE TABLE cars (
    id SERIAL PRIMARY KEY,
    plate VARCHAR(255) UNIQUE,
    brand VARCHAR(255),
    model VARCHAR(255),
    color VARCHAR(255),
    owner_id BIGINT,
    FOREIGN KEY (owner_id) REFERENCES owner(id)
);