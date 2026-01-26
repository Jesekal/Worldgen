package com.jeskal.worldgen.world;

public class Tile {

    private final Tiletype type;

    public Tile(Tiletype type) {
        this.type = type;
    }

    public Tiletype getType() {
        return type;
    }
}
