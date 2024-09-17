create table EVENT
(
    event_id SERIAL,
    event_name VARCHAR(100) NOT NULL,
    created_time TIMESTAMP NOT NULL,
    CONSTRAINT event_uk1 UNIQUE (event_name, created_time),
    PRIMARY KEY (event_id)
);
