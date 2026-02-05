package com.jeskal.worldgen.world;

public class Tile {

    public static final int size = 32;

    private final Tiletype type;

    public Tile(Tiletype type) {
        this.type = type;
    }

    public Tiletype getType() {
        return type;
    }
}
