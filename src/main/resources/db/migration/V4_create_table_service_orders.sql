CREATE TABLE service_orders (
    id SERIAL PRIMARY KEY,
    description TEXT,
    prev_images TEXT,
    after_images TEXT,
    initial_date DATE,
    final_date DATE,
    car_id BIGINT,
    owner_id BIGINT,
    FOREIGN KEY (car_id) REFERENCES car(id),
    FOREIGN KEY (owner_id) REFERENCES owner(id)
);