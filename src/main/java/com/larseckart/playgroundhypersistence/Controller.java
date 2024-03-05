package com.larseckart.playgroundhypersistence;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class Controller {

    @GetMapping("/albums")
    public List<Album> getAlbums() {
        return List.of(new Album(new CoverArt( "", "", "cover art"),
                List.of(new Song(100L, new Artist("artist", "", "")))));
    }
}
