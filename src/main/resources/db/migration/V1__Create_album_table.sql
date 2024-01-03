create table ALBUM
(
    album_id SERIAL,
    coverArt jsonb not null,
    PRIMARY KEY (album_id)
);
