create table EVENT
(
    event_id SERIAL,
    event_name VARCHAR(100) NOT NULL,
    created_time TIMESTAMP NOT NULL,
    PRIMARY KEY (event_id)
);
