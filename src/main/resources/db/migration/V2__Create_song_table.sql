create table SONG
(
    song_id SERIAL,
    length  varchar(100) not null,
    artist  jsonb        not null,
    PRIMARY KEY (song_id)
);
