CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    login VARCHAR(24) UNIQUE,
    password TEXT,
    role VARCHAR(10)
);