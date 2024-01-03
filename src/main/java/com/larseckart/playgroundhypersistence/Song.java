package com.larseckart.playgroundhypersistence;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.Type;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private Long length = 0L;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private Artist artist;

    public Song(Long length, Artist artist) {
        this.length = length;
        this.artist = artist;
    }

    public Song() {
    }

}
