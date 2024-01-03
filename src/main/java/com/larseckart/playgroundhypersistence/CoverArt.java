package com.larseckart.playgroundhypersistence;

import java.io.Serializable;

public record CoverArt(String frontCoverArtUrl, String backCoverArtUrl, String upcCode) implements Serializable {
}
