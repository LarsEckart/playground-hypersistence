package com.larseckart.playgroundhypersistence;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private CoverArt coverArt;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Song> songs;

    public Album() {
    }

    public Album(CoverArt coverArt, List<Song> songs) {
        this.coverArt = coverArt;
        this.songs = songs;
    }
}
