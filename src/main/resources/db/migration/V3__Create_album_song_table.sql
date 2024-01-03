create table album_songs
(
    songs_id  integer,
    album_id integer,
    CONSTRAINT fk_song
        FOREIGN KEY (songs_id)
            REFERENCES song (song_id),
    CONSTRAINT fk_album
        FOREIGN KEY (album_id)
            REFERENCES album (album_id)
);
