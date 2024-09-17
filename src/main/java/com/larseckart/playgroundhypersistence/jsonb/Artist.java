package com.larseckart.playgroundhypersistence.jsonb;

import java.io.Serializable;

public record Artist(String name, String country, String genre) implements Serializable {
}
