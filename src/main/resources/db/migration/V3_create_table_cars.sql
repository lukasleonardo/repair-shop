CREATE TABLE cars (
    id SERIAL PRIMARY KEY,
    plate VARCHAR(10) UNIQUE,
    brand VARCHAR(50),
    model VARCHAR(100),
    color VARCHAR(50),
    owner_id BIGINT,
    FOREIGN KEY (owner_id) REFERENCES owner(id)
);