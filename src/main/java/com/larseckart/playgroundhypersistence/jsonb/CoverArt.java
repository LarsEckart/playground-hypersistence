package com.larseckart.playgroundhypersistence.jsonb;

import java.io.Serializable;

public record CoverArt(String frontCoverArtUrl, String backCoverArtUrl, String upcCode) implements Serializable {
}
