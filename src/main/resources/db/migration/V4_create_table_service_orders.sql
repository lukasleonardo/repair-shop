CREATE TABLE service_orders (
    id SERIAL PRIMARY KEY,
    description VARCHAR(255),
    prev_images BYTEA[],
    after_images BYTEA[],
    initial_date TIMESTAMP,
    final_date TIMESTAMP,
    car_id BIGINT,
    owner_id BIGINT,
    FOREIGN KEY (car_id) REFERENCES car(id),
    FOREIGN KEY (owner_id) REFERENCES owner(id)
);